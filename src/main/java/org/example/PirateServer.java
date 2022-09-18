package org.example;
import java.io.*;
//import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PirateServer {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    public static void main(String[] args){
        System.out.println("Starting Server!");
         try{
             serverSocket = new ServerSocket(54321);
             clientSocket = serverSocket.accept();
             DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
             String  str=(String)dis.readUTF();
             System.out.println("message= "+str);
             serverSocket.close();
         }catch(Exception e){System.out.println(e);}


    }




    }
