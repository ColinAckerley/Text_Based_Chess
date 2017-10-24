package chess;
import pieces.*;
import pieces.Pawn;
public class Board
{
	Object[][] board = new Object[8][8];
	final int SIZE = 8;
	void initBoard()
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
	boolean inCheckmate()
	{
		return false;
	}
	boolean inCheck()
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
				{f
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
	public static void main(String args[])
	{
		Board b = new Board();
		b.initBoard();
		b.printBoard();
	}
	public boolean checkPawnDiag(int curRow, int curCol, int newRow, int newCol)
	{
		if(board[newRow][newCol] == "  " || board[newRow][newCol] == "##")
		{
			return false;
		}
		return true;
	}
}
