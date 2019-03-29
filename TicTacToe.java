import java.util.Scanner;
/**
 * This class implements the game we all love to
 * not play.
 *
 * @author (M Rasamny)
 * @version (03/13/2018)
 */
public class TicTacToe
{
    // instance variables 
    private GamePiece[][] board;
    private GamePiece[] player;
    private int nextPlayerIndex;
    private int numOfMoves;

    public TicTacToe()
    {
        this(new GamePiece('X'), new GamePiece('O'));
    }

    public TicTacToe(GamePiece p1, GamePiece p2)
    {
        nextPlayerIndex = 0;
        numOfMoves = 0;

        player = new GamePiece[2];
        player[0] = new GamePiece(p1);
        player[1] = new GamePiece(p2);

        board = new GamePiece[3][3];
        clear();
    }

    public boolean isValid(int location)
    {
        return location >= 0 && location < board.length*board.length;
    }

    public boolean isEmpty(int location)
    {
        int row = location / board.length;
        int col = location % board[row].length;
        return board[row][col] == null;
    }

    public int movesRemaining()
    {
        return board.length*board.length-numOfMoves;
    }

    public GamePiece getPiece(int location)
    {
        int row = location / board.length;
        int col = location % board[row].length;
        if (board[row][col] == null){
            return null;
        }
        return new GamePiece(board[row][col]);
    }
    
    private int[] getCoord(int location)
    {
        int[] coord = new int[2];
        coord[0]= location / board.length;
        coord[1] = location % board.length;
        return coord;
    }
    
    public GamePiece getWinner()
    {
        int[][] winningPattern={{0,1,2},{1,4,7},{2,5,8},
                        {0,3,6},{3,4,5},{6,7,8},
                        {0,4,8},{2,4,6}
                       };
        GamePiece winningPiece=null;      
        for(int i=0; i < winningPattern.length && winningPiece == null; i++){
            int[] pattern = winningPattern[i];
            if (getPiece(pattern[0]) == getPiece(pattern[1]) &&
                getPiece(pattern[1]) == getPiece(pattern[2])){
                  winningPiece = getPiece(pattern[0]);  
            }
        }
        return winningPiece;
    }

    public boolean add(int location)
    {
        int[] coord = getCoord(location);
        int row = coord[0];
        int col = coord[1];
        if (isValid(location) && isEmpty(location)){
            board[row][col] = player[nextPlayerIndex];
            nextPlayerIndex = nextPlayerIndex > 0?0:1;
            numOfMoves++;
            return true;
        }
        return false;
    }

    public void clear()
    {
        for(int row=0; row < board.length; row++){
            for(int col=0; col < board[row].length; col++){
                board[row][col] = null;
            }
        }
    }

    public String toString()
    {
        String s = "";
        for(int row = 0; row < board.length; row++){
            for(int col=0; col < board[row].length; col++){
                s += "--";
            }
            s += "-\n";
            for(int col=0; col < board[row].length; col++){
                int location = row*board.length+col;
                s += "|" + (board[row][col]==null?location:getPiece(location));
            }
            s += "|\n";
        }
        for(int col=0; col < board.length; col++){
            s += "--";
        }
        s += "-\n";
        return s;
    }

    public static void main(String[] argv)
    {
        Scanner input = new Scanner(System.in);
        TicTacToe ttt = new TicTacToe(new GamePiece('X'),new GamePiece('O'));
        int location;

        // add code here
        ttt.add(4);
        System.out.println(ttt);
        System.out.println(ttt.getWinner()==null?"No Winner!":ttt.getWinner());
        ttt.add(0);
        System.out.println(ttt);
        System.out.println(ttt.getWinner()==null?"No Winner!":ttt.getWinner());
        ttt.add(2);
        System.out.println(ttt);
        System.out.println(ttt.getWinner()==null?"No Winner!":ttt.getWinner());        
        ttt.add(3);
        System.out.println(ttt);
        System.out.println(ttt.getWinner()==null?"No Winner!":ttt.getWinner());
        ttt.add(6);
        System.out.println(ttt);
        System.out.println(ttt.getWinner()==null?"No Winner!":ttt.getWinner());
        
        //System.out.println(ttt);
    }
}
