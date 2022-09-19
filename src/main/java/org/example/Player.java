package org.example;

public class Player {
    private int score;

    public Player(){
        score = 0;
    }

    public int getScore(){
        return score;
    }
    public void updateScore(int num){
        score =  score + num;
    }


}//End Player Class
