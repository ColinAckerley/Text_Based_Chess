package chess;
import pieces.*;
public class Board
{
	Piece[][] board = new Piece[8][8];
	final int SIZE = 8;
	public String lastMove = "";
	public Board()
	{
		this.initBoard();
	}
	private void initBoard()
	{
		board[0][0] = new Rook("black");
		board[0][1] = new Knight("black");
		board[0][2] = new Bishop("black");
		board[0][3] = new Queen("black");
		board[0][4] = new King("black");
		board[0][5] = new Bishop("black");
		board[0][6] = new Knight("black");
		board[0][7] = new Rook("black");
		for(int i = 0; i < SIZE; i++)
		{
			board[1][i] = new Pawn("black");
		}
		board[7][0] = new Rook("white");
		board[7][1] = new Knight("white");
		board[7][2] = new Bishop("white");
		board[7][3] = new Queen("white");
		board[7][4] = new King("white");
		board[7][5] = new Bishop("white");
		board[7][6] = new Knight("white");
		board[7][7] = new Rook("white");
		for(int i = 0; i < SIZE; i++)
		{
			board[6][i] = new Pawn("white");
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
		if(
			!curPiece.checkMoveValidity(this, board, curRow, curCol, newRow, newCol)
					|| !curPiece.getColor().equalsIgnoreCase(color)
		)
		{
			throw new Exception();
		}
		board[newRow][newCol] = curPiece;
		board[curRow][curCol] = null;
		lastMove = newRow + "," + newCol;
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
	boolean inCheckmate(String color)
	{
		boolean a = false, b = false, c = false, d = false, e = false, f = false, g = false, h = false;
		int[] tmp = getKingPos(color, board); // Find the location of the
												// color's king
		int kingRow = tmp[0];
		int kingCol = tmp[1];
		if(inCheck(color, board))
		{
			if(
				!board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow - 1, kingCol - 1)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow - 1,
								kingCol)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow - 1,
								kingCol + 1)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow,
								kingCol - 1)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow,
								kingCol + 1)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow + 1,
								kingCol - 1)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow + 1,
								kingCol)
						&& !board[kingRow][kingCol].checkMoveValidity(this, board, kingRow, kingCol, kingRow + 1,
								kingCol + 1)
				)
				{
				return true;
			}
			Piece[][] tmpBoard = board.clone();
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow - 1, kingCol - 1))
			{
				tmpBoard[kingRow - 1][kingCol - 1] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					a = true;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow - 1, kingCol))
			{
				tmpBoard[kingRow - 1][kingCol] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					b = true;
				;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow - 1, kingCol + 1))
			{
				tmpBoard[kingRow - 1][kingCol + 1] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					c = true;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow, kingCol - 1))
			{
				tmpBoard[kingRow][kingCol - 1] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					d = true;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow, kingCol + 1))
			{
				tmpBoard[kingRow][kingCol + 1] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					e = true;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow + 1, kingCol - 1))
			{
				tmpBoard[kingRow + 1][kingCol - 1] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					f = true;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow + 1, kingCol))
			{
				tmpBoard[kingRow + 1][kingCol] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					g = true;
			}
			if(tmpBoard[kingRow][kingCol].checkMoveValidity(this, tmpBoard, kingRow, kingCol, kingRow + 1, kingCol + 1))
			{
				tmpBoard[kingRow + 1][kingCol + 1] = tmpBoard[kingRow][kingCol];
				if(inCheck(color, tmpBoard))
					h = true;
			}
		}
		if(a && b && c && d && e && f && g && h)
			return true;
		return false;
	}
	private int[] getKingPos(String color, Piece[][] curBoard)
	{
		int col = 0, row = 0;
		for(int i = 0; i < SIZE; i++)
		{
			for(int j = 0; j < SIZE; j++)
			{
				if(curBoard[i][j] != null)
					if(
						curBoard[i][j].getClass().isInstance(new King(color))
								&& curBoard[i][j].getColor().equalsIgnoreCase(color)
						)
						{
						row = i;
						col = j;
					}
			}
		}
		int[] kingPos = new int[2];
		kingPos[0] = row;
		kingPos[1] = col;
		return kingPos;
	}
	public boolean inCheck(String color, Piece[][] curBoard)
	{
		if(curBoard == null)
		{
			curBoard = board.clone();
		}
		int[] tmp = getKingPos(color, curBoard); // Find the location of the
													// color's king
		int kingRow = tmp[0];
		int kingCol = tmp[1];
		for(int i = 0; i < SIZE; i++) // Go through the whole board
		{
			for(int j = 0; j < SIZE; j++)
			{
				if(curBoard[i][j] != null)
				{
					// Check if the other player's can perform a move that will
					// capture the cur player's king
					if(
						curBoard[i][j].checkMoveValidity(this, curBoard, i, j, kingRow, kingCol)
								&& !curBoard[i][j].getColor().equalsIgnoreCase(color)
						)
						{
						return true;
					}
				}
			}
		}
		return false;
	}
	boolean checkPromotion(String color)
	{
		if(color.equalsIgnoreCase("black"))
		{
			for(int i = 0; i < SIZE; i++)
			{
				if(board[0][i] != null)
				{
					if(board[0][i].toString().equalsIgnoreCase("wP"))
					{
						return true;
					}
				}
			}
		}
		if(color.equalsIgnoreCase("white"))
		{
			for(int i = 0; i < SIZE; i++)
			{
				if(board[7][i].toString().equalsIgnoreCase("bP"))
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
						if(curCol == 0 || curCol == SIZE - 1)
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
