package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameHostTest {

    @Test
    @DisplayName("Creating Game and adding 3 players")
    void numOfPlayers() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        assertEquals(3, host.numOfPlayers() );
    }

    @Test
    @DisplayName("Drawing cards from the deck ")
    void drawCard() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        assertEquals(GameHost.FortuneCard.TreasureChest, host.drawCard(1) );
    }
    @Test
    @DisplayName("Rolling the Dice")
    void rollDice() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        int[] riggedDice = {1,2,3,4,5,6,1,2};
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Gold,
                                        GameHost.Dice.Diamond, GameHost.Dice.Sword, GameHost.Dice.Skull,
                                        GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        assertArrayEquals(rolledDice, host.rollDice(8, riggedDice) );
    }
    @Test
    @DisplayName("Get Players scores ")
    void getScore() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
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
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        host.displayScores();
        host.updateScore(player1, 500);
        host.updateScore(player2, 200);
        host.updateScore(player3, 150);
        host.displayScores();
        host.updateScore(player1, 2500);
        host.updateScore(player2, 1000);
        host.updateScore(player3, 1500);
        host.displayScores();
        String winner = "Player 1 wins\n";
        assertEquals(winner, host.endRound());

    }

    @Test
    @DisplayName("Keeping Dice and Re-Rolling the rest of the Dice")
    void keepReRollDice() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);
        int[] riggedDice = {1,2,3,4,5,6,1,2};

        GameHost.Dice[] FirstRolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Gold,
                GameHost.Dice.Diamond, GameHost.Dice.Sword, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        GameHost.Dice[] rolledDice = host.rollDice(8, riggedDice);
        int[] keepDice = {0,6,1,7};
        riggedDice = new int[]{1, 1, 2, 2, 6, 6, 1, 2};
        GameHost.Dice[] FinalRolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        assertArrayEquals(FinalRolledDice, host.keepReRollDice(keepDice, rolledDice, riggedDice, false) );
    }

    @Test
    @DisplayName("Getting Scorce using a captain fortune card")
    void calculateScore(){
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Captain;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};
        int score = 400;
        assertEquals(score, host.calculateScore(player1, card, rolledDice));
    }




}