package com.company;

import java.util.ArrayList;

public class Game {

/*    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Die> dice = new ArrayList<Die>();
    private int numRounds;
    private int numDice;
    private ArrayList<String> diceValues;
    private Player winner;


    public Game(int numOfPlayers, int numRounds, int numDice) {
        this.numRounds = numRounds;
        this.numDice = numDice;
        generatePlayers(numOfPlayers);
        generateDice(numDice);
        startGame();
    }

    private void playerTurn(Player player) {
        boolean playerInput;
        int roundScore = 0;
        diceValues = new ArrayList<String>();

        System.out.print(player.getName() + ", it's your turn.\nPress Enter to roll your die/dice. ");
        playerInput = CLI.readEnterKey();

        while (playerInput) {
            for (int i = 0; i < numRounds ; i++) {
                for (Die die : dice) {
                    die.roll();
                    roundScore += die.getValue();
//                    diceValues.add(die.toString());
                }
                player.setScore(roundScore);
            }
            System.out.println(player.getName() + ", you rolled: " + showDiceRolls(diceValues));
            playerInput = false;
        }
    }

    public void startGame() {
        for (Player player : players) {
            playerTurn(player);
        }

    }

    private void generatePlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            String name = CLI.getString("Player " + (i + 1) + ", enter your name, then press Enter.\nName: ");
            Player newPlayer = new Player(name);
            players.add(newPlayer);
        }
    }

    private void generateDice(int numDice) {
        for (int i = 0; i < numDice; i++) {
            Die die = new Die();
            dice.add(die);
        }
    }

    private String showDiceRolls(ArrayList<String> dice) {
        String rolls = "";
        for (int i = 0; i < dice.size() ; i++) {

            *//*if (i != dice.size()) rolls += dice.get(i).toString() + ", ";
            else rolls += dice.get(i).toString();*//*
        }

        return rolls;
    }*/

    private ArrayList<Player> players = new ArrayList<Player>();
    private int numRounds;
    private int numDice;
//    private Player winner;
    //TODO: Modify winner to include multiple winners

    public Game(int numOfPlayers, int numRounds, int numDice) {
        this.numRounds = numRounds;
        this.numDice = numDice;
        generatePlayers(numOfPlayers);
        startGame();
    }

    private void playerTurn(Player player) {
        int sum = 0;
        ArrayList<Die> playerCurrentRoll = player.rollHand();

        for (Die die: playerCurrentRoll) {
            die.roll();
            sum += die.getValue();
            System.out.println(player.getName() + " rolled " + die.getValue());
        }
        int newScore = sum + player.getScore();

        player.setScore(newScore);
        System.out.println(player.getName() + "'s total score is: " + newScore);
    }

    public void startGame() {
        for (int i = 0; i < numRounds; i++) {
            for (Player player : players) {
                playerTurn(player);
            }
        }
    }

    private void generatePlayers(int numPlayers) {
        for (int i = 0; i < numPlayers ; i++) {
            String name = CLI.getString("Player " + (i + 1) + ", enter your name\nName: ");
            Player newPlayer = new Player(name, 0);
            players.add(newPlayer);
            Hand hand = new Hand();
            ArrayList<Die> newDice = generateDice();
            hand.setDice(newDice);
            newPlayer.setHand(hand);
        }
    }

    private ArrayList<Die> generateDice() {
        ArrayList<Die> tempArr = new ArrayList<Die>();

        for (int i = 0; i < numDice; i++) {
            Die newDie = new Die();
            tempArr.add(newDie);
        }
        return tempArr;
    }
}
