package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Character> characters;
    private boolean isWinner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", characters=" + characters +
                ", isWinner=" + isWinner +
                '}';
    }
}
