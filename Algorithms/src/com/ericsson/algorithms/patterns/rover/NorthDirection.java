package com.ericsson.algorithms.patterns.rover;

public class NorthDirection extends Direction {

	public static final NorthDirection DIRECTION = new NorthDirection();
	
	@Override
	public Direction turnLeft() {
		return WestDirection.DIRECTION;
	}

	@Override
	public Direction turnRight() {
		return EastDirection.DIRECTION;
	}

	@Override
	public void move(Location location) throws OutOfTerritoryException {
		int newLocation = location.getY() + 1;
		if(!Location.validateY(newLocation))
			throw new OutOfTerritoryException();
		location.setY(newLocation);
	}

	@Override
	public String toString() {
		return "NORTH";
	}

}
