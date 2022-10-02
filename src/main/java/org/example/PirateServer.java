package org.example;
import java.io.*;
//import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class PirateServer {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static Socket[] playerSockets;

    private static DataInputStream player2In;
    private static DataInputStream player3In;
    private static DataOutputStream player2Out;
    private static DataOutputStream player3Out;

    private static Player player1;
    private static Player player2;
    private static Player player3;
    private static Player[] allPlayers;

    private static int numOfPlayers;

    public static void main(String[] args){
        System.out.println("Starting Server!");
        Scanner keyboard = new Scanner(System.in);
        numOfPlayers = 0;
        boolean notValid = true;
        while(notValid) {
            System.out.println("Enter Number of players (2-3)");
            numOfPlayers = keyboard.nextInt();
            if(numOfPlayers == 2 || numOfPlayers == 3){
                notValid = false;
            } else {
                System.out.println("Not a valid choice. Try again!");
            }
        }
        if (numOfPlayers == 2){
            System.out.println("Waiting for one Other players to connect");
        } else {
            System.out.println("Waiting for 2 Other players to connect");
        }
        // Wait for other player to connect
         try{
             notValid = true;
             serverSocket = new ServerSocket(54321);
             playerSockets = new Socket[(numOfPlayers-1)];
             int count = 0;
             while (notValid){
                 if(count == 0){
                     System.out.println("Waiting for Player 2 to connect");
                     playerSockets[count] = serverSocket.accept();
                     System.out.println("Player 2 to connected");
                     player2In = new DataInputStream(playerSockets[count].getInputStream());
                     player2Out = new DataOutputStream(playerSockets[count].getOutputStream());
                     player2Out.writeUTF("You are Player 2 \nYou are connected to the Pirate Game Server");
                     player2Out.flush();
                     count = count + 1;
                 } else if (count == 1){
                     System.out.println("Waiting for Player 3 to connect");
                     playerSockets[count] = serverSocket.accept();
                     System.out.println("Player 3 to connected");
                     player3In = new DataInputStream(playerSockets[count].getInputStream());
                     player3Out = new DataOutputStream(playerSockets[count].getOutputStream());
                     player3Out.writeUTF("You are Player 3 \nYou are connected to the Pirate Game Server");
                     player3Out.flush();
                     count = count + 1;
                 }
                 if(count == (numOfPlayers-1)){
                     notValid = false;
                 }

             }
             //Now all player should be connected
             String msg ="All Players are connected\n";
             msg = msg + "Starting Pirate Game.....";
             writeToPlayers(msg);

             //initialize Game host class
             player1 = new Player(1);
             player2 = new Player(2);
             player3 = new Player(3);
             allPlayers = new Player[]{player1, player2};
             if(numOfPlayers == 3){
                 allPlayers = new Player[]{player1, player2,  player3};
             }
             GameHost host = new GameHost(allPlayers);

             //Start first Round
             startRound(host);


             //clientSocket = serverSocket.accept();
             //DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
             //String  str=(String)dis.readUTF();
             //System.out.println("message= "+str);
             serverSocket.close();
         }catch(Exception e){System.out.println(e);}


    }
    public PirateServer(Socket[] PlayerSocket){

    }

    private static void writeToPlayers(String msg){
        System.out.println(msg);
        try {
            player2Out.writeUTF(msg);
            player2Out.flush();
            if(numOfPlayers >= 3){
                player3Out.writeUTF(msg);
                player3Out.flush();
            }
        }catch(Exception e){System.out.println(e);}

    }

    private static String getPlayerInput(int playerNum){
        String msg = "";
        if(playerNum == 1){
            System.out.println("Your true. Waiting for input");
            Scanner keyboard = new Scanner(System.in);
            msg = keyboard.nextLine();
        } else if (playerNum == 2){
            try {
                msg = (String) player2In.readUTF();
            }catch(Exception e){System.out.println(e);}
        } else if (playerNum == 3) {
            try {
                msg = (String) player3In.readUTF();
            }catch(Exception e){System.out.println(e);}
        }
        return msg;
    }

    protected static void startRound(GameHost host){
        int counter = 0;
        boolean isGameEnd = false;
        while (!isGameEnd) {
            int currentPlayerNum = host.getCurrentPlayerTurn();
            String playerInput = "";
            //Track the round number
            if(currentPlayerNum == 1){
                counter = counter + 1;
            }
            String msg = "\n\n\n[ROUND " + counter + "]\n";
            msg = msg + host.displayScores();
            msg = msg + "Starting Player " + currentPlayerNum + " Turn...\n";
            msg = msg + "[Player " + currentPlayerNum + " Drawing Phase]: Drawing Card....\n";
            //GameHost.FortuneCard card = host.drawCard(GameHost.FortuneCard.None);
            GameHost.Dice[] fakedice = {GameHost.Dice.None};
            GameHost.Dice[] dice;

            dice = host.playerTurnStart(allPlayers[currentPlayerNum - 1], GameHost.FortuneCard.None, fakedice);
            GameHost.FortuneCard card = allPlayers[currentPlayerNum - 1].getFortuneCard();
            //Get the extra information on the card if there is any
            String cardInfo = "";
            if(card == GameHost.FortuneCard.SeaBattle){
                int num = allPlayers[currentPlayerNum - 1].getSwordCardNum();
                if(num == 2){
                    cardInfo = " " + num + " Swords (300)";
                } else if (num == 3) {
                    cardInfo = " " + num + " Swords (500)";
                } else if (num == 4) {
                    cardInfo = " " + num + " Swords (1000)";
                }
            } else if (card == GameHost.FortuneCard.Skulls) {
                int num = allPlayers[currentPlayerNum - 1].getSkullCardNum();
                if(num == 1){
                    cardInfo = " " + num + " Skulls";
                } else if (num == 2) {
                    cardInfo = " " + num + " Skulls";
                }
            }


            msg = msg + "[Player " + currentPlayerNum + " Drawing Phase]: Fortune Card = " + card.toString() + cardInfo +" \n";
            msg = msg + "[Player " + currentPlayerNum + " Rolling Phase]: Rolling Dice....\n";
            msg = msg + "Dice Roll = " + Arrays.toString(dice) + " \n";
            writeToPlayers(msg);


            //TODO: Fix the format of the console statements

            boolean[] playerTurnPhase = host.getPlayerTurnPhase(allPlayers[currentPlayerNum - 1]);
            //Check if player can continue re-rolling and not on skull island
            if ((playerTurnPhase[0] == true) && (allPlayers[currentPlayerNum - 1].getIsSkullIsland() == false)) {

                boolean keepReRolling = true;
                while (keepReRolling) {

                    //Prompt player to either keep dice and reroll the rest or move on to scoring
                    msg = "[Player " + currentPlayerNum + " re-Roll Phase]: Choose the dice you keep. For Example: 1,2,3 will pick the first 3 dice.\n";
                    msg = msg + "[Player " + currentPlayerNum + "]: If you want to keep all the dice press Enter to continue\n\n";
                    msg = msg + "[Player " + currentPlayerNum + " Dice]:" + Arrays.toString(dice) + " \n";
                    writeToPlayers(msg);
                    //Wait for Players Input
                    playerInput = getPlayerInput(currentPlayerNum);
                    //System.out.println(playerInput);
                    //Error checking on the playerInput
                    //Quiting the game
                    if (playerInput.equals("quit")) {
                        isGameEnd = true;
                        keepReRolling = false;
                        msg = "[GAME OVER]: Player quit the game\n";
                        msg = msg + host.displayScores();
                        writeToPlayers(msg);

                    }
                    if (isInputValid(playerInput)) {
                        //TODO: Check of there is at least 2 dice being re-rolled
                        String[] input = playerInput.split(",", 8);
                        int[] keepdice = new int[input.length];
                        for (int i = 0; i < input.length; i++) {
                            keepdice[i] = (Integer.valueOf(input[i]) - 1);
                        }
                        //System.out.println(Arrays.toString(input));
                        //System.out.println(Arrays.toString(keepdice));
                        //keep and ReRoll rest of the dice
                        if(isreRollPossible(dice, keepdice,card,host, allPlayers[currentPlayerNum - 1])) {
                            dice = host.keepReRollDice(allPlayers[currentPlayerNum - 1], keepdice, dice, fakedice, GameHost.FortuneCard.None);
                            keepReRolling = true;
                            msg = "[Player " + currentPlayerNum + "]: keeping dice: " + playerInput + ". The rest are being rerolled  \n";
                            writeToPlayers(msg);
                        }

                    } else if (playerInput.equals("")) {
                        //System.out.println("Continue to scoring");
                        msg = "[Player " + currentPlayerNum + " Scoring Phase]: Calculating Score \n";
                        writeToPlayers(msg);
                        keepReRolling = false;

                    }

                    //keepReRolling = false;
                }//Re-Rolling loop

            } else if ((playerTurnPhase[0] == true) && (allPlayers[currentPlayerNum - 1].getIsSkullIsland() == true)) {
                //Enter Skull island
                msg = "[Player " + currentPlayerNum + "]: Player " + currentPlayerNum + " Has entered the islands of the Skulls\n";
                writeToPlayers(msg);
                while (allPlayers[currentPlayerNum - 1].getIsSkullIsland() == true){
                    int numOfSkull = host.countSkulls(dice);
                    msg = "[Player " + currentPlayerNum + " Skull Island Phase]: Player " + currentPlayerNum + " has " + numOfSkull + "Skulls\n";
                    msg = msg + "[Player " + currentPlayerNum + "]: Please press \"1\" to continue rolling for skulls. Press Enter for move on to scoring\n";
                    writeToPlayers(msg);
                    //Wait for Players Input
                    playerInput = getPlayerInput(currentPlayerNum);
                    boolean rollSkull = true;
                    if (playerInput.equals("quit")) {
                        isGameEnd = true;
                        allPlayers[currentPlayerNum - 1].setIsSkullIsland(false);
                        rollSkull = false;
                    }
                    if(playerInput.equals("")){
                        allPlayers[currentPlayerNum - 1].setIsSkullIsland(false);
                        rollSkull = false;
                    }
                    if(playerInput.equals("1")){
                        rollSkull = true;
                    } else {
                        rollSkull = false;
                    }

                    if(rollSkull == true) {
                        dice = host.skullIsland(allPlayers[currentPlayerNum - 1], card, dice, fakedice);
                    }
                }

                msg = msg + "[Player " + currentPlayerNum + "]: No more skulls were rolled moving on the scoring\n";
                writeToPlayers(msg);

            }

            //Get the Score
            playerTurnPhase = host.getPlayerTurnPhase(allPlayers[currentPlayerNum - 1]);
            if(playerTurnPhase[1] == true) {
                int score = host.calculateScore(allPlayers[currentPlayerNum - 1], card, dice);
                msg = "[Player " + currentPlayerNum + "]: Score = " + score + "\n";
                writeToPlayers(msg);
            }

            //End the players turn
            msg = "SCORE UPDATE: \n";
            msg = msg + host.displayScores();
            writeToPlayers(msg);
            String endMessage = host.endTurn(allPlayers[currentPlayerNum - 1]);
            msg = endMessage;
            writeToPlayers(msg);

            //When there is a winner
            if (host.isWinner){
                isGameEnd = true;
                msg = "[GAME OVER]: " + host.getWinner();
                writeToPlayers(msg);
            }
        }



    }

    protected static boolean isInputValid(String input){
        String regx = "\\d,\\d,\\d,\\d";
        regx = "([1-8],){0,5}[1-8]";

        if (input.matches(regx)){
            return true;
        } else {
            return false;
        }
    }

    protected static boolean isreRollPossible(GameHost.Dice[] dice, int[] keepdice, GameHost.FortuneCard card, GameHost host, Player player){
        //Check length of keep dice if its 7 or more than there is less than 2 dice left to roll
        int length = keepdice.length;
        if(length >= 7){
            String msg = "Player did not leave 2 or more dice to roll";
            writeToPlayers(msg);
            return false;
        }

        //Check if the leftover rolling dice is a skull that does not het rolled
        int numOfSkulls = host.countSkulls(dice);
        int skullsInKeptDice = 0;
        for(int i = 0; i < keepdice.length; i++){
            if(dice[keepdice[i]] == GameHost.Dice.Skull){
                skullsInKeptDice = skullsInKeptDice + 1;
            }
        }
        //More skulls in count means less dice to roll. This check will see if there is at least 2 dice left to roll
        String msg = "";
        if(numOfSkulls > skullsInKeptDice) {
            int leftoverSkulls = numOfSkulls - skullsInKeptDice;
            if (card == GameHost.FortuneCard.Sorceress) {
                if (player.getIsSorceress() == true) {
                    if ((skullsInKeptDice + leftoverSkulls - 1) >= 7) {
                        msg = " Only one skull can be re-rolled and there are less then 2 dice trying to be rolled";
                        writeToPlayers(msg);
                        return false;
                    }
                } else if (player.getIsSorceress() == false) {
                    if ((skullsInKeptDice + leftoverSkulls) >= 7) {
                        msg = "Already used Sorceress and re-rolled a Skull.";
                        msg = msg + "The rest of the skulls cannot be re-rolled and there are less then 2 dice trying to be rolled";
                        writeToPlayers(msg);
                        return false;
                    }
                }
            } else if ((skullsInKeptDice + leftoverSkulls) >= 7) {
                msg = "Skulls cannot be re-rolled and there are less then 2 dice trying to be rolled";
                writeToPlayers(msg);
                return false;
            }
        }

        return true;
    }//End of method




    }//End PirateServer Class
