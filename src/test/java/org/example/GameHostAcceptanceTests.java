package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameHostAcceptanceTests {

    @Test
    @DisplayName("die with 3 skulls on first roll")
    void dieWith3Skulls(){
        System.out.println("A-TEST: die with 3 skulls on first roll\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Diamond, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 0;
        assertEquals(score, host.calculateScore(player1, card, firstRoll));
    }

    @Test
    @DisplayName("Acceptance Test Line 45")
    void acceptanceTestLine45(){
        System.out.println("A-TEST Line 45\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Skull, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Sword,
                GameHost.Dice.Sword, GameHost.Dice.Sword};
        int[] keepDice = {1,2,3,4};
        GameHost.Dice[] riggedDice = {GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Sword};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 0;
        assertEquals(score, host.calculateScore(player1, card, secondRoll));
    }

    @Test
    @DisplayName("Acceptance Test Line 46")
    void acceptanceTestLine46(){
        System.out.println("A-TEST Line 46\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Skull, GameHost.Dice.Skull, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Sword, GameHost.Dice.Sword};
        int[] keepDice = {2,3,4,5};
        GameHost.Dice[] riggedDice = {GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Sword};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 0;
        assertEquals(score, host.calculateScore(player1, card, secondRoll));
    }

}