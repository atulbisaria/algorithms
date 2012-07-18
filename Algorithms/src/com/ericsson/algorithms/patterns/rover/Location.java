package com.ericsson.algorithms.patterns.rover;

public class Location {

	public static final int MIN_X_LIMIT = 0;
	public static final int MIN_Y_LIMIT = 0;
	public static final int MAX_X_LIMIT = 10;
	public static final int MAX_Y_LIMIT = 10;
	
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public static boolean validateX(int x) {
		return x >= MIN_X_LIMIT && x <= MAX_X_LIMIT;
	}
	
	public static boolean validateY(int y) {
		return y >= MIN_Y_LIMIT && y <= MAX_Y_LIMIT;
	}
	
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
}
