package connectfour;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Gariel Mahwastu
 * This class contains all of the methods for user input
 * and printing.
 * 
 */

public class TextUI{

    //Creating scanner
    private Scanner userIn = new Scanner(System.in);

    //Variables
    private int userInt;
    private String fileToOpen;
    private char userAns;

    //Setters and getters for read from file
    public char getUserAns(){
        return userAns;
    }
    public void setUserAns(char newChar){
        userAns = newChar;
    }

    //Setters and getters for user input
    public int getUserInpt(){
        return userInt;
    }
    public void setUserInpt(int newUserInpt){
        userInt = newUserInpt;
    }

    //Getters for filename
    public String getFileName(){
        return fileToOpen;
    }

    //Asking for user input
    public void userInput(){
        int errorCheck = 0;
        System.out.println("Please enter column position between 0 - 6. Enter 7 to save: ");
        while(errorCheck == 0){
            try{
                userInt = userIn.nextInt();
                errorCheck = 1;
            }catch(InputMismatchException ex){
                System.out.println("Please enter column position between 0 - 6. Enter 7 to save: ");
                userIn.nextLine();
                errorCheck = 0;
            }
            if((userInt < 0 || userInt > 7) && errorCheck == 1){
                System.out.println("Please enter column position between 0 - 6. Enter 7 to save: ");
                errorCheck = 0;
            }
        }
    }

    //Printing out the turn
    public void printingTurn(char player){
        System.out.println("Turn = " + player);
    }

    //Method to print board
    public void displayBoard(String boardToPrint){
        System.out.println(boardToPrint);
    }

    //Printing error message
    public void displayError(){
        System.out.println("Error - Option is Out of Bounds");
        
    }

    //Column is full error message
    public void fullColumn(){
        int checkError = 0;
        System.out.println("Column is full. Try Again");
        System.out.println("Please enter column position between 0 - 6. Enter 7 to save: ");
        while(checkError == 0){
            try{
                userInt = userIn.nextInt();
                checkError = 1;
            } catch(InputMismatchException ex){
                System.out.println("Please enter column position between 0 - 6. Enter 7 to save: ");
                userIn.nextLine();
                checkError = 0;
            }
            if((userInt < 0 || userInt > 7) && checkError == 1){
                System.out.println("Please enter column position between 0 - 6. Enter 7 to save: ");
                checkError = 0;
            }
        }
    }

    //Printing for when game is a tie
    public void gameIsTie(){
        System.out.println("The game is a tie.");
    }

    //Printing the winner
    public void gameIsWon(char player){
        System.out.println("Player " + player + " Wins!");
    }

    //Asking user to access from file
    public void accessFile(){
        int checkError = 0;
        System.out.println("Would you like to load game from a file? (y/n)");

        while(checkError == 0){
                userAns = userIn.nextLine().charAt(0);
                userAns = Character.toLowerCase(userAns);
                checkError = 1;

            if(userAns != 'y' && userAns != 'n'){
                System.out.println("Would you like to load game from a file? (y/n)");
                checkError = 0;
            }
        }
    }

    //Asking user for name of file
    public void askFileName(){
        int errorCheck = 0;
        System.out.println("Please enter a valid file name. Please include .csv: ");

        while(errorCheck == 0){
            fileToOpen = userIn.nextLine();
            errorCheck = 1;
        }
    }

    public String askFileToSave(){
        int errorCheck = 0;
        userIn.nextLine();
        System.out.println("Please enter a valid file name. Please include .csv: ");

        while(errorCheck == 0){
            fileToOpen = userIn.nextLine();
            errorCheck = 1;

            for(int i = 0; i < fileToOpen.length(); i++){
                if(fileToOpen.charAt(i) == ' '){
                    errorCheck = 0;
                    System.out.println("Please enter the file name without whitespace");
                    break;
                }
            }
        }
        return fileToOpen;
    }

    public String toString(){
        String txUI = "Text UI Class";
        return txUI;
    }


}