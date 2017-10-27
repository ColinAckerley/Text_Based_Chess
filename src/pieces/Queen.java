package pieces;
import chess.Board;
public class Queen extends Piece
{
	String color;
	public Queen(String color)
	{
		this.color = color;
	}
	boolean checkMoveValidity(Board board, int curRow, int curCol, int newRow, int newCol)
	{
		Piece[][] b = board.getBoard();
		if(
			new Rook(color).checkMoveValidity(board, curRow, curCol, newRow, newCol)
					|| new Bishop(color).checkMoveValidity(board, curRow, curCol, newRow, newCol)
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
