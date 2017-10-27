package pieces;
import chess.Board;
public class Pawn extends Piece
{
	String color;
	boolean hasMoved;
	Board board;
	public Pawn(String color)
	{
		this.color = color;
		this.hasMoved = false;
	}
	boolean checkMoveValidity(Board b, int curRow, int curCol, int newRow, int newCol)
	{
		int rowDiff = Math.abs(newRow - curRow);
		int colDiff = Math.abs(newCol - curCol);
		
		
		if (!b.pathFree(curRow, curCol, newRow, newCol)) {
			return false;}
		
		
		
		if(color == "Black")
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
		if(color == "White")
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
		}
		if(colDiff == 1)
		{
			return b.checkPawnDiag(curRow, curCol, newRow, newCol);
		}
		return true;
	}
	public String getColor()
	{
		return this.color;
	}
	public String toString()
	{
		return color.charAt(0) + "P";
	}
	
	public boolean checkPawnDiag(int curRow, int curCol, int newRow, int newCol)
	{
		if(
			(board[newRow][newCol] == "  " || board[newRow][newCol] == "##")
					&& enpassantCheck(curRow, curCol, newRow, newCol) == false
		)
		{
			return false;
		}
		return true;
	}
	
	public boolean enpassantCheck(int curRow, int curCol, int newRow, int newCol)
	{
		if(board[curRow][curCol] == "bP" && curRow == 4)
		{ // Checks if BLACK piece is in the correct row for Enpassant
			if(curCol == 0 && board[curRow][curCol + 1] == "wP")
			{ // If black piece is on left edge of the board & opponent's pawn
				// is adjacent to the right
				if((newRow == curRow + 1 && newCol == curCol + 1) && lastMoveWasDoubleMove(curRow, curCol + 1) == true)
				{ // if destination is directly below adjacent pawn
					// and the last move was that pawn's double move
					return true;
				}
			}
			if(curCol == 7 && board[curRow][curCol - 1] == "wP")
			{ // edge case on right-most column of board
				if((newRow == curRow + 1 && newCol == curCol - 1) && lastMoveWasDoubleMove(curRow, curCol - 1) == true)
				{
					return true;
				}
			}
			if(curCol != 0 && curCol != 7 && board[curRow][curCol - 1] == "wP")
			{ // non-edge columns with pawn to the left
				if((newRow == curRow + 1 && newCol == curCol - 1) && lastMoveWasDoubleMove(curRow, curCol - 1) == true)
				{
					return true;
				}
				if(curCol != 0 && curCol != 7 && board[curRow][curCol + 1] == "wP")
				{ // non-edge columns with pawn to the right
					if(
						(newRow == curRow + 1 && newCol == curCol + 1)
								&& lastMoveWasDoubleMove(curRow, curCol + 1) == true
						)
						{
						return true;
					}
				}
			}
		}
		if(board[curRow][curCol] == "wP" && curRow == 3)
		{ // Checks if WHITE piece is in the correct row for Enpassant
			if(curCol == 0 && board[curRow][curCol + 1] == "bP")
			{
				if((newRow == curRow - 1 && newCol == curCol + 1) && lastMoveWasDoubleMove(curRow, curCol + 1) == true)
				{
					return true;
				}
			}
			if(curCol == 7 && board[curRow][curCol - 1] == "bP")
			{
				if((newRow == curRow - 1 && newCol == curCol - 1) && lastMoveWasDoubleMove(curRow, curCol - 1) == true)
				{
					return true;
				}
			}
			if(curCol != 0 && curCol != 7 && board[curRow][curCol - 1] == "bP")
			{
				if((newRow == curRow - 1 && newCol == curCol - 1) && lastMoveWasDoubleMove(curRow, curCol - 1) == true)
				{
					return true;
				}
				if(curCol != 0 && curCol != 7 && board[curRow][curCol + 1] == "bP")
				{
					if(
						(newRow == curRow - 1 && newCol == curCol + 1)
								&& lastMoveWasDoubleMove(curRow, curCol + 1) == true
						)
						{
						return true;
					}
				}
			}
		}
		return false;
	}
	public void enpassant(int curRow, int curCol, int newRow, int newCol)
	{
		if(enpassantCheck(curRow, curCol, newRow, newCol) == true)
		{
			if(board[curRow][curCol] == "bP")
			{
				removePiece(board[newRow - 1][newCol]);
			}
			if(board[curRow][curCol] == "wP")
			{
				removePiece(board[newRow + 1][newCol]);
			}
		}
	
}
	
}
