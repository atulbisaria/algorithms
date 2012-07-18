package com.ericsson.algorithms.patterns;


public class SnakesLaddersGame {

	public Player[] players;
	public Board board;
	public Dice dice;
	
	public void playGame() {
		for (int i = 0; i < players.length; i++) {
			boolean hasWon = players[i].takeTurn();
			if(hasWon) {
				// print winner
				return;
			}
			
			
		}
	}
}

class Board {
	public Cell[][] cells;
	public int size;
	
	public Cell nextCell(Cell currentCell, int move) {
		return null;
	}
}

class Player {
	
	public Dice dice;
	public Cell current;
	public Board board;
	
	public boolean takeTurn() {
		int move = dice.roll();
		Cell next = board.nextCell(current, move);
		if(next != null)
			current = next;
		
		return false;
	}
}

class Cell {

	public int x;
	public int y;
	
	public Transition snake;
	public Transition ladder;
}

class Transition {

	public int toX;
	public int toY;
}

class Dice {
	
	public int roll() {
		return 0;
	}
}


