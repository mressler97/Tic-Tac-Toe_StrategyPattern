# Tic-Tac-Toe using Strategy Pattern

A simple game of Tic-Tac-Toe that implements the strategy pattern allowing the user to change which algorithms are used at runtime. In this instance, it allows for computer vs computer, computer vs player, and player vs player. After each game, the program will keep running and will prompt the user if any of the starting arguments would like to be changed, hence exemplifying that strategies can be changed at runtime. 

## Instructions to run program

The program takes two command line arguments. The first argument is the number of players (i.e `0` is computer vs computer, `1` is computer vs player, and `2` is player vs player). The second command line argument is for verbosity (i.e. `0` is no verbosity, `1` is verbosity on). After each game, the program will ask for user input if the strategy would like to be changed.

If a JAR file is created, the program can be ran as follows: `java -jar TTT.jar 0 1`. Otherwise compile it and run the main.java file in a favored IDE.
