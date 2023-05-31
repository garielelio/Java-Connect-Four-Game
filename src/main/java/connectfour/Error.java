package connectfour;

/**
 * @author Gariel Mahwastu
 * This class will print out error message for the board file
 * 
 */
public class Error{

    //Error message for file not found
    public void fileNotFound(){
        System.out.println("File not found");
    }

    //Error message for IOException
    public void exception(){
        System.out.println("File cannot be opened");
    }

    //Error message for index out of bound
    public void outOfBounds(){
        System.out.println("There is an error in the file. Try again.");
    }

    //ToString
    public String toString(){
        String err = "Error class";
        return err;
    }


}