package chess;
public class Pawn extends Piece
{
	String color;
	boolean hasMoved;
	Board board;
	public Pawn(String color)
	{
		this.color = color;
		this.hasMoved = false;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(newRow - curRow);
		int colDiff = Math.abs(newCol - curCol);
		if(color == "Black")
		{
			if(newRow <= curRow || colDiff > 1)
			{ // pawn can't go backwards, or move over more than one space
				// column-wise
				return false;
			}
			if(hasMoved == true && rowDiff > 1)
			{ // pawn can't move up more than one space if it has already moved
				return false;
			}
			if(hasMoved == false && rowDiff > 2)
			{ // pawn can't move up more than two spaces, if first move
				return false;
			}
		}
		if(color == "White")
		{
			if(newRow >= curRow || colDiff > 1)
			{ // pawn can't go backwards, or move over more than one space
				// column-wise
				return false;
			}
			if(hasMoved == true && rowDiff > 1)
			{
				return false;
			}
			if(hasMoved == false && rowDiff > 2)
			{
				return false;
			}
		}
		return false;
	}
	Queen promote(String location, Pawn p)
	{
		Queen q = new Queen(color);
		// Cannot cast Pawn to Queen. Will need to create new Queen and give the
		// last known location of pawn
		// Queen will either be in board[0][j] or board[7][j]
		// MAIN CHALLENGE: Removing pawn from board and giving Queen pawn's last
		// location
		return null;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "P";
	}
}
