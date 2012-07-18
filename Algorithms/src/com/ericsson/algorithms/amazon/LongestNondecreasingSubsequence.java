package com.ericsson.algorithms.amazon;

import java.util.Arrays;

public class LongestNondecreasingSubsequence {

	public static void longestNondecreasingSubsequence(int[] numbers) {
		
		int[] longestSequenceLength = new int[numbers.length];
		int[] prevIndex = new int[numbers.length];
		
		Arrays.fill(longestSequenceLength, 1);
		Arrays.fill(prevIndex, -1);
		
		int maxLength = 1;
		int longestSequenceEnd = 0;
		
		for (int i = 1; i < numbers.length; i++) {
			int length = 1;
			int prev_index = -1;
			
			for (int j = 0; j < i; j++) {
				if(numbers[j] <= numbers[i] && length < (longestSequenceLength[j] + 1)) {
					length = longestSequenceLength[j] + 1;
					prev_index = j;
				}
			}
			
			longestSequenceLength[i] = length;
			prevIndex[i] = prev_index;
			
			if(length > maxLength) {
				maxLength = length;
				longestSequenceEnd = i;
			}
		}
		
		System.out.println("longestSequenceEnd = " + longestSequenceEnd + " -- maxLength = " + maxLength);
	}
	
	public static void main(String[] args) {
		longestNondecreasingSubsequence(new int[] {2,1,5,4,3,10,9,8,11,15,14});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void longest(int[] numbers) {
		
		int finalStartIndex = 0;
		int finalEndIndex = 0;
		int startIndex = 0;
		
		for (int i = 1; i < numbers.length; i++) {
			if(numbers[i] < numbers[i - 1]) {
				startIndex = i;
			} 
			
			if(i - startIndex > finalEndIndex - finalStartIndex) {
				finalStartIndex = startIndex;
				finalEndIndex = i;
			}
		}
		
		for (int i = finalStartIndex; i <= finalEndIndex; i++) {
			System.out.print(numbers[i] + ", ");
		}
	}
	

}
