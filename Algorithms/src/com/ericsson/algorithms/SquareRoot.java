package com.ericsson.algorithms;

public class SquareRoot {

	public static int squareRoot(int number) {

		int[] numbers = new int[number];
		for (int i = 0; i < numbers.length; i++) 
			numbers[i] = i + 1;
		
		return binarySearch(numbers, number);
	}
	
	private static int binarySearch(int[] numbers, int number) {
		
		if(numbers.length == 1)
			return numbers[0];
		
		int middle = numbers.length / 2;
		
		int[] leftNumbers = new int[middle];
		int[] rightNumbers = new int[numbers.length - middle];
		
		for (int i = 0; i < middle; i++) 
			leftNumbers[i] = numbers[i];
		for (int i = middle; i < numbers.length; i++) 
			rightNumbers[i - middle] = numbers[i];
		
		if(numbers[middle] * numbers[middle] <= number)
			return binarySearch(rightNumbers, number);
		else
			return binarySearch(leftNumbers, number);
	}

	
	public static void main(String[] args) {
		
		
		System.out.println(squareRoot(15));
		
		
	}
}
