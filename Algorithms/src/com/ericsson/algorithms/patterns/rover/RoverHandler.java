package com.ericsson.algorithms.patterns.rover;

public class RoverHandler {

	public static Rover rover;
	
	public static void maneuover(String input) {
		char[] codes = input.toCharArray();
		for (int i = 0; i < codes.length; i++) {
			String character = Character.toString(codes[i]);
			if(character.equals("M"))
				rover.move();
			else if(character.equals("L"))
				rover.turnLeft();
			else if(character.equals("R"))
				rover.turnRight();
		}
	}
	
	public static void main(String[] args) {
		rover = new Rover(EastDirection.DIRECTION, new Location(0, 0));
		maneuover("MMMLMMRM");
		
		System.out.println("Direction = " + rover.getDirection());
		System.out.println(rover.getLocation());
	}

}
