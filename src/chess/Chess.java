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
				else
					drawAvail = false;
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
					if(chessBoard.inCheckmate(curColor))
					{
						System.out.println(flipColor(curColor) + " wins");
						System.exit(0);
					}
					if(chessBoard.inCheckmate(flipColor(curColor)))
					{
						System.out.println(curColor + " wins");
						System.exit(0);
					}
					if(chessBoard.inCheck(flipColor(curColor), null))
					{
						System.out.println("Check");
						System.out.println();
						printBoard = true;
						curColor = flipColor(curColor);
					}
					else if(!chessBoard.inCheckmate(curColor))
					{
						curColor = flipColor(curColor);
						printBoard = true;
						continue;
					}
				}
				catch (Exception c)
				{
					System.out.println("Illegal move, try again\n");
					printBoard = false;
					continue;
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
