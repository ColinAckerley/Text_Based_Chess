package pieces;
import chess.Board;
public class King extends Piece
{
	String color;
	boolean hasMoved;
	boolean hasCastled;
	public King(String color)
	{
		this.hasMoved = false;
		this.hasCastled = false;
		this.color = color;
	}
	public boolean checkMoveValidity(Board board, int curRow, int curCol, int newRow, int newCol)
	{
		Piece[][] b = board.getBoard();
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(colDiff > 1 || rowDiff > 1)
			return false;
		return true;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "K";
	}
	boolean castleCheckValid(Board board, int curRow, int curCol, int newRow, int newCol)
	{
		Piece[][] b = board.getBoard();
		if(
			b[curRow][curCol].toString().equals("bK") && b[newRow][newCol].toString().equals("bR")
					&& hasMoved == false && b[newRow][newCol].hasMoved == false
					&& (!board.inCheck("black", null) && castlePathFree(board, curCol, newCol, "black")
		))
		{
			return true;
		}
		if(
			b[curRow][curCol].toString().equals("wK") && b[newRow][newCol].toString().equals("wR")
					&& b[curRow][curCol].hasMoved == false && hasMoved == false
					&& (!board.inCheck("white", null) && castlePathFree(board, curCol, newCol, "white")
		))
		{
			return true;
		}
		return false;
	}
	boolean castlePathFree(Board board, int curCol, int newCol, String color)
	{
		Piece[][] b = board.getBoard();
		if(color.equals("black"))
		{
			if(curCol > newCol)
			{
				for(int col = 1; col < 4; col++)
				{
					if(!b[0][col].toString().equals(null))
					{
						return false;
					}
				}
			}
			for(int col = 5; col < 8; col++)
			{
				if(!b[0][col].toString().equals(null))
				{
					return false;
				}
			}
		}
		if(color.equals("white"))
		{
			if(curCol > newCol)
			{
				for(int col = 1; col < 4; col++)
				{
					if(!b[7][col].toString().equals(null))
					{
						return false;
					}
				}
			}
			for(int col = 5; col < 7; col++)
			{
				if(!b[7][col].toString().equals(null))
				{
					return false;
				}
			}
		}
		return true;
	}
}
