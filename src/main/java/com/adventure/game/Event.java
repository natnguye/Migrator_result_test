

package com.adventure.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Event {
    private String description;
    private List<Choice> choices;
    private List<Consequence> consequences;

    public Event(String description, List<Choice> choices, List<Consequence> consequences) {
        this.description = description;
        this.choices = choices;
        this.consequences = consequences;
    }

    public String getDescription() {
        return description;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public List<Consequence> getConsequences() {
        return consequences;
    }

    public void playEvent(GameState gameState) {
        System.out.println(description);
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i).getDescription());
        }
        int choice = getValidChoice(gameState);
        Choice selectedChoice = choices.get(choice - 1);
        Consequence consequence = selectedChoice.getConsequence();
        consequence.apply(gameState);
        updateGameState(gameState, consequence);
    }

    private int getValidChoice(GameState gameState) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice > 0 && choice <= choices.size()) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + choices.size());
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private void updateGameState(GameState gameState, Consequence consequence) {
        gameState.updateHealth(consequence.getHealthEffect());
        gameState.updateGold(consequence.getGoldEffect());
    }

    public static void main(String[] args) {
        GameState gameState = new GameState();
        gameState.setHealth(100);
        gameState.setGold(100);

        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("Go to the forest", new Consequence("You found a sword.", 10, 50)));
        choices.add(new Choice("Go to the mountain", new Consequence("You found a shield.", 20, 30)));

        Event event = new Event("You are at the crossroads. Where do you want to go?", choices, new ArrayList<>());
        event.playEvent(gameState);

        System.out.println("Health: " + gameState.getHealth());
        System.out.println("Gold: " + gameState.getGold());
    }
}

class Choice {
    private String description;
    private Consequence consequence;

    public Choice(String description, Consequence consequence) {
        this.description = description;
        this.consequence = consequence;
    }

    public String getDescription() {
        return description;
    }

    public Consequence getConsequence() {
        return consequence;
    }
}

class Consequence {
    private String description;
    private int healthEffect;
    private int goldEffect;

    public Consequence(String description, int healthEffect, int goldEffect) {
        this.description = description;
        this.healthEffect = healthEffect;
        this.goldEffect = goldEffect;
    }

    public void apply(GameState gameState) {
        System.out.println(description);
    }

    public int getHealthEffect() {
        return healthEffect;
    }

    public int getGoldEffect() {
        return goldEffect;
    }
}

class GameState {
    private int health;
    private int gold;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void updateHealth(int healthEffect) {
        this.health += healthEffect;
    }

    public void updateGold(int goldEffect) {
        this.gold += goldEffect;
    }
}