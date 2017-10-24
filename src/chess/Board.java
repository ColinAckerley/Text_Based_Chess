package chess;
public class Board
{
	Object[][] board = new Object[8][8];
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
	boolean pathFree(int curRow, int curCol, int newRow, int newCol)
	{
		return false;
	}
	Pawn checkPromotion()
	{
		return null;
	}
	public static void main(String args[])
	{
		Board b = new Board();
		b.initBoard();
		b.printBoard();
	}
}
