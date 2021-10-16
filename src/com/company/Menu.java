package com.company;

public class Menu {
    private String welcomeMessage;
    private String[] gameOptions = { "1. Play Dice Wars",  "2. Exit the program" };
    private final int MIN_NUM_PLAYERS = 2;
    private final int MIN_NUM_GAME_OPTION = 1;
    private final int MAX_NUM_GAME_OPTION = 10;

    public Menu(String gameName) {
        welcomeMessage = "Welcome to " + gameName + "!";
    }

    public Menu() {
        this("Dice Wars");
    }

    public void run() {
        displayGreeting();
        while (true) {
            int choice = promptForOption();
            if (choice != gameOptions.length) {
                launchGame(choice);
            } else {
                System.out.println("Exiting the program...");
                System.exit(0);
            }
        }
    }

    private void displayGreeting() {
        String greeting =
                "=".repeat(welcomeMessage.length()) + "\n" +
                welcomeMessage + "\n" +
                "=".repeat(welcomeMessage.length()) + "\n\n";
        System.out.println(greeting);

    }

    private int promptForOption() {
        String optionsMenu = "";
        for (String option: gameOptions) {
            optionsMenu += option + "\n";
        }

        System.out.println(optionsMenu);
        System.out.println("Please enter the number for your choice and press Enter: ");
        System.out.print("> ");
        int choice = CLI.readNumber(MIN_NUM_GAME_OPTION, gameOptions.length);
        System.out.println();

        return choice;
    }


    private void launchGame(int gameOption) {

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
