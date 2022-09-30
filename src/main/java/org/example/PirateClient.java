package org.example;
import java.io.*;
import java.net.Socket;

public class PirateClient {

    private static Socket playerSocket;

    public static void main(String[] args) {
        System.out.println("Starting Client!");

        try{
            playerSocket = new Socket("localhost", 54321);
            DataOutputStream dout=new DataOutputStream(playerSocket.getOutputStream());
            DataInputStream serverIn = new DataInputStream(playerSocket.getInputStream());

            String  str=(String)serverIn.readUTF();
            System.out.println(str);
            str=(String)serverIn.readUTF();
            System.out.println(str);
            str=(String)serverIn.readUTF();
            System.out.println(str);
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            playerSocket.close();
        }catch(Exception e){System.out.println(e);}



    }


}
