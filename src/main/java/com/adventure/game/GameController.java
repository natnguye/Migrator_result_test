

package com.adventure.game;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class GameController {
    private Game game;
    private HelpSystem helpSystem;
    private SaveLoadSystem saveLoadSystem;
    private Scanner scanner;

    public GameController() {
        this.game = new Game();
        this.helpSystem = new HelpSystem();
        this.saveLoadSystem = new SaveLoadSystem();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the adventure game!");
        System.out.println("You are standing at the entrance of a dark cave.");
        System.out.println("What do you want to do?");
        System.out.println("Type 'help' for available commands.");
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("help")) {
                helpSystem.displayHelp();
            } else if (input.equalsIgnoreCase("save")) {
                saveLoadSystem.saveGame(game);
            } else if (input.equalsIgnoreCase("load")) {
                game = saveLoadSystem.loadGame();
                if (game != null) {
                    System.out.println("Game loaded. Current state: " + game.getGameState());
                } else {
                    System.out.println("Error loading game. Please try again.");
                }
            } else if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                if (game.isValidInput(input)) {
                    try {
                        game.updateGameState(input);
                        System.out.println(game.getGameState());
                    } catch (Exception e) {
                        System.out.println("Error updating game state: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid input. Type 'help' for available commands.");
                }
            }
        }
    }

    private class Game {
        private String gameState;
        private Map<String, String> validInputs;
        private Map<String, String> gameMechanics;

        public Game() {
            this.gameState = "You are standing at the entrance of a dark cave.";
            this.validInputs = new HashMap<>();
            validInputs.put("go inside", "You are now inside the cave.");
            validInputs.put("go outside", "You are now outside the cave.");
            validInputs.put("explore", "You found a treasure!");
            this.gameMechanics = new HashMap<>();
            gameMechanics.put("game mechanics", "The game is a text-based adventure game. You can type commands to navigate and interact with the environment. The game has a cave that you can enter and explore. You can find treasure by typing 'explore'.");
        }

        public void updateGameState(String input) {
            if (validInputs.containsKey(input)) {
                gameState = validInputs.get(input);
                if (input.equalsIgnoreCase("go outside") {
                    gameState = "You are now outside the cave. You can't go any further.";
                }
            }
        }

        public String getGameState() {
            return gameState;
        }

        public boolean isValidInput(String input) {
            return validInputs.containsKey(input);
        }

        public String getGameMechanics() {
            return gameMechanics.get("game mechanics");
        }
    }

    private class HelpSystem {
        private Map<String, String> helpCommands;

        public HelpSystem() {
            helpCommands = new HashMap<>();
            helpCommands.put("help", "Displays available commands.");
            helpCommands.put("save", "Saves the current game state.");
            helpCommands.put("load", "Loads a saved game state.");
            helpCommands.put("quit", "Quits the game.");
            helpCommands.put("go inside", "Goes inside the cave.");
            helpCommands.put("game mechanics", "Displays game mechanics.");
        }

        public void displayHelp() {
            System.out.println("Available commands:");
            for (Map.Entry<String, String> entry : helpCommands.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private class SaveLoadSystem {
        private static final String SAVE_FILE = "game_save.txt";

        public void saveGame(Game game) {
            if (game != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
                    writer.write(game.getGameState());
                    writer.newLine();
                    writer.write(game.getGameMechanics());
                } catch (IOException e) {
                    System.out.println("Error saving game: " + e.getMessage());
                }
                System.out.println("Game saved.");
            } else {
                System.out.println("Error: Game state is null.");
            }
        }

        public Game loadGame() {
            try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
                String gameState = reader.readLine();
                String gameMechanics = reader.readLine();
                if (gameState != null && gameMechanics != null) {
                    Game game = new Game();
                    game.gameState = gameState;
                    game.gameMechanics.put("game mechanics", gameMechanics);
                    return game;
                } else {
                    System.out.println("Error: Saved game state is null.");
                    return null;
                }
            } catch (IOException e) {
                System.out.println("Error loading game: " + e.getMessage());
                return null;
            } catch (Exception e) {
                System.out.println("Error loading game: " + e.getMessage());
                return null;
            }
        }
    }
}