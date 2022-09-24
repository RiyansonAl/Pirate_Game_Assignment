package org.example;

public class Player {

    private int playerNumber;
    private int score;

    private GameHost.FortuneCard card;

    private boolean finshedRolled;
    private boolean isUpdateScore;

    private int SkullCardType;


    public Player(int playerNum){
        score = 0;
        finshedRolled = isUpdateScore = false;
        playerNumber = playerNum;

    }

    public int getScore(){
        return score;
    }
    public void updateScore(int num){
        score =  score + num;
    }

    protected void setRoll(boolean roll){ finshedRolled = roll; }
    protected boolean getRoll(){ return finshedRolled; }

    protected void setUpdateScore(boolean isScore){ isUpdateScore = isScore; }
    protected boolean getUpdateScore(){ return isUpdateScore; }

    protected int getPlayerNumber(){ return playerNumber; }

    protected void setSkullCardNum(int num){ SkullCardType = num; }
    protected int getSkullCardNum(){ return SkullCardType; }

    protected void setFortuneCard(GameHost.FortuneCard cardToSet){card = cardToSet;}
    protected GameHost.FortuneCard getFortuneCard(){return card;}


}//End Player Class
