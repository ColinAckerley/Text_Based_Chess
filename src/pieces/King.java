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
	

	boolean castleCheckValid(int curRow, int curCol, int newRow, int newCol)
	{
		if(
			board[curRow][curCol] == "bK" && board[newRow][newCol] == "bR" && board[curRow][curCol].hasMoved == false
					&& board[newRow][newCol].getHasMoved() == false
					&& board.pathFree(curRow, curCol, newRow, newCol) == true
					&& board[curRow][curCol].inCheck() == false
		)
		{
			return true;
		}
		if(
			board[curRow][curCol] == "wK" && board[newRow][newCol] == "wR"
					&& board[curRow][curCol].getHasMoved() == false && board[newRow][newCol].getHasMoved() == false
					&& board.pathFree(curRow, curCol, newRow, newCol) == true
					&& board[curRow][curCol].inCheck() == false
		)
		{
			return true;
		}
		return false;
	}
	public void castle(int curRow, int curCol, int newRow, int newCol)
	{
		if(castleCheckValid(curRow, curCol, newRow, newCol) == true)
		{
			if(board[curRow][curCol] == "bK")
			{ // check what color the castling pieces are
				King k = new King("bK");
				k = (King) board[curRow][curCol];
				board[curRow][curCol] = board[newRow][newCol];
				board[newRow][newCol] = k;
			}
			if(board[curRow][curCol] == "wK")
			{
				King k = new King("wK");
				k = (King) board[curRow][curCol];
				board[curRow][curCol] = board[newRow][newCol];
				board[newRow][newCol] = k;
			}
		}
	}
}
	
