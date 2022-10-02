package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GameHostMultiPlayerAcceptanceTest {

    @Test
    @DisplayName("Acceptance Test Line 131")
    void acceptanceTestLine131(){
        System.out.println("A-TEST Line 131\n");

        try {
            System.out.println("A-TEST Line 131\n");
            Player player1 = new Player(1);
            Player player2 = new Player(2);
            Player player3 = new Player(3);
            Player[] players = {player1, player2, player3};

            GameHost host = new GameHost(players);

            //Set winning score to 4000
            host.winningScore = 4000;

            //Player 1 card and Dice roll
            GameHost.FortuneCard player1Card = GameHost.FortuneCard.Captain;
            GameHost.Dice[] player1Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Skull};

            //Player 2 card and Dice roll
            GameHost.FortuneCard player2Card = GameHost.FortuneCard.Sorceress;
            GameHost.Dice[] player2Dice = {GameHost.Dice.Monkey, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                    GameHost.Dice.Monkey, GameHost.Dice.Skull};

            //Player 3 card and Dice roll
            GameHost.FortuneCard player3Card = GameHost.FortuneCard.Captain;
            GameHost.Dice[] player3Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Skull, GameHost.Dice.Skull,
                    GameHost.Dice.Sword, GameHost.Dice.Skull};


            String msg = "";

            System.out.println("Starting Player 1 Turn");
            msg = msg + "Starting Player 1 Turn\n";
            player1Dice = host.playerTurnStart(player1, player1Card, player1Dice);
            msg = msg + "Player 1 card: " + player1Card.toString() + "\n";
            msg = msg + "Player 1 Rolled Dice: " + Arrays.toString(player1Dice) + "\n";
            //Score for Player 1
            int score = host.calculateScore(player1, player1Card, player1Dice);
            //End Player 1's turn
            msg = msg + host.endTurn(player1);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();


            System.out.println("Starting Player 2 Turn");
            msg = msg + "Starting Player 2 Turn\n";
            player2Dice = host.playerTurnStart(player2, player2Card, player2Dice);
            msg = msg + "Player 2 card: " + player2Card.toString() + "\n";
            msg = msg + "Player 2 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 2
            score = host.calculateScore(player2, player2Card, player2Dice);
            //End Player 2's turn
            msg = msg + host.endTurn(player2);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();

            System.out.println("Starting Player 3 Turn");
            msg = msg + "Starting Player 3 Turn\n";
            player3Dice = host.playerTurnStart(player3, player3Card, player3Dice);
            msg = msg + "Player 3 card: " + player3Card.toString() + "\n";
            msg = msg + "Player 3 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 3
            score = host.calculateScore(player3, player3Card, player3Dice);
            //End Player 3's turn
            msg = msg + host.endTurn(player3);
            msg = msg + "\nFinal Score board: \n";
            msg = msg + host.displayScores();
            System.out.println(msg);

            //Create a text file to write the steps to this test
            File test131 = new File("TestLine131.txt");

            FileWriter writer = new FileWriter("TestLine131.txt");
            writer.write(msg);
            writer.close();


            int[] ExpectedScores = {4000, 100, 0};
            assertArrayEquals(ExpectedScores, host.getScores());
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Acceptance Test Line 134")
    void acceptanceTestLine134(){
        System.out.println("A-TEST Line 134\n");

        try {
            Player player1 = new Player(1);
            Player player2 = new Player(2);
            Player player3 = new Player(3);
            Player[] players = {player1, player2, player3};

            GameHost host = new GameHost(players);

            //Set winning score to 4000
            host.winningScore = 4000;

            //Player 1 card and Dice roll
            GameHost.FortuneCard player1Card = GameHost.FortuneCard.Captain;
            GameHost.Dice[] player1Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Skull};

            //Player 2 card and Dice roll
            GameHost.FortuneCard player2Card = GameHost.FortuneCard.Sorceress;
            GameHost.Dice[] player2Dice = {GameHost.Dice.Monkey, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Skull,
                    GameHost.Dice.Skull, GameHost.Dice.Skull};

            //Player 3 card and Dice roll
            GameHost.FortuneCard player3Card = GameHost.FortuneCard.Skulls;
            GameHost.Dice[] player3Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Skull, GameHost.Dice.Skull,
                    GameHost.Dice.Skull, GameHost.Dice.Skull};


            String msg = "";

            System.out.println("Starting Player 1 Turn");
            msg = msg + "Starting Player 1 Turn\n";
            player1Dice = host.playerTurnStart(player1, player1Card, player1Dice);
            msg = msg + "Player 1 card: " + player1Card.toString() + "\n";
            msg = msg + "Player 1 Rolled Dice: " + Arrays.toString(player1Dice) + "\n";
            //Score for Player 1
            int score = host.calculateScore(player1, player1Card, player1Dice);
            //End Player 1's turn
            msg = msg + host.endTurn(player1);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();


            System.out.println("Starting Player 2 Turn");
            msg = msg + "Starting Player 2 Turn\n";
            player2Dice = host.playerTurnStart(player2, player2Card, player2Dice);
            msg = msg + "Player 2 card: " + player2Card.toString() + "\n";
            msg = msg + "Player 2 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 2
            score = host.calculateScore(player2, player2Card, player2Dice);
            //End Player 2's turn
            msg = msg + host.endTurn(player2);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();

            System.out.println("Starting Player 3 Turn");
            msg = msg + "Starting Player 3 Turn\n";
            player3Dice = host.playerTurnStart(player3, player3Card, player3Dice);
            player3.setSkullCardNum(1);
            int player3CardInfo = player3.getSkullCardNum();
            msg = msg + "Player 3 card: " + player3Card.toString() + " (" + player3CardInfo + " Skull)\n";
            msg = msg + "Player 3 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            player3.setSkullCardNum(1);

            //Player 3 goes to skull island
            if(player3.getIsSkullIsland() == true){
                msg = msg + "Player 3 goes to skull island \n";
                host.skullIsland(player3, player3Card, player3Dice, player3Dice);

            }

            //Score for Player 3
            score = host.calculateScore(player3, player3Card, player3Dice);
            //End Player 3's turn
            msg = msg + host.endTurn(player3);
            msg = msg + "\nFinal Score board: \n";
            msg = msg + host.displayScores();
            System.out.println(msg);

            //Create a text file to write the steps to this test
            File test131 = new File("TestLine134.txt");

            FileWriter writer = new FileWriter("TestLine134.txt");
            writer.write(msg);
            writer.close();


            int[] ExpectedScores = {3500, 0, 0};
            assertArrayEquals(ExpectedScores, host.getScores());
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Acceptance Test Line 139")
    void acceptanceTestLine139(){
        System.out.println("A-TEST Line 139\n");

        try {
            Player player1 = new Player(1);
            Player player2 = new Player(2);
            Player player3 = new Player(3);
            Player[] players = {player1, player2, player3};

            GameHost host = new GameHost(players);

            //Set winning score to 4000
            host.winningScore = 4000;

            //Player 1 card and Dice roll
            GameHost.FortuneCard player1Card = GameHost.FortuneCard.Captain;
            GameHost.Dice[] player1Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Skull,
                    GameHost.Dice.Skull, GameHost.Dice.Skull};

            GameHost.Dice[] player1Dice2 = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword};

            //Player 2 card and Dice roll
            GameHost.FortuneCard player2Card = GameHost.FortuneCard.Captain;
            GameHost.Dice[] player2Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Skull};

            GameHost.Dice[] player2Dice2 = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Skull,
                    GameHost.Dice.Skull, GameHost.Dice.Skull};

            //Player 3 card and Dice roll
            GameHost.FortuneCard player3Card = GameHost.FortuneCard.Captain;
            GameHost.Dice[] player3Dice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                    GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Skull,
                    GameHost.Dice.Skull, GameHost.Dice.Skull};


            String msg = "";

            System.out.println("Starting Player 1 Turn");
            msg = msg + "Starting Player 1 Turn\n";
            player1Dice = host.playerTurnStart(player1, player1Card, player1Dice);
            msg = msg + "Player 1 card: " + player1Card.toString() + "\n";
            msg = msg + "Player 1 Rolled Dice: " + Arrays.toString(player1Dice) + "\n";
            //Score for Player 1
            int score = host.calculateScore(player1, player1Card, player1Dice);
            //End Player 1's turn
            msg = msg + host.endTurn(player1);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();


            System.out.println("Starting Player 2 Turn");
            msg = msg + "Starting Player 2 Turn\n";
            player2Dice = host.playerTurnStart(player2, player2Card, player2Dice);
            msg = msg + "Player 2 card: " + player2Card.toString() + "\n";
            msg = msg + "Player 2 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 2
            score = host.calculateScore(player2, player2Card, player2Dice);
            //End Player 2's turn
            msg = msg + host.endTurn(player2);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();

            System.out.println("Starting Player 3 Turn");
            msg = msg + "Starting Player 3 Turn\n";
            player3Dice = host.playerTurnStart(player3, player3Card, player3Dice);
            msg = msg + "Player 3 card: " + player3Card.toString() + "\n";
            msg = msg + "Player 3 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 3
            score = host.calculateScore(player3, player3Card, player3Dice);
            //End Player 3's turn
            msg = msg + host.endTurn(player3);
            msg = msg + "\nScore board: \n";
            msg = msg + host.displayScores();
            System.out.println(msg);

            //Round 2, player 1 gets 9000 and get player 2 and player 3 a chance to bring down player 1's score
            System.out.println("Starting Player 1 Turn");
            msg = msg + "ROUND 2 \nStarting Player 1 Turn\n";
            player1Dice = host.playerTurnStart(player1, player1Card, player1Dice2);
            msg = msg + "Player 1 card: " + player1Card.toString() + "\n";
            msg = msg + "Player 1 Rolled Dice: " + Arrays.toString(player1Dice) + "\n";
            //Score for Player 1
            score = host.calculateScore(player1, player1Card, player1Dice);
            //End Player 1's turn
            msg = msg + host.endTurn(player1);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();


            System.out.println("Starting Player 2 Turn");
            msg = msg + "Starting Player 2 Turn\n";
            player2Dice = host.playerTurnStart(player2, player2Card, player2Dice2);
            msg = msg + "Player 2 card: " + player2Card.toString() + "\n";
            msg = msg + "Player 2 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 2
            score = host.calculateScore(player2, player2Card, player2Dice);
            //End Player 2's turn
            msg = msg + host.endTurn(player2);
            msg = msg + "Score board: \n";
            msg = msg + host.displayScores();

            System.out.println("Starting Player 3 Turn");
            msg = msg + "Starting Player 3 Turn\n";
            player3Dice = host.playerTurnStart(player3, player3Card, player3Dice);
            msg = msg + "Player 3 card: " + player3Card.toString() + "\n";
            msg = msg + "Player 3 Rolled Dice: " + Arrays.toString(player2Dice) + "\n";
            //Score for Player 3
            score = host.calculateScore(player3, player3Card, player3Dice);
            //End Player 3's turn
            msg = msg + host.endTurn(player3);
            msg = msg + "\nScore board: \n";
            msg = msg + host.displayScores();

            //Create a text file to write the steps to this test
            File test131 = new File("TestLine139.txt");

            FileWriter writer = new FileWriter("TestLine139.txt");
            writer.write(msg);
            writer.close();


            int[] ExpectedScores = {9000, 4000, 0};
            assertArrayEquals(ExpectedScores, host.getScores());
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }





}//End Test class