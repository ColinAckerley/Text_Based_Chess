package chess;
public class Rook extends Piece
{
	String color;
	public Rook(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(int curRow, int curCol, int newRow, int newCol)
	{
		// 'dest' must be in same row or same column as origin
		// if attempted to move diagonally arraywise, return false
		// else, check straight lines row or column wise to 'dest' and path
		// should be either empty space or hashtag, excluding 'dest' itself
		// if 'dest' is taken by a piece, return true
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "R";
	}
}
