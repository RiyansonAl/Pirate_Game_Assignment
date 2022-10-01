package org.example;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class PirateClient {

    private static Socket playerSocket;
    private static int playerNum;

    public static void main(String[] args) {
        System.out.println("Starting Client!");

        try{
            playerSocket = new Socket("localhost", 54321);
            DataOutputStream playerOut=new DataOutputStream(playerSocket.getOutputStream());
            DataInputStream serverIn = new DataInputStream(playerSocket.getInputStream());

            //Get Player Number
            String  str=(String)serverIn.readUTF();
            System.out.println(str);
            String[] arrOfStr = str.split(" ", 5);
            System.out.println(arrOfStr[3]);
            playerNum = Integer.valueOf(arrOfStr[3]);

            //Keeping reading until the server sends a command for input
            int count = 0;
            while (count < 20){
                try {
                    str = (String) serverIn.readUTF();
                    System.out.println(str);
                    String[] serverCommand = str.split(":", 5);
                    //System.out.println(Arrays.toString(serverCommand));
                    System.out.println(serverCommand[0]);
                    String playerCommand = "[Player " + playerNum + " re-Roll Phase]";
                    String playerSkullIslandCommand = "[Player " + playerNum + " Skull Island Phase]";
                    if((serverCommand[0].equals(playerCommand)) || (serverCommand[0].equals(playerSkullIslandCommand))){
                        System.out.println("equals");
                        Scanner keyboard = new Scanner(System.in);
                        String playerInput = keyboard.nextLine();
                        playerOut.writeUTF(playerInput);
                        playerOut.flush();
                    }
                } catch (IOException error){

                }
                count = count + 1;
                System.out.println(count);
            }
            /*str=(String)serverIn.readUTF();
            System.out.println(str);
            str=(String)serverIn.readUTF();
            System.out.println(str);
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
             */
            playerSocket.close();
        }catch(Exception e){System.out.println(e);}



    }


}
