

package com.dungeonmaster;

import java.util.ArrayList;
import java.util.List;

public class DungeonMaster {
    private LogWriter logWriter;
    private List<String> archetypes;
    private List<Character> characters;
    private Game game;
    private boolean isGameStarted;

    public DungeonMaster(LogWriter logWriter) {
        this.logWriter = logWriter;
        this.archetypes = new ArrayList<>();
        this.archetypes.add("Warrior");
        this.archetypes.add("Mage");
        this.archetypes.add("Rogue");
        this.characters = new ArrayList<>();
        this.game = new Game();
        this.isGameStarted = false;
    }

    public void createCharacter(String name, String archetype) {
        if (archetypes.contains(archetype)) {
            Character character = new Character(name, archetype);
            characters.add(character);
            logWriter.writeLine("Welcome, " + name + " the " + archetype + "!");
            logWriter.writeLine("You are now ready to start the game.");
        } else {
            logWriter.writeLine("Invalid archetype. Please choose from the suggested archetypes.");
        }
    }

    public void printArchetypes() {
        if (!archetypes.isEmpty()) {
            logWriter.writeLine("Suggested archetypes:");
            for (String archetype : archetypes) {
                logWriter.writeLine(archetype);
            }
        } else {
            logWriter.writeLine("No archetypes available.");
        }
    }

    public void introduce() {
        logWriter.writeLine("Welcome to the Dungeon Master game!");
        logWriter.writeLine("This is a game of adventure and bravery.");
        logWriter.writeLine("You will create a character and embark on a journey.");
        printArchetypes();
        logWriter.writeLine("Please create your character by typing 'create <name> <archetype>'.");
    }

    public void startGame() {
        if (!isGameStarted) {
            if (!characters.isEmpty()) {
                game.start(characters);
                isGameStarted = true;
            } else {
                logWriter.writeLine("Please create a character before starting the game.");
            }
        } else {
            logWriter.writeLine("Game is already started.");
        }
    }

    public void processCommand(String command) {
        String[] parts = command.split(" ");
        if (parts[0].equals("create")) {
            if (parts.length == 3) {
                createCharacter(parts[1], parts[2]);
            } else {
                logWriter.writeLine("Invalid command. Please use 'create <name> <archetype>'.");
            }
        } else if (parts[0].equals("start")) {
            startGame();
        } else {
            logWriter.writeLine("Unknown command. Please use 'create <name> <archetype>' or 'start'.");
        }
    }

    public static void main(String[] args) {
        LogWriter logWriter = new LogWriter();
        DungeonMaster dungeonMaster = new DungeonMaster(logWriter);
        dungeonMaster.introduce();
        dungeonMaster.processCommand("create John Warrior");
        dungeonMaster.processCommand("start");
    }
}

class LogWriter {
    public void writeLine(String message) {
        System.out.println(message);
    }

    public void write(String message) {
        System.out.print(message);
    }
}

class Character {
    private String name;
    private String archetype;

    public Character(String name, String archetype) {
        this.name = name;
        this.archetype = archetype;
    }

    public String getName() {
        return name;
    }

    public String getArchetype() {
        return archetype;
    }
}

class Game {
    public void start(List<Character> characters) {
        // game logic
        System.out.println("Game started with " + characters.size() + " characters.");
    }
}