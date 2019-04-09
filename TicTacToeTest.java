

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TicTacToeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TicTacToeTest
{
  private TicTacToe Board;
    /**
     * Default constructor for test class TicTacToeTest
     */
    public TicTacToeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
      Board = new TicTacToe();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    @Test
    public void isEmpty()
    {
      assertTrue(Board.isEmpty(4));
      Board.add(4);
      assertTrue(!Board.isEmpty(4));
    }
    
    @Test
    public void isValid()
    {
        assertTrue(Board.isValid(0));
        assertTrue(Board.isValid(1));
        assertTrue(Board.isValid(2));
        assertTrue(Board.isValid(3));
        assertTrue(Board.isValid(4));
        assertTrue(Board.isValid(5));
        assertTrue(Board.isValid(6));
        assertTrue(Board.isValid(7));
        assertTrue(Board.isValid(8));
        assertTrue(!Board.isValid(9));
        assertTrue(!Board.isValid(10));
        assertTrue(!Board.isValid(11));
    }
    
    @Test
    public void movesRemaining()
    {
        
    }
}
