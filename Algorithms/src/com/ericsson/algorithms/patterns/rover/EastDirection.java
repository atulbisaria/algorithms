package com.ericsson.algorithms.patterns.rover;

public class EastDirection extends Direction {

	public static final EastDirection DIRECTION = new EastDirection();
	
	@Override
	public Direction turnLeft() {
		return NorthDirection.DIRECTION;
	}

	@Override
	public Direction turnRight() {
		return SouthDirection.DIRECTION;
	}

	@Override
	public void move(Location location) throws OutOfTerritoryException {
		int newLocation = location.getX() + 1;
		if(!Location.validateX(newLocation))
			throw new OutOfTerritoryException();
		location.setX(newLocation);
	}

	@Override
	public String toString() {
		return "EAST";
	}

}
