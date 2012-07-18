package com.ericsson.algorithms.careermonk.sorting;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedElement {

	public static int findFirstRepeatedElement(int[] numbers) {
		
		Set<Integer> valueSet = new HashSet<Integer>();
		int firstRepeated = Integer.MIN_VALUE;
		for (int i = (numbers.length - 1); i >= 0; i--) {
			
			boolean successful = valueSet.add(numbers[i]);
			if(!successful)
				firstRepeated = numbers[i];
		}
		
		return firstRepeated;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] {3,2,1,2,2,3};
		System.out.println(findFirstRepeatedElement(numbers));
	}
}
