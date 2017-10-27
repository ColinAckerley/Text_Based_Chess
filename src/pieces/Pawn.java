package pieces;
import chess.Board;
public class Pawn extends Piece
{
	String color;
	boolean hasMoved;
	Board board;
	public Pawn(String color)
	{
		this.color = color;
		this.hasMoved = false;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		return true;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "P";
	}
}
