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
	public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(colDiff > 1 || rowDiff > 1)
			return false;
		if(newRow < 0 || newCol < 0 || newRow > 7 || newCol > 7)
			return false;
		if(b[newRow][newCol] != null)
			if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
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
	boolean castleCheckValid(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
	{
		if(
			b[curRow][curCol].toString().equalsIgnoreCase("bK") && b[newRow][newCol].toString().equalsIgnoreCase("bR")
					&& hasMoved == false && b[newRow][newCol].hasMoved == false
					&& (!board.inCheck("black", null) && castlePathFree(board, b, curCol, newCol, "black"))
		)
		{
			return true;
		}
		if(
			b[curRow][curCol].toString().equalsIgnoreCase("wK") && b[newRow][newCol].toString().equalsIgnoreCase("wR")
					&& b[curRow][curCol].hasMoved == false && hasMoved == false
					&& (!board.inCheck("white", null) && castlePathFree(board, b, curCol, newCol, "white"))
		)
		{
			return true;
		}
		return false;
	}
	boolean castlePathFree(Board board, Piece[][] b, int curCol, int newCol, String color)
	{
		if(color.equalsIgnoreCase("black"))
		{
			if(curCol > newCol)
			{
				for(int col = 1; col < 4; col++)
				{
					if(!b[0][col].toString().equalsIgnoreCase(null))
					{
						return false;
					}
				}
			}
			for(int col = 5; col < 8; col++)
			{
				if(!b[0][col].toString().equalsIgnoreCase(null))
				{
					return false;
				}
			}
		}
		if(color.equalsIgnoreCase("white"))
		{
			if(curCol > newCol)
			{
				for(int col = 1; col < 4; col++)
				{
					if(!b[7][col].toString().equalsIgnoreCase(null))
					{
						return false;
					}
				}
			}
			for(int col = 5; col < 7; col++)
			{
				if(!b[7][col].toString().equalsIgnoreCase(null))
				{
					return false;
				}
			}
		}
		return true;
	}
}
