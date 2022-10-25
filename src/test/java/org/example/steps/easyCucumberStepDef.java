package org.example.steps;

// MyStepDefinition.java
import scs.comp5903.cucumber.model.annotation.*;
import scs.comp5903.cucumber.model.JStepKeyword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.GameHost;
import org.example.Player;

import java.io.File;
import java.util.Arrays;

public class easyCucumberStepDef {

    private int count;
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

    @JGivenStep("I have {int} apple")
    // @JStep(keyword = JStepKeyword.GIVEN, step = "I have {int} apple") // alternatively, u can use @JStep
    public void iHave(int count) {
        this.count = count;
        System.out.println("Nukber of apples: " + count);
    }

    @JWhenStep("I eat {int} apple")
    public void iEat(int eatCount) {
        this.count -= eatCount;
    }

    @JThenStep("I should left {int} apple")
    public void iShouldLeft(int leftCount) {
        assertEquals(leftCount, this.count);
    }

    @JGivenStep("that the host is initialized")
    public void hostinit() {
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

    @JWhenStep("Player {int} rolls {String}")
    public void playerRoll(int playerNum, String stringRoll) {
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

    @JAndStep("Player {int} draws a {String} card")
    public void playerDraw(int playerNum, String cardName) {
        System.out.println("Draw Card");
        card = host.getCardByName(cardName);
        System.out.println(card);
    }

    @JAndStep("Player {int} starts there turn")
    public void playerStartTurn(int playerNum) {
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

    @JThenStep("Player {int} dies and gets a score of {int}")
    public void iShouldLeft(int playerNum, int score) {
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

    @JAndStep("Player {int} keeps dice {String} and re-rolls the rest and gets {String}")
    public void playerKeepReRoll(int playerNum, String keepDiceString, String stringRoll) {
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

    @JThenStep("Player {int} gets a score of {int}")
    public void playerScoreing(int playerNum, int score) {
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

    @JAndStep("Player {int} draws the {String} card with {String}")
    public void playerDrawsSpecialCard(int playerNum, String cardName, String cardnumString) {
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

    @JAndStep("Player {int} enters island of skulls and rolls {String}")
    public void playerEntersIslandOfSkulls(int playerNum, String stringRoll) {
        String[] diceString = stringRoll.split(",",9);

        GameHost.Dice[] gotRoll = new GameHost.Dice[diceString.length];

        for (int i = 0; i < gotRoll.length; i++){
            gotRoll[i] = host.getRollByName(diceString[i].strip());
        }

        if(currentPlayer.getIsSkullIsland() == true){
            roll = host.skullIsland(currentPlayer, card, roll, gotRoll);
        }
    }

    @JThenStep("Player {int} exits island of skulls and subtracts {int} to each other player's score")
    public void playerExitsIslandOfSkulls(int playerNum, int score) {
        System.out.println("Exit skull island");
        roll = host.skullIsland(currentPlayer, card, roll, roll);
        String[] temp = currentPlayer.getScoreBreakDown().split("=", 2);
        String[] negativeScoreString = temp[1].split(" ", 5);
        int negativeScore = Integer.valueOf(negativeScoreString[1]);

        //System.out.println(currentPlayer.getScoreBreakDown());
        System.out.println(host.endTurn(currentPlayer));
        assertEquals(score, negativeScore);
    }

    @JAndStep("Player {int} has {int} points")
    public void playerEntersIslandOfSkulls(int playerNum, int points) {
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



}
