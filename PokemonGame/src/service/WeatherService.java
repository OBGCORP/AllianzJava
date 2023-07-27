package service;

import model.Player;
import model.Weather;

import java.util.Random;

public class WeatherService {

    public void weatherEffectOnPoke(Player player1, Player player2) {
        if (randomWeather() == Weather.HEATWAVE) {
            if (player1.getCharacter().getPokemonList().get(0).getName().equals("Squirtle")) {
                player1.getCharacter().getPokemonList().get(0).setHealth(player1.getCharacter().getPokemonList().get(0).getHealth() - 15);
            } else if (player2.getCharacter().getPokemonList().get(0).getName().equals("Squirtle")) {
                player2.getCharacter().getPokemonList().get(0).setHealth(player2.getCharacter().getPokemonList().get(0).getHealth() - 15);
            }
        } else if (randomWeather() == Weather.RAIN) {
            if (player1.getCharacter().getPokemonList().get(0).getName().equals("Pikachu")) {
                player1.getCharacter().getPokemonList().get(0).setHealth(player1.getCharacter().getPokemonList().get(0).getHealth() - 15);
            } else if (player2.getCharacter().getPokemonList().get(0).getName().equals("Pikachu")) {
                player2.getCharacter().getPokemonList().get(0).setHealth(player2.getCharacter().getPokemonList().get(0).getHealth() - 15);
            }
        } else if (randomWeather() == Weather.WINDY) {
            if (player1.getCharacter().getPokemonList().get(0).getName().equals("Charmender")) {
                player1.getCharacter().getPokemonList().get(0).setHealth(player1.getCharacter().getPokemonList().get(0).getHealth() - 15);
            } else if (player2.getCharacter().getPokemonList().get(0).getName().equals("Charmender")) {
                player2.getCharacter().getPokemonList().get(0).setHealth(player2.getCharacter().getPokemonList().get(0).getHealth() - 15);
            }
        }
    }

    public Weather randomWeather() {
        Weather weather = null;
        Random random = new Random();
        int rand = random.nextInt(4);
        switch (rand) {
            case 1:
                weather = Weather.RAIN;
                break;
            case 2:
                weather = Weather.WINDY;
                break;
            case 3:
                weather = Weather.HEATWAVE;
                break;
        }
        return weather;
    }

}
