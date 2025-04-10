

package com.adventure.game;

import java.io.*;
import java.util.*;

public class DungeonMaster {
    private Player player;
    private Level currentLevel;

    public void initializeGame() {
        System.out.println("Initializing game...");
        player = createCharacter("Default", 100, 0);
    }

    public Player createCharacter(String name, int health, int score) {
        return new Player(name, health, score);
    }

    public void playLevel(Level level) {
        currentLevel = level;
        currentLevel.start();
        currentLevel.updatePlayerProgress(player);
        System.out.println("Player progress: " + player.getName() + ", Health: " + player.getHealth() + ", Score: " + player.getScore());
        saveProgress();
    }

    public void saveProgress() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("player_progress.dat"))) {
            oos.writeObject(player);
        } catch (IOException e) {
            System.err.println("Error saving progress: " + e.getMessage());
        }
    }

    public void loadProgress() {
        File file = new File("player_progress.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                player = (Player) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading progress: " + e.getMessage());
            }
        } else {
            System.out.println("No saved progress found.");
        }
    }
}

class Player implements Serializable {
    private String name;
    private int health;
    private int score;
    private int experience;
    private int level;

    public Player(String name, int health, int score) {
        this.name = name;
        this.health = health;
        this.score = score;
        this.experience = 0;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void updateHealth(int health) {
        this.health += health;
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public void updateExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 100) {
            this.level++;
            this.experience = 0;
        }
    }
}

class Level implements Serializable {
    private String name;
    private String description;
    private int experienceReward;

    public Level(String name, String description, int experienceReward) {
        this.name = name;
        this.description = description;
        this.experienceReward = experienceReward;
    }

    public void start() {
        System.out.println("Starting level: " + name);
        System.out.println(description);
    }

    public void updatePlayerProgress(Player player) {
        player.updateHealth(10);
        player.updateScore(100);
        player.updateExperience(experienceReward);
    }
}