package pieces;
import chess.Board;
public class Bishop extends Piece
{
	String color;
	public Bishop(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board board, int curRow, int curCol, int newRow, int newCol)
	{
		Piece[][] b = board.getBoard();
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(rowDiff != colDiff)
			return false;
		int rowOffset, colOffset;
		if(newRow > curRow) // Determines if the piece is moving up or down the
							// rows
		{
			rowOffset = 1;
		}
		else
		{
			rowOffset = -1;
		}
		if(newCol > curCol) // Determines if the piece if moving left or right
							// in the columns
		{
			colOffset = 1;
		}
		else
		{
			colOffset = -1;
		}
		for(int row = curRow + rowOffset; row != newRow; row += rowOffset)
		{
			for(int col = curCol + colOffset; col != newCol; col += colOffset)
			{
				if(b[row][col] != null) // If space is occupied
				{
					return false;
				}
			}
		}
		return true;
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
