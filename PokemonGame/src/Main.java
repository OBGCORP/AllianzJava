import model.*;
import model.Character;
import service.GameService;
import service.LoadService;
import service.PlayerService;
import service.WeatherService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    // Setting up initial services
    static LoadService loadService = new LoadService();
    static PlayerService playerService = new PlayerService();
    static GameService gameService = new GameService();
    static WeatherService weatherService = new WeatherService();

    public static void startGame(Scanner input) {


        // Load characters and display their list
        ArrayList<Character> characterList = loadService.loadCharacters();
        System.out.println("List of Characters");
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println((i + 1) + "- " + characterList.get(i).toString());
        }

        // Player creation
        Player[] players = new Player[2];
        for (int playerIndex = 0; playerIndex < players.length; playerIndex++) {
            System.out.print("\nPlayer " + (playerIndex + 1) + ": Choose your character (1-" + characterList.size() + "): ");
            int characterIndex = input.nextInt() - 1;
            Character chosenCharacter = characterList.get(characterIndex);

            System.out.print("Player " + (playerIndex + 1) + ": Enter your name: ");
            String playerName = input.next();
            players[playerIndex] = playerService.createPlayer(playerName, chosenCharacter);
        }

        // Load pokemons and display their list
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
        System.out.println("\nList of Pokemons");
        for (int i = 0; i < pokemonList.size(); i++) {
            System.out.println((i + 1) + "- " + pokemonList.get(i).toString());
        }

        // Pokemon selection for each player
        for (Player player : players) {
            System.out.println("\n" + player.getName() + ": Choose your Pokemon! (1-" + pokemonList.size() + "): ");
            int pokemonIndex = input.nextInt() - 1;
            player.getCharacter().getPokemonList().add(pokemonList.get(pokemonIndex));
        }

        // Randomly choose the first player to play
        Random random = new Random();
        boolean isPlayer1Turn = random.nextBoolean();

        int roundCount = 1;
        final int maxRounds = 2;

        Weather weatherEnum = weatherService.randomWeather();
        Player player1 = players[0];
        Player player2 = players[1];

        weatherService.weatherEffectOnPoke(player1, player2);

        // Game loop
        while (true) {
            if (gameService.healthCheck(player1) && gameService.healthCheck(player2)) {
                Player currentPlayer = isPlayer1Turn ? player1 : player2;
                Player opponentPlayer = isPlayer1Turn ? player2 : player1;
                System.out.println("\n" + currentPlayer.getName() + "'s turn.");
                selectDisplayOptions(input, gameService, currentPlayer, opponentPlayer);
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                System.out.println("Round " + roundCount);
                roundCount++;
                handlePlayerLoss(player1, player2, pokemonList);
                resetPokemonHealthToMax(pokemonList);

                // Exit the loop when the max number of rounds is reached
                if (roundCount > maxRounds) {
                    System.out.println("Game Ended.");
                    break;
                }
            }
        }
    }

    private static void handlePlayerLoss(Player player1, Player player2, ArrayList<Pokemon> pokemonList) {
        Player winner = null;
        Player loser = null;

        if (player1.getCharacter().getPokemonList().get(0).getHealth() <= 0 && player2.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            winner = player2;
            loser = player1;
            System.out.println(player1.getName() + " lost the game.");
        } else if (player2.getCharacter().getPokemonList().get(0).getHealth() <= 0 && player1.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            winner = player1;
            loser = player2;
            System.out.println(player2.getName() + " won the game.");
        }

        if (winner != null && loser != null) {
            Pokemon winnerPokemon = winner.getCharacter().getPokemonList().get(0);
            Pokemon weakestPokemonForLoser = loadService.getWeakestPokemonForPlayer(pokemonList);

            winnerPokemon.setHealth(weakestPokemonForLoser.getMaxHealth());
            winner.getCharacter().getPokemonList().set(0, weakestPokemonForLoser);
        }

        System.out.println(player1);
        System.out.println(player2);
    }

    private static void resetPokemonHealthToMax(ArrayList<Pokemon> pokemonList) {
        for (Pokemon pokemon : pokemonList) {
            pokemon.setHealth(pokemon.getMaxHealth());
        }
    }


    public static void selectDisplayOptions(Scanner input, GameService gameService, Player attacker, Player defender) {
        while (true) {
            System.out.println("Available attacks:");
            System.out.println("1 - Normal attack");
            System.out.println("2 - Attack with your Pokemon's special power");
            System.out.println("3 - Attack with your Character's special power");
            System.out.print("Enter your choice (1, 2, or 3): ");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    gameService.attack(attacker, defender, false, false);
                    return;
                case 2:
                    gameService.attack(attacker, defender, true, false);
                    return;
                case 3:
                    gameService.attack(attacker, defender, false, true);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1, 2, or 3).");
            }
        }
    }

    public static void main(String[] args) {
        boolean isLive = true;
        while (isLive) {
            Scanner scan = new Scanner(System.in);
            System.out.println("---- WELCOME TO THE POKEMON ----");
            System.out.println("Press (1) to start game, press (2) to exit game.");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    startGame(scan);
                    break;
                case 2:
                    System.err.println("Exiting game.");
                    isLive = false;
                    break;
                default:
                    System.err.println("Invalid choice. Only available inputs are:");
                    System.out.println("(1) Start game.");
                    System.out.println("(2) Exit game.");
                    break;
            }
        }
    }
}