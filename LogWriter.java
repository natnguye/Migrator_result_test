

package com.game.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogWriter {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String LOG_FILE = "game.log";
    private Scanner scanner;

    public LogWriter() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            writer.println("Logging system initialized.");
        } catch (IOException e) {
            System.err.println("Error initializing logging system: " + e.getMessage());
            throw new RuntimeException(e);
        }
        scanner = new Scanner(System.in);
    }

    public void sayHelp() {
        System.out.println(ANSI_CYAN + "Help message:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "  Type 'go north' to go north" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "  Type 'go south' to go south" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "  Type 'go east' to go east" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "  Type 'go west' to go west" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "  Type 'quit' to quit the game" + ANSI_RESET);
    }

    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

    public String readInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public String askDungeonMaster(String prompt) {
        while (true) {
            try {
                displayPrompt(prompt);
                String input = readInput();
                if (input.isEmpty()) {
                    System.out.println("Please enter a valid input.");
                } else if (input.equals("quit")) {
                    System.out.println("Game quit.");
                    System.exit(0);
                } else if (input.startsWith("go ")) {
                    String direction = input.substring(3);
                    if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
                        return input;
                    } else {
                        System.out.println("Invalid direction. Please try again.");
                    }
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}