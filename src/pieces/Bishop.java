package pieces;

import chess.Board;

public class Bishop extends Piece
{
	String color;
	public Bishop(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(!b.pathFree(curRow, curCol, newRow, newCol))
			return false;
		if(rowDiff == colDiff)
			return true;
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "B";
	}
}
