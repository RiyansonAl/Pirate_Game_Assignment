package org.example;

public class Player {

    private int playerNumber;
    private int score;

    private GameHost.FortuneCard card;

    private boolean finshedRolled;
    private boolean isUpdateScore;

    private int SkullCardType;
    private int SwordCardType;
    private boolean isSkullIsland;
    private boolean isSorceress;
    private String scoreBreakDown;



    public Player(int playerNum){
        score = 0;
        finshedRolled = isUpdateScore = isSkullIsland = isSorceress = false;
        scoreBreakDown = "";
        playerNumber = playerNum;

    }

    public int getScore(){
        return score;
    }
    public void updateScore(int num){
        score =  score + num;
        if(score < 0){
            score = 0;
        }
    }

    protected void setRoll(boolean roll){ finshedRolled = roll; }
    protected boolean getRoll(){ return finshedRolled; }

    protected void setUpdateScore(boolean isScore){ isUpdateScore = isScore; }
    protected boolean getUpdateScore(){ return isUpdateScore; }

    protected int getPlayerNumber(){ return playerNumber; }

    protected void setSkullCardNum(int num){ SkullCardType = num; }
    protected int getSkullCardNum(){ return SkullCardType; }
    protected void setSwordCardNum(int num){ SwordCardType = num; }
    protected int getSwordCardNum(){ return SwordCardType; }

    protected void setFortuneCard(GameHost.FortuneCard cardToSet){card = cardToSet;}
    protected GameHost.FortuneCard getFortuneCard(){return card;}

    protected void setIsSkullIsland(boolean val){ isSkullIsland = val; }
    protected boolean getIsSkullIsland(){ return isSkullIsland; }

    protected void setIsSorceress(boolean val){ isSorceress = val; }
    protected boolean getIsSorceress(){ return isSorceress; }

    protected void setScoreBreakDown(String breakDown){ scoreBreakDown = scoreBreakDown + breakDown; }

    protected String getScoreBreakDown(){ return scoreBreakDown; }

    protected void endPlayerTurn(){
        finshedRolled = isUpdateScore = isSkullIsland = isSorceress = false;
        scoreBreakDown = "";
    }


}//End Player Class
