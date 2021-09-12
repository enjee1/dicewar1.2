package com.company;

import java.util.ArrayList;

public class Hand {
    public ArrayList<Die> dice;

    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }

    public void rollDice() {
        for (int i = 0; i < dice.size(); i++) {
            dice.get(i).roll();
        }
    }

}
