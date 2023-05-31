package connectfour;

/**
 * @author Gariel Mahwastu
 * This class contains the main method where the game is run
 * and also for setting the player turn
 * 
 */
public class ConnectFour{

    private char playerTurn = 'A';

    //Method for changing the turn
    public char changingTurn(char currPlayer){
        if (currPlayer == 'A'){
            playerTurn = 'B';
        } else {
            playerTurn = 'A';
        }
        return playerTurn;
    }

    //Setters and getters for the turn
    public char getCurTurn(){
        return playerTurn;
    }

    public void setCurTurn(char newVal){
        playerTurn = newVal;
    }

    public String toString(){
        String conFour = "Connect four class";
        return conFour;
    }

    public static void main(String[] args){
        Board theBoard = new Board();
        TextUI txtUI = new TextUI();
        ConnectFour connFour = new ConnectFour();

        boolean repeat = true;
        txtUI.setUserAns('y');
        while(txtUI.getUserAns() == 'y' && repeat){ //Ask user for input to load from file
            txtUI.accessFile();
            if(txtUI.getUserAns() != 'y'){
                break;
            }
            txtUI.askFileName();
            repeat = theBoard.loadFromFile(txtUI.getFileName());
        }
        theBoard.checkBoardFromFile();  //Checking from file, printing board, and print turn
        txtUI.displayBoard(theBoard.toString());
        txtUI.printingTurn(connFour.getCurTurn());

        while(theBoard.checkVerHor(theBoard.getDepthOfGame()) && theBoard.checkDiagonal(theBoard.getDepthOfGame())){
            txtUI.userInput();
            if(txtUI.getUserInpt() == 7){
                theBoard.saveToFile(txtUI.askFileToSave());
                System.exit(0);
            }
            theBoard.setUserColumn(txtUI.getUserInpt());

            while(theBoard.checkingBoard(theBoard.getUserColumn())){ //While loop if column is full
                txtUI.fullColumn();
                if(txtUI.getUserInpt() == 7){
                    theBoard.saveToFile(txtUI.askFileToSave());
                    System.exit(0);
                }
                theBoard.setUserColumn(txtUI.getUserInpt());
            }
            theBoard.setDepthOfGame(theBoard.getDepthOfGame() + 1);
            theBoard.changingTheBoard(theBoard.getUserColumn(), connFour.getCurTurn());
            txtUI.displayBoard(theBoard.toString());
            connFour.setCurTurn(connFour.changingTurn(connFour.getCurTurn()));
            if(theBoard.getDepthOfGame() != 42){
                txtUI.printingTurn(connFour.getCurTurn());
            }
        }
        if (theBoard.getDepthOfGame() >= 42){
            txtUI.gameIsTie();
        } else{
            connFour.setCurTurn(connFour.changingTurn(connFour.getCurTurn()));
            txtUI.gameIsWon(connFour.getCurTurn());
        }
    }
}