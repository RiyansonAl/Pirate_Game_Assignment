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
        FortuneCard card;
        if (riggedNum == 0){
            int num = (int) (Math.random()*(8-1)+ 1);
            card = drawCardHelper(num);
        } else {
            card = drawCardHelper(riggedNum);
        }
        return card;
    }

    private FortuneCard drawCardHelper(int num){
        switch(num){
            case 1:
                return FortuneCard.TreasureChest;
            case 2:
                return FortuneCard.Captain;
            case 3:
                return FortuneCard.Sorceress;
            case 4:
                return FortuneCard.SeaBattle;
            case 5:
                return FortuneCard.Gold;
            case 6:
                return FortuneCard.Diamond;
            case 7:
                return FortuneCard.MonkeyBusiness;
            case 8:
                return FortuneCard.Skulls;
            default:
                return FortuneCard.Skulls;
        }
    }

    public Dice[] rollDice(int numOfDice, int[] riggedDice){
        Dice[] dices = new Dice[numOfDice];
        if(riggedDice[0] == 0) {
            int num;
            for (int i = 0; i < numOfDice; i++) {
                num = (int) (Math.random() * (6 - 1) + 1);
                dices[i] = rollDiceHelper(num);
            }
        } else {
            for (int i = 0; i < numOfDice; i++) {
                dices[i] = rollDiceHelper(riggedDice[i]);
            }
        }
        return dices;
    }
    private Dice rollDiceHelper(int num){
        switch(num) {
            case 1:
                return Dice.Monkey;
            case 2:
                return Dice.Parrot;
            case 3:
                return Dice.Gold;
            case 4:
                return Dice.Diamond;
            case 5:
                return Dice.Sword;
            case 6:
                return Dice.Skull;
            default:
                return Dice.Skull;
        }

    }
    protected void updateScore(Player player, int score){
        player.updateScore(score);
    }

    protected int[] getScores(){
        int[] scores = new int[players.length];
        for(int i = 0; i < scores.length; i++){
            scores[i] = players[i].getScore();
        }
        return scores;
    }

    public String displayScores(){
        int[] scores = getScores();
        int numOfPlayers = players.length;

        //String for the final print
        String scoreBoard = "";
        //Player numbers
        switch(numOfPlayers) {
            case 1:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\n";
                break;
            case 2:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\n";
                break;
            case 3:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\tPlayer 3\t|\n";
                break;
        }
        //Format and display the points
        scoreBoard = scoreBoard + "|";
        for(int i = 0; i < scores.length; i++){
            if(scores[i] > 999){
                scoreBoard = scoreBoard + "\t" + scores[i] + "\t\t|";
            } else {
                scoreBoard = scoreBoard + "\t" + scores[i] + "\t\t\t|";
            }
        }
        //Add an end of line
        scoreBoard = scoreBoard + "\n\n";
        //Print out the Score board
        System.out.print(scoreBoard);

        return scoreBoard;
    }

    protected String endRound(){

    }




}//End gameHost class
