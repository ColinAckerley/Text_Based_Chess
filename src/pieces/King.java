/**
 * @author Colin Ackerley
 * @author SSteven Benmoha
 */
package pieces;
import chess.Board;
public class King extends Piece
{
    private String color;
    private boolean hasMoved;
    /**
     *@param String color 	the color of the King
     *@return
     * King constructor
     */
    public King(String color)
    {
        this.hasMoved = false;
        this.color = color;
    }
    /**
     *@param board, b, curRow, curCol, newRow, newCol    the Board object 'board', the 2d Piece array b, the current row and column of the Piece, and the new row and column for it
     *@return true if it is a valid move for King, false if not
     * Checks the validity of the King's requested move
     */
    public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        int rowDiff = Math.abs(curRow-newRow);
        int colDiff = Math.abs(curCol-newCol);
        if(newRow < 0 || newCol < 0 || newRow > 7 || newCol > 7)
            return false;
        if(castleCheckValid(board, b, curRow, curCol, newRow, newCol))
        {
            hasMoved = true;
            return true;
        }
        if(colDiff > 1 || rowDiff > 1)
            return false;
        if(b[newRow][newCol] != null)
            if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
                return false;
        hasMoved = true;
        return true;
    }
    /**
     *@param
     *@return the color of the piece
     * Returns the String containing the King's color
     */
    public String getColor()
    {
        return this.color;
    }
    /**
     *@param
     *@return the string representation of the King piece
     * Returns the String that represents the King piece
     */
    public String toString()
    {
        return color.charAt(0)+"K";
    }
    /**
     *@param board, b, curRow, curCol, newRow, newCol    the Board object 'board', the 2d Piece array b, the current row and column of the Piece, and the new row and column for it
     *@return true if it is a valid castling move, false if not
     * Checks if the requested move is a valid castling move and returns true or false
     */
    private boolean castleCheckValid(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        if(b[newRow][newCol] != null)
        {
            if(b[curRow][curCol].toString().equalsIgnoreCase("bK") && b[newRow][newCol].toString().equalsIgnoreCase("bR") && !hasMoved && !b[newRow][newCol].hasMoved && (!board.inCheck("black", null) && castlePathFree(board, b, curCol, newCol, "black")))
                return true;
            if(b[curRow][curCol].toString().equalsIgnoreCase("wK") && b[newRow][newCol].toString().equalsIgnoreCase("wR") && (!b[newRow][newCol].hasMoved) && (!hasMoved) && (!board.inCheck("white", null) && castlePathFree(board, b, curCol, newCol, "white")))
                return true;
        }
        return false;
    }
    /**
     *@param board, b, curCol, newCol    the Board object 'board', the 2d Piece array b, the current column of the Piece, and the new column for it
     *@return true if there is an empty path between King and Rook, false if not
     * Checks if there are only open spaces between the King and the Rook, one of the conditions for a successful castling move
     */
    private boolean castlePathFree(Board board, Piece[][] b, int curCol, int newCol, String color)
    {
        if(color.equalsIgnoreCase("black"))
        {
            if(curCol > newCol)
            {
                for(int col = 1; col < 4; col++)
                {
                    if(b[0][col] != null)
                    {
                        return false;
                    }
                }
            }
            if(curCol < newCol)
            {
                for(int col = 5; col < 7; col++)
                {
                    if(b[0][col] != null)
                    {
                        return false;
                    }
                }
            }
        }
        if(color.equalsIgnoreCase("white"))
        {
            if(curCol > newCol)
            {
                for(int col = 1; col < 4; col++)
                {
                    if(b[7][col] != null)
                    {
                        return false;
                    }
                }
            }
            if(curCol < newCol)
            {
                for(int col = 5; col < 7; col++)
                {
                    if(b[7][col] != null)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}