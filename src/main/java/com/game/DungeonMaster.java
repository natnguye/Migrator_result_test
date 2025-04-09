

package com.game;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DungeonMaster {
    private Player player;
    private LogWriter logWriter;
    private String[] archetypes = {"Warrior", "Mage", "Rogue"};

    public DungeonMaster(LogWriter logWriter) {
        this.logWriter = logWriter;
        this.player = null;
    }

    public void createCharacter() {
        if (player != null) {
            logWriter.write("Character already exists.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your character's name:");
        String name = scanner.nextLine();
        System.out.println("Enter your character's archetype:");
        String archetype = scanner.nextLine();

        if (!name.isEmpty() && isValidArchetype(archetype)) {
            player = new Player(name, archetype);
            logWriter.write("Character created successfully.");
        } else {
            logWriter.write("Invalid input. Please enter a name and a valid archetype.");
        }
    }

    public void printArchetypes() {
        logWriter.write("Suggested archetypes:");
        for (int i = 0; i < archetypes.length; i++) {
            logWriter.write((i + 1) + ". " + archetypes[i]);
        }
    }

    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        while (gameRunning) {
            try {
                System.out.println("Enter a command:");
                String command = scanner.nextLine();
                switch (command) {
                    case "create":
                        createCharacter();
                        break;
                    case "archetypes":
                        printArchetypes();
                        break;
                    case "exit":
                        gameRunning = false;
                        break;
                    case "update":
                        if (player != null) {
                            System.out.println("Enter new state:");
                            String newState = scanner.nextLine();
                            updatePlayerState(newState);
                        } else {
                            logWriter.write("No player exists to update.");
                        }
                        break;
                    default:
                        logWriter.write("Invalid command");
                }
            } catch (InputMismatchException e) {
                logWriter.write("Invalid input. Please enter a valid command.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public void updatePlayerState(String newState) {
        if (player != null) {
            player.updateState(newState);
            logWriter.write("Player state updated to " + newState);
        }
    }

    private boolean isValidArchetype(String archetype) {
        for (String validArchetype : archetypes) {
            if (validArchetype.equalsIgnoreCase(archetype)) {
                return true;
            }
        }
        return false;
    }
}

class Player {
    private String name;
    private String archetype;
    private String state;

    public Player(String name, String archetype) {
        this.name = name;
        this.archetype = archetype;
        this.state = "active";
    }

    public String getName() {
        return name;
    }

    public String getArchetype() {
        return archetype;
    }

    public void updateState(String newState) {
        this.state = newState;
    }

    public String getState() {
        return state;
    }
}

class ConsoleLogWriter implements LogWriter {
    public void write(String message) {
        System.out.println(message);
    }
}

interface LogWriter {
    void write(String message);
}