package chess;
public class King extends Piece
{
	String color;
	public King(String color)
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
	public String getName()
	{
		if(color.equals("w"))
			return "wK";
		return "bK";
	}
}