package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.GameHost;
import org.example.Player;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    File fileName;

    String msg = "";

    @Given("that the host is initialized")
    public void thatTheHostIsInitialized() {
        System.out.println("init");
        player1 = new Player(1);
        player2 = new Player(2);
        player3 = new Player(3);
        players = new Player[]{player1, player2, player3};

        host = new GameHost(players);
        score = 0;
        msg = "";
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
        } else {
            obtainScore = currentPlayer.getScore();
        }
        System.out.println("Printing the string " + score);
        System.out.println(host.endTurn(currentPlayer));
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
        msg = msg + "\nStarting Player " + playerNum + " Turn\n";
        msg = msg + "Player " + playerNum + " Draws " + card.toString() + "\n";
        msg = msg + "Player " + playerNum + " Rolls " + Arrays.toString(roll) + "\n";
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
        String endTurnMsg = host.endTurn(currentPlayer);
        System.out.println(endTurnMsg);
        msg = msg + endTurnMsg;
        assertEquals(score, obtainScore);
    }

    @And("Player {int} draws a {string} card with {string}")
    public void playerDrawsACardWith(int playerNum, String cardName, String cardnumString) {
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

        System.out.println("Draw Card");
        card = host.getCardByName(cardName);

        String[] cardnumSplit = cardnumString.split(" ", 2);

        int cardNum = Integer.valueOf(cardnumSplit[0]);
        if(cardnumSplit[1].equals("Swords")){
            currentPlayer.setSwordCardNum(cardNum);
        } else if (cardnumSplit[1].equals("Skulls")){
            currentPlayer.setSkullCardNum(cardNum);
        }


        System.out.println("Card: " + card + " with number: " + cardNum);
        msg = msg + "Player " + playerNum + " draws " + card + " with number: " + cardNum + "\n";

    }

    @And("Player {int} enters Skull island and rolls {string}")
    public void playerEntersSkullIslandAndRolls(int playerNum, String stringRoll) {
        String[] diceString = stringRoll.split(",",9);

        GameHost.Dice[] gotRoll = new GameHost.Dice[diceString.length];

        for (int i = 0; i < gotRoll.length; i++){
            gotRoll[i] = host.getRollByName(diceString[i].strip());
        }
        //roll = gotRoll;

        if(currentPlayer.getIsSkullIsland() == true){
            roll = host.skullIsland(currentPlayer, card, roll, gotRoll);
        }

    }

    @Then("Player {int} exits Skull island and subtracts {int} to each other player's score")
    public void playerExitsSkullIslandAndSubtractsToEachOtherPlayerSScore(int playerNum, int score) {
        System.out.println("Exit skull island");
        roll = host.skullIsland(currentPlayer, card, roll, roll);
        String[] temp = currentPlayer.getScoreBreakDown().split("=", 2);
        String[] negativeScoreString = temp[1].split(" ", 5);
        int negativeScore = Integer.valueOf(negativeScoreString[1]);

        //System.out.println(currentPlayer.getScoreBreakDown());
        System.out.println(host.endTurn(currentPlayer));
        assertEquals(score, negativeScore);
    }

    @And("Player {int} has {int} points")
    public void playerHasPoints(int playerNum, int points) {

        switch (playerNum){
            case 1:
                player1.updateScore(points);
                break;
            case 2:
                player2.updateScore(points);
                break;
            case 3:
                player3.updateScore(points);
                break;
            default:
                player1.updateScore(points);
                break;
        }

    }

    @When("Player {int} rolls {string}")
    public void playerRolls(int playerNum, String stringRoll) {
        String[] diceString = stringRoll.split(",",9);
        //System.out.println(Arrays.toString(diceString));
        //System.out.println(diceString[1]);
        //System.out.println(diceString[1].strip());

        GameHost.Dice[] gotRoll = new GameHost.Dice[diceString.length];

        for (int i = 0; i < gotRoll.length; i++){
            gotRoll[i] = host.getRollByName(diceString[i].strip());
        }
        roll = gotRoll;
        //System.out.println(Arrays.toString(gotRoll));
        //System.out.println(gotRoll[3]);

    }

    @And("Player {int} draws a {string} card")
    public void playerDrawsACard(int playerNum, String cardName) {
        System.out.println("Draw Card");
        card = host.getCardByName(cardName);
        System.out.println(card);
    }

    @Then("Player {int} gets a score of {int}")
    public void playerGetsAScoreOf(int playerBum, int score) {
        boolean[] playerTurnPhase = host.getPlayerTurnPhase(currentPlayer);
        int obtainScore = 0;
        System.out.println("PlayerTurnPhase = " + playerTurnPhase[1] );
        if(playerTurnPhase[1] == true){
            obtainScore = host.calculateScore(currentPlayer, card, roll);
        }
        System.out.println("Printing the string " + score);
        String endTurnMsg = host.endTurn(currentPlayer);
        System.out.println(endTurnMsg);
        msg = msg + endTurnMsg;
        assertEquals(score, obtainScore);

    }

    @And("the scores are displayed")
    public void theScoresAreDisplayed() {
        msg = msg + "\nScore board: \n";
        String scoreboard = host.displayScores();
        msg = msg + scoreboard;
        System.out.println(scoreboard);
    }

    @Then("log the game in log file {string}")
    public void logTheGameInLogFile(String logName) {
        fileName = new File(logName);
        try {
            FileWriter writer = new FileWriter(logName);
            writer.write(msg);
            writer.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Given("that the host is initialized with {int} players")
    public void thatTheHostIsInitializedWithPlayers(int numOfPlayers) {
        System.out.println("init");
        player1 = new Player(1);
        player2 = new Player(2);
        player3 = new Player(3);
        if(numOfPlayers == 2){
            players = new Player[]{player1, player2};

        } else {
            players = new Player[]{player1, player2, player3};
        }

        host = new GameHost(players);
        score = 0;
        msg = "";
        System.out.println("init end");


    }
}
