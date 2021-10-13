package com.company;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Die> dice;

    public Hand (int diceCount) {
        dice = new ArrayList<>();
        for (int i = 0; i < diceCount ; i++) {
            dice.add(new Die());
        }
    }

    public int rollDice() {
        int sum = 0;
        for (int i = 0; i < dice.size(); i++) {
            sum += dice.get(i).roll();
        }
        return sum;
    }

    public String showHand(){
        String handContents = "";

        for (int i = 0; i < dice.size(); i++) {
            if (i != dice.size() - 1) {
                handContents += (dice.get(i).getValue() + ", ");
            } else {
                handContents += dice.get(i).getValue();
            }

        }
        return handContents;
    }

}
