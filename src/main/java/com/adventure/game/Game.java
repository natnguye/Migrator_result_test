

package com.adventure.game;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
    public static void main(String[] args) {
        DungeonMaster dungeonMaster = new DungeonMaster();
        if (!dungeonMaster.validate()) {
            System.out.println("DungeonMaster is not valid");
            return;
        }
        dungeonMaster.startGame();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter command: ");
                String command = scanner.nextLine();
                if (!dungeonMaster.handleCommand(command)) {
                    System.out.println("Invalid command");
                }
                if (dungeonMaster.isGameOver()) {
                    System.out.println("Game over!");
                    break;
                }
                if (!dungeonMaster.validateGameState()) {
                    System.out.println("Game state is not valid");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        if (!dungeonMaster.validate()) {
            System.out.println("DungeonMaster is not valid after game is over");
        }
    }
}

class DungeonMaster {
    private boolean isValid = true;
    private boolean isGameOver = false;
    private boolean isGameStateValid = true;

    public boolean validate() {
        return isValid;
    }

    public void startGame() {
        // Start game logic
        System.out.println("Welcome to the adventure game!");
        System.out.println("You are standing at the entrance of a dark cave.");
        System.out.println("There is a path to the north and a path to the east.");
        System.out.println("What do you want to do?");
    }

    public boolean handleCommand(String command) {
        // Handle command logic
        if (command.equalsIgnoreCase("go north")) {
            System.out.println("You are now on the north path.");
            System.out.println("There is a river to the north and a forest to the east.");
            System.out.println("What do you want to do?");
            return true;
        } else if (command.equalsIgnoreCase("go east")) {
            System.out.println("You are now on the east path.");
            System.out.println("There is a mountain to the east and a valley to the west.");
            System.out.println("What do you want to do?");
            return true;
        } else if (command.equalsIgnoreCase("quit")) {
            isGameOver = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean validateGameState() {
        return isGameStateValid;
    }
}