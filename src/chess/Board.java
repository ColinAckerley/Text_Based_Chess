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
		for(int i = 0; i < SIZE; i++)
		{
			board[1][i] = new Pawn("b");
		}
		board[7][0] = new Rook("w");
		board[7][1] = new Knight("w");
		board[7][2] = new Bishop("w");
		board[7][3] = new Queen("w");
		board[7][4] = new King("w");
		board[7][5] = new Bishop("w");
		board[7][6] = new Knight("w");
		board[7][7] = new Rook("w");
		for(int i = 0; i < SIZE; i++)
		{
			board[6][i] = new Pawn("w");
		}
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
	boolean checkPromotion(String color)
	{
		if(color.equals("b"))
		{
			for(int i = 0; i < SIZE; i++)
			{
				if(board[0][i].toString().equals("wP"))
				{
					return true;
				}
			}
		}
		if(color.equals("w"))
		{
			for(int i = 0; i < SIZE; i++)
			{
				if(board[7][i].toString().equals("bP"))
				{
					return true;
				}
			}
		}
		return false;
	}
	public void promote(String desiredPiece, int newRow, int newCol, String color)
	{
		if(checkPromotion(color))
		{
			if(desiredPiece == "R")
			{
				board[newRow][newCol] = new Rook(color);
			}
			if(desiredPiece == "N")
			{
				board[newRow][newCol] = new Knight(color);
			}
			if(desiredPiece == "Q")
			{
				board[newRow][newCol] = new Queen(color);
			}
			if(desiredPiece == "B")
			{
				board[newRow][newCol] = new Bishop(color);
			}
		}
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
		int curRow;
		for(curRow = 0; curRow < SIZE; curRow++)
		{
			for(int curCol = 0; curCol < SIZE; curCol++)
			{
				if(board[curRow][curCol] == null)
				{
					if(curRow % 2 == 0 && curCol % 2 == 0)
					{
						curBoard += "##";
					}
					else if(curRow % 2 == 0 && curCol % 2 == 1)
					{
						if(curCol == 0 || curCol == SIZE -1)
							curBoard += "   ";
						else
							curBoard += "    ";
					}	
					else if(curRow % 2 == 1 && curCol % 2 == 1)
					{
						curBoard += "##";
					}
					else if(curRow % 2 == 1 && curCol % 2 == 0)
					{
						if(curCol == 0 || curCol == SIZE -1)
							curBoard += "   ";
						else
							curBoard += "    ";
					}
				}
				else
					curBoard += board[curRow][curCol] + " ";
			}
			if(curRow > 1 && curRow < 6)
			{
				curBoard += " ";
				curBoard +=  SIZE - curRow;
			}
			else
				curBoard += SIZE - curRow;
			curBoard += "\n";
		}
		String letters = " a  b  c  d  e  f  g  h ";
		curBoard += letters;
		curBoard += "\n";
		return curBoard;
	}
}
