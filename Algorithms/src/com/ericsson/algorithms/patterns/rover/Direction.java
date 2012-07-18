package com.ericsson.algorithms.patterns.rover;

public abstract class Direction {

	public abstract Direction turnLeft();
	public abstract Direction turnRight();
	public abstract void move(Location location) throws OutOfTerritoryException;
}
