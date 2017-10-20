package chess;
public abstract class Piece
{
	String color;
	abstract boolean checkMoveValidity(String origin, String dest);
	abstract String move(String origin, String dest);
}
