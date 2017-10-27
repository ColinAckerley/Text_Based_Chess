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
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		if(!b.pathFree(curRow, curCol, newRow, newCol))
			return false;
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
	
	public boolean getHasMoved(King k) {
		
		if (k.hasMoved == true) {
			
			return true;
		}
		return false;
	}	

	boolean castleCheckValid(Piece[][] board, int curRow, int curCol, int newRow, int newCol)
	{
		if(
			board[curRow][curCol].toString().equals("bK") && board[newRow][newCol].toString().equals("bR") && hasMoved == false
					&& board[newRow][newCol].hasMoved == false
					&& board.pathFree(curRow, curCol, newRow, newCol) == true &&
					inCheck() == false
		)
		{
			return true;
		}
		if(
			board[curRow][curCol].toString().equals("wK") && board[newRow][newCol].toString().equals("wR")
														  && board[curRow][curCol].hasMoved == false
														  && hasMoved == false
														  && board.pathFree(curRow, curCol, newRow, newCol) == true
														  && inCheck() == false
		)
		{
			return true;
		}
		return false;
		}
	}
}
	
