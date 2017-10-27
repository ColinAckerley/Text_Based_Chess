package chess;
import java.util.Scanner;
public class Chess
{
	public static void main(String[] args)
	{
		boolean drawAvail = false;
		boolean printBoard = true;
		@SuppressWarnings("resource")
		Scanner getInput = new Scanner(System.in);
		Board chessBoard = new Board();
		String curColor = "White";
		while (true)
		{
			if(printBoard)
				System.out.println(chessBoard);
			System.out.print(curColor + "'s move: ");
			String input = getInput.nextLine();
			System.out.println();
			if(input.equalsIgnoreCase("resign"))
			{
				System.out.println(flipColor(curColor) + " wins");
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
			}
			else
			{
				try
				{
					chessBoard.move(curColor, input);
				}
				catch (Exception c)
				{
					System.out.println("Illegal move, try again\n");
					printBoard = false;
					continue;
				}
				if(chessBoard.inCheck(flipColor(curColor)))
				{
					System.out.println("Check");
					printBoard = true;
					curColor = flipColor(curColor);
				}
				else if(chessBoard.inCheckmate().equals("false"))
				{
					curColor = flipColor(curColor);
					printBoard = true;
					continue;
				}
				else if(chessBoard.inCheckmate().equals("white"))
				{
					System.out.println("Black wins");
					System.exit(0);
				}
				else if(chessBoard.inCheckmate().equals("black"))
				{
					System.out.println("White wins");
					System.exit(0);
				}
			}
		}
	}
	public static String flipColor(String s)
	{
		if(s.equals("White"))
			return "Black";
		return "White";
	}
}
