package org.example;



public class GameHost {

    private Player[] players;
    public enum FortuneCard {
        TreasureChest, Captain, Sorceress, SeaBattle,
        Gold, Diamond, MonkeyBusiness, Skulls
    }
    public enum Dice {
        Monkey, Parrot, Gold, Diamond,
        Sword, Skull
    }

    //Constructor for GameHost
    public GameHost(Player[] newPlayers){
        players = newPlayers;
    }

    //Returns Number of player in the game
    public int numOfPlayers(){
        return players.length;
    }

    public FortuneCard drawCard(int riggedNum){

    }

    public Dice[] rollDice(int numOfDice, int[] riggedDice){

    }
}
