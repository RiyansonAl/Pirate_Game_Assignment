package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(rolledDice, host.rollDice(8,riggedDice) );
    }



}