;
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
    public void movesRemainingTest()
    {
        assertTrue(Board.movesRemaining() == 9);
        Board.add(0);
        assertTrue(Board.movesRemaining() == 8);
        Board.add(1);
        assertTrue(Board.movesRemaining() == 7);
        Board.add(2);
        assertTrue(Board.movesRemaining() == 6);
        Board.add(3);
        assertTrue(Board.movesRemaining() == 5);
        Board.add(4);
        assertTrue(Board.movesRemaining() == 4);
        Board.add(5);
        assertTrue(Board.movesRemaining() == 3);
        Board.add(6);
        assertTrue(Board.movesRemaining() == 2);
        Board.add(7);
        assertTrue(Board.movesRemaining() == 1);
        Board.add(8);
        assertTrue(Board.movesRemaining() == 0);
    }
    
    @Test
    public void toStringTest()
    {
        assertEquals("-------\n|0|1|2|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
    }
    
    @Test
    public void addTest()
    {
        Board.add(-1);
        assertEquals("-------\n|0|1|2|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(0);
        assertEquals("-------\n|X|1|2|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(1);
        assertEquals("-------\n|X|O|2|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(2);
        assertEquals("-------\n|X|O|X|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(3);
        assertEquals("-------\n|X|O|X|\n-------\n|O|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(4);
        assertEquals("-------\n|X|O|X|\n-------\n|O|X|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(5);
        assertEquals("-------\n|X|O|X|\n-------\n|O|X|O|\n-------\n|6|7|8|\n-------\n",Board.toString());
        Board.add(6);
        assertEquals("-------\n|X|O|X|\n-------\n|O|X|O|\n-------\n|X|7|8|\n-------\n",Board.toString());
        Board.add(7);
        assertEquals("-------\n|X|O|X|\n-------\n|O|X|O|\n-------\n|X|O|8|\n-------\n",Board.toString());
        Board.add(8);
        assertEquals("-------\n|X|O|X|\n-------\n|O|X|O|\n-------\n|X|O|X|\n-------\n",Board.toString());
    }
    
    @Test
    public void clearTest()
    {
        Board.add(0);
        Board.add(1);
        Board.add(2);
        Board.add(3);
        Board.add(4);
        Board.add(5);
        Board.add(6);
        Board.add(7);
        Board.add(8);
        Board.clear();
        assertEquals("-------\n|0|1|2|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------\n",Board.toString());
    }
    
    @Test
    public void getPiece()
    {
        assertNull(Board.getPiece(4));
        Board.add(0);
        assertEquals(Board.getPiece(0).getPiece(), 'X');
        Board.add(1);
        assertEquals(Board.getPiece(1).getPiece(), 'O');
        Board.add(2);
        assertEquals(Board.getPiece(2).getPiece(), 'X');
        Board.add(3);
        assertEquals(Board.getPiece(3).getPiece(), 'O');
        Board.add(4);
        assertEquals(Board.getPiece(4).getPiece(), 'X');
        Board.add(5);
        assertEquals(Board.getPiece(5).getPiece(), 'O');
        Board.add(6);
        assertEquals(Board.getPiece(6).getPiece(), 'X');
        Board.add(7);
        assertEquals(Board.getPiece(7).getPiece(), 'O');
        Board.add(8);
        assertEquals(Board.getPiece(8).getPiece(), 'X');
    }
    
    @Test
    public void getWinner()
    {
        Board.add(0);
        Board.add(3);
        Board.add(1);
        Board.add(4);
        Board.add(2);
        //System.out.println(Board);
        //System.out.println(Board.getWinner());
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
        Board.add(1);
        Board.add(3);
        Board.add(4);
        Board.add(5);
        Board.add(7);
        //System.out.println(Board);
        //System.out.println(Board.getWinner());
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
        Board.add(2);
        Board.add(3);
        Board.add(5);
        Board.add(4);
        Board.add(8);
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
        Board.add(0);
        Board.add(2);
        Board.add(3);
        Board.add(5);
        Board.add(6);
        assertEquals(Board.getWinner().getPiece(),'O');
        Board.clear();
        Board.add(3);
        Board.add(2);
        Board.add(4);
        Board.add(7);
        Board.add(5);
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
        Board.add(6);
        Board.add(3);
        Board.add(7);
        Board.add(5);
        Board.add(8);
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
        Board.add(0);
        Board.add(3);
        Board.add(4);
        Board.add(7);
        Board.add(8);
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
        Board.add(2);
        Board.add(3);
        Board.add(4);
        Board.add(7);
        Board.add(6);
        assertEquals(Board.getWinner().getPiece(),'X');
        Board.clear();
    }
}
