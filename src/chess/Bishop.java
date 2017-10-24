package chess;
public class Bishop extends Piece
{
	String color;
	public Bishop(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "B";
	}
}
