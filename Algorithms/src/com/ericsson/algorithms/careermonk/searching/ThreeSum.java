package com.ericsson.algorithms.careermonk.searching;

import java.util.Arrays;

public class ThreeSum {

	public static void printThreeSum(int[] n, int T) {
		
		Arrays.sort(n);
		
		for (int i = 0; i <= n.length - 3; i++) {
			int start = i + 1;
			int end = n.length - 1;
			while(start < end) {
				if(n[i] + n[start] + n[end] == T) {
					System.out.println("Numbers are: " + n[i] + ", " + n[start] + ", " + n[end]);
					return;
				} else if(n[i] + n[start] + n[end] > T) {
					end--;
				} else 
					start++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] n = new int[] {1,5,6,9,15};
		
		printThreeSum(n, 14);
	}
}
