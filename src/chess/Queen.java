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
		return false;
	}
	String move(String origin, String dest)
	{
		return "";
	}
}
