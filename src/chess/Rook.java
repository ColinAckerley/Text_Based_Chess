package chess;
public class Rook extends Piece
{
	String color;
	public Rook(String color)
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
			return "wR";
		return "bR";
	}
}
