package com.company;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
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
