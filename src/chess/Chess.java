package chess;
import java.io.IOException;
import java.util.Scanner;
public class Chess
{
    public static void main(String[] args)
    {
        boolean drawAvail = false;
        boolean printBoard = true;
        @SuppressWarnings("resource") Scanner getInput = new Scanner(System.in);
        Board chessBoard = new Board();
        String curColor = "White";
        while(true)
        {
            if(printBoard)
                System.out.println(chessBoard);
            System.out.print(curColor+"'s move: ");
            String input = getInput.nextLine();
            System.out.println();
            if(input.equalsIgnoreCase("resign"))
            {
                System.out.println(flipColor(curColor)+" wins");
                System.exit(0);
            }
            if(input.equalsIgnoreCase("draw"))
            {
                if(drawAvail)
                {
                    System.out.println("draw");
                    System.exit(0);
                }
            }
            if(input.equalsIgnoreCase("draw?"))
            {
                drawAvail = true;
                curColor = flipColor(curColor);
                printBoard = false;
            }
            else
            {
                drawAvail = false;
                try
                {
                    chessBoard.move(curColor, input);
                    if(chessBoard.inCheckmate(curColor))
                    {
                        System.out.println(chessBoard);
                        System.out.println(flipColor(curColor)+" wins");
                        System.exit(0);
                    }
                    if(chessBoard.inCheckmate(flipColor(curColor)))
                    {
                        System.out.println(chessBoard);
                        System.out.println(curColor+" wins");
                        System.exit(0);
                    }
                    if(chessBoard.inCheck(flipColor(curColor), null))
                    {
                        System.out.println("Check");
                        System.out.println();
                        printBoard = true;
                    }
                    if(chessBoard.inStalemate(curColor))
                    {
                        System.out.println(chessBoard);
                        System.out.println("Stalemate");
                        System.exit(0);
                    }
                    else if(!chessBoard.inCheckmate(curColor))
                    {
                        curColor = flipColor(curColor);
                        printBoard = true;
                    }
                }
                catch(IOException e)
                {
                    System.out.println("Illegal move, try again\n");
                    printBoard = false;
                }
            }
        }
    }
    private static String flipColor(String s)
    {
        if(s.equals("White"))
            return "Black";
        return "White";
    }
}
