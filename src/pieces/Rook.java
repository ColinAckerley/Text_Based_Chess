package pieces;
import chess.Board;
public class Rook extends Piece
{
	String color;
	public Rook(String color)
	{
		this.color = color;
	}
	public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(b[newRow][newCol] != null)
			if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
				return false;
		if(rowDiff != 0 && colDiff != 0)
			return false;
		if(rowDiff == 0)
		{
			for(int i = curCol + 1; i < newCol; i++)
			{
				if(b[curRow][i] != null)
					return false;
			}
		}
		if(colDiff == 0)
		{
			for(int i = curRow + 1; i < newRow; i++)
			{
				if(b[i][curCol] != null)
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
		return color.charAt(0) + "R";
	}
}
