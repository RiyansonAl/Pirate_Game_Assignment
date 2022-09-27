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

        GameHost.FortuneCard card = GameHost.FortuneCard.MonkeyBusiness;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Diamond, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 0;
        assertEquals(score, host.calculateScore(player1, card, firstRoll));
    }

}