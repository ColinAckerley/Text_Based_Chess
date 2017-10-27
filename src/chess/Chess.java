package chess;
import java.util.Scanner;
public class Chess
{
	public static void main(String[] args)
	{
		boolean drawAvail = false;
		@SuppressWarnings("resource")
		Scanner getInput = new Scanner(System.in);
		Board chessBoard = new Board();
		String curColor = "White";
		while (true)
		{
			System.out.println(chessBoard);
			System.out.print(curColor + "'s move:");
			String input = getInput.next();
			System.out.println();
			if(input.contains("resign"))
			{
				System.out.println(flipColor(curColor) + " wins");
				System.exit(0);
			}
			if(input.contains("draw"))
			{
				if(drawAvail)
				{
					System.out.println("draw");
					System.exit(0);
				}
			}
			if(input.contains("draw?"))
			{
				drawAvail = true;
			}
			else
			{
				if(!chessBoard.move(curColor, input))
				{
					System.out.println("Illegal move, try again");
					continue;
				}
				chessBoard.move(curColor, input);
				if(chessBoard.inCheck(flipColor(curColor)))
				{
					System.out.println("Check");
					curColor = flipColor(curColor);
				}
				else if(chessBoard.inCheckmate().equals("false"))
				{
					curColor = flipColor(curColor);
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
