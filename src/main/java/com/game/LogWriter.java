

package com.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogWriter {
    private Scanner scanner;

    public LogWriter() {
        this.scanner = new Scanner(System.in);
    }

    public void sayHelp() {
        System.out.println("\u001B[34m" + "Help: type 'go north' to go north, 'go south' to go south, 'go east' to go east, 'go west' to go west, 'take <object>' to take an object, 'use <object>' to use an object, 'inventory' to see your inventory, 'quit' to quit the game, 'exit' to exit the help menu" + "\u001B[0m");
    }

    public void sayDungeonMaster(String message) {
        if (message != null && !message.isEmpty()) {
            System.out.println("\u001B[31m" + "Dungeon Master: " + message + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Dungeon Master: No message available" + "\u001B[0m");
        }
    }

    public String askDungeonMaster(String message) {
        while (true) {
            try {
                System.out.print("\u001B[32m" + message + "\u001B[0m");
                String input = scanner.nextLine();
                if (input != null && !input.isEmpty()) {
                    return input;
                } else {
                    System.out.println("\u001B[31m" + "Invalid input. Please enter a valid command." + "\u001B[0m");
                }
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "Invalid input. Please enter a valid command." + "\u001B[0m");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        LogWriter logWriter = new LogWriter();
        logWriter.sayHelp();
        logWriter.sayDungeonMaster("Welcome to the game!");
        String userInput = logWriter.askDungeonMaster("What would you like to do? ");
        System.out.println("\u001B[32m" + "You entered: " + userInput + "\u001B[0m");
    }
}