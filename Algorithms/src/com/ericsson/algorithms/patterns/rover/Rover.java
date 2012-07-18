package com.ericsson.algorithms.patterns.rover;

public class Rover {

	private Direction direction;
	private Location location;
	
	public Rover(Direction direction, Location location) {
		this.direction = direction;
		this.location = location;
	}

	public Direction getDirection() {
		return direction;
	}

	public Location getLocation() {
		return location;
	}

	public void turnLeft() {
		direction = direction.turnLeft();
	}
	
	public void turnRight() {
		direction = direction.turnRight();
	}
	
	public void move() {
		try {
			direction.move(location);
		} catch (OutOfTerritoryException e) {
			System.out.println("Rover moved out of territory from " + location);
		}
	}
}
