package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameHostTest {

    @Test
    @DisplayName("Creating Game and adding 3 players")
    void numOfPlayers() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        assertEquals(3, host.numOfPlayers() );
    }

    @Test
    @DisplayName("Drawing cards from the deck ")
    void drawCard() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        GameHost.FortuneCard riggedCard = GameHost.FortuneCard.TreasureChest;
        assertEquals(GameHost.FortuneCard.TreasureChest, host.drawCard(riggedCard) );
    }
    @Test
    @DisplayName("Rolling the Dice")
    void rollDice() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        //int[] riggedDice = {1,2,3,4,5,6,1,2};
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Gold,
                                        GameHost.Dice.Diamond, GameHost.Dice.Sword, GameHost.Dice.Skull,
                                        GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        assertArrayEquals(rolledDice, host.rollDice(8, rolledDice) );
    }
    @Test
    @DisplayName("Get Players scores ")
    void getScore() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        host.displayScores();
        host.updateScore(player1, 500);
        host.updateScore(player2, 200);
        host.updateScore(player3, 150);
        host.displayScores();
        host.updateScore(player1, -250);
        host.displayScores();
        int[] scores = {250, 200, 150};
        assertArrayEquals(scores, host.getScores() );
    }

    @Test
    @DisplayName("Check Scores and pick winner with the highest score over 3000")
    void endRound(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        host.displayScores();
        host.updateScore(player1, 500);
        host.updateScore(player2, 200);
        host.updateScore(player3, 150);
        host.displayScores();
        //No winner yet
        System.out.println("1: " +  host.checkForWinner());
        host.updateScore(player1, 2500);
        host.updateScore(player2, 1000);
        host.updateScore(player3, 1500);
        System.out.println("2: " +  host.checkForWinner());
        System.out.println("3: " +  host.checkForWinner());
        System.out.println("4: " +  host.checkForWinner());
        host.displayScores();
        String winner = "Player 1 wins";
        assertEquals(winner, host.checkForWinner());

    }

    @Test
    @DisplayName("Keeping Dice and Re-Rolling the rest of the Dice")
    void keepReRollDice() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        int[] riggedDice = {1,2,3,4,5,6,1,2};

        GameHost.Dice[] FirstRolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Gold,
                GameHost.Dice.Diamond, GameHost.Dice.Sword, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        GameHost.Dice[] rolledDice = host.rollDice(8, FirstRolledDice);
        int[] keepDice = {0,6,1,7};
        riggedDice = new int[]{1, 1, 2, 2, 6, 6, 1, 2};
        GameHost.Dice[] FinalRolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        player1.setIsSorceress(true);
        assertArrayEquals(FinalRolledDice, host.keepReRollDice(player1, keepDice, rolledDice, FinalRolledDice, GameHost.FortuneCard.None) );
    }

    @Test
    @DisplayName("Getting Score using a captain fortune card")
    void calculateScore(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Captain;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        int score = 400;
        player1.setUpdateScore(true);
        assertEquals(score, host.calculateScore(player1, card, rolledDice));
    }

    @Test
    @DisplayName("Getting Scorce using a Gold fortune card")
    void calculateScore2(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Skull,
                GameHost.Dice.Gold, GameHost.Dice.Parrot};
        int score = 1600;
        player1.setUpdateScore(true);
        assertEquals(score, host.calculateScore(player1, card, rolledDice));
    }

    @Test
    @DisplayName("Getting Score using a Diamond fortune card")
    void calculateScore3(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Diamond;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Diamond, GameHost.Dice.Diamond, GameHost.Dice.Diamond,
                GameHost.Dice.Diamond, GameHost.Dice.Diamond, GameHost.Dice.Diamond,
                GameHost.Dice.Gold, GameHost.Dice.Diamond};
        int score = 5400;
        player1.setUpdateScore(true);
        assertEquals(score, host.calculateScore(player1, card, rolledDice));
    }

    @Test
    @DisplayName("Getting Score using a Monkey Business fortune card")
    void calculateScore4(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.MonkeyBusiness;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey};
        int score = 2600;
        player1.setUpdateScore(true);
        assertEquals(score, host.calculateScore(player1, card, rolledDice));
    }

    @Test
    @DisplayName("Getting Score using a Treasure Chest fortune card")
    void playerTurnStart1() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        GameHost.FortuneCard riggedCard = GameHost.FortuneCard.TreasureChest;
        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Gold,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Parrot,
                GameHost.Dice.Skull, GameHost.Dice.Skull};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, riggedCard, riggedDice);

        int[] keepDice = {2,4,6,7};
        GameHost.Dice[] riggedDiceReRolled = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Gold,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Skull};
        GameHost.Dice[] finalRoll = new GameHost.Dice[riggedDiceReRolled.length];

        boolean[] player1TurnPhase = host.getPlayerTurnPhase(player1);


        while((player1TurnPhase[0] == true) || (player1TurnPhase[1] == true)){
            player1TurnPhase = host.getPlayerTurnPhase(player1);
            System.out.println("isRoll: " + player1TurnPhase[0] + ", isUpdateScore: " + player1TurnPhase[1]);

            if((player1TurnPhase[0] == true) && (player1TurnPhase[1] == true)){
                //Turn is not finished and Player is not finished rolling, So player can keep re-rolling the dice
                finalRoll = host.keepReRollDice(player1, keepDice, riggedDice, riggedDiceReRolled, riggedCard);
            }else if ( (player1TurnPhase[0] == false) && (player1TurnPhase[1] == true)){
                //Finished rolling now calculate score
                host.calculateScore(player1, riggedCard, finalRoll);
            }
        }//End While Loop
        //if turn ended, rolling is done and the score is set
        if((player1TurnPhase[0] == false) && (player1TurnPhase[1] == false)){
            System.out.println(host.endTurn(player1));
        }
        System.out.println("End of reRolling the Dice");

        int score = 200;
        assertEquals(score, host.getScores()[0]);

    }

    @Test
    @DisplayName("Rolling 3 skulls on the first roll and ending turn")
    void playerTurnStart2() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        GameHost.FortuneCard riggedCard = GameHost.FortuneCard.Captain;
        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Gold,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Skull};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, riggedCard, riggedDice);

        int[] keepDice = {5, 6, 7};
        GameHost.Dice[] finalRoll = firstRoll;

        boolean[] player1TurnPhase = host.getPlayerTurnPhase(player1);

        while((player1TurnPhase[0] == true) || (player1TurnPhase[1] == true)){
            player1TurnPhase = host.getPlayerTurnPhase(player1);
            System.out.println("isRoll: " + player1TurnPhase[0] + ", isUpdateScore: " + player1TurnPhase[1]);

            if((player1TurnPhase[0] == true) && (player1TurnPhase[1] == true)){
                //Turn is not finished and Player is not finished rolling, So player can keep re-rolling the dice
                finalRoll = host.keepReRollDice(player1, keepDice, riggedDice, firstRoll, riggedCard);
            }else if ( (player1TurnPhase[0] == false) && (player1TurnPhase[1] == true)){
                //Finished rolling now calculate score
                host.calculateScore(player1, riggedCard, finalRoll);
            }
        }//End While Loop
        //if turn ended, rolling is done and the score is set
        if((player1TurnPhase[0] == false) && (player1TurnPhase[1] == false)){
            System.out.println(host.endTurn(player1));
        }

        int score = 0;
        assertEquals(score, host.getScores()[0]);

    }

    @Test
    @DisplayName("Getting ending turn after getting a skull fortune card with 2 skulls")
    void calculateScore5(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Skulls;

        GameHost.Dice[] riggeddDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Skull};


        int numOfSkulls = host.getSkullCardType(player1, 2);
        player1.setSkullCardNum(numOfSkulls);

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, riggeddDice);

        int score = 0;
        assertEquals(score, host.calculateScore(player1, card, firstRoll));
    }

    @Test
    @DisplayName("Getting a score after getting a SeaBattle fortune card with 2 swords on it")
    void calculateScore6(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.SeaBattle;

        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Skull};

        int numOfSwords = host.getSwordCardType(player1, 2);
        player1.setSwordCardNum(numOfSwords);

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, riggedDice);

        int score = 600;
        assertEquals(score, host.calculateScore(player1, card, firstRoll));
    }

    @Test
    @DisplayName("Getting a score after getting a SeaBattle fortune card with 2 swords on it")
    void calculateScore7(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.SeaBattle;

        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Monkey,
                GameHost.Dice.Monkey, GameHost.Dice.Skull};

        int numOfSwords = host.getSwordCardType(player1, 2);
        player1.setSwordCardNum(numOfSwords);

        player1.updateScore(1000);

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, riggedDice);

        GameHost.Dice[] newRiggeddDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Skull};

        int[] keepDice = {0,1,2,3,4,7};
        GameHost.Dice[] finalRoll;
        finalRoll = host.keepReRollDice(player1, keepDice, firstRoll, newRiggeddDice, card);

        int score = 700;
        assertEquals(score, player1.getScore());
    }

    @Test
    @DisplayName("Test for entering Island of the Skulls and deduct opponents scores.")
    void skullIsland(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Captain;

        GameHost.Dice[] riggedDice = {GameHost.Dice.Skull, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Diamond, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond};
        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Skull, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Skull, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond};
        GameHost.Dice[] riggedDice3 = {GameHost.Dice.Skull, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Skull, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond};

        player1.updateScore(1000);
        player2.updateScore(2000);
        player3.updateScore(700);

        host.displayScores();

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, riggedDice);
        GameHost.Dice[] secondRoll = new GameHost.Dice[8];
        GameHost.Dice[] finalRoll = new GameHost.Dice[8];

        if(player1.getIsSkullIsland() ==  true){
            secondRoll = host.skullIsland(player1, card, firstRoll, riggedDice2);
        }
        if(player1.getIsSkullIsland() ==  true){
            finalRoll = host.skullIsland(player1, card, secondRoll, riggedDice3);
        }
        if(player1.getIsSkullIsland() ==  false){
            host.displayScores();
            System.out.println(host.endTurn(player1));
        }

        int scores[] = {1000, 1000, 0};
        assertArrayEquals(scores, host.getScores());
    }

    @Test
    @DisplayName("Getting a score after getting a Sorceress fortune card and rerolling one of the skull dice")
    void calculateScore8(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Sorceress;

        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Skull};
        int[] keepdice = {0,1,3,6,4};

        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Monkey,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Sword};
        int[] keepdice2 = {0,1,2,3,6};

        GameHost.Dice[] riggedDice3 = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Monkey,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Skull,
                GameHost.Dice.Gold, GameHost.Dice.Gold};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, riggedDice);
        System.out.println("First Roll:");
        System.out.println(Arrays.toString(firstRoll));

        GameHost.Dice[] secondReRoll = host.keepReRollDice(player1, keepdice, firstRoll, riggedDice2, card);
        System.out.println("Second Roll:");
        System.out.println(Arrays.toString(secondReRoll));

        GameHost.Dice[] thridReRoll = host.keepReRollDice(player1, keepdice2, secondReRoll, riggedDice3, card);
        System.out.println("Third Roll:");
        System.out.println(Arrays.toString(thridReRoll));

        int score = 700;
        assertEquals(score, host.calculateScore(player1, card, thridReRoll));
    }

    @Test
    @DisplayName("Starting the pirateServer and creating a gameHost instance")
    void pirateServerStart(){
        int port = 54321;
        try{
            Socket player1Socket = new Socket("localhost", port);
            Socket player2Socket = new Socket("localhost", port);
            Socket player3Socket = new Socket("localhost", port);
            Socket[] playerSockets = {player1Socket,player2Socket,player3Socket};

            PirateServer server = new PirateServer(playerSockets);

        }catch(Exception e){System.out.println(e);}

    }

    @Test
    @DisplayName("Starting the First Round of the Pirate Game")
    void pirateServerStartFirstRound(){
        int port = 54321;
        try{
            Socket player1Socket = new Socket("localhost", port);
            Socket player2Socket = new Socket("localhost", port);
            Socket player3Socket = new Socket("localhost", port);
            Socket[] playerSockets = {player1Socket,player2Socket,player3Socket};

            PirateServer server = new PirateServer(playerSockets);

            Player player1 = new Player(1);
            Player player2 = new Player(2);
            Player player3 = new Player(3);
            Player[] players = {player1, player2, player3};

            GameHost host = new GameHost(players);

            server.startRound(host);

        }catch(Exception e){System.out.println(e);}

    }

    @Test
    @DisplayName("Test for one winner after")
    void finalWinner(){
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        player1.updateScore(1500);
        player2.updateScore(1500);
        player3.updateScore(2000);

        //No winner
        System.out.println("1: " + host.checkForWinner());
        //Updated scare for Player 2 to be winner
        player2.updateScore(2000);
        System.out.println("2: "+ host.checkForWinner());

        //end round needs to be done 2 more times for the other players to have a turn
        System.out.println("3: "+ host.checkForWinner());
        System.out.println("4: " +  host.checkForWinner());

        String winningPlayer = "";
        if (host.isWinner == true) {
            winningPlayer = host.getWinner();
        }

        String expected = "Player 2 wins";
        assertEquals(expected, winningPlayer);
    }

    @Test
    @DisplayName("Testing user input for a valid input")
    void testingUserInput(){

        String input1 = "1";
        String input2 = "1,2";
        String input3 = "1,2,3";
        String input4 = "1,2,3,4";
        String input5 = "1,2,3,4,5";
        String input6 = "1,2,3,4,5,6";

        String[] inputs = {input1, input2, input3, input4, input5, input6};
        boolean[] results = {false, false, false, false, false, false};
        int counter = 0;
        for (int i = 0; i < inputs.length; i++){
            if(PirateServer.isInputValid(inputs[i])){
                results[i] = true;
                System.out.println("input "+ i + "= true");
                counter = counter + 1;
            } else {
                System.out.println("input "+ i + "= false");
            }
        }
        boolean finalResult = false;
        if(counter == results.length){
            finalResult = true;
        }


        boolean expected = true;
        assertEquals(expected, finalResult);
    }

    @Test
    @DisplayName("Testing If there is 2 or more dice to re-Roll")
    void testingUserInput2(){

        GameHost.Dice[] dice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Diamond, GameHost.Dice.Sword,
                GameHost.Dice.Monkey, GameHost.Dice.Skull};

        int[] keepdice = {1,2,3,4};

        boolean finalResult = PirateServer.isreRollPossible(dice, keepdice);


        boolean expected = true;
        assertEquals(expected, finalResult);
    }






}