

package com.game;

import java.util.Scanner;

public class DungeonMaster {
    private Player player;
    private LogWriter logWriter;
    private boolean gameOver;
    private String gameState;

    public DungeonMaster() {
        this.logWriter = new LogWriter();
        this.gameOver = false;
        this.gameState = "start";
    }

    public Player createCharacter() {
        logWriter.write("\u001B[34m" + "Enter your character's name: " + "\u001B[0m");
        String name = logWriter.readInput();
        return new Player(name);
    }

    public void playGame() {
        Player player = createCharacter();
        logWriter.write("\u001B[34m" + "Welcome, " + player.getName() + "!" + "\u001B[0m");
        while (!gameOver) {
            if (gameState.equals("start")) {
                logWriter.write("\u001B[34m" + "You are in a dark room. Do you want to go north, south, east or west?" + "\u001B[0m");
                String direction = logWriter.readInput();
                if (direction.equalsIgnoreCase("north")) {
                    gameState = "north";
                } else if (direction.equalsIgnoreCase("south")) {
                    gameState = "south";
                } else if (direction.equalsIgnoreCase("east")) {
                    gameState = "east";
                } else if (direction.equalsIgnoreCase("west")) {
                    gameState = "west";
                } else {
                    logWriter.write("\u001B[34m" + "Invalid direction. Please try again." + "\u001B[0m");
                }
            } else if (gameState.equals("north")) {
                logWriter.write("\u001B[34m" + "You went north. You found a treasure!" + "\u001B[0m");
                gameOver = true;
            } else if (gameState.equals("south")) {
                logWriter.write("\u001B[34m" + "You went south. You found a monster!" + "\u001B[0m");
                gameOver = true;
            } else if (gameState.equals("east")) {
                logWriter.write("\u001B[34m" + "You went east. You found a river!" + "\u001B[0m");
                gameOver = true;
            } else if (gameState.equals("west")) {
                logWriter.write("\u001B[34m" + "You went west. You found a forest!" + "\u001B[0m");
                gameOver = true;
            }
        }
    }
}

class LogWriter {
    private Scanner scanner;

    public LogWriter() {
        this.scanner = new Scanner(System.in);
    }

    public void write(String message) {
        System.out.println(message);
    }

    public String readInput() {
        return scanner.nextLine();
    }
}

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}