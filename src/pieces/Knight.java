package pieces;
import chess.Board;
public class Knight extends Piece
{
    private String color;
    public Knight(String color)
    {
        this.color = color;
    }
    public boolean checkMoveValidity(Board board, Piece[][] b, int curRow, int curCol, int newRow, int newCol)
    {
        if(b[newRow][newCol] != null)
            if(b[newRow][newCol].getColor().equalsIgnoreCase(b[curRow][curCol].getColor()))
                return false;
        int rowDiff = Math.abs(curRow-newRow);
        int colDiff = Math.abs(curCol-newCol);
        return rowDiff == 2 && colDiff == 1 || rowDiff == 1 && colDiff == 2;
    }
    public String getColor()
    {
        return this.color;
    }
    public String toString()
    {
        return color.charAt(0)+"N";
    }
}
