package chess;
public class Knight extends Piece
{
	String color;
	public Knight(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(String origin, String dest)
	{
		return false;
	}
	String move(String origin, String dest)
	{
		return "";
	}
	public String toString()
	{
		if(color.equals("w"))
			return "wN";
		return "bN";
	}
}
