package chess;
public class Rook extends Piece
{
	String color;
	public Rook(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(rowDiff != 0 && colDiff == 0)
			return true;
		if(colDiff != 0 && rowDiff == 0)
			return true;
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
