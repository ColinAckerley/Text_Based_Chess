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
		
		// 'dest' must be in same row or same column as origin
		// if attempted to move diagonally arraywise, return false
		// else, check straight lines row or column wise to 'dest' and path should be either empty space or hashtag, excluding 'dest' itself 
		// if 'dest' is taken by a piece, return true
		
		
		return false;
	}
	String move(String origin, String dest)
	{
		
		// if checkMoveValidity is true, remove whatever is at 'dest':
		// 1) if empty space or hashtag, simply replace array space with Rook piece
		// 2) if another piece, remove from game, and then replace array space with Rook piece
		
		
		return "";
	}
	public String toString()
	{
		if(color.equals("w"))
			return "wR";
		return "bR";
	}
}
