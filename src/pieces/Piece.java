package pieces;
import chess.Board;
public abstract class Piece
{
    boolean hasMoved;
    public abstract boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol);

    public abstract String getColor();
}
