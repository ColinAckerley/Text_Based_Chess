package chess;
public class Board
{
	
	Object[][] board = new Object[8][8];
	
	
	void initBoard() {
	
	board[0][0] = new Rook("b");
	board[0][1] = new Knight("b");
	board[0][2] = new Bishop("b");
	board[0][3] = new Queen("b");
		
	}
	
	
	void drawBoard()
	{
	}
	void checkStatus()
	{
	}
	void printBoard()
	{
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
