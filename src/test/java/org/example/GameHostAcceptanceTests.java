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

    @Test
    @DisplayName("Acceptance Test Line 47")
    void acceptanceTestLine47(){
        System.out.println("A-TEST Line 47\n");
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
                GameHost.Dice.Monkey, GameHost.Dice.Monkey};
        int[] keepDice2 = {1,2,3,4,5,6};
        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Skull, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);
        GameHost.Dice[] thirdRoll = host.keepReRollDice(player1, keepDice, secondRoll, riggedDice2, card);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 0;
        assertEquals(score, host.calculateScore(player1, card, thirdRoll));
    }

    @Test
    @DisplayName("Acceptance Test Line 49")
    void acceptanceTestLine49(){
        System.out.println("A-TEST Line 49\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Skull, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Gold, GameHost.Dice.Gold};
        int[] keepDice = {3,4,5,6,7};
        GameHost.Dice[] riggedDice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Skull,
                GameHost.Dice.Gold, GameHost.Dice.Gold};
        int[] keepDice2 = {3,4,5,6,7};
        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Skull,
                GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Gold, GameHost.Dice.Gold};

        System.out.println("First Roll");
        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        System.out.println("Second Roll");
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);
        System.out.println("Third Roll");
        GameHost.Dice[] thirdRoll = host.keepReRollDice(player1, keepDice, secondRoll, riggedDice2, card);

        player1.setUpdateScore(true);
        int ObtainedScore = host.calculateScore(player1, card, thirdRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 4800;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 51")
    void acceptanceTestLine51(){
        System.out.println("A-TEST: Acceptance Test Line 51\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Captain;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Diamond, GameHost.Dice.Diamond, GameHost.Dice.Skull,
                GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 800;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 52")
    void acceptanceTestLine52(){
        System.out.println("A-TEST: Acceptance Test Line 52\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Skull,
                GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Parrot,
                GameHost.Dice.Skull, GameHost.Dice.Parrot};

        int[] keepDice = {0,1};

        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Skull,
                GameHost.Dice.Skull, GameHost.Dice.Sword, GameHost.Dice.Parrot,
                GameHost.Dice.Monkey, GameHost.Dice.Parrot};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);

        int ObtainedScore = host.calculateScore(player1, card, secondRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 200;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 53")
    void acceptanceTestLine53(){
        System.out.println("A-TEST: Acceptance Test Line 53\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Monkey,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 300;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 54")
    void acceptanceTestLine54(){
        System.out.println("A-TEST: Acceptance Test Line 54\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Monkey,
                GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Parrot,
                GameHost.Dice.Skull, GameHost.Dice.Parrot};

        int[] keepDice = {0,1,2};

        GameHost.Dice[] riggedDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Monkey,
                GameHost.Dice.Skull, GameHost.Dice.Sword, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);

        int ObtainedScore = host.calculateScore(player1, card, secondRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 300;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 55")
    void acceptanceTestLine55(){
        System.out.println("A-TEST: Acceptance Test Line 55\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Diamond, GameHost.Dice.Diamond, GameHost.Dice.Diamond,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Skull,
                GameHost.Dice.Sword, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 500;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 56")
    void acceptanceTestLine56(){
        System.out.println("A-TEST: Acceptance Test Line 56\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Diamond;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Gold, GameHost.Dice.Parrot, GameHost.Dice.Skull,
                GameHost.Dice.Sword, GameHost.Dice.Monkey};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 700;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 57")
    void acceptanceTestLine57(){
        System.out.println("A-TEST: Acceptance Test Line 57\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Skull, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 400;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 58")
    void acceptanceTestLine58(){
        System.out.println("A-TEST Line 58\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Skull, GameHost.Dice.Parrot, GameHost.Dice.Monkey,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};
        int[] keepDice = {0,1,2};
        GameHost.Dice[] riggedDice = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Skull, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};
        int[] keepDice2 = {0,1,2,3,4,5};
        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Skull, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Sword, GameHost.Dice.Sword};

        System.out.println("First Roll");
        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        System.out.println("Second Roll");
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);
        System.out.println("Third Roll");
        GameHost.Dice[] thirdRoll = host.keepReRollDice(player1, keepDice, secondRoll, riggedDice2, card);

        player1.setUpdateScore(true);
        int ObtainedScore = host.calculateScore(player1, card, thirdRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 800;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 59")
    void acceptanceTestLine59(){
        System.out.println("A-TEST Line 59\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Captain;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Skull, GameHost.Dice.Parrot, GameHost.Dice.Monkey,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};
        int[] keepDice = {0,1,2};
        GameHost.Dice[] riggedDice = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Skull, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};
        int[] keepDice2 = {0,1,2,3,4,5};
        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Skull, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Sword, GameHost.Dice.Sword};

        System.out.println("First Roll");
        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        System.out.println("Second Roll");
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);
        System.out.println("Third Roll");
        GameHost.Dice[] thirdRoll = host.keepReRollDice(player1, keepDice, secondRoll, riggedDice2, card);

        player1.setUpdateScore(true);
        int ObtainedScore = host.calculateScore(player1, card, thirdRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 1200;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 60")
    void acceptanceTestLine60(){
        System.out.println("A-TEST Line 60\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Gold, GameHost.Dice.Parrot, GameHost.Dice.Monkey,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};
        int[] keepDice = {0,1,2};
        GameHost.Dice[] riggedDice = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Sword, GameHost.Dice.Parrot, GameHost.Dice.Monkey,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};
        int[] keepDice2 = {0,1,2,3};
        GameHost.Dice[] riggedDice2 = {GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Sword,
                GameHost.Dice.Sword, GameHost.Dice.Sword, GameHost.Dice.Monkey,
                GameHost.Dice.Parrot, GameHost.Dice.Monkey};

        System.out.println("First Roll");
        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);
        System.out.println("Second Roll");
        GameHost.Dice[] secondRoll = host.keepReRollDice(player1, keepDice, firstRoll, riggedDice, card);
        System.out.println("Third Roll");
        GameHost.Dice[] thirdRoll = host.keepReRollDice(player1, keepDice, secondRoll, riggedDice2, card);

        player1.setUpdateScore(true);
        int ObtainedScore = host.calculateScore(player1, card, thirdRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 600;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 61")
    void acceptanceTestLine61(){
        System.out.println("A-TEST: Acceptance Test Line 61\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Monkey,
                GameHost.Dice.Monkey, GameHost.Dice.Monkey, GameHost.Dice.Monkey,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 1100;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 62")
    void acceptanceTestLine62(){
        System.out.println("A-TEST: Acceptance Test Line 62\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Monkey, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot, GameHost.Dice.Parrot,
                GameHost.Dice.Parrot, GameHost.Dice.Parrot};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 2100;
        assertEquals(score, ObtainedScore);
    }

    @Test
    @DisplayName("Acceptance Test Line 63")
    void acceptanceTestLine63(){
        System.out.println("A-TEST: Acceptance Test Line 63\n");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player[] players = {player1, player2, player3};

        GameHost host = new GameHost(players);

        GameHost.FortuneCard card = GameHost.FortuneCard.Gold;
        GameHost.Dice[] rolledDice = {GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Gold, GameHost.Dice.Gold, GameHost.Dice.Gold,
                GameHost.Dice.Gold, GameHost.Dice.Gold};

        GameHost.Dice[] firstRoll = host.playerTurnStart(player1, card, rolledDice);

        int ObtainedScore = host.calculateScore(player1, card, firstRoll);

        System.out.println(host.endTurn(player1));
        System.out.println("\n\n\n");

        int score = 5400;
        assertEquals(score, ObtainedScore);
    }




}