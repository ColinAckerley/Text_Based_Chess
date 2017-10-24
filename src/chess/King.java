package chess;
public class King extends Piece
{
	String color;
	public King(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(int curRow, int curCol, int newRow, int newCol)
	{
		return false;
	}
	String move(String origin, String dest)
	{
		return "";
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "K";
	}
}
