package chess;
import java.util.ArrayList;
public class Player
{
	ArrayList<Piece> currentPieces = new ArrayList<Piece>();
	public Player(String color)
	{
		Knight k1 = new Knight(color);
		Knight k2 = new Knight(color);
		King k = new King(color);
		Queen q = new Queen(color);
		Pawn p1 = new Pawn(color);
		Pawn p2 = new Pawn(color);
		Pawn p3 = new Pawn(color);
		Pawn p4 = new Pawn(color);
		Pawn p5 = new Pawn(color);
		Pawn p6 = new Pawn(color);
		Pawn p7 = new Pawn(color);
		Pawn p8 = new Pawn(color);
		Rook r1 = new Rook(color);
		Rook r2 = new Rook(color);
		Bishop b1 = new Bishop(color);
		Bishop b2 = new Bishop(color);
		this.color = color;
		currentPieces.add(k1);
		currentPieces.add(k2);
		currentPieces.add(k);
		currentPieces.add(q);
		currentPieces.add(p1);
		currentPieces.add(p2);
		currentPieces.add(p3);
		currentPieces.add(p4);
		currentPieces.add(p5);
		currentPieces.add(p6);
		currentPieces.add(p7);
		currentPieces.add(p8);
		currentPieces.add(r1);
		currentPieces.add(r2);
		currentPieces.add(b1);
		currentPieces.add(b2);
	}
	String color;
	boolean isTurn;
	boolean hasWon;
}
