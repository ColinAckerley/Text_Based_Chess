package pieces;

import chess.Board;

public class Rook extends Piece
{
	String color;
	public Rook(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
<<<<<<< HEAD:src/chess/Rook.java
		
=======
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(rowDiff != 0 && colDiff == 0)
			return true;
		if(colDiff != 0 && rowDiff == 0)
			return true;
>>>>>>> 07cb5b33b3ed9fd119767a814f7b28eeb6339ad6:src/pieces/Rook.java
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "R";
	}
}
