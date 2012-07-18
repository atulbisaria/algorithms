package com.ericsson.algorithms.tw;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a cell in a generation
 */
public class Cell {

	private State state;
	private List<Cell> neighbours;
	private int liveNeighbours;

	public Cell(String state) {
		this.state = (state.equals(State.DEAD.value()) ? State.DEAD
				: State.LIVE);
	}
	
	public Cell(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Cell> getNeighbours() {
		if(neighbours == null)
			neighbours = new ArrayList<Cell>();
		return neighbours;
	}

	public int getLiveNeighbours() {
		return liveNeighbours;
	}

	public void updateLiveNeighbours() {
		int count = 0;
		for (Cell neighbour : neighbours) {
			if(neighbour.state.equals(State.LIVE)) {
				count++;
			}
		}
		
		liveNeighbours = count;
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
