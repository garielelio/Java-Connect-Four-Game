# Connect Four Game

This program creates a connect four game that is played with 2 players.

## Description

This program uses encapsulation, setters and getters, and OOP. This program first asks the user 
if they would like to load a game from a file. The program continues by providing the user with a board for the game and 
allows the user to play a connect four game. The 2 players will be indicated by A and B. The program will ask the user to 
re-enter the input if the value that is being inputted is out of the range. The program also allows the user to save an
unfinished game to a file. The winner of the program is the player who can connect four As or Bs and the game will 
determine that it is a tie when the board is full and no winner is found. The file to load the program must be inside
the assets folder. The file to save the program will also be located inside the assets folder.

## Getting Started

### Dependencies

* The program requires to import BufferedReader and BufferedWriter to load and save the game from and to a file
* The program requires to import exceptions to handle exceptions for user input and to load and save to a file
* The program requires java.util.Scanner, java.util.Arrays, and java.util.ArrayList

### Executing program
* Note: Executing will vary for everyone   
   
* scioer start and scioer shell
* cd to folder A2
* To build the program: gradle build
* To run the program: gradle run
```
gradle build
gradle run
java -cp build/classes/java/main connectfour.ConnectFour
```
* Expected output:
```
Would you like to load game from a file? (y/n)
n
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0

Turn = A
Please enter column position between 0 - 6. Enter 7 to save: 
```
## Limitations

* No limitations found

## Author Information

* Name: Gariel Mahwastu
* Email: gmahwast@uoguelph.ca

## Development History

* November 13, 2022
    * Adding a new class to handle error message

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)


