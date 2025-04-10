

package com.adventure.game;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int number;
    private List<String> events;
    private List<String> challenges;

    public Level(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Level number must be a positive integer");
        }
        this.number = number;
        this.events = new ArrayList<>();
        this.challenges = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Level number must be a positive integer");
        }
        this.number = number;
    }

    public List<String> getEvents() {
        return new ArrayList<>(events);
    }

    public void setEvents(List<String> events) {
        if (events == null) {
            throw new NullPointerException("Events list cannot be null");
        }
        this.events = new ArrayList<>(events);
    }

    public List<String> getChallenges() {
        return new ArrayList<>(challenges);
    }

    public void setChallenges(List<String> challenges) {
        if (challenges == null) {
            throw new NullPointerException("Challenges list cannot be null");
        }
        this.challenges = new ArrayList<>(challenges);
    }

    public void addEvent(String event) {
        if (event == null) {
            throw new NullPointerException("Event cannot be null");
        }
        if (!events.contains(event)) {
            this.events.add(event);
        }
    }

    public void removeEvent(String event) {
        if (event == null) {
            throw new NullPointerException("Event cannot be null");
        }
        this.events.remove(event);
    }

    public void addChallenge(String challenge) {
        if (challenge == null) {
            throw new NullPointerException("Challenge cannot be null");
        }
        if (!challenges.contains(challenge)) {
            this.challenges.add(challenge);
        }
    }

    public void removeChallenge(String challenge) {
        if (challenge == null) {
            throw new NullPointerException("Challenge cannot be null");
        }
        this.challenges.remove(challenge);
    }

    public void updateEvent(String oldEvent, String newEvent) {
        if (oldEvent == null || newEvent == null) {
            throw new NullPointerException("Event cannot be null");
        }
        int index = this.events.indexOf(oldEvent);
        if (index != -1) {
            this.events.set(index, newEvent);
        } else {
            throw new IllegalArgumentException("Old event not found in the list");
        }
    }

    public void updateChallenge(String oldChallenge, String newChallenge) {
        if (oldChallenge == null || newChallenge == null) {
            throw new NullPointerException("Challenge cannot be null");
        }
        int index = this.challenges.indexOf(oldChallenge);
        if (index != -1) {
            this.challenges.set(index, newChallenge);
        } else {
            throw new IllegalArgumentException("Old challenge not found in the list");
        }
    }

    public void clearEvents() {
        this.events.clear();
    }

    public void clearChallenges() {
        this.challenges.clear();
    }
}