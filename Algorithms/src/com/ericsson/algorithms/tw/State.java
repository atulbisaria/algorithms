package com.ericsson.algorithms.tw;

public enum State {

	LIVE("X"), DEAD("-");
	private String state;

	private State(String state) {
		this.state = state;
	}
	public String value(){
		return state;
	}
	
	@Override
	public String toString() {
		return state;
	}
}
