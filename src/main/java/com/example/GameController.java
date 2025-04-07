

package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public class GameController {
    private DungeonMaster _dungeonMaster;

    public GameController(DungeonMaster dungeonMaster) {
        _dungeonMaster = dungeonMaster;
    }

    public void startGame() {
        Character character = new Character();
        System.out.println("Welcome to the game!");
        System.out.println("You are a brave adventurer seeking fortune and glory.");
        System.out.println("You find yourself in a dark and mysterious dungeon.");
        System.out.println("What do you want to do?");
        System.out.println("1. Explore the dungeon");
        System.out.println("2. Fight a monster");
        System.out.println("3. Run away");
        handleUserInput(character);
    }

    public void handleUserInput(Character character) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            if (input.matches("[1-3]")) {
                switch (input) {
                    case "1":
                        exploreDungeon(character);
                        break;
                    case "2":
                        fightMonster(character);
                        break;
                    case "3":
                        runAway(character);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void exploreDungeon(Character character) {
        Room room = _dungeonMaster.getRoom(character);
        character.setCurrentRoom(room);
        System.out.println("You find yourself in a " + room.getDescription());
        System.out.println("There is a door to the north and a door to the south.");
        System.out.println("What do you want to do?");
        System.out.println("1. Go north");
        System.out.println("2. Go south");
        System.out.println("3. Search the room");
        handleRoomInput(character, room);
    }

    private void handleRoomInput(Character character, Room room) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            if (input.matches("[1-3]")) {
                switch (input) {
                    case "1":
                        goNorth(character, room);
                        break;
                    case "2":
                        goSouth(character, room);
                        break;
                    case "3":
                        searchRoom(character, room);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void goNorth(Character character, Room room) {
        Room nextRoom = _dungeonMaster.getRoom(character, "north");
        character.setCurrentRoom(nextRoom);
        System.out.println("You find yourself in a " + nextRoom.getDescription());
        System.out.println("There is a door to the north and a door to the south.");
        System.out.println("What do you want to do?");
        System.out.println("1. Go north");
        System.out.println("2. Go south");
        System.out.println("3. Search the room");
        handleRoomInput(character, nextRoom);
    }

    private void goSouth(Character character, Room room) {
        Room nextRoom = _dungeonMaster.getRoom(character, "south");
        character.setCurrentRoom(nextRoom);
        System.out.println("You find yourself in a " + nextRoom.getDescription());
        System.out.println("There is a door to the north and a door to the south.");
        System.out.println("What do you want to do?");
        System.out.println("1. Go north");
        System.out.println("2. Go south");
        System.out.println("3. Search the room");
        handleRoomInput(character, nextRoom);
    }

    private void searchRoom(Character character, Room room) {
        System.out.println("You search the room and find a treasure chest.");
        System.out.println("What do you want to do?");
        System.out.println("1. Open the chest");
        System.out.println("2. Leave the chest alone");
        handleChestInput(character, room);
    }

    private void handleChestInput(Character character, Room room) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            if (input.matches("[1-2]")) {
                switch (input) {
                    case "1":
                        openChest(character, room);
                        break;
                    case "2":
                        leaveChestAlone(character, room);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void openChest(Character character, Room room) {
        System.out.println("You open the chest and find a treasure.");
        System.out.println("You gain 100 gold pieces.");
        character.addGold(100);
        System.out.println("What do you want to do?");
        System.out.println("1. Continue exploring the dungeon");
        System.out.println("2. Go back to the start");
        handleChestInput(character, room);
    }

    private void leaveChestAlone(Character character, Room room) {
        System.out.println("You leave the chest alone.");
        System.out.println("What do you want to do?");
        System.out.println("1. Continue exploring the dungeon");
        System.out.println("2. Go back to the start");
        handleChestInput(character, room);
    }

    private void fightMonster(Character character) {
        Monster monster = _dungeonMaster.getMonster(character);
        System.out.println("You encounter a " + monster.getName());
        System.out.println("The monster has " + monster.getHealth() + " health.");
        System.out.println("What do you want to do?");
        System.out.println("1. Attack the monster");
        System.out.println("2. Run away");
        handleMonsterInput(character, monster);
    }

    private void handleMonsterInput(Character character, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            if (input.matches("[1-2]")) {
                switch (input) {
                    case "1":
                        attackMonster(character, monster);
                        break;
                    case "2":
                        runAway(character);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void attackMonster(Character character, Monster monster) {
        System.out.println("You attack the monster.");
        int damage = character.getAttack();
        monster.takeDamage(damage);
        System.out.println("You deal " + damage + " damage to the monster.");
        System.out.println("The monster has " + monster.getHealth() + " health left.");
        if (monster.isDead()) {
            System.out.println("You killed the monster.");
            System.out.println("You gain 100 experience points.");
            character.addExperience(100);
            System.out.println("What do you want to do?");
            System.out.println("1. Continue exploring the dungeon");
            System.out.println("2. Go back to the start");
            handleMonsterInput(character, monster);
        } else {
            System.out.println("The monster is still alive.");
            System.out.println("What do you want to do?");
            System.out.println("1. Attack the monster again");
            System.out.println("2. Run away");
            handleMonsterInput(character, monster);
        }
    }

    private void runAway(Character character) {
        System.out.println("You run away from the monster.");
        System.out.println("Game over.");
        System.exit(0);
    }
}

class Character {
    private int gold;
    private int experience;
    private int attack;
    private Room currentRoom;

    public Character() {
        gold = 0;
        experience = 0;
        attack = 10;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void addExperience(int amount) {
        experience += amount;
    }

    public int getAttack() {
        return attack;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }
}

class DungeonMaster {
    private ObjectMapper objectMapper;

    public DungeonMaster() {
        objectMapper = new ObjectMapper();
    }

    public Room getRoom(Character character) {
        JsonNode roomData = objectMapper.createObjectNode().put("description", "A dark and mysterious room.");
        return new Room(roomData.get("description").asText());
    }

    public Room getRoom(Character character, String direction) {
        JsonNode roomData = objectMapper.createObjectNode().put("description", "A dark and mysterious room.");
        return new Room(roomData.get("description").asText());
    }

    public Monster getMonster(Character character) {
        JsonNode monsterData = objectMapper.createObjectNode().put("name", "A fierce dragon").put("health", 100);
        return new Monster(monsterData.get("name").asText(), monsterData.get("health").asInt());
    }
}

class Room {
    private String description;

    public Room(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class Monster {
    private String name;
    private int health;

    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isDead() {
        return health <= 0;
    }
}