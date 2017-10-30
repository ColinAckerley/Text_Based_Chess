package pieces;
import chess.Board;
public class Bishop extends Piece
{
    private String color;
    public Bishop(String color)
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
        if(rowDiff != colDiff)
            return false;
        int rowOffset, colOffset;
        if(newRow > curRow) // Determines if the piece is moving up or down the
        // rows
        {
            rowOffset = 1;
        }else
        {
            rowOffset = -1;
        }
        if(newCol > curCol) // Determines if the piece is moving left or right
        // in the columns
        {
            colOffset = 1;
        }else
        {
            colOffset = -1;
        }
        int col = curCol+colOffset;
        int row = curRow+rowOffset;
        while(row != newRow)
        {
            if(b[row][col] != null) // If space is occupied
            {
                return false;
            }
            row += rowOffset;
            col += colOffset;
        }
        return true;
    }
    public String getColor()
    {
        return this.color;
    }
    public String toString()
    {
        return color.charAt(0)+"B";
    }
}
