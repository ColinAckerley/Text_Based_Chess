package pieces;
import chess.Board;
public class Rook extends Piece
{
	String color;
	boolean hasMoved;
	public Rook(String color)
	{
		this.color = color;
		this.hasMoved = false;
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
			int offset;
			if(curCol < newCol)
				offset = 1;
			else
				offset = -1;
			for(int i = curCol + offset; i != newCol; i += offset)
				if(b[curRow][i] != null)
					return false;
		}
		if(colDiff == 0)
		{
			int offset;
			if(curRow < newRow)
				offset = 1;
			else
				offset = -1;
			for(int i = curRow + offset; i != newRow; i += offset)
				if(b[i][curCol] != null)
					return false;
		}
		
		hasMoved = true;
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
