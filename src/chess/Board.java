package chess;
import pieces.*;
public class Board
{
	Piece[][] board = new Piece[8][8];
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
	public boolean move(String color, String move)
	{
		return false;
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
		String curBoard = "";
		for(int curRow = 0; curRow < SIZE; curRow++)
		{
			for(int curCol = 0; curCol < SIZE; curCol++)
			{
				if(board[curRow][curCol].equals(null))
				{
					if(curRow % 2 == 0 && curCol % 2 == 0)
					{
						curBoard += "##";
					}
					else if(curRow % 2 == 0 && curCol % 2 == 1)
					{
						curBoard += "    ";
					}
					else if(curRow % 2 == 1 && curCol % 2 == 1)
					{
						curBoard += "##";
					}
					else if(curRow % 2 == 1 && curCol % 2 == 0)
					{
						curBoard += "    ";
					}
				}
				else
					curBoard += board[curRow][curCol];
			}
			curBoard += SIZE - curRow;
			curBoard += "\n";
		}
		String letters  = " a  b  c  d  e  f  g  h ";
		curBoard += "\n";
		curBoard += letters;
		return curBoard;
	}
}
