

package com.game;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        DungeonMaster dungeonMaster = null;
        try {
            dungeonMaster = new DungeonMaster();
        } catch (Exception e) {
            System.out.println("Failed to create DungeonMaster object: " + e.getMessage());
            return;
        }

        if (dungeonMaster == null) {
            System.out.println("Failed to create DungeonMaster object.");
            return;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("Failed to create Scanner object: " + e.getMessage());
            return;
        }

        boolean isRunning = true;
        boolean isGameStarted = false;

        while (isRunning) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Please enter a command.");
                continue;
            }

            try {
                switch (input) {
                    case "help":
                        if (isGameStarted) {
                            System.out.println("Available commands:");
                            System.out.println("  help - Display this help message");
                            System.out.println("  quit - Quit the game");
                            System.out.println("  restart - Restart the game");
                        } else {
                            System.out.println("Available commands:");
                            System.out.println("  help - Display this help message");
                            System.out.println("  start - Start the game");
                            System.out.println("  quit - Quit the game");
                        }
                        break;
                    case "start":
                        if (isGameStarted) {
                            System.out.println("Game is already started.");
                        } else {
                            dungeonMaster.startGame();
                            isGameStarted = true;
                            System.out.println("Game started.");
                        }
                        break;
                    case "restart":
                        if (isGameStarted) {
                            dungeonMaster.resetGame();
                            isGameStarted = false;
                            System.out.println("Game reset.");
                        } else {
                            System.out.println("Game is not started.");
                        }
                        break;
                    case "quit":
                        isRunning = false;
                        break;
                    default:
                        if (isGameStarted) {
                            dungeonMaster.handleCommand(input);
                        } else {
                            System.out.println("Invalid command. Please type 'start' to begin the game.");
                        }
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        if (scanner != null) {
            scanner.close();
        }
    }
}