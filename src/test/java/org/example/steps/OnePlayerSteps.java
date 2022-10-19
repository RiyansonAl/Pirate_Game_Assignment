package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.GameHost;
import org.example.Player;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnePlayerSteps {
    GameHost host;
    Player player1;
    Player player2;
    Player player3;
    Player[] players;
    GameHost.FortuneCard card;
    GameHost.Dice[] roll;
    int score;
    Player currentPlayer;

    @Given("that the host is initialized")
    public void thatTheHostIsInitialized() {
        System.out.println("init");
        player1 = new Player(1);
        player2 = new Player(2);
        player3 = new Player(3);
        players = new Player[]{player1, player2, player3};

        host = new GameHost(players);
        score = 0;
        System.out.println("init end");
    }

    @When("I roll {string}")
    public void iRoll(String stringRoll) {
        String[] diceString = stringRoll.split(",",9);
        System.out.println(Arrays.toString(diceString));
        System.out.println(diceString[1]);
        System.out.println(diceString[1].strip());

        GameHost.Dice[] gotRoll = new GameHost.Dice[diceString.length];

        for (int i = 0; i < gotRoll.length; i++){
            gotRoll[i] = host.getRollByName(diceString[i].strip());
        }
        roll = gotRoll;
        System.out.println(Arrays.toString(gotRoll));
        System.out.println(gotRoll[3]);


    }

    @And("I draw a {string} card")
    public void iDrawACard(String cardName) {
        System.out.println("Draw Card");
        card = host.getCardByName(cardName);
        System.out.println(card);

    }

    @Then("I die and get a score of {int}")
    public void iDieAndGetAScoreOf(int score) {
        boolean[] playerTurnPhase = host.getPlayerTurnPhase(currentPlayer);
        int obtainScore = 0;
        System.out.println("PlayerTurnPhase = " + playerTurnPhase[1] );
        if(playerTurnPhase[1] == true){
            obtainScore = host.calculateScore(currentPlayer, card, roll);
        }
        System.out.println("Printing the string " + score);
        System.out.println(host.endTurn(player1));
        assertEquals(score, obtainScore);

    }

    @And("Player {int} starts there turn")
    public void startsThereTurn(int playerNum) {
        switch (playerNum){
            case 1:
                currentPlayer = player1;
                break;
            case 2:
                currentPlayer = player2;
                break;
            case 3:
                currentPlayer = player3;
                break;
            default:
                currentPlayer = player1;
                break;
        }
        roll = host.playerTurnStart(currentPlayer, card, roll);
    }

    @And("Player {int} keeps dice {string} and re-rolls the rest and gets {string}")
    public void playerKeepsDiceAndReRollsTheRestAndGets(int playerNum, String keepDiceString, String stringRoll) {

        String[] diceString = stringRoll.split(",",9);

        GameHost.Dice[] preDice = roll;

        GameHost.Dice[] gotRoll = new GameHost.Dice[diceString.length];

        for (int i = 0; i < gotRoll.length; i++){
            gotRoll[i] = host.getRollByName(diceString[i].strip());
        }

        String[] keepDiceStringSpilt = keepDiceString.split(",", 9);
        int[] keepDice = new int[keepDiceStringSpilt.length];

        for (int i = 0; i < keepDiceStringSpilt.length; i++){
            keepDice[i] = (Integer.valueOf(keepDiceStringSpilt[i]) - 1);
        }
        System.out.println(Arrays.toString(keepDice));


        roll = host.keepReRollDice(currentPlayer, keepDice, preDice, gotRoll, card);

    }

    @Then("I get a score of {int}")
    public void iGetAScoreOf(int score) {
        boolean[] playerTurnPhase = host.getPlayerTurnPhase(currentPlayer);
        int obtainScore = 0;
        System.out.println("PlayerTurnPhase = " + playerTurnPhase[1] );
        if(playerTurnPhase[1] == true){
            obtainScore = host.calculateScore(currentPlayer, card, roll);
        }
        System.out.println("Printing the string " + score);
        System.out.println(host.endTurn(player1));
        assertEquals(score, obtainScore);
    }
}
