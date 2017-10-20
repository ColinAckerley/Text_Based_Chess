package chess;
import java.util.ArrayList;
public class Player
{
	String color;
	boolean isTurn;
	boolean hasWon;
	ArrayList<Piece> currentPieces = new ArrayList<Piece>();
	public Player(String color)
	{
		this.color = color;
	}
}
