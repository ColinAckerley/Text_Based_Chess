package chess;
public class Queen extends Piece
{
	String color;
	public Queen(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(String origin, String dest)
	{
		char 
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
		return color.charAt(0) + "Q";
	}
}
