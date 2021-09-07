package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
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

            /*if (i != dice.size()) rolls += dice.get(i).toString() + ", ";
            else rolls += dice.get(i).toString();*/
        }

        return rolls;
    }
}
