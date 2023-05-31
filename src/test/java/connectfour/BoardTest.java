package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* you will need to add test methods and likely change the
setup method as well.  The samples that are here are just so that
you can see how junit works.

Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    //2 tests for diagonal
    @Test
    public void testFirstDiagonalCondition(){
        tester.changingTheBoard(0,'A');
        tester.changingTheBoard(1,'B');
        tester.changingTheBoard(1,'A');
        tester.changingTheBoard(2,'B');
        tester.changingTheBoard(2,'B');
        tester.changingTheBoard(2,'A');
        tester.changingTheBoard(3,'B');
        tester.changingTheBoard(3,'B');
        tester.changingTheBoard(3,'B');
        tester.changingTheBoard(3,'A');
        Assert.assertEquals(tester.checkDiagonal(10), false);
    }

    @Test
    public void testSecondDiagonalCondition(){
        tester.changingTheBoard(3,'A');
        tester.changingTheBoard(3,'A');
        tester.changingTheBoard(3,'A');
        tester.changingTheBoard(3,'B');
        tester.changingTheBoard(4,'A');
        tester.changingTheBoard(4,'A');
        tester.changingTheBoard(4,'B');
        tester.changingTheBoard(5,'A');
        tester.changingTheBoard(5,'B');
        tester.changingTheBoard(6,'B');
        Assert.assertEquals(tester.checkDiagonal(10), false);
    }

    //2 tests for vertical and horizontal
    @Test
    public void testVerticalWinCondition(){
        tester.changingTheBoard(2,'A');
        tester.changingTheBoard(2,'A');
        tester.changingTheBoard(2,'A');
        tester.changingTheBoard(2,'A');
        Assert.assertEquals(tester.checkVerHor(4), false);
    }

    @Test
    public void testHorizontalWinCondition(){
        tester.changingTheBoard(3,'B');
        tester.changingTheBoard(4,'B');
        tester.changingTheBoard(5,'B');
        tester.changingTheBoard(6,'B');
        Assert.assertEquals(tester.checkVerHor(4), false);
    }
}