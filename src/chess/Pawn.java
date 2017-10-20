package chess;
public class Pawn extends Piece
{
	String color;
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
}
