package com.ericsson.algorithms.directi;

import java.util.ArrayList;
import java.util.List;

public class Mkuhar {

	public static void main(String[] args) {
		
		int money = 100;
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Ingredient(10, 8, 10, 10, 13, 11));
		ingredients.add(new Ingredient(12, 20, 6, 10, 17, 24));
		
		int mealsServed = 0;
		while(money >= 0) {
			
		}

		System.out.println(mealsServed);
	}
}

class Ingredient {
	
	private int amountNeeded;
	private int amountAlreadyPresent;
	
	private int smallPackageSize;
	private int smallPackageCost;
	private int largePackageSize;
	private int largePackageCost;
	
	public Ingredient(int amountNeeded, int amountAlreadyPresent,
			int smallPackageSize, int smallPackageCost, int largePackageSize,
			int largePackageCost) {
		this.amountNeeded = amountNeeded;
		this.amountAlreadyPresent = amountAlreadyPresent;
		this.smallPackageSize = smallPackageSize;
		this.smallPackageCost = smallPackageCost;
		this.largePackageSize = largePackageSize;
		this.largePackageCost = largePackageCost;
	}

	public int getAmountNeeded() {
		return amountNeeded;
	}

	public int getAmountAlreadyPresent() {
		return amountAlreadyPresent;
	}

	public int getSmallPackageSize() {
		return smallPackageSize;
	}

	public int getSmallPackageCost() {
		return smallPackageCost;
	}

	public int getLargePackageSize() {
		return largePackageSize;
	}

	public int getLargePackageCost() {
		return largePackageCost;
	}

}
