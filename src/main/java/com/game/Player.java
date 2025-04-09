

package com.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String archetype;
    private List<String> equipment;

    public Player(String name, String archetype, List<String> equipment) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (archetype == null || archetype.isEmpty()) {
            throw new IllegalArgumentException("Archetype cannot be null or empty");
        }
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        this.name = name;
        this.archetype = archetype;
        this.equipment = new ArrayList<>(equipment);
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

    public List<String> getEquipment() {
        return new ArrayList<>(equipment);
    }

    public void setEquipment(List<String> equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        this.equipment = new ArrayList<>(equipment);
    }

    public void addEquipment(String equipment) {
        if (equipment == null || equipment.isEmpty()) {
            throw new IllegalArgumentException("Equipment cannot be null or empty");
        }
        if (this.equipment.contains(equipment)) {
            throw new IllegalArgumentException("Equipment is already added");
        }
        this.equipment.add(equipment);
    }

    public void removeEquipment(String equipment) {
        if (equipment == null || equipment.isEmpty()) {
            throw new IllegalArgumentException("Equipment cannot be null or empty");
        }
        this.equipment.remove(equipment);
    }

    public boolean hasEquipment() {
        return !equipment.isEmpty();
    }

    public boolean hasEquipment(String equipment) {
        if (equipment == null || equipment.isEmpty()) {
            throw new IllegalArgumentException("Equipment cannot be null or empty");
        }
        return this.equipment.contains(equipment);
    }
}