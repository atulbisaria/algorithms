package com.ericsson.algorithms.careermonk.searching;

import java.util.Arrays;

public class SumClosestToZero {

	public static void print(int[] n) {
		
		Arrays.sort(n);
		
		int start = 0;
		int end = n.length - 1;
		
		int minSum = Integer.MAX_VALUE;
		int negative = n[start];
		int positive = n[end];
		
		while(start < end) {
			int sum = n[start] + n[end];
			if(Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				negative = start;
				positive = end;
			}
			
			if(sum < 0) 
				end--;
			else if(sum > 0)
				start++;
			else break;
		}
		
		System.out.println("Numbers are: " + n[negative] + " and " + n[positive]);
	}
	
	public static void main(String[] args) {
		int[] n = new int[] {1, 60, -10, 70, -80, 85};
		
		print(n);
	}
}
