package service;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LoadService {
    public ArrayList<Character> loadCharacters() {
        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);

        Character ash = new Ash("Ash", strategy1);
        Character brooke = new Brooke("Brooke", strategy2);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons() {
        SpecialPower electricity = new Electricty("Electricity", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu("Pikachu", 100, 10, TypeEnum.ELECTRICY, electricity, 100);
        Pokemon pokemon2 = new Squirtle("Squirtle", 15, 8, TypeEnum.WATER, water, 150);
        Pokemon pokemon3 = new Charmander("Charmender", 90, 12, TypeEnum.FIRE, fire, 90);
        Pokemon pokemon4 = new Balbausar("Balbausar", 140, 7, TypeEnum.EARTH, earth, 140);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }

    public Pokemon getWeakestPokemonForPlayer(ArrayList<Pokemon> pokemonList) {
        if (pokemonList.isEmpty()) {
            // Null check
            return null;
        }

        // Use Collections.min() to find the weakest Pokemon based on max health
        Pokemon weakestPokemon = Collections.min(pokemonList, Comparator.comparing(Pokemon::getMaxHealth));
        return weakestPokemon;
    }
}
