package com.ericsson.algorithms.amazon;

public class Chess {

	private Player player1;
	private Player player2;
	private ChessBoard board;
	
	private boolean isGameOver() {
		return false;
	}
	
	public void playGame() {
		while(!isGameOver()) {
			player1.takeTurn(board);
			player2.takeTurn(board);
		}
	}
}

class Player {

	private String pieceColor;

	public void takeTurn(ChessBoard board) {
		// make next winning move
	}
}

class ChessBoard {

	private Piece[] white;
	private Piece[] black;
	
	public Piece[] getWhite() {
		return white;
	}
	public void setWhite(Piece[] white) {
		this.white = white;
	}
	public Piece[] getBlack() {
		return black;
	}
	public void setBlack(Piece[] black) {
		this.black = black;
	}
}

abstract class Piece {

	private String color;
	private Location location;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}

class Location {

}