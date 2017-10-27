package chess;
import pieces.*;
public class Board
{
	Object[][] board = new Object[8][8];
	final int SIZE = 8;
	public Board()
	{
		this.initBoard();
	}
	private void initBoard()
	{
		board[0][0] = new Rook("b");
		board[0][1] = new Knight("b");
		board[0][2] = new Bishop("b");
		board[0][3] = new Queen("b");
		board[0][4] = new King("b");
		board[0][5] = new Bishop("b");
		board[0][6] = new Knight("b");
		board[0][7] = new Rook("b");
		for(int i = 0; i < 8; i++)
		{
			board[1][i] = new Pawn("b");
		}
		for(int i = 0; i < 8; i++)
		{
			if(i % 2 == 0)
				board[5][i] = "##";
			else
				board[5][i] = "  ";
		}
		for(int i = 0; i < 8; i++)
		{
			if(i % 2 == 0)
				board[4][i] = "  ";
			else
				board[4][i] = "##";
		}
		for(int i = 0; i < 8; i++)
		{
			if(i % 2 == 0)
				board[3][i] = "##";
			else
				board[3][i] = "  ";
		}
		for(int i = 0; i < 8; i++)
		{
			if(i % 2 == 0)
				board[2][i] = "  ";
			else
				board[2][i] = "##";
		}
		for(int m = 0; m < 8; m++)
		{
			board[6][m] = new Pawn("w");
		}
		board[7][0] = new Rook("w");
		board[7][1] = new Knight("w");
		board[7][2] = new Bishop("w");
		board[7][3] = new Queen("w");
		board[7][4] = new King("w");
		board[7][5] = new Bishop("w");
		board[7][6] = new Knight("w");
		board[7][7] = new Rook("w");
	}
	void drawBoard()
	{
	}
	void checkStatus()
	{
	}
	public void move(String color, String move)
	{
	}
	void printBoard()
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	String inCheckmate()
	{
		return "false";
	}
	boolean inCheck(String color)
	{
		return false;
	}
	public boolean pathFree(int curRow, int curCol, int newRow, int newCol)
	{
		return false;
	}
	boolean checkPromotion(int newRow, int newCol)
	{
		if(board[0][newCol] == "wP")
		{
			return true;
		}
		if(board[7][newCol] == "bP")
		{
			return true;
		}
		return false;
	}
	public void promote(String desiredPiece, int newRow, int newCol)
	{
		if(checkPromotion(newRow, newCol) == true)
		{
			if(newRow == 0)
			{
				if(desiredPiece == "R")
				{
					board[newRow][newCol] = new Rook("w");
				}
				if(desiredPiece == "N")
				{
					board[newRow][newCol] = new Knight("w");
				}
				if(desiredPiece == "Q")
				{
					board[newRow][newCol] = new Queen("w");
				}
				if(desiredPiece == "B")
				{
					board[newRow][newCol] = new Bishop("w");
				}
			}
			if(newRow == 7)
			{
				if(desiredPiece == "R")
				{
					board[newRow][newCol] = new Rook("b");
				}
				if(desiredPiece == "N")
				{
					board[newRow][newCol] = new Knight("b");
				}
				if(desiredPiece == "Q")
				{
					board[newRow][newCol] = new Queen("b");
				}
				if(desiredPiece == "B")
				{
					board[newRow][newCol] = new Bishop("b");
				}
			}
		}
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
	boolean castleCheckValid(int curRow, int curCol, int newRow, int newCol)
	{
		
		
		  if (board[curRow][curCol] == "bK" && board[newRow][newCol] == "bR" &&
			  board[curRow][curCol].hasMoved == false && 
			  board[newRow][newCol].getHasMoved() == false &&
			  board.pathFree(curRow, curCol, newRow, newCol) == true &&
		      board[curRow][curCol].inCheck() == false) { 		  
		  return true; }
		  
		  if (board[curRow][curCol] == "wK" && board[newRow][newCol] == "wR" &&
		      board[curRow][curCol].getHasMoved() == false &&
		      board[newRow][newCol].getHasMoved() == false &&
		      board.pathFree(curRow, curCol, newRow, newCol) == true &&
		      board[curRow][curCol].inCheck() == false) {
		  
		  return true; }
		 
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
	public void removePiece(Object o)
	{
	}
	boolean lastMoveWasDoubleMove(int pawnRow, int pawnCol)
	{
		// check lastMove value(?) to see if given row,column coordinates was
		// the last move
		// and also checks if hasMoved of Pawn piece at given coordinates is
		// false;
		return false;
	}
	public String toString()
	{
		printBoard();
		return "";
	}
}
