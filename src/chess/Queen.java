package chess;
public class Queen extends Piece
{
	String color;
	public Queen(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(int curRow, int curCol, int newRow, int newCol)
	{
		// Combines functionality of bishop + rook
		// possibly patch these two pieces' checkMoveValidity methods
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "Q";
	}
}
