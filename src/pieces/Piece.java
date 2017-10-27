package pieces;
import chess.Board;
public abstract class Piece
{
	String color;
	boolean hasMoved;
	abstract boolean checkMoveValidity(Piece[][] board, int curRow, int curCol, int newRow, int newCol);
}
