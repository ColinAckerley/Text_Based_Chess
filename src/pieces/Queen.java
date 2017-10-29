package pieces;
import chess.Board;
public class Queen extends Piece
{
	String color;
	public Queen(String color)
	{
		this.color = color;
	}
	public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
	{
		if(
			new Rook(color).checkMoveValidity(board, b, curRow, curCol, newRow, newCol)
					|| new Bishop(color).checkMoveValidity(board, b, curRow, curCol, newRow, newCol)
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
