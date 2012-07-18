package com.ericsson.algorithms.tw;

public class Rule {

	private int minLiveNeighboursCount;
	private int maxLiveNeighboursCount;
	
	private State currentState;
	private State nextState;
	
	private Rule next;

	public Rule(int minLiveNeighboursCount, int maxLiveNeighboursCount,
			State currentState, State nextState) {
		this.minLiveNeighboursCount = minLiveNeighboursCount;
		this.maxLiveNeighboursCount = maxLiveNeighboursCount;
		this.currentState = currentState;
		this.nextState = nextState;
	}
	
	public Rule setNext(Rule rule) {
		rule.next = this;
		return rule;
	}

	public void applyRule(Cell cell) {
		if (cell.getState().equals(currentState)
				&& cell.getLiveNeighbours() >= minLiveNeighboursCount
				&& cell.getLiveNeighbours() <= maxLiveNeighboursCount) {
			cell.setState(nextState);
		} else if (next != null) {
			next.applyRule(cell);
		}
	}
}
