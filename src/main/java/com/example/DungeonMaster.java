

package com.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DungeonMaster {
    private Player _player;
    private LogWriter _logWriter;
    private List<String> _archetypes;

    public DungeonMaster(Player player, LogWriter logWriter) {
        if (player == null || logWriter == null) {
            throw new NullPointerException("Player and LogWriter cannot be null");
        }
        this._player = player;
        this._logWriter = logWriter;
        this._archetypes = new ArrayList<>();
        this._archetypes.add("Warrior");
        this._archetypes.add("Mage");
        this._archetypes.add("Rogue");
    }

    public Character createCharacter() {
        Scanner scanner = new Scanner(System.in);
        String name = getValidName(scanner);
        int age = getValidAge(scanner);
        String archetype = getValidArchetype(scanner);
        return new Character(name, age, archetype);
    }

    private String getValidName(Scanner scanner) {
        while (true) {
            System.out.println("Enter character name:");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Name cannot be empty. Please try again.");
        }
    }

    private int getValidAge(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter character age:");
                int age = scanner.nextInt();
                scanner.nextLine();
                if (age > 0) {
                    return age;
                }
                System.out.println("Age must be greater than 0. Please try again.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private String getValidArchetype(Scanner scanner) {
        while (true) {
            System.out.println("Enter character archetype:");
            printArchetypes();
            String archetype = scanner.nextLine();
            if (_archetypes.contains(archetype)) {
                return archetype;
            }
            System.out.println("Invalid archetype. Please try again.");
        }
    }

    public void printArchetypes() {
        for (int i = 0; i < _archetypes.size(); i++) {
            System.out.println((i + 1) + ". " + _archetypes.get(i));
        }
    }

    public LogWriter getLogWriter() {
        return _logWriter;
    }
}

class Player {
    private String name;

    public Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println("Player Name: " + name);
    }
}

class Character {
    private String name;
    private int age;
    private String archetype;

    public Character(String name, int age, String archetype) {
        if (name == null || name.isEmpty() || age <= 0 || archetype == null || archetype.isEmpty()) {
            throw new NullPointerException("Name, age and archetype cannot be null or empty");
        }
        this.name = name;
        this.age = age;
        this.archetype = archetype;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getArchetype() {
        return archetype;
    }

    public void printDetails() {
        System.out.println("Character Name: " + name);
        System.out.println("Character Age: " + age);
        System.out.println("Character Archetype: " + archetype);
    }
}

class LogWriter {
    public void writeLog(String message, String level) {
        if (message != null && !message.isEmpty()) {
            System.out.println(level + ": " + message);
        }
    }
}