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
	boolean checkMoveValidity(Piece[][] board, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(curRow - newRow);
		int colDiff = Math.abs(curCol - newCol);
		
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
		if(board[curRow][curCol].toString().equals("bK") && board[newRow][newCol].toString().equals("bR")
														 && hasMoved == false
														 && board[newRow][newCol].hasMoved == false
														 && (!board[curRow][curCol].inCheck("b"))
														 && castlePathFree(board,curCol,newCol,"b"))
		{
					return true;
		}
		
		if(board[curRow][curCol].toString().equals("wK") && board[newRow][newCol].toString().equals("wR")
														 && board[curRow][curCol].hasMoved == false
														 && hasMoved == false
														 && (!board[curRow][curCol].inCheck("w"))
														 && castlePathFree(board,curCol,newCol,"w"))
		{
					return true;
		}
			return false;
		}
	
	boolean castlePathFree(Piece[][] board, int curCol, int newCol, String color) {

		if (color.equals("b")) {
			
			if(curCol>newCol) {
			for (int col = 1; col < 4; col++) {
				if (!board[0][col].toString().equals(null)) {
					return false;
				}
			}
			
			for (int col = 5; col < 8; col++) {
				if (!board[0][col].toString().equals(null)) {
					return false;
				}
			}
		}
	}
		if (color.equals("w")) {
			
			if(curCol>newCol)
			for (int col = 1; col < 4; col++) {
				if (!board[7][col].toString().equals(null)) {
					return false;
				}
			}

			for (int col = 5; col < 7; col++) {
				if (!board[7][col].toString().equals(null)) {
					return false;
				}
			}
		}	
			

		return true;
	}

}

	
