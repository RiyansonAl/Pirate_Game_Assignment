package org.example;
import java.io.*;
//import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PirateServer {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static Socket[] playerSockets;

    private static DataInputStream player2In;
    private static DataInputStream player3In;
    private static DataOutputStream player2Out;
    private static DataOutputStream player3Out;

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
                     player2Out.writeUTF("Connected to the Pirate Game");
                     player2Out.flush();
                     count = count + 1;
                 } else if (count == 1){
                     System.out.println("Waiting for Player 3 to connect");
                     playerSockets[count] = serverSocket.accept();
                     System.out.println("Player 3 to connected");
                     player2In = new DataInputStream(playerSockets[count].getInputStream());
                     player3Out = new DataOutputStream(playerSockets[count].getOutputStream());
                     player3Out.writeUTF("Connected to the Pirate Game");
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
            if(numOfPlayers > 3){
                player3Out.writeUTF(msg);
            }
        }catch(Exception e){System.out.println(e);}

    }




    }
