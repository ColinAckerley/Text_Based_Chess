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
		// Combines functionality of bishop + rook
		// possibly patch these two pieces' checkMoveValidity methods
		
		
		return false;
	}
	String move(String origin, String dest)
	{
		
		// if checkMoveValidity is true, remove whatever is at 'dest':
		// 1) if empty space or hashtag, simply replace array space with Queen piece
		// 2) if another piece, remove from game, and then replace array space with Queen piece
		
		
		return "";
	}
	public String toString()
	{
		if(color.equals("w"))
			return "wQ";
		return "bQ";
	}
	
	
	
	
}
