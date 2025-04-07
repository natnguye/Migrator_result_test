

package com.example;

import com.example.SpellBook;
import com.example.Weapon;

/**
 * Represents a player in the game.
 */
public class Player {
    private Weapon weapon;
    private SpellBook spellBook;

    /**
     * Constructs a new player with the given weapon and spell book.
     * 
     * @param weapon    the player's weapon
     * @param spellBook the player's spell book
     */
    public Player(Weapon weapon, SpellBook spellBook) {
        if (weapon == null) {
            throw new NullPointerException("Weapon cannot be null");
        }
        if (spellBook == null) {
            throw new NullPointerException("SpellBook cannot be null");
        }
        this.weapon = weapon;
        this.spellBook = spellBook;
    }

    /**
     * Returns the player's weapon.
     * 
     * @return the player's weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Returns the player's spell book.
     * 
     * @return the player's spell book
     */
    public SpellBook getSpellBook() {
        return spellBook;
    }
}