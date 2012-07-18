package com.ericsson.algorithms.patterns.rover;

public class WestDirection extends Direction {

	public static final WestDirection DIRECTION = new WestDirection();
	
	@Override
	public Direction turnLeft() {
		return SouthDirection.DIRECTION;
	}

	@Override
	public Direction turnRight() {
		return NorthDirection.DIRECTION;
	}

	@Override
	public void move(Location location) throws OutOfTerritoryException {
		int newLocation = location.getX() - 1;
		if(!Location.validateX(newLocation))
			throw new OutOfTerritoryException();
		location.setX(newLocation);
	}
	
	@Override
	public String toString() {
		return "WEST";
	}

}
