package com.ericsson.algorithms;

public class ClosestPair {

	
	public static int[] closestPair(int[] numbers) {
		
		if(numbers.length <= 1)
			return null;
		else if(numbers.length == 2)
			return numbers;
		else if(numbers.length == 3) {
			int value1 = 0;
			int value2 = 0;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < 3; i++) {
				for (int j = (i + 1); j < numbers.length; j++) {
					if(Math.abs(numbers[i] - numbers[j]) < min) {
						min = Math.abs(numbers[i] - numbers[j]);
						value1 = numbers[i];
						value2 = numbers[j];
					}
				}
			}
			
			return new int[]{value1, value2};
		}
		else {
			int middle = numbers.length / 2;
			
			int[] left = new int[middle];
			int[] right = new int[numbers.length - middle];
			
			for (int i = 0; i < middle; i++) 
				left[i] = numbers[i];
			for (int i = middle; i < numbers.length; i++) 
				right[i - middle] = numbers[i];
			
			int[] leftClosestPair = closestPair(left);
			int[] rightClosestPair = closestPair(right);
			
			if(Math.abs(leftClosestPair[0] - leftClosestPair[1]) < Math.abs(rightClosestPair[0] - rightClosestPair[1])) 
				return leftClosestPair;
			
			return rightClosestPair;
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		int[] numbers = new int[]{1,3,5,6,11,18,20};
		
		int[] closest = closestPair(numbers);
		System.out.println(closest[0] + " and " + closest[1]);
	}

}
