package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private Hand hand;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public ArrayList<Die> rollHand() {
        hand.rollDice();
        return hand.dice;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setScore(int value) {
        score = value;
    }

    public int getScore() {
        return score;
    }

}
