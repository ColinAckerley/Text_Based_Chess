/*
   *@author Colin Ackerley and Steven Benmoha
 */
package pieces;
import chess.Board;
public class Queen extends Piece
{
    String color;
    public Queen(String color)
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
        if(new Rook(color).checkMoveValidity(board, b, curRow, curCol, newRow, newCol) || new Bishop(color).checkMoveValidity(board, b, curRow, curCol, newRow, newCol))
            return true;
        return false;
    }
    /*
        *@param
        *@return String with the color of the current Queen
     */
    public String getColor()
    {
        return this.color;
    }
    /*
       *@param
      * @return The string representation of the current Queen
    */
    public String toString()
    {
        return color.charAt(0)+"Q";
    }
}
