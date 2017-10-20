package chess;
import java.util.ArrayList;
public class Player
{
	ArrayList<Piece> currentPieces = new ArrayList<Piece>();
	public Player(String color)
	{
		this.color = color;
	}
	String color;
	boolean isTurn;
	boolean hasWon;
}
