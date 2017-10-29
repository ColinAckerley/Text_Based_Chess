package pieces;
import chess.Board;
public class Knight extends Piece
{
	String color;
	public Knight(String color)
	{
		this.color = color;
	}
	public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
	{
		if(b[newRow][newCol] != null)
			if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
				return false;
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(rowDiff == 2 && colDiff == 1)
			return true;
		if(rowDiff == 1 && colDiff == 2)
			return true;
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "N";
	}
}
