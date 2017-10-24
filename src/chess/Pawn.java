package chess;
public class Pawn extends Piece
{
	String color;
	boolean firstMove = false;
	public Pawn(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(String origin, String dest){
		
		// only allowable moves are 
	
		// a) up one row (if array space == '    ' or '##')
		// b) up two rows (if firstMove = true && array space == '    ' or '##')
		// c) forwards diagonal either L or R (if the array space != '     ' or '##' )
		// Reverse this logic for Black Pieces
		
		
		//Problems I am running into/Questions I have:
		
		// 1) How do we check board[][] spaces in the Pawn class without the actual board state provided?
		// 2) I need a way to turn the Strings 'origin' and 'dest' into concrete array locations with specific [i][j] locations
		// 3) When receiving 'origin' string I need to know what color the piece is in order to properly verify move validity
		
		
		// MAIN CHALLENGE FOR ALL PIECES: Turning ORIGIN and DEST to concrete array locations
		//                           	  and checking the ACTUAL board state (array entries) 
		//							 	  for their values
		
	
				
		return false;
	}
	String move(String origin, String dest)
	{
		// if checkMoveValidity is true, remove whatever is at 'dest':
		// 1) if empty space or hashtag, simply replace array space with pawn piece
		// 2) if another piece, remove from game, and then replace array space with pawn piece 
		
		return "";
	}
	Queen promote(String location, Pawn p)
	{
		Queen q = new Queen(color);
		
		// Cannot cast Pawn to Queen. Will need to create new Queen and give the last known location of pawn
		// Queen will either be in board[0][j] or board[7][j]
		
		// MAIN CHALLENGE: Removing pawn from board and giving Queen pawn's last location
		
		return null;
	}
	public String toString()
	{
		if(color.equals("w"))
			return "wp";
		return "bp";
	}
}
