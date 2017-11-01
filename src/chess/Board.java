/**
 * @author Colin Ackerley
 * @author Steven Benmoha
 */
package chess;
import pieces.*;
public class Board
{
    private Piece[][] board = new Piece[8][8];
    private final int SIZE = 8;
    public String lastMove;
    public int startingRow;
    /**
     * @param none
     *
     * @return Board constructor
     */
    Board()
    {
        this.initBoard();
    }
    /**
     * @param
     *
     * @return Called when a new board is created. Puts all the pieces on the board
     * for a new game
     */
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
            board[1][i] = new Pawn("black");
        board[7][0] = new Rook("white");
        board[7][1] = new Knight("white");
        board[7][2] = new Bishop("white");
        board[7][3] = new Queen("white");
        board[7][4] = new King("white");
        board[7][5] = new Bishop("white");
        board[7][6] = new Knight("white");
        board[7][7] = new Rook("white");
        for(int i = 0; i < SIZE; i++)
            board[6][i] = new Pawn("white");
    }
    /**
     * @param String color representing who is currently moving, String move
     * representing where the move is being attempted
     *
     * @return Method to move a given piece if the proposed move is valid
     */
    void move(String color, String move) throws Exception
    {
        int curRow, newRow, curCol = 0, newCol = 0;
        String curPos = move.substring(0, 2);
        String newPos = move.substring(3, 5);
        curRow = Integer.parseInt(curPos.substring(1));
        newRow = Integer.parseInt(newPos.substring(1));
        int tmpInt = curRow;
        switch(tmpInt)
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
        switch(tmpInt)
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
        switch(tmp)
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
        switch(tmp)
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
        if(!curPiece.checkMoveValidity(this, board, curRow, curCol, newRow, newCol) || !curPiece.getColor().equalsIgnoreCase(color))
            throw new Exception();
        if(board[newRow][newCol] != null)
        { // if you are moving to an occupied space
            if((board[curRow][curCol].toString().contains("wK") && board[newRow][newCol].toString().contains("wR")) || (board[curRow][curCol].toString().contains("bK") && board[newRow][newCol].toString().contains("bR")))
            {
                Piece temp = board[newRow][newCol]; // set a temp piece that is
                // that rook
                board[newRow][newCol] = curPiece; // king in rook's spot
                board[curRow][curCol] = temp; // rook in king's spot
            }
            else
            {
                board[newRow][newCol] = curPiece;
                board[curRow][curCol] = null;
            }
        }
        else if(board[newRow][newCol] == null && (board[curRow][curCol].toString().equalsIgnoreCase("wP") || board[curRow][curCol].toString().equalsIgnoreCase("bP")))
        { // if a piece moves to an empty space
            // and it's a pawn that made through its
            // validity check (aka
            // enpassant move)
            board[newRow][newCol] = curPiece; // move the pawn
            board[curRow][newCol] = null; // remove the opponents pawn from
            // board
            board[curRow][curCol] = null; // and empty the space you came from
        }
        else
        {
            board[newRow][newCol] = curPiece;
            board[curRow][curCol] = null;
        }
        startingRow = curRow;
        lastMove = newRow+","+newCol;
        if(checkPromotion(color))
        {
            if(move.trim().length() > 5)
            {
                if(!checkPromotion(color))
                    throw new Exception();
                promote(Character.toString(move.trim().charAt(6)), newRow, newCol, color);
            }
            else
                promote("Q", newRow, newCol, color);
        }
    }
    /**
     * @param String color representing which player is being tested for checkmate
     *
     * @return rue if the player of Color is in checkmate, false otherwise Method to
     * see if a given player is in checkmate
     */
    boolean inCheckmate(String color)
    {
        return inCheck(color, board) && !canPieceMove(color);
    }
    /**
     * @param String color representing who is being tested for stalemate
     *
     * @return true if the given player is in stalemate, false otherwise Method to
     * check if the given player is in stalemate
     */
    boolean inStalemate(String color)
    {
        return !inCheck(color, board) && !canPieceMove(color);
    }
    /**
     * @param String color representing which player is being tested for possible
     * moves
     *
     * @return true if the given player has any valid moves that don't result in
     * check, false otherwise Tests all pieces for the given player to see if they
     * can move in any way that will result in that player not being in check
     */
    private boolean canPieceMove(String color)
    {
        Piece[][] tmpBoard = new Piece[SIZE][];
        Piece curPiece;
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
            {
                curPiece = board[i][j];
                if(curPiece != null)
                    if(curPiece.getColor().equalsIgnoreCase(color))
                        for(int k = 0; k < SIZE; k++)
                            for(int l = 0; l < SIZE; l++)
                                if(curPiece.checkMoveValidity(this, board, i, j, k, l))
                                {
                                    for(int m = 0; m < SIZE; m++)
                                        tmpBoard[m] = board[m].clone();
                                    tmpBoard[k][l] = curPiece;
                                    tmpBoard[i][j] = null;
                                    if(!inCheck(color, tmpBoard))
                                        return true;
                                }
            }
        return false;
    }
    /**
     * @param String color representing which color's king is being searched for,
     * Piece[][]board representing the board that is being searched
     *
     * @return 1D array of the position of the king for color Method to search for
     * the king for a given color
     */
    private int[] getKingPos(String color, Piece[][] curBoard)
    {
        int col = 0, row = 0;
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                if(curBoard[i][j] != null)
                    if(curBoard[i][j].getClass().isInstance(new King(color)) && curBoard[i][j].getColor().equalsIgnoreCase(color))
                    {
                        row = i;
                        col = j;
                    }
        int[] kingPos = new int[2];
        kingPos[0] = row;
        kingPos[1] = col;
        return kingPos;
    }
    /**
     * @param String color representing which piece is being tested for check
     *
     * @return true if the given color is in check, false otherwise Method to test
     * if a given player is in check or not
     */
    public boolean inCheck(String color, Piece[][] curBoard)
    {
        if(curBoard == null)
        {
            curBoard = new Piece[SIZE][];
            for(int i = 0; i < SIZE; i++)
                curBoard[i] = board[i].clone();
        }
        int[] tmp = getKingPos(color, curBoard); // Find the location of the
        // color's king
        int kingRow = tmp[0];
        int kingCol = tmp[1];
        for(int i = 0; i < SIZE; i++) // Go through the whole board
            for(int j = 0; j < SIZE; j++)
                if(curBoard[i][j] != null)
                    // Check if the other player's can perform a move that will
                    // capture the cur player's king
                    if(curBoard[i][j].checkMoveValidity(this, curBoard, i, j, kingRow, kingCol) && !curBoard[i][j].getColor().equalsIgnoreCase(color))
                        return true;
        return false;
    }
    /**
     * @param String color representing which color is being checked for a possible
     * promotion
     *
     * @return true if the given color can be promoted, false otherwise
     */
    private boolean checkPromotion(String color)
    {
        if(color.equalsIgnoreCase("white"))
            for(int i = 0; i < SIZE; i++)
                if(board[0][i] != null)
                    if(board[0][i].toString().equalsIgnoreCase("wP"))
                        return true;
        if(color.equalsIgnoreCase("black"))
            for(int i = 0; i < SIZE; i++)
                if(board[7][i] != null)
                    if(board[7][i].toString().equalsIgnoreCase("bP"))
                        return true;
        return false;
    }
    /**
     * @param String representing the player's desired piece upon promotion, int for
     * which row to put the piece, int for which col to place the piece, String
     * color representing which player is getting the promotion
     *
     * @return
     */
    private void promote(String desiredPiece, int newRow, int newCol, String color)
    {
        if(checkPromotion(color))
        {
            if(desiredPiece.equalsIgnoreCase("R"))
                board[newRow][newCol] = new Rook(color.toLowerCase());
            if(desiredPiece.equalsIgnoreCase("N"))
                board[newRow][newCol] = new Knight(color.toLowerCase());
            if(desiredPiece.equalsIgnoreCase("Q"))
                board[newRow][newCol] = new Queen(color.toLowerCase());
            if(desiredPiece.equalsIgnoreCase("B"))
                board[newRow][newCol] = new Bishop(color.toLowerCase());
        }
    }
    /**
     * @param
     *
     * @return string that is a text representation of the current state of the
     * board
     */
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
                    if(curRow%2 == 0 && curCol%2 == 0)
                    {
                        curBoard += "## ";
                    }
                    else if(curRow%2 == 0 && curCol%2 == 1)
                    {
                        if(curCol == 0 || curCol == SIZE-1)
                            curBoard += "   ";
                        else
                            curBoard += "   ";
                    }
                    else if(curRow%2 == 1 && curCol%2 == 1)
                    {
                        curBoard += "## ";
                    }
                    else if(curRow%2 == 1 && curCol%2 == 0)
                    {
                        if(curCol == 0 || curCol == SIZE-1)
                            curBoard += "   ";
                        else
                            curBoard += "   ";
                    }
                }
                else
                    curBoard += board[curRow][curCol]+" ";
            }
            if(curRow > 1 && curRow < 6)
            {
                curBoard += "";
                curBoard += SIZE-curRow;
            }
            else
                curBoard += SIZE-curRow;
            curBoard += "\n";
        }
        String letters = " a  b  c  d  e  f  g  h ";
        curBoard += letters;
        curBoard += "\n";
        return curBoard;
    }
}