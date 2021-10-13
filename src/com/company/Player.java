package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private Hand hand;

    public Player(String name, int diceCount) {
        this.name = name;
        this.hand = new Hand(diceCount);
    }

    public String takeTurn() {
        int value = hand.rollDice();
        score += value;
        return hand.showHand();
    }

    public String getName() {
        return name;
    }

    /*public void setScore(int value) {
        score = value;
    }*/

    public int getScore() {
        return score;
    }

    public Hand getHand() {
        return hand;
    }

}
