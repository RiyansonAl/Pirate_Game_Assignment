package org.example;


import java.util.Arrays;

public class GameHost {

    private Player[] players;
    private int winningScore = 3000;
    protected boolean[] playerTurnOrder;

    private String scoreBreakDown;
    public enum FortuneCard {
        TreasureChest, Captain, Sorceress, SeaBattle,
        Gold, Diamond, MonkeyBusiness, Skulls, None
    }
    public enum Dice {
        Monkey, Parrot, Gold, Diamond,
        Sword, Skull, None
    }

    //Constructor for GameHost
    public GameHost(Player[] newPlayers){
        players = newPlayers;
        scoreBreakDown = "";
        playerTurnOrder = new boolean[newPlayers.length];
        if(newPlayers.length > 1){
            //Setting Player one to go first
            playerTurnOrder[0] = true;
            for(int i = 1; i < newPlayers.length; i++){
                playerTurnOrder[i] = false;
            }
        }
    }

    //Returns Number of player in the game
    public int numOfPlayers(){
        return players.length;
    }

    public FortuneCard drawCard(FortuneCard riggedCard){
        FortuneCard card;
        if (riggedCard == FortuneCard.None){
            int num = (int) (Math.random()*(8-1)+ 1);
            card = drawCardHelper(num);
        } else {
            card = riggedCard;
        }
        return card;
    }

    private FortuneCard drawCardHelper(int num){
        switch(num){
            case 1:
                return FortuneCard.TreasureChest;
            case 2:
                return FortuneCard.Captain;
            case 3:
                return FortuneCard.Sorceress;
            case 4:
                return FortuneCard.SeaBattle;
            case 5:
                return FortuneCard.Gold;
            case 6:
                return FortuneCard.Diamond;
            case 7:
                return FortuneCard.MonkeyBusiness;
            case 8:
                return FortuneCard.Skulls;
            default:
                return FortuneCard.Skulls;
        }
    }

    public Dice[] rollDice(int numOfDice, Dice[] riggedDice){
        Dice[] dices = new Dice[numOfDice];
        if(riggedDice[0] == Dice.None) {
            int num;
            for (int i = 0; i < numOfDice; i++) {
                num = (int) (Math.random() * (6 - 1) + 1);
                dices[i] = rollDiceHelper(num);
            }
        } else {
            dices = riggedDice;
        }
        return dices;
    }
    private Dice rollDiceHelper(int num){
        switch(num) {
            case 1:
                return Dice.Monkey;
            case 2:
                return Dice.Parrot;
            case 3:
                return Dice.Gold;
            case 4:
                return Dice.Diamond;
            case 5:
                return Dice.Sword;
            case 6:
                return Dice.Skull;
            default:
                return Dice.Skull;
        }

    }
    protected void updateScore(Player player, int score){
        player.updateScore(score);
    }

    protected int[] getScores(){
        int[] scores = new int[players.length];
        for(int i = 0; i < scores.length; i++){
            scores[i] = players[i].getScore();
        }
        return scores;
    }

    public String displayScores(){
        int[] scores = getScores();
        int numOfPlayers = players.length;

        //String for the final print
        String scoreBoard = "";
        //Player numbers
        switch(numOfPlayers) {
            case 1:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\n";
                break;
            case 2:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\n";
                break;
            case 3:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\tPlayer 3\t|\n";
                break;
        }
        //Format and display the points
        scoreBoard = scoreBoard + "|";
        for(int i = 0; i < scores.length; i++){
            if(scores[i] > 999){
                scoreBoard = scoreBoard + "\t" + scores[i] + "\t\t|";
            } else {
                scoreBoard = scoreBoard + "\t" + scores[i] + "\t\t\t|";
            }
        }
        //Add an end of line
        scoreBoard = scoreBoard + "\n\n";
        //Print out the Score board
        System.out.print(scoreBoard);

        return scoreBoard;
    }

    protected String endRound(){
        int[] scores = getScores();
        int max = 0;
        int player = 0;

        //Check for highest score
        for(int i = 0; i < scores.length; i++){
            if(scores[i] >= max){
                max = scores[i];
                player = i + 1;
            }
        }
        //Return string
        String winner = "";
        //Check if the max value is a winning score
        if(max >= winningScore){
            //Check if there are duplicate scores for multiple winners.
            int count = 0;
            for(int i = 0; i < scores.length; i++){
                if(scores[i] == max){
                    count = count + 1;
                }
            }
            //One Winner
            if(count == 1){ //One winner
                winner = "Player " + player + " wins\n";
            }
            if(count >= 2){
                int[] wonPlayers = new int[count];
                int k = 0;
                //Find which player won
                for(int i = 0; i < scores.length; i++){
                    if(scores[i] == max){
                        wonPlayers[k] = i + 1;
                        k = k + 1;
                    }
                }
                //Create string for winning players
                for(int i = 0; i < wonPlayers.length; i++){
                    winner = winner + "Player " + wonPlayers[i] + " wins\n";
                }
            }
        }
        System.out.print(winner);
        return winner;
    }

    protected Dice[] keepReRollDice(Player player, int[] keepDice, Dice[] preDice, Dice[] riggedDice, FortuneCard card){
        Dice[] diceSet = new Dice[preDice.length];
        //Give default value to the new Dice set
        for(int i = 0; i < diceSet.length; i++){
            diceSet[i] = Dice.None;
        }
        //Debug line
        System.out.println(Arrays.toString(preDice));

        //Add in the dice that is being kept to the new Dice set.
        int counter = 0;
        for(int i = 0; i < keepDice.length; i++){
            diceSet[counter] = preDice[keepDice[i]];
            counter = counter + 1;
            preDice[keepDice[i]] = Dice.None;
        }
        //Debug line
        System.out.println(Arrays.toString(diceSet));

        //Keep the skulls since that cannot be re-rolled unless the sorceress fortune card
        boolean hasSorceress = false;
        if (card == FortuneCard.Sorceress){
            hasSorceress = player.getIsSorceress();
        }
        for(int i = 0; i < preDice.length; i++){
            if((preDice[i] == Dice.Skull) && !hasSorceress){ //Found one skull dice and don't have Sorceress Card
                diceSet[counter] = preDice[i];
                counter = counter + 1;
            } else if((preDice[i] == Dice.Skull) && (hasSorceress)) { //found one skull dice and have Sorceress Card
                hasSorceress = false;
                player.setIsSorceress(false);
            }
        }

        //Debug line
        System.out.println(Arrays.toString(diceSet));

        //The remaining dice is the amount of dice that will be rolled
        int diceToRoll = preDice.length - counter;
        Dice[] newRoll;
        if(riggedDice[0] == Dice.None){
            Dice[] noRiggedDice = {Dice.None, Dice.None, Dice.None};
            newRoll = rollDice(diceToRoll, noRiggedDice);
        }else {
            //Get the new set of riggedDice from the orignal rigged Dice set

            Dice[] newRiggedDice = new Dice[diceToRoll];
            int k = 0;
            for(int i = counter; i < riggedDice.length; i++){
                newRiggedDice[k] = riggedDice[i];
                k = k + 1;
            }

            newRoll = rollDice(diceToRoll, newRiggedDice);
        }
        //Add the new dice to the dice set
        int j = 0;
        for(int i = 0; i < newRoll.length; i++){
            diceSet[counter] = newRoll[i];
            counter = counter + 1;
        }
        //Check for the number of skulls. If 3 or more skulls then turn ends
        //3 skulls and no Treasure chest card, then rolling ends and score 0 for this round
        int numOfSkulls = countSkulls(diceSet);
        //if the card is a skulls card, add the number of skulls from the card to the number of skulls rolled
        if(card == FortuneCard.Skulls){
            numOfSkulls = numOfSkulls + player.getSkullCardNum();
        }

        if((numOfSkulls >= 3) && (card == FortuneCard.SeaBattle)){
            int seabattleCard = player.getSwordCardNum();
            int score = 0;
            if(seabattleCard == 2){
                score = -300;
                player.setScoreBreakDown("-300 Lost Sea Battle");
            } else if(seabattleCard == 3){
                score = -500;
                player.setScoreBreakDown("-500 Lost Sea Battle");
            } else if (seabattleCard == 4){
                score = -1000;
                player.setScoreBreakDown("-1000 Lost Sea Battle");
            }
            System.out.println(player.getScoreBreakDown());
            player.updateScore(score);
            playerTurnPhase(player, false, false);
        } else if((numOfSkulls >= 3) && (card == FortuneCard.TreasureChest)){
            playerTurnPhase(player, false, true);
            //The returned Dice set is only the kept dice from before the re-Roll
            Dice[] originalKeepDice = new Dice[keepDice.length];
            for(int i = 0; i < keepDice.length; i++){
                originalKeepDice[i] = diceSet[i];
            }
            diceSet = originalKeepDice;
            player.setScoreBreakDown("(3 or more skulls with Treasure Chest card score based on kept dice)  ");
        } else if((numOfSkulls >= 3) && (card != FortuneCard.TreasureChest)){
            playerTurnPhase(player, false, false);
            player.setScoreBreakDown("3 or more skulls score this turn is 0");
        }
        //Debug line
        System.out.println(Arrays.toString(diceSet));
        return diceSet;
    }

    protected int calculateScore(Player player, FortuneCard card, Dice[] rolledDice){
        int score = 0;


        if(player.getUpdateScore() == true) {

            if (card == FortuneCard.Captain) {
                score = scoreFromDice(player, rolledDice, card);
                score = score * 2;
                player.setScoreBreakDown("(Captain Fortune Card) x 2 score ");
            } else if(card == FortuneCard.SeaBattle){
                int seaBattleCardNum = player.getSwordCardNum();
                score = score + scoreFromDice(player, rolledDice, card);
                if(seaBattleCardNum == 2){
                    score = score + 300;
                    player.setScoreBreakDown(" 300 (SeaBattle won) ");
                } else if (seaBattleCardNum == 3){
                    score = score + 500;
                    player.setScoreBreakDown(" 500 (SeaBattle won) ");
                } else if (seaBattleCardNum == 4){
                    score = score + 1000;
                    player.setScoreBreakDown(" 1000 (SeaBattle won) ");
                }

            } else if ((card == FortuneCard.Gold) || (card == FortuneCard.Diamond) || (card == FortuneCard.MonkeyBusiness)
                    || (card == FortuneCard.TreasureChest) || (card == FortuneCard.Skulls) || (card == FortuneCard.Sorceress)) {
                score = scoreFromDice(player, rolledDice, card);
            }

            player.setScoreBreakDown(" = " + score);
            System.out.println(player.getScoreBreakDown());
            player.updateScore(score);
            player.setUpdateScore(false);
        } else { //Turn must end since they got zero score from too many skulls or lost seabattle
            score = 0;
        }
        return score;
    }

    private int scoreFromDice(Player player, Dice[] rolledDice, FortuneCard card){
        //Initializing the array to count duplicates
        int[] duplicates = {0, 0, 0, 0, 0, 0};

        //Count the duplicates in the rolled dice Array
        for(int i = 0; i < rolledDice.length; i++){

            switch(rolledDice[i]) {
                case Monkey:
                    duplicates[0] = duplicates[0] + 1;
                    break;
                case Parrot:
                    duplicates[1] = duplicates[1] + 1;
                    break;
                case Gold:
                    duplicates[2] = duplicates[2] + 1;
                    break;
                case Diamond:
                    duplicates[3] = duplicates[3] + 1;
                    break;
                case Sword:
                    duplicates[4] = duplicates[4] + 1;
                    break;
                case Skull:
                    duplicates[5] = duplicates[5] + 1;
                    break;
            }
        }
        int score = 0;

        //Check if card is Monkey Business
        if(card == FortuneCard.MonkeyBusiness){
            //Make all parrots into monkeys to calculate the score
            duplicates[0] = duplicates[0] + duplicates[1];
            duplicates[1] = 0;
        }

        //TODO: Full Chest for when all eight dice is used for points
        //Check for Full Chest bonus
        boolean isFullChest = false;
        int count = 0;
        for(int i = 0; i < (duplicates.length-1); i++){
            //If there is 8 of a kind
            if(duplicates[i] == 8){
                isFullChest = true;
            }
            //Count for the dice used to score
            if(duplicates[i] >=3 ){
                count = count + duplicates[i];
            }
        }
        //Include the Gold and Diamonds for the Full Chest
        //Gold
        count = count + duplicates[2];
        //Diamonds
        count = count + duplicates[3];
        //Full chest is true if all 8 dice is used to score
        if(count == 8){
            isFullChest = true;
        }
        if(isFullChest){
            //Full Chest bonus
            score = score + 500;
            player.setScoreBreakDown("Full Chest bonus (500) + ");
        }

        //Check if card it either Gold or diamond
        if(card == FortuneCard.Gold){
            duplicates[2] = duplicates[2] + 1;
            player.setScoreBreakDown("Gold Fortune Card added to Dice roll + ");
        }
        if(card == FortuneCard.Diamond){
            duplicates[3] = duplicates[3] + 1;
            player.setScoreBreakDown("Diamond Fortune Card added to Dice roll + ");
        }



        //Score for identical/duplicate objects
        for(int i = 0; i < (duplicates.length-1); i++){

            switch(duplicates[i]) {
                case 3://3 of a kind
                    score = score + 100;
                    player.setScoreBreakDown("3 of a kind (100) + ");
                    break;
                case 4://4 of a kind
                    score = score + 200;
                    player.setScoreBreakDown("4 of a kind (200) + ");
                    break;
                case 5://5 of a kind
                    score = score + 500;
                    player.setScoreBreakDown("5 of a kind (500) + ");
                    break;
                case 6://6 of a kind
                    score = score + 1000;
                    player.setScoreBreakDown("6 of a kind (1000) + ");
                    break;
                case 7://7 of a kind
                    score = score + 2000;
                    player.setScoreBreakDown("7 of a kind (2000) + ");
                    break;
                case 8://8 of a kind
                    score = score + 4000;
                    player.setScoreBreakDown("8 of a kind (4000) + ");
                    break;
                case 9://8 of a kind
                    score = score + 4000;
                    player.setScoreBreakDown("8 of a kind (4000) + ");
                    break;
            }
        }

        //Score for each diamond and gold
        score = score + (100 * (duplicates[2] + duplicates[3]));
        if(duplicates[2] > 0){
            player.setScoreBreakDown("Gold dice rolled (100 * " + duplicates[2] + ") + ");
        }
        if(duplicates[3] > 0){
            player.setScoreBreakDown("Diamond dice rolled (100 * " + duplicates[3] + ") + ");
        }

        return score;
    }

    protected Dice[] playerTurnStart(Player player, FortuneCard riggedCard, Dice[] riggedDice){
        //Roll the dice
        Dice[] firstRoll = rollDice(8, riggedDice);
        FortuneCard card = drawCard(riggedCard);
        player.setFortuneCard(card);
        int numOfSkulls = countSkulls(firstRoll);

        if(card == FortuneCard.Skulls){
            int numOnSkullCard;
            if(riggedCard == FortuneCard.None){
                numOnSkullCard = getSkullCardType(player, 0);
                player.setSkullCardNum(numOnSkullCard);
            } else {
                numOnSkullCard = player.getSkullCardNum();

            }
            numOfSkulls = numOfSkulls + numOnSkullCard;
            System.out.println(numOnSkullCard);
            System.out.println(numOfSkulls);
        } else if (card == FortuneCard.SeaBattle){
            if(riggedCard == FortuneCard.None){
                int numOnSwordCard = getSwordCardType(player, 0);
                player.setSwordCardNum(numOnSwordCard);
            }
        } else if (card == FortuneCard.Sorceress){
            player.setIsSorceress(true);
        }

        //TODO: Display the Player, Drawn card and the first roll here, Maybe have a method from printint this infomation

        //if number of skulls is exactly 3 then end the round unless there is a Treasure Chest card
        //TODO First if statement should not be here
        if((numOfSkulls == 3) && (card == FortuneCard.SeaBattle)){
            //Lost the sea battle subtrack the score
            int seabattleCard = player.getSwordCardNum();
            int score = 0;
            if(seabattleCard == 2){
                score = -300;
                player.setScoreBreakDown("-300 Lost Sea Battle");
            } else if(seabattleCard == 3){
                score = -500;
                player.setScoreBreakDown("-500 Lost Sea Battle");
            } else if (seabattleCard == 4){
                score = -1000;
                player.setScoreBreakDown("-1000 Lost Sea Battle");
            }
            player.updateScore(score);
            playerTurnPhase(player, false, false);
        } else if (numOfSkulls == 3) {
            //End Players Turn and Give score of Zero for Turn
            playerTurnPhase(player, false, false);
            player.setScoreBreakDown("3 skulls. Score = 0");
        } else if (numOfSkulls >= 4){
            //Go to Island of the skulls
            player.setIsSkullIsland(true);
            playerTurnPhase(player, false, false);
        } else {
            playerTurnPhase(player, true, true);
        }

        return firstRoll;
    }

    protected String endTurn(Player player){
        //Only enter this method if player is done turn and done rolling and score is updated
        String msg = "";

        //If at the end of the round check if there is a winner
        //If last player is ending the turn then it is the end of the round
        if(player.getPlayerNumber() == players.length){
            msg = endRound();
        }

        //If there is no winner then set true for next players turn
        if(msg == ""){
            if((player.getPlayerNumber() + 1) > players.length){
                playerTurnOrder[player.getPlayerNumber() - 1] = false;
                playerTurnOrder[0] = true;

            }else{
                playerTurnOrder[player.getPlayerNumber() - 1 ] = false;
                playerTurnOrder[player.getPlayerNumber()] = true;
            }
            msg = msg + "Player " + player.getPlayerNumber() + " score breakDown:\n";
            msg = msg + player.getScoreBreakDown() + "\n";
            player.endPlayerTurn();
            msg = msg + "Player " + player.getPlayerNumber() + " Turn Ended\n";
            msg = msg + "Player " + (player.getPlayerNumber() + 1) + " Turn Starting....";
        }

        return msg;
    }

    private int countSkulls(Dice[] roll){
        int count = 0;
        for(int i = 0; i < roll.length; i++){
            if(roll[i] == Dice.Skull){
                count = count + 1;
            }
        }
        return count;
    }

    protected int getSkullCardType(Player player, int rigged){
        //Random number between 1 and 3
        int numOfSkulls = 0;
        //Random number between 1 and 3
        int num = (int) (Math.random()*(3-1)+ 1);
        //2x2 Skulls card and 2x1 Skulls card
        switch (num){
            case 1:
                numOfSkulls = 2;
                break;
            case 2:
                numOfSkulls = 2;
                break;
            case 3:
                numOfSkulls = 1;
                break;
        }

        if (rigged != 0){
            numOfSkulls = rigged;

        }
        return numOfSkulls;
    }

    protected int getSwordCardType(Player player, int rigged){
        //Random number between 1 and 3
        int numOfSwords = 0;
        //Random number between 1 and 3
        int num = (int) (Math.random()*(3-1)+ 1);
        //2x2 Skulls card and 2x1 Skulls card
        switch (num){
            case 1:
                numOfSwords = 2;
                break;
            case 2:
                numOfSwords = 3;
                break;
            case 3:
                numOfSwords = 4;
                break;
        }

        if (rigged != 0){
            numOfSwords = rigged;

        }
        return numOfSwords;
    }

    private void playerTurnPhase(Player player, boolean isRolled, boolean isUpdatedScore){
        player.setRoll(isRolled);
        player.setUpdateScore(isUpdatedScore);
    }
    protected boolean[] getPlayerTurnPhase(Player player){
        return new boolean[]{player.getRoll(), player.getUpdateScore()};
    }

    protected Dice[] skullIsland(Player player, FortuneCard card, Dice[] roll, Dice[] riggiedDice){
        int numOfSkulls = countSkulls(roll);
        //if the card is a skulls card, add the number of skulls from the card to the number of skulls rolled
        int skullsCard = 0;
        if(card == FortuneCard.Skulls){
            skullsCard = player.getSkullCardNum();
            numOfSkulls = numOfSkulls + skullsCard;
        }

        if((numOfSkulls <= 3) || ((numOfSkulls - skullsCard) > roll.length)){
            return roll;
        }
        Dice[] newDiceSet = new Dice[roll.length];
        for(int i = 0; i < (numOfSkulls - skullsCard); i++){
            newDiceSet[i] = Dice.Skull;
        }

        if(riggiedDice[0] == Dice.None){
            //Roll for more skulls
            Dice[] noRiggedDice = {Dice.None, Dice.None, Dice.None};
            Dice[] newRoll;
            int diceToRoll = newDiceSet.length - (numOfSkulls - skullsCard);
            newRoll = rollDice(diceToRoll, noRiggedDice);
            int k = (numOfSkulls - skullsCard);
            for(int i = 0; i < newRoll.length; i++){
                newDiceSet[k] = newRoll[i];
                k = k + 1;
            }

        } else {
            //Use rigged Dice
            newDiceSet = riggiedDice;
        }

        int newNumOfSkulls = countSkulls(newDiceSet);
        if(card == FortuneCard.Skulls){
            newNumOfSkulls = newNumOfSkulls + player.getSkullCardNum();
        }
        if(numOfSkulls > newNumOfSkulls){
            player.setIsSkullIsland(true);
        } else {
            //No new dice calculate the scores and end turn
            int playerNum = player.getPlayerNumber();
            int deducteScore = newNumOfSkulls * 100;
            player.setScoreBreakDown( "-100 * "+ newNumOfSkulls+" (Number of skulls rolled in island of the skulls) + ");
            //If all 8 dice were used
            if((newNumOfSkulls - skullsCard) == 8){
                deducteScore = deducteScore + 500;
                player.setScoreBreakDown( "Full Ches bonus -500 to opponents + ");
            }
            if(card == FortuneCard.Captain){
                deducteScore = deducteScore * 2;
                player.setScoreBreakDown( " x 2 total deduction (Captain Fortune Card) ");
            }

            //Update all the other players scores
            for(int i = 0; i < players.length; i++){
                if(playerNum != players[i].getPlayerNumber()){
                    players[i].updateScore(-1*deducteScore);
                }
            }
            player.setScoreBreakDown( " = " + -1*deducteScore + " To all other players");
            System.out.println(player.getScoreBreakDown());
            //End the players Turn
            player.setIsSkullIsland(false);
            playerTurnPhase(player, false, false);
        }


        return newDiceSet;
    }




}//End gameHost class
