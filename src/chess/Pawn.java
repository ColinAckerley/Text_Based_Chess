package chess;
public class Pawn extends Piece
{
	String color;
	boolean firstMove = false;
	public Pawn(String color)
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
	Queen promote(Pawn p)
	{
		return null;
	}
	public String toString()
	{
		if(color.equals("w"))
			return "wp";
		return "bp";
	}
}
