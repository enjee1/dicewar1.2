package com.company;

import java.util.Random;

public class Die {

    private final Random myRand;
    private final int sides;
    private int value;

    public Die() {
        this(6);
    }

    public Die (int sides) {
        this.sides = sides;
        myRand = new Random();
    }

    public int roll() {
         value = (myRand.nextInt(sides) + 1);
         return value;
    }

    public int getValue() {
        return value;
    }

}
