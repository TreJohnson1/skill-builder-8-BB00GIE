
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GamePieceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GamePieceTest
{
    private GamePiece Player1;
    /**
     * Default constructor for test class GamePieceTest
     */
    public GamePieceTest()
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
        Player1 = new GamePiece('x');
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
    public void getPieceTest()
    {
        assertEquals(Player1.getPiece(),'x');
    }

    @Test
    public void setPieceTest()
    {
        Player1.setPiece('x');
        assertEquals(Player1.getPiece(),'x');
    }
    
    @Test
    public void ConstructorTest()
    {
        assertTrue(Player1.toString().equals("x"));
        Player1 = new GamePiece('@');
        assertTrue(Player1.toString().equals("@"));
    }
    
    @Test
    public void toStringTest()
    {
        assertEquals(Player1.toString(),"x");
        Player1.setPiece('O');
        assertEquals(Player1.toString(),"O");
    }
}
