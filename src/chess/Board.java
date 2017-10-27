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
	public void move(String color, String move) throws Exception
	{
		int curRow = 0, newRow = 0, curCol = 0, newCol = 0;
		String curPos = move.substring(0, 2);
		String newPos = move.substring(3, 5);
		curRow = Integer.parseInt(curPos.substring(1));
		newRow = Integer.parseInt(newPos.substring(1));
		int tmpInt = curRow;
		switch (tmpInt)
		{
		case 1:
			curRow = 7;
			break;
		case 2:
			curRow = 6;
			break;
		case 3:
			curRow = 5;
			break;
		case 4:
			curRow = 4;
			break;
		case 5:
			curRow = 3;
			break;
		case 6:
			curRow = 2;
			break;
		case 7:
			curRow = 1;
			break;
		case 8:
			curRow = 0;
			break;
		}
		tmpInt = newRow;
		switch (tmpInt)
		{
		case 1:
			newRow = 7;
			break;
		case 2:
			newRow = 6;
			break;
		case 3:
			newRow = 5;
			break;
		case 4:
			newRow = 4;
			break;
		case 5:
			newRow = 3;
			break;
		case 6:
			newRow = 2;
			break;
		case 7:
			newRow = 1;
			break;
		case 8:
			newRow = 0;
			break;
		}
		char tmp = curPos.charAt(0);
		switch (tmp)
		{
		case 'a':
			curCol = 0;
			break;
		case 'b':
			curCol = 1;
			break;
		case 'c':
			curCol = 2;
			break;
		case 'd':
			curCol = 3;
			break;
		case 'e':
			curCol = 4;
			break;
		case 'f':
			curCol = 5;
			break;
		case 'g':
			curCol = 6;
			break;
		case 'h':
			curCol = 7;
			break;
		}
		tmp = newPos.charAt(0);
		switch (tmp)
		{
		case 'a':
			newCol = 0;
			break;
		case 'b':
			newCol = 1;
			break;
		case 'c':
			newCol = 2;
			break;
		case 'd':
			newCol = 3;
			break;
		case 'e':
			newCol = 4;
			break;
		case 'f':
			newCol = 5;
			break;
		case 'g':
			newCol = 6;
			break;
		case 'h':
			newCol = 7;
			break;
		}
		Piece curPiece = board[curRow][curCol];
		System.out.println("The current piece is " + curPiece);
		System.out.println("The current row is" + curRow);
		System.out.println("The current col is " + curCol);
		System.out.println("The new row is " +  newRow);
		System.out.println("The new col is " + newCol);
		if(!curPiece.checkMoveValidity(this, curRow, curCol, newRow, newCol))
		{
			throw new Exception();
		}
		board[newRow][newCol] = curPiece;
		board[curRow][curCol] = null;
		if(checkPromotion(color))
		{
			if(move.trim().length() > 5)
			{
				if(!checkPromotion(color))
				{
					throw new Exception();
				}
				promote(move.trim().charAt(6), newRow, newCol, color);
			}
			else
				promote('Q', newRow, newCol, color);
		}
	}
	String inCheckmate()
	{
		return "false";
	}
	public boolean inCheck(String color)
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
	public void promote(char desiredPiece, int newRow, int newCol, String color)
	{
		if(checkPromotion(color))
		{
			if(desiredPiece == 'R')
			{
				board[newRow][newCol] = new Rook(color);
			}
			if(desiredPiece == 'N')
			{
				board[newRow][newCol] = new Knight(color);
			}
			if(desiredPiece == 'Q')
			{
				board[newRow][newCol] = new Queen(color);
			}
			if(desiredPiece == 'B')
			{
				board[newRow][newCol] = new Bishop(color);
			}
		}
	}
	public Piece[][] getBoard()
	{
		return board;
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
						curBoard += "## ";
					}
					else if(curRow % 2 == 0 && curCol % 2 == 1)
					{
						if(curCol == 0 || curCol == SIZE - 1)
							curBoard += "   ";
						else
							curBoard += "   ";
					}
					else if(curRow % 2 == 1 && curCol % 2 == 1)
					{
						curBoard += "## ";
					}
					else if(curRow % 2 == 1 && curCol % 2 == 0)
					{
						if(curCol == 0 ||  curCol == SIZE - 1)
							curBoard += "   ";
						else
							curBoard += "   ";
					}
				}
				else
					curBoard += board[curRow][curCol] + " ";
			}
			if(curRow > 1 && curRow < 6)
			{
				curBoard += "";
				curBoard += SIZE - curRow;
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
