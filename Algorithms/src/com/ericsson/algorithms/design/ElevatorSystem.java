package com.ericsson.algorithms.design;

import java.util.PriorityQueue;

public class ElevatorSystem {

	public Elevator[] elevators;

}

class Elevator {

	public int interval;
	public PriorityQueue<Floor> queue;
	public State state;

}

class Skycraper {

	public Floor[] floors;
	public ElevatorSystem elevatorSystem;

}

class Floor {

	public int number;
	public State request;
}

class User {

}

enum State {
	NONE, UP, DOWN
}
