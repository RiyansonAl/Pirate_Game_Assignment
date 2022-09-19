package org.example;


public class GameHost {

    private Player[] players;

    //Constructor for GameHost
    public GameHost(Player[] newPlayers){
        players = newPlayers;
    }

    //Returns Number of player in the game
    public int numOfPlayers(){
        return players.length;
    }
}
