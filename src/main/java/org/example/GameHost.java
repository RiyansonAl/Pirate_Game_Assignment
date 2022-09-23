package org.example;


import java.util.Arrays;

public class GameHost {

    private Player[] players;
    private int winningScore = 3000;
    protected int[] playerTurnOrder;
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
    }

    //Returns Number of player in the game
    public int numOfPlayers(){
        return players.length;
    }

    public FortuneCard drawCard(int riggedNum){
        FortuneCard card;
        if (riggedNum == 0){
            int num = (int) (Math.random()*(8-1)+ 1);
            card = drawCardHelper(num);
        } else {
            card = drawCardHelper(riggedNum);
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

    public Dice[] rollDice(int numOfDice, int[] riggedDice){
        Dice[] dices = new Dice[numOfDice];
        if(riggedDice[0] == 0) {
            int num;
            for (int i = 0; i < numOfDice; i++) {
                num = (int) (Math.random() * (6 - 1) + 1);
                dices[i] = rollDiceHelper(num);
            }
        } else {
            for (int i = 0; i < numOfDice; i++) {
                dices[i] = rollDiceHelper(riggedDice[i]);
            }
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

    protected Dice[] keepReRollDice(int[] keepDice, Dice[] preDice, int[] riggedDice, boolean hasSorceress){
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
            preDice[keepDice[i]] = Dice.None; //Place holder to ignore the kept dice
        }
        //Debug line
        System.out.println(Arrays.toString(diceSet));

        //Keep the skulls since that cannot be re-rolled unless the sorceress fortune card
        for(int i = 0; i < preDice.length; i++){
            if((preDice[i] == Dice.Skull) && !hasSorceress){ //Found one skull dice and don't have Sorceress Card
                diceSet[counter] = preDice[i];
                counter = counter + 1;
            } else if((preDice[i] == Dice.Skull) && (hasSorceress)) { //found one skull dice and have Sorceress Card
                hasSorceress = false;
            }
        }

        //Debug line
        System.out.println(Arrays.toString(diceSet));

        //The remaining dice is the amount of dice that will be rolled
        int diceToRoll = preDice.length - counter;
        Dice[] newRoll;
        if(riggedDice[0] == 0){
            int[] noRiggedDice = {0,0,0};
            newRoll = rollDice(diceToRoll, noRiggedDice);
        }else {
            //Get the new set of riggedDice from the orignal rigged Dice set
            int[] newRiggedDice = new int[diceToRoll];
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
        //Debug line
        System.out.println(Arrays.toString(diceSet));
        return diceSet;
    }

    protected int calculateScore(Player player, FortuneCard card, Dice[] rolledDice){
        int score = 0;

        if(card == FortuneCard.Captain){
            score = scoreFromDice(rolledDice, FortuneCard.None);
            score = score * 2;
        } else if ((card == FortuneCard.Gold) || (card == FortuneCard.Diamond) || (card == FortuneCard.MonkeyBusiness)) {
            score = scoreFromDice(rolledDice, card);
        }

        player.updateScore(score);
        return score;
    }

    private int scoreFromDice(Dice[] rolledDice, FortuneCard card){
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
        //Full chest is true if all 8 dice is used to score
        if(count == 8){
            isFullChest = true;
        }
        if(isFullChest){
            //Full Chest bonus
            score = score + 500;
        }

        //Check if card it either Gold or diamond
        if(card == FortuneCard.Gold){
            duplicates[2] = duplicates[2] + 1;
        }
        if(card == FortuneCard.Diamond){
            duplicates[3] = duplicates[3] + 1;
        }



        //Score for identical/duplicate objects
        for(int i = 0; i < (duplicates.length-1); i++){

            switch(duplicates[i]) {
                case 3://3 of a kind
                    score = score + 100;
                    break;
                case 4://4 of a kind
                    score = score + 200;
                    break;
                case 5://5 of a kind
                    score = score + 500;
                    break;
                case 6://6 of a kind
                    score = score + 1000;
                    break;
                case 7://7 of a kind
                    score = score + 2000;
                    break;
                case 8://8 of a kind
                    score = score + 4000;
                    break;
            }
        }

        //Score for each diamond and gold
        score = score + (100 * (duplicates[2] + duplicates[3]));

        return score;
    }

    protected Dice[] playerTurnStart(Player player, FortuneCard riggedCard, Dice[] riggedDice){


    }

    protected void endTurn(){

    }




}//End gameHost class
