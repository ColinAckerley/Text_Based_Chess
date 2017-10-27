package pieces;
import chess.Board;
public class Knight extends Piece
{
	String color;
	public Knight(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board board, int curRow, int curCol, int newRow, int newCol)
	{
		Piece[][] b = board.getBoard();
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
