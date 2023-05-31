package connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * @author Gariel Mahwastu
 * This class will maintain the state of the board, create string representation of the board,
 * and checking for win condition. 
 */

public class Board{

    //Object for error message
    private Error errMes = new Error();

    //Arraylist for the board index
    private ArrayList<Integer> verIndex = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10));
    private ArrayList<Integer> horIndex = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12));

    //Variables
    private int depthOfGame = 0;
    private int userCol;
    private ArrayList<Integer> curVerIdx = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5, 5));

    /**
     * This is a getters for depthOfGame
     * @param NONE
     * @return depthOfGame
     */
    public int getDepthOfGame(){
        return depthOfGame;
    }

    /**
     * This is a setters for depthOfGame
     * @param replaceDepth
     * @return NONE
     */
    public void setDepthOfGame(int replaceDepth){
        depthOfGame = replaceDepth;
    }

    /**
     * This is a getters for user column
     * @param NONE
     * @return userCol
     */
    public int getUserColumn(){
        return userCol;
    }

    /**
     * This is a setters for user column
     * @param replaceUserCol
     * @return NONE
     */
    public void setUserColumn(int replaceUserCol){
        userCol = replaceUserCol;
    }

    //Array for the board
    private char[][] gameBoard =  
            {{'0','|','0','|','0','|','0','|','0','|','0','|','0','\n'},
             {'-','+','-','+','-','+','-','+','-','+','-','+','-','\n'},
             {'0','|','0','|','0','|','0','|','0','|','0','|','0','\n'},
             {'-','+','-','+','-','+','-','+','-','+','-','+','-','\n'},
             {'0','|','0','|','0','|','0','|','0','|','0','|','0','\n'},
             {'-','+','-','+','-','+','-','+','-','+','-','+','-','\n'},
             {'0','|','0','|','0','|','0','|','0','|','0','|','0','\n'},
             {'-','+','-','+','-','+','-','+','-','+','-','+','-','\n'},
             {'0','|','0','|','0','|','0','|','0','|','0','|','0','\n'},
             {'-','+','-','+','-','+','-','+','-','+','-','+','-','\n'},
             {'0','|','0','|','0','|','0','|','0','|','0','|','0','\n'}};
   
    //Method to change array to string
    private String changeToString(){
        String strToRet = "";
        //Itterate through the array
        for (int i = 0; i <= 10; i++){
            for (int j = 0; j <= 13; j++){
                strToRet += gameBoard[i][j];
            }
        }
        return strToRet;
    }

    /**
     * Return the string representation of the array
     * @param NONE
     * @return changeToString()
     */
    public String toString(){
        return changeToString();
    }

    /**
     * Check for win condition in vertical and horizontal
     * @param gameProgress
     * @return true or false
     */
    public boolean checkVerHor(int gameProgress){
        char win = '.';
        //Check horizontal
        boolean exit1 = true;
        for(int i = 0; i <= 5; i++){
            for(int a = 0; a <= 3; a++){
                if(gameBoard[verIndex.get(i)][horIndex.get(a)] == gameBoard[verIndex.get(i)][horIndex.get(a+1)] 
                && gameBoard[verIndex.get(i)][horIndex.get(a+1)] == gameBoard[verIndex.get(i)][horIndex.get(a+2)]
                && gameBoard[verIndex.get(i)][horIndex.get(a+2)] == gameBoard[verIndex.get(i)][horIndex.get(a+3)]){
                    if(gameBoard[verIndex.get(i)][horIndex.get(a)] != '0'){
                        win = gameBoard[verIndex.get(i)][horIndex.get(a)];
                        exit1 = false;
                        break;
                    }
                }
            }
            if(!exit1){
                break;
            }
        }
        //Check for vertical
        if (win == '.'){
            boolean exit2 = true;
            for(int i = 0; i <= 6; i++){
                for(int j = 0; j <= 2; j++){
                    if(gameBoard[verIndex.get(j)][horIndex.get(i)] == gameBoard[verIndex.get(j+1)][horIndex.get(i)] 
                    && gameBoard[verIndex.get(j+1)][horIndex.get(i)] == gameBoard[verIndex.get(j+2)][horIndex.get(i)]
                    && gameBoard[verIndex.get(j+2)][horIndex.get(i)] == gameBoard[verIndex.get(j+3)][horIndex.get(i)]){
                        if(gameBoard[verIndex.get(j)][horIndex.get(i)] != '0'){
                            win = gameBoard[verIndex.get(j)][horIndex.get(i)];
                            exit2 = false;
                            break;
                        }
                    }
                }
                if(!exit2){
                    break;
                }
            }
        }
        if(gameProgress == 42 && win == '.'){
            return false;
        } else if(win != '.'){
            return false;
        }
        return true;
    }

    /**
     * Method for checking board
     * @param userPos
     * @return true or false
     */
    public boolean checkingBoard(int userPos){
        if(gameBoard[0][horIndex.get(userPos)] == 'A'
        || gameBoard[0][horIndex.get(userPos)] == 'B'){
            return true;
        }
        return false;
    }

    /**
     * Check for win condition in diagonal position
     * @param gameProgress
     * @return true or false
     */
    public boolean checkDiagonal(int gameProgress){
        char win = '.';
        //Check for diagonal (right top)
        if(win == '.'){
            boolean exit3 = true;
            for (int i = 0; i <= 2; i++){
                for(int j = 0; j <= 3; j++){
                   if(gameBoard[verIndex.get(i+3)][horIndex.get(j)] == gameBoard[verIndex.get(i+2)][horIndex.get(j+1)]
                   && gameBoard[verIndex.get(i+2)][horIndex.get(j+1)] == gameBoard[verIndex.get(i+1)][horIndex.get(j+2)]
                   && gameBoard[verIndex.get(i+1)][horIndex.get(j+2)] == gameBoard[verIndex.get(i)][horIndex.get(j+3)]){
                        if(gameBoard[verIndex.get(i+3)][horIndex.get(j)] != '0'){
                            win = gameBoard[verIndex.get(i+3)][horIndex.get(j)];
                            exit3 = false;
                            break;
                        }
                    }
                }
                if(!exit3){
                    break;
                }
            }
        }
        //Check for diagonal (left top)
        if (win == '.'){
            boolean exit4 = true;
            for(int i = 0; i <= 2; i++){
                for(int j = 0; j <= 3; j++){
                   if(gameBoard[verIndex.get(i+3)][horIndex.get(j+3)] == gameBoard[verIndex.get(i+2)][horIndex.get(j+2)]
                   && gameBoard[verIndex.get(i+2)][horIndex.get(j+2)] == gameBoard[verIndex.get(i+1)][horIndex.get(j+1)]
                   && gameBoard[verIndex.get(i+1)][horIndex.get(j+1)] == gameBoard[verIndex.get(i)][horIndex.get(j)]){
                        if(gameBoard[verIndex.get(i+3)][horIndex.get(j+3)] != '0'){
                            win = gameBoard[verIndex.get(i+3)][horIndex.get(j+3)];
                            exit4 = false;
                            break;
                        }
                    }
                }
                if(!exit4){
                    break;
                }
            }
        }
        if(gameProgress == 42 && win == '.'){
            return false;
        } else if(win != '.'){
            return false;
        }
        return true;
    }

    /**
     * Checking the board from file
     * @param NONE
     * @return NONE
     */
    public void checkBoardFromFile(){
        for(int i = 5; i >= 0; i--){
            for(int k = 0; k <= 6; k++){
                if (gameBoard[verIndex.get(i)][horIndex.get(k)] == 'A'
                || gameBoard[verIndex.get(i)][horIndex.get(k)] == 'B'){
                    curVerIdx.set(k, curVerIdx.get(k) - 1);
                }
            }
        }
    }

    /**
     * Changing the board
     * @param currCol & currPlayer
     * @return NONE
     */
    public void changingTheBoard(int currCol, char currPlayer){
        gameBoard[verIndex.get(curVerIdx.get(currCol))][horIndex.get(currCol)] = currPlayer;
        curVerIdx.set(currCol, curVerIdx.get(currCol) - 1);
    }

    /**
     * Saving the values in a file
     * @param fName
     * @return true or false
     */
    public boolean saveToFile(String fName){
        try{
            BufferedWriter writeFile = new BufferedWriter(new FileWriter("./assets/" + fName)); 
            for(int k = 0; k <= 5; k++){
                for(int j = 0; j <= 6; j++){
                    if(gameBoard[verIndex.get(k)][horIndex.get(j)] == 'A'){
                        writeFile.write("1");
                    } else if(gameBoard[verIndex.get(k)][horIndex.get(j)] == 'B'){
                        writeFile.write("2");
                    } else{
                        writeFile.write("0");
                    }
                    if (j < 6){
                        writeFile.write(",");
                    }
                }
                if(k < 5){
                    writeFile.write("\n");
                }
            }
            writeFile.close();
            return false;
        } catch (IOException e){
            errMes.exception();
            return true;
        }
    }

    /**
     * Load the values from a file
     * @param fname
     * @return true or false
     */
    public boolean loadFromFile(String fName){
        String store = "";
        try{
            BufferedReader readFile = new BufferedReader(new FileReader("./assets/" + fName));
            try{
                int idx = 0;
                while((store = readFile.readLine()) != null){
                    String[] fromRead = store.split(",");

                    for(int k = 0; k <= 6; k++){
                        char currChar = fromRead[k].charAt(0);
                        if(currChar == '1'){
                            gameBoard[verIndex.get(idx)][horIndex.get(k)] = 'A';
                            depthOfGame++;
                        } else if(currChar == '2'){
                            gameBoard[verIndex.get(idx)][horIndex.get(k)] = 'B';
                            depthOfGame++;
                        } else {
                            gameBoard[verIndex.get(idx)][horIndex.get(k)] = '0';
                        }
                    }  
                    idx = idx + 1;     
                }
                readFile.close();
                return false;
            } catch (StringIndexOutOfBoundsException e){
                errMes.outOfBounds();
                return true;
            }
        } catch (FileNotFoundException e){
            errMes.fileNotFound();
            return true;
        } catch (IOException e){
            errMes.exception();
            return true;
        }
    }

}


