package pieces;
import chess.Board;
public class Pawn extends Piece
{
	String color;
	boolean hasMoved;
	
	public Pawn(String color)
	{
		this.color = color;
		this.hasMoved = false;
	}
	boolean checkMoveValidity(Piece[][] board, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(newRow - curRow);
		int colDiff = Math.abs(newCol - curCol);
					
		if(color == "b")
		{
			if(newRow <= curRow || colDiff > 1)
			{ // pawn can't go backwards, or move over more than one space
				// column-wise
				return false;
			}
			if(hasMoved == true && rowDiff > 1)
			{ // pawn can't move up more than one space if it has already moved
				return false;
			}
			if(hasMoved == false && rowDiff > 2)
			{ // pawn can't move up more than two spaces, if first move
				return false;
			}
		}
		if(color == "w")
		{
			if(newRow >= curRow || colDiff > 1)
			{ // pawn can't go backwards, or move over more than one space
				// column-wise
				return false;
			}
			if(hasMoved == true && rowDiff > 1)
			{
				return false;
			}
			if(hasMoved == false && rowDiff > 2)
			{
				return false;
			}
			
			if (board[newRow][newCol] != null) {
				return false;}
			
		}
		if(colDiff == 1)
		{
			return checkPawnDiag(board,curRow, curCol, newRow, newCol);
		}
		return true;
	}
	
	public boolean checkPawnDiag(Piece[][] board,int curRow, int curCol, int newRow, int newCol)
	{
		if(
			(board[newRow][newCol].toString().equals(null) || board[newRow][newCol].toString().equals(null))
					&& enpassantCheck(board, curRow, curCol, newRow, newCol) == false
		)
		{
			return false;
		}
		return true;
	}
	
	public boolean enpassantCheck(Piece[][] board, int curRow, int curCol, int newRow, int newCol)
	{
		if(board[curRow][curCol].toString().equals("bP") && curRow == 4)
		{ // Checks if BLACK piece is in the correct row for Enpassant
			if(curCol == 0 && board[curRow][curCol + 1].toString().equals("wP"))
			{ // If black piece is on left edge of the board & opponent's pawn
				// is adjacent to the right
				if((newRow == curRow+1 && newCol == curCol+1) && lastMoveWasDoubleMove(board,curRow, curCol+1))
				{ // if destination is directly below adjacent pawn
					// and the last move was that pawn's double move
					return true;
				}
			}
			if(curCol == 7 && board[curRow][curCol-1].toString().equals("wP"))
			{ // edge case on right-most column of board
				if((newRow == curRow+1 && newCol == curCol-1) && lastMoveWasDoubleMove(board,curRow, curCol-1))
				{
					return true;
				}
			}
			if(curCol != 0 && curCol != 7 && board[curRow][curCol-1].toString().equals("wP"))
			{ // non-edge columns with pawn to the left
				if((newRow == curRow+1 && newCol == curCol-1) && lastMoveWasDoubleMove(board,curRow, curCol-1))
				{
					return true;
				}
				if(curCol != 0 && curCol != 7 && board[curRow][curCol+1].toString().equals("wP"))
				{ // non-edge columns with pawn to the right
					if((newRow == curRow+1 && newCol == curCol+1) && lastMoveWasDoubleMove(board,curRow, curCol + 1))
						{
						return true;
					}
				}
			}
		}
		if(board[curRow][curCol].toString().equals("wP") && curRow == 3)
		{ // Checks if WHITE piece is in the correct row for Enpassant
			if(curCol == 0 && board[curRow][curCol+1].toString().equals("bP"))
			{
				if((newRow == curRow-1&& newCol == curCol+1) && lastMoveWasDoubleMove(board,curRow,curCol+1))
				{
					return true;
				}
			}
			if(curCol == 7 && board[curRow][curCol-1].toString().equals("bP"))
			{
				if((newRow == curRow-1 && newCol == curCol-1) && lastMoveWasDoubleMove(board,curRow, curCol-1))
				{
					return true;
				}
			}
			if(curCol != 0 && curCol != 7 && board[curRow][curCol-1].toString().equals("bP"))
			{
				if((newRow == curRow-1 && newCol == curCol-1) && lastMoveWasDoubleMove(board,curRow,curCol-1))
				{
					return true;
				}
				if(curCol != 0 && curCol != 7 && board[curRow][curCol+1].toString().equals("bP"))
				{
					if(
						(newRow == curRow-1 && newCol == curCol+1) && lastMoveWasDoubleMove(board,curRow,curCol+1))
						{
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean lastMoveWasDoubleMove(Piece[][] board, int pawnRow, int pawnCol) {
		
		if (board[pawnRow][pawnCol].hasMoved == false) {

			return true;
		}
		
		return false;
	}

	public String getColor() {
		return this.color;
	}

	public String toString() {
		return color.charAt(0) + "P";
	}

}
