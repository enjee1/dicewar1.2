package com.company;

import java.util.ArrayList;

public class Game {


    private ArrayList<Player> players = new ArrayList<Player>();
    private int numRounds;
    private int numDice;
    private ArrayList<Player> winner = new ArrayList<Player>();

    public Game(int numOfPlayers, int numRounds, int numDice) {
        this.numRounds = numRounds;
        this.numDice = numDice;
        generatePlayers(numOfPlayers);
        startGame();
    }

    private void playerTurn(Player player) {
//        int sum = 0;
        String playerCurrentRoll = player.takeTurn();

        /*for (Die die: playerCurrentRoll) {
            die.roll();
            sum += die.getValue();
        }*/

//        int newScore = sum + player.getScore();

//        player.setScore(newScore);
        System.out.println(player.getName() + ", you rolled " + playerCurrentRoll);
        System.out.println(player.getName() + "'s total score is: " + player.getScore());
        System.out.println();
    }

    public void startGame() {

        for (int i = 0; i < numRounds; i++) {
            for (Player player : players) {
                System.out.print(player.getName() + ", it's your turn.\nPress Enter to roll your die(ce).\n> ");
                CLI.readEnterKey();
                playerTurn(player);
            }
            System.out.println(
                    CLI.createSeparator("*", 20) + "\n" +
                    "Round " + (i + 1) + " has ended.\n" +
                    CLI.createSeparator("*", 20) + "\n");
        }
        determineWinner();
        Menu menu = new Menu();
        menu.run();

    }

    private void generatePlayers(int numPlayers) {
        for (int i = 0; i < numPlayers ; i++) {
            String name = CLI.getString("Player " + (i + 1) + ", enter your name\nName: ");
            System.out.println();
            Player newPlayer = new Player(name, numDice);
            players.add(newPlayer);
        }
    }

    private void determineWinner() {
        int highestScore = 0;

        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                winner.clear();
                winner.add(player);
            } else if (player.getScore() == highestScore) {
                winner.add(player);
            }
        }

        System.out.println(showWinner(winner));
    }

    private String showWinner(ArrayList<Player> winners) {
        String victoryMessage = "";
        String multiWinnerNames = "";
        int multiWinnerScore = 0;

        if (winners.size() == 1) {
            Player winner = winners.get(0);
            victoryMessage =
                    "The winner of the game is " + winner.getName() + " with a score of " + winner.getScore() + "."
                            + " Congratulations " + winner.getName() + "!\n";
        } else {
            for (int i = 0; i < winners.size(); i++) {
                if (i != winners.size() - 1) {
                    multiWinnerNames += (winners.get(i).getName() + ", ");
                } else {
                    multiWinnerNames += "and " + winners.get(i).getName();
                }
            }
            victoryMessage =
                    "The winners of the game are " + multiWinnerNames+ " with a score of " + winners.get(1).getScore() + "."
                            + " Congratulations players!\n";


        }
        return victoryMessage;
    }
}
