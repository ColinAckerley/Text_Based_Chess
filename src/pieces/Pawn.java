/*
   * @author Colin Ackerley and Steven Benmoha
 */
package pieces;
import chess.Board;
public class Pawn extends Piece
{
    private String color;
    private boolean hasMoved;
    /*
       *@param String color 	the color of the Pawn
       *@return
       * Pawn constructor
    */
    public Pawn(String color)
    {
        this.color = color;
        this.hasMoved = false;
    }
    /*
     *@param board, b, curRow, curCol, newRow, newCol    the Board object 'board', the 2d Piece array b,
     * the current row and column of the Piece, and the new row and column for it
     *@return true if it is a valid move for Pawn, false if not
     * Checks the validity of the Pawn's requested move
  */
    public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        if(b[newRow][newCol] != null)
            if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
                return false;
        int rowDiff = Math.abs(newRow-curRow);
        int colDiff = Math.abs(newCol-curCol);
        if(color.equalsIgnoreCase("black"))
        {
            if(newRow <= curRow || colDiff > 1)
            { // pawn can't go backwards, or move over more than one space
                // column-wise
                return false;
            }
        }
        if(color.equalsIgnoreCase("white"))
        {
            if(newRow >= curRow || colDiff > 1)
            { // pawn can't go backwards, or move over more than one space
                // column-wise
                return false;
            }
        }
        if(hasMoved && rowDiff > 1)
        {
            return false;
        }
        if(!hasMoved && rowDiff > 2)
        {
            return false;
        }
        if(colDiff == 1)
        {
            return checkPawnDiag(board, b, curRow, curCol, newRow, newCol);
        }
        if(b[newRow][newCol] != null)
        {
            return false;
        }
        this.hasMoved = true;
        return true;
    }
    /*
     *@param board, b, curRow, curCol, newRow, newCol  -- the Board object 'board', the 2d Piece array b,
     * the current row and column of the Piece, and the new row and column for it
     *@return true if it is a valid diagonal move for Pawn, false if not
     * Checks the diagonal of the Pawn to see if it is a valid diagonal move
  */
    private boolean checkPawnDiag(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        return (b[newRow][newCol] != null || enpassantCheck(board, b, curRow, curCol, newRow, newCol));
    }
    /*
     *@param board, b, curRow, curCol, newRow, newCol  -- the Board object 'board', the 2d Piece array b,
     * the current row and column of the Piece, and the new row and column for it
     *@return true if it is an enpassant move
     * Checks to see this is an enpassant move and returns true if so, false if not
  */
    private boolean enpassantCheck(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        if(b[curRow][curCol].toString().equals("bP") && curRow == 4)
        { // Checks if BLACK piece is in the correct row
            // for Enpassant
            if(curCol == 0 && b[curRow][curCol+1] != null)
            { // If black piece is on left edge of the board &
                // opponent's pawn
                // is adjacent to the right
                if((newRow == curRow+1 && newCol == curCol+1) && lastMoveWasDoubleMove(board, b, curRow, curCol+1) && b[curRow][curCol+1].toString().equals("wP"))
                { // if destination is directly below adjacent
                    // pawn
                    // and the last move was that pawn's double
                    // move
                    return true;
                }
            }
            if(curCol == 7 && b[curRow][curCol-1] != null)
            { // edge case on right-most column of board
                if((newRow == curRow+1 && newCol == curCol-1) && lastMoveWasDoubleMove(board, b, curRow, curCol-1) && b[curRow][curCol-1].toString().equals("wP"))
                {
                    return true;
                }
            }
            if(curCol != 0 && curCol != 7 && b[curRow][curCol-1] != null)
            { // non-edge columns with pawn to the left
                if((newRow == curRow+1 && newCol == curCol-1) && lastMoveWasDoubleMove(board, b, curRow, curCol-1) && b[curRow][curCol-1].toString().equals("wP"))
                {
                    return true;
                }
                
            }
            
            if(curCol != 0 && curCol != 7 && b[curRow][curCol+1] != null)
            { // non-edge columns with pawn to the
                // right
                if((newRow == curRow+1 && newCol == curCol+1) && lastMoveWasDoubleMove(board, b, curRow, curCol+1) && b[curRow][curCol+1].toString().equals("wP"))
                {
                    return true;
                }
            }
            
        }
        if(b[curRow][curCol].toString().equals("wP") && curRow == 3)
        {
            if(curCol == 0 && b[curRow][curCol+1] != null)
            {
                if((newRow == curRow-1 && newCol == curCol+1) && lastMoveWasDoubleMove(board, b, curRow, curCol+1) && b[curRow][curCol+1].toString().equals("bP"))
                {
                    return true;
                }
            }
            if(curCol == 7 && b[curRow][curCol-1] != null)
            {
                if((newRow == curRow-1 && newCol == curCol-1) && lastMoveWasDoubleMove(board, b, curRow, curCol-1) && b[curRow][curCol-1].toString().equals("bP"))
                {
                    return true;
                }
            }
            if(curCol != 0 && curCol != 7 && b[curRow][curCol-1] != null)
            {
                if((newRow == curRow-1 && newCol == curCol-1) && lastMoveWasDoubleMove(board, b, curRow, curCol-1) && b[curRow][curCol-1].toString().equals("bP"))
                {
                    return true;
                }
            }
            if(curCol != 0 && curCol != 7 && b[curRow][curCol+1] != null)
            {
                if((newRow == curRow-1 && newCol == curCol+1) && lastMoveWasDoubleMove(board, b, curRow, curCol+1) && b[curRow][curCol+1].toString().equals("bP"))
                {
                    return true;
                }
            }
        }
        return false;
    }
    /*
     *@param board, b, curRow, curCol -- the Board object 'board', the 2d Piece array b, the current row and column of the Piece
     *@return true if the previous move was the opponent's pawn's double move
     * Checks the last move of the board to see if it was the opponent's pawn's first move as well as a double move
  */
    private boolean lastMoveWasDoubleMove(Board board, Piece[][] b, int curRow, int curCol)
    {
        return ((board.startingRow == 1) || (board.startingRow == 6)) && board.lastMove.equalsIgnoreCase(curRow+","+curCol);
    }
    /*
     *@param 
     *@return the color of the piece
     * Returns the String containing the Pawn's color
  */
    public String getColor()
    {
        return this.color;
    }
    /*
     *@param 
     *@return the string representation of the Pawn piece
     * Returns the String that represents the Pawn piece
  */
    public String toString()
    {
        return color.charAt(0)+"P";
    }
}
