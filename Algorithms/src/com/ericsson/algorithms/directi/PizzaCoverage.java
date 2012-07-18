package com.ericsson.algorithms.directi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PizzaCoverage {

	public static void main(String[] args) {
		
		long before = System.currentTimeMillis();
		// Input
		int numRestaurants = 2;
		int radiusOfDelivery = 2;
		
		List<Coordinate> possibleLocations = new ArrayList<Coordinate>();
//		possibleLocations.add(new Coordinate(1, 0));
//		possibleLocations.add(new Coordinate(4, 0));
//		possibleLocations.add(new Coordinate(7, 0));
		possibleLocations.add(new Coordinate(-2, 0));
		possibleLocations.add(new Coordinate(0, 1));
		possibleLocations.add(new Coordinate(3, 0));
		
		Set<Solitaire> solitaires = new HashSet<Solitaire>();
//		solitaires.add(new Solitaire(0, 0, 1));
//		solitaires.add(new Solitaire(3, 0, 7));
//		solitaires.add(new Solitaire(5, 0, 9));
//		solitaires.add(new Solitaire(8, 0, 1));
		solitaires.add(new Solitaire(-3, 1, 1));
		solitaires.add(new Solitaire(-3, 0, 1));
		solitaires.add(new Solitaire(-3, -1, 1));
		solitaires.add(new Solitaire(-2, -1, 1));
		
		solitaires.add(new Solitaire(0, 0, 3));
		solitaires.add(new Solitaire(0, 2, 1));
		solitaires.add(new Solitaire(2, 1, 3));
		solitaires.add(new Solitaire(4, 0, 2));
		
		// Iterate over all possible subsets and check if they are feasible, Choose the best amongst all such feasible sets.

		Iterator<Coordinate> iterator = possibleLocations.iterator();
		while(iterator.hasNext()) {
			iterator.next().calculateCoveredSolitaires(solitaires, radiusOfDelivery);
		}

		int max = Integer.MIN_VALUE;
		int numSubsets = 1 << possibleLocations.size();
		for (int i = 0; i < numSubsets; i++) {
			int sum = 0;
			int bitCount = 0;
			for (int j = 0; j < possibleLocations.size(); j++) {
				if((i & (1 << j)) == (1 << j)) {
					sum += possibleLocations.get(j).getCoveredSolitaires();
					bitCount++;
				}
			}
			
			if(bitCount == numRestaurants && sum > max)
				max = sum;
		}
		
		System.out.println(max);
		System.out.println("Time Taken = " + (System.currentTimeMillis() - before) + " ms");
	}

}

class Coordinate {
	private int x;
	private int y;
	private int coveredSolitaires;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCoveredSolitaires() {
		return coveredSolitaires;
	}

	public void calculateCoveredSolitaires(Set<Solitaire> solitaires, int radiusOfDelivery) {

		Iterator<Solitaire> iter = solitaires.iterator();
		while (iter.hasNext()) {
			Solitaire solitaire = (Solitaire) iter.next();
			if ((int) Math.sqrt(Math.pow((double) (x - solitaire.getX()), 2)
					+ Math.pow((double) (y - solitaire.getY()), 2)) > radiusOfDelivery)
				coveredSolitaires += solitaire.getNumberOfPeople();

		}
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

}

class Solitaire extends Coordinate {

	private int numberOfPeople;
	
	public Solitaire(int x, int y, int numberOfPeople) {
		super(x, y);
		this.numberOfPeople = numberOfPeople;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	
}
