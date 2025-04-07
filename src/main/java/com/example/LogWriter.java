

package com.example;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogWriter {
    private PrintStream outputStream;

    public LogWriter(PrintStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("Output stream cannot be null");
        }
        if (!outputStream.equals(System.out) && !outputStream.equals(System.err)) {
            throw new IllegalArgumentException("Output stream must be a console output stream");
        }
        this.outputStream = outputStream;
    }

    public void sayHelp() {
        outputStream.println("\u001B[34m" + "This is a help message. You can use the following commands:" + "\u001B[0m");
        outputStream.println("\u001B[34m" + "  - help: Display this help message" + "\u001B[0m");
        outputStream.println("\u001B[34m" + "  - quit: Quit the game" + "\u001B[0m");
    }

    public void sayDungeonMaster(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (message.length() > 80) {
            throw new IllegalArgumentException("Message is too long and exceeds the console width");
        }
        outputStream.println("\u001B[31m" + "Dungeon Master: " + message + "\u001B[0m");
    }

    public String askDungeonMaster(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (message.length() > 80) {
            throw new IllegalArgumentException("Message is too long and exceeds the console width");
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                outputStream.print("\u001B[31m" + "Dungeon Master: " + message + "\u001B[0m");
                String input = scanner.nextLine().trim();
                if (input == null || input.isEmpty()) {
                    throw new InputMismatchException("Input cannot be null or empty");
                }
                return input;
            } catch (InputMismatchException e) {
                outputStream.println("\u001B[31m" + "Invalid input. Please try again." + "\u001B[0m");
            }
        }
    }
}