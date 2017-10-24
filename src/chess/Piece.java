package chess;
public abstract class Piece
{
	String color;
	abstract boolean checkMoveValidity(int curRow, int curCol, int newRow, int newCol);
}
