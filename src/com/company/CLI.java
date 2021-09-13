package com.company;

import java.util.Scanner;

public class CLI {

    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String question) {

        System.out.print(question);
        return scanner.nextLine();
    }

    public static int readNumber(int min, int max) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine().trim());
                if (num > max || num < min) {
                    System.out.println("Invalid selection, please enter a number between " + min + " and " + max + ".");
                    System.out.print("> ");
                } else {
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid selection, please enter a number between " + min + " and " + max + ".");
                System.out.print("> ");
            }
        }
        return num;
    }

    public static void readEnterKey() {

        while (scanner.nextLine() != "") {
            System.out.println("Press the Enter key to proceed.");
        }

    }

    public static String createSeperator(String c, int repeater) {
        String output = c.repeat(repeater);

        return output;
    }
}
