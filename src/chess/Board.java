package chess;
public class Board
{
	
	Object[][] board = new Object[8][8];
	
	
	void initBoard() {
	
		
	board[0][0] = new Rook("b");
	board[0][1] = new Knight("b");
	board[0][2] = new Bishop("b");
	board[0][3] = new Queen("b");
	board[0][4] = new King("b");
	board[0][5] = new Bishop("b");
	board[0][6] = new Knight("b");
	board[0][7] = new Rook("b");
	
	for (int i = 0; i < 8; i++) {
		
		board[1][i] = new Pawn("b");
		
	}
	

	for (int i=2; i < 6; i++) {
		for (int j =0; j < 8; j++) {
			
			if (i%2 == 0 && j%2 == 0) {
				
				board[i][j] = "    ";
				
			}
			
			else { board[i][j] = "##" ; }
			
		}
			
	}
	
	
	
	
	
	for (int m = 0; m < 8; m++) {
		
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
