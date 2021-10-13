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

    /*public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }*/

    public void rollDice() {
        for (int i = 0; i < dice.size(); i++) {
            dice.get(i).roll();
        }
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
