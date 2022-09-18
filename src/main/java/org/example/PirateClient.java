package org.example;
import java.io.*;
import java.net.Socket;

public class PirateClient {

    private static Socket clientSocket;

    public static void main(String[] args) {
        System.out.println("Starting Client!");

        try{
            clientSocket = new Socket("localhost", 54321);
            DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            clientSocket.close();
        }catch(Exception e){System.out.println(e);}



    }


}
