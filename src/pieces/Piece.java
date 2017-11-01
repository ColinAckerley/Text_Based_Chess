/**
   * @author Colin Ackerley
   * @author Steven Benmoha
 */
package pieces;
import chess.Board;
public abstract class Piece
{
    boolean hasMoved;
    /**
        *@param board for the current state of the board class, b representing the current chessboard, and ints for the
        *current row and column, as well as the proposed row and column
        *@return true if the proposed move is valid, false otherwise
     */
    public abstract boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol);
    /**
        * @param
        *@return String representing the color of the current piece
     */
    public abstract String getColor();
}
