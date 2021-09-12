package com.company;

import java.util.Scanner;

public class Menu {
    private String seperator;
    private String welcomeMessage;
    private String[] gameOptions = { "1. Play Dice Wars", "2. Exit the program" };
    private String greeting;

    public Menu() {
        welcomeMessage = "Welcome to Dice Wars";
        seperator = "=".repeat(welcomeMessage.length());
        createGreeting();
        displayGreeting();
    }

    public void run() {
        int choice;
        System.out.println("Please enter the number for your choice and press Enter: ");
        System.out.print("> ");
        choice = CLI.readNumber(gameOptions.length - (gameOptions.length - 1), gameOptions.length);

        if (choice != gameOptions.length) {
            launchGame(choice);
        } else {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }

    public String createGreeting() {
        greeting =
                (seperator + "\n" +
                welcomeMessage + "\n" +
                seperator + "\n" + "\n");

        for (String option: gameOptions) {
            greeting += option + "\n";
        }

        return greeting;
    }

    public void displayGreeting() {
        System.out.println(greeting);
    }

    public void launchGame(int gameOption) {

        if (gameOption == 1) {

            int numPlayers;
            int numDice;
            int numRounds;

            System.out.print("Enter the number of players (minimum 2, maximum 10)" + "\n" + "> ");
            numPlayers = CLI.readNumber(2, 10);

            System.out.print("Enter the number of dice (minimum 1, maximum 10)" + "\n" + "> ");
            numDice = CLI.readNumber(1, 10);

            System.out.print("Enter the number of rounds to play (minimum 1, maximum 10)" + "\n" + "> ");
            numRounds = CLI.readNumber(1, 10);
            Game game = new Game(numPlayers, numRounds, numDice);
        }
    }




}
