/*
    *@author Colin Ackerley and Steven Benmoha
 */
package pieces;
import chess.Board;
public class Knight extends Piece
{
    private String color;
    /*
        *@param String color representing which color the given Knight should be
        *@return
     */
    public Knight(String color)
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
        if(b[newRow][newCol] != null)
            if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
                return false;
        int rowDiff = Math.abs(curRow-newRow);
        int colDiff = Math.abs(curCol-newCol);
        return rowDiff == 2 && colDiff == 1 || rowDiff == 1 && colDiff == 2;
    }
    /*
       *@param
        *@return String with the color of the current Knight
     */
    public String getColor()
    {
        return this.color;
    }
    /*
        *@param
        *@return The string representation of the current Knight
     */
    public String toString()
    {
        return color.charAt(0)+"N";
    }
}
