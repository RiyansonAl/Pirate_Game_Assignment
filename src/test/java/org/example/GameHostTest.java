package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertArrayEquals(FinalRolledDice, host.keepReRollDice(player1, keepDice, rolledDice, FinalRolledDice, false, GameHost.FortuneCard.None) );
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
        int score = 4900;
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
        int score = 2100;
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
                finalRoll = host.keepReRollDice(player1, keepDice, riggedDice, riggedDiceReRolled, false, riggedCard);
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
                finalRoll = host.keepReRollDice(player1, keepDice, riggedDice, firstRoll, false, riggedCard);
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
        finalRoll = host.keepReRollDice(player1, keepDice, firstRoll, newRiggeddDice, false, card);

        int score = 700;
        assertEquals(score, player1.getScore());
    }

    //TODO: Skull Island Test
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

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, riggedDice);
        GameHost.Dice[] secondRoll = new GameHost.Dice[8];
        GameHost.Dice[] finalRoll = new GameHost.Dice[8];

        if(player1.getIsSkullIsland ==  true){
            secondRoll = host.skullIsland(player1, card, firstRoll, riggedDice2);
        }
        if(player1.getIsSkullIsland ==  true){
            finalRoll = host.skullIsland(player1, card, secondRoll, riggedDice3);
        }
        if(player1.getIsSkullIsland ==  false){
            host.displayScores()
            System.out.println(host.endRound());
        }

        int scores[] = {1000, 1000, 0};
        assertArrayEquals(scores, host.getScores());
    }


    //TODO: Refactor Sorceress card to only work Once per round not once per re-roll




}