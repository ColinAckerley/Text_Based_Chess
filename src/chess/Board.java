package chess;
public class Board
{
<<<<<<< HEAD
	void drawInitBoard()
	{
		
	}
=======
	
	Object[][] board = new Object[8][8];
	
	
	void initBoard() {
	
	board[0][0] = new Rook("b");
	board[0][1] = new Knight("b");
	board[0][2] = new Bishop("b");
	board[0][3] = new Queen("b");
		
	}
	
	
>>>>>>> 3065baae79ad474135d6f905e4c9bc0712544910
	void drawBoard()
	{
	}
	void checkStatus()
	{
	}
	void printBoard()
	{
		System.out.print("Hello World");
	}
	boolean inCheckmate()
	{
		return false;
	}
	boolean inCheck()
	{
		return false;
	}
	Pawn checkPromotion()
	{
		return null;
	}
}
