

package com.adventure.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogWriter {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_BOLD = "\u001B[1m";
    private static final String ANSI_UNDERLINE = "\u001B[4m";

    private Scanner scanner;

    public LogWriter() {
        this.scanner = new Scanner(System.in);
    }

    public void displayText(String text) {
        System.out.println(text);
    }

    public void displayTextWithColor(String text, String color) {
        switch (color) {
            case "red":
                System.out.println(ANSI_RED + text + ANSI_RESET);
                break;
            case "green":
                System.out.println(ANSI_GREEN + text + ANSI_RESET);
                break;
            case "yellow":
                System.out.println(ANSI_YELLOW + text + ANSI_RESET);
                break;
            case "blue":
                System.out.println(ANSI_BLUE + text + ANSI_RESET);
                break;
            default:
                System.out.println(text);
        }
    }

    public void displayTextWithFormat(String text, String format) {
        switch (format) {
            case "bold":
                System.out.println(ANSI_BOLD + text + ANSI_RESET);
                break;
            case "underline":
                System.out.println(ANSI_UNDERLINE + text + ANSI_RESET);
                break;
            default:
                System.out.println(text);
        }
    }

    public void displayTextWithColorAndFormat(String text, String color, String format) {
        String colorCode = "";
        String formatCode = "";

        switch (color) {
            case "red":
                colorCode = ANSI_RED;
                break;
            case "green":
                colorCode = ANSI_GREEN;
                break;
            case "yellow":
                colorCode = ANSI_YELLOW;
                break;
            case "blue":
                colorCode = ANSI_BLUE;
                break;
            default:
                break;
        }

        switch (format) {
            case "bold":
                formatCode = ANSI_BOLD;
                break;
            case "underline":
                formatCode = ANSI_UNDERLINE;
                break;
            default:
                break;
        }

        System.out.println(colorCode + formatCode + text + ANSI_RESET);
    }

    public String askForUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void processUserInput(String input) {
        try {
            int choice = Integer.parseInt(input);
            if (choice < 1 || choice > 5) {
                displayTextWithColor("Invalid choice. Please choose a number between 1 and 5.", "red");
            } else {
                displayTextWithColor("You have chosen option " + choice, "green");
            }
        } catch (NumberFormatException e) {
            displayTextWithColor("Invalid input. Please enter a number.", "red");
        }
    }

    public void processUserInput(String input, String[] validInputs) {
        boolean isValid = false;
        for (String validInput : validInputs) {
            if (input.equalsIgnoreCase(validInput)) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            displayTextWithColor("You have entered a valid input: " + input, "green");
        } else {
            displayTextWithColor("Invalid input. Please enter one of the following: " + String.join(", ", validInputs), "red");
        }
    }
}