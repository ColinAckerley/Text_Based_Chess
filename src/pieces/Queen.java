package pieces;
import chess.Board;
public class Queen extends Piece
{
	String color;
	public Queen(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Piece[][] b, int curRow, int curCol, int newRow, int newCol)
	{
		if(
			new Rook(color).checkMoveValidity(b, curRow, curCol, newRow, newCol)
					|| new Bishop(color).checkMoveValidity(b, curRow, curCol, newRow, newCol)
		)
			return true;
		return false;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "Q";
	}
}
