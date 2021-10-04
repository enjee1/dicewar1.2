package com.company;

public class Menu {
    private String welcomeMessage;
    private String[] gameOptions = { "1. Play Dice Wars",  "2. Exit the program" };
    private String greeting;
    private final int MIN_NUM_PLAYERS = 2;
    private final int MIN_NUM_GAME_OPTION = 1;
    private final int MAX_NUM_GAME_OPTION = 10;

    public Menu() {
        welcomeMessage = "Welcome to Dice Wars";
        createGreeting();
        displayGreeting();
    }

    public void run() {
        int choice;
        System.out.println("Please enter the number for your choice and press Enter: ");
        System.out.print("> ");
        choice = CLI.readNumber(MIN_NUM_GAME_OPTION, gameOptions.length);
        System.out.println();

        if (choice != gameOptions.length) {
            launchGame(choice);
        } else {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }

    public String createGreeting() {
        greeting =
                (CLI.createSeparator("=", welcomeMessage.length()) + "\n" +
                welcomeMessage + "\n" +
                CLI.createSeparator("=", welcomeMessage.length()) + "\n" + "\n");

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

            System.out.print("Enter the number of players (" +
                   "minimum: " + MIN_NUM_PLAYERS + ", maximum: " + MAX_NUM_GAME_OPTION + ")" + "\n" + "> ");
            numPlayers = CLI.readNumber(MIN_NUM_PLAYERS, MAX_NUM_GAME_OPTION);
            System.out.println();

            System.out.print("Enter the number of dice (" +
                    "minimum: " + MIN_NUM_GAME_OPTION + ", maximum: " + MAX_NUM_GAME_OPTION + ")" + "\n" + "> ");
            numDice = CLI.readNumber(MIN_NUM_GAME_OPTION, MAX_NUM_GAME_OPTION);
            System.out.println();

            System.out.print("Enter the number of rounds to play (" +
                    "minimum: " + MIN_NUM_GAME_OPTION + ", maximum: " + MAX_NUM_GAME_OPTION + ")" + "\n" + "> ");
            numRounds = CLI.readNumber(MIN_NUM_GAME_OPTION, MAX_NUM_GAME_OPTION);
            System.out.println();

            Game game = new Game(numPlayers, numRounds, numDice);
        } else if (gameOption == 2) {
            //playYahtzee()
        } else {
            //getOutOfMyArcade();
        }

    }
}
