**Game README**

This README provides an overview of the game code and its optimization. The game is a turn-based battle game where two players, each with a character and a Pokemon, take turns attacking each other until one player loses all their Pokemon. The game involves selecting attacks and using special powers to defeat the opponent.

## Game Code Overview

The game code consists of several Java classes that handle different aspects of the game. Here's a brief overview of each class:

1. `GameService`: This class contains game-related functionalities, such as checking the health of players and performing attacks. The `attack` method handles different attack types based on the player's choice.

2. `LoadService`: This class is responsible for loading characters and Pokemon lists from some data source (e.g., file or database). It also includes the `getWeakestPokemonForPlayer` method, which finds the weakest Pokemon in a given Pokemon list.

3. `PlayerService`: This class is responsible for creating player objects and managing their attributes.

4. `Character`: Represents a player's character in the game and contains a list of Pokemon that belong to the character.

5. `Pokemon`: Represents a Pokemon with attributes like health and special powers.

6. `Player`: Represents a player in the game, with a character and a name.

7. `Main`: This class contains the `startGame` method, which initializes the game and manages the game loop.

## Game Optimization

The code was optimized to improve its readability, maintainability, and efficiency. The optimizations include:

1. **Modularity**: The code was organized into separate methods and classes to improve readability and maintainability. Common code blocks were extracted into separate methods.

2. **Input Validation**: Input validation was added to handle invalid user choices during the game. The program prompts the user to enter a valid option if an invalid one is provided.

3. **Utilization of `Collections.min()`**: The code to find the weakest Pokemon for a player was optimized using `Collections.min()` from the `java.util.Collections` class. This reduces the need for manual iteration and comparison.

4. **Reduced Redundancy**: Redundant code blocks were reduced by using variables and methods to store and update Pokemon health and other attributes.

5. **Code Comments**: Relevant comments were added to improve code understanding and maintainability.

## How to Run the Game

To play the game, you can follow these steps:

1. Compile the Java files: Compile all the Java files in the project using a Java compiler.

2. Run the Main class: Execute the `Main` class, which contains the `startGame` method. The game will prompt the players to select their characters, Pokemon, and perform attacks in turns until a player loses all their Pokemon or the maximum number of rounds is reached.

3. Follow the on-screen instructions: During the game, players will be prompted to choose attacks and make decisions accordingly.

## License

This game code is provided under the [MIT License](https://opensource.org/licenses/MIT). You are free to use, modify, and distribute the code for your own projects, subject to the terms of the license.

Feel free to contribute to the game code or suggest improvements by creating pull requests or raising issues on the repository.

Happy gaming!
