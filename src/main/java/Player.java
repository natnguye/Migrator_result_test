

package com.game;

/**
 * Represents the player character in the game.
 */
public class Player {
    private String name;
    private int health;
    private int score;

    /**
     * Constructs a new Player object with the given name, health, and score.
     * 
     * @param name  the player's name
     * @param health the player's initial health
     * @param score the player's initial score
     */
    public Player(String name, int health, int score) {
        this.name = name;
        this.health = health;
        this.score = score;
    }

    /**
     * Returns the player's name.
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     * 
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the player's current health.
     * 
     * @return the player's current health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the player's health.
     * 
     * @param health the new health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the player's current score.
     * 
     * @return the player's current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score.
     * 
     * @param score the new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Increases the player's score by the given amount.
     * 
     * @param amount the amount to increase the score by
     */
    public void increaseScore(int amount) {
        this.score += amount;
    }

    /**
     * Decreases the player's health by the given amount.
     * 
     * @param amount the amount to decrease the health by
     */
    public void decreaseHealth(int amount) {
        this.health -= amount;
    }

    /**
     * Returns whether the player is alive (i.e., has health greater than 0).
     * 
     * @return true if the player is alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", score=" + score +
                '}';
    }
}