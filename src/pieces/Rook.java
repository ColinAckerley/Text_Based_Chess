/*
    *@author Colin Ackerley and Steven Benmoha
 */
package pieces;
import chess.Board;
public class Rook extends Piece
{
    private String color;
    /*
        *@param String representing what color to make the Rook
        *@return
     */
    public Rook(String color)
    {
        this.color = color;
    }
    /*
     *@param Board board representing an instance of the board class, Piece[][]b representing the current chess board,
     *ints representing the cur row and column and the new row and column
     *@return true if the proposed move is valid, false otherwise
  */
    public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        int rowDiff = Math.abs(curRow-newRow);
        int colDiff = Math.abs(curCol-newCol);
        if(b[newRow][newCol] != null)
            if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
                return false;
        if(rowDiff != 0 && colDiff != 0)
            return false;
        if(rowDiff == 0)
        {
            int offset;
            if(curCol < newCol)
                offset = 1;
            else
                offset = -1;
            for(int i = curCol+offset; i != newCol; i += offset)
                if(b[curRow][i] != null)
                    return false;
        }
        if(colDiff == 0)
        {
            int offset;
            if(curRow < newRow)
                offset = 1;
            else
                offset = -1;
            for(int i = curRow+offset; i != newRow; i += offset)
                if(b[i][curCol] != null)
                    return false;
        }
        hasMoved = true;
        return true;
    }
    /*
       *@param
       *@return String with the color of the current Rook
    */
    public String getColor()
    {
        return this.color;
    }
    /*
       *@param
       *@return The string representation of the current Rook
    */
    public String toString()
    {
        return color.charAt(0)+"R";
    }
}
