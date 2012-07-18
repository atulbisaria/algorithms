package com.ericsson.algorithms.patterns.rover;

public class SouthDirection extends Direction {

	public static final SouthDirection DIRECTION = new SouthDirection();
	
	@Override
	public Direction turnLeft() {
		return EastDirection.DIRECTION;
	}

	@Override
	public Direction turnRight() {
		return WestDirection.DIRECTION;
	}

	@Override
	public void move(Location location) throws OutOfTerritoryException {
		int newLocation = location.getY() - 1;
		if(!Location.validateY(newLocation))
			throw new OutOfTerritoryException();
		location.setY(newLocation);
	}
	
	@Override
	public String toString() {
		return "SOUTH";
	}

}
