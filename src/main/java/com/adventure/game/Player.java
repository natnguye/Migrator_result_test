

package com.adventure.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String archetype;
    private List<String> abilities;
    private int health;
    private int strength;
    private int agility;
    private int intelligence;
    private int charisma;

    public Player(String name, String archetype) {
        if (name == null || name.isEmpty() || archetype == null || archetype.isEmpty()) {
            throw new IllegalArgumentException("Name and archetype cannot be null or empty");
        }
        this.name = name;
        this.archetype = archetype;
        this.abilities = new ArrayList<>();
        this.health = 100;
        this.strength = 10;
        this.agility = 10;
        this.intelligence = 10;
        this.charisma = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        if (archetype == null || archetype.isEmpty()) {
            throw new IllegalArgumentException("Archetype cannot be null or empty");
        }
        this.archetype = archetype;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void addAbility(String ability) {
        if (ability == null || ability.isEmpty()) {
            throw new IllegalArgumentException("Ability cannot be null or empty");
        }
        if (!abilities.contains(ability)) {
            this.abilities.add(ability);
        }
    }

    public void removeAbility(String ability) {
        if (ability == null || ability.isEmpty()) {
            throw new IllegalArgumentException("Ability cannot be null or empty");
        }
        if (this.abilities.contains(ability)) {
            this.abilities.remove(ability);
        }
    }

    public void updateStatistics(int health, int strength, int agility, int intelligence, int charisma) {
        if (health < 0 || strength < 0 || agility < 0 || intelligence < 0 || charisma < 0) {
            throw new IllegalArgumentException("Statistics cannot be negative");
        }
        if (health > 100 || strength > 100 || agility > 100 || intelligence > 100 || charisma > 100) {
            throw new IllegalArgumentException("Statistics cannot be greater than 100");
        }
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public void updateAbilities(List<String> newAbilities) {
        if (newAbilities == null) {
            throw new IllegalArgumentException("New abilities cannot be null");
        }
        if (newAbilities.isEmpty()) {
            this.abilities = new ArrayList<>();
            return;
        }
        for (String ability : newAbilities) {
            if (ability == null || ability.isEmpty()) {
                throw new IllegalArgumentException("Ability cannot be null or empty");
            }
        }
        List<String> uniqueAbilities = new ArrayList<>();
        for (String ability : newAbilities) {
            if (!uniqueAbilities.contains(ability)) {
                uniqueAbilities.add(ability);
            }
        }
        this.abilities = uniqueAbilities;
    }

    public void resetAbilities() {
        if (!this.abilities.isEmpty()) {
            this.abilities = new ArrayList<>();
        }
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }
}