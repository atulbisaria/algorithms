package com.ericsson.algorithms.careermonk.searching;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

	public static void printTwoSum(int[] n, int k) {
		
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < n.length; i++) {
			if(!s.contains(n[i])) {
				s.add(k - n[i]);
			}
			else {
				System.out.println("Numbers are: " + n[i] + " and " + (k - n[i]));
				break;
			}
				
		}
	}
	
	public static void main(String[] args) {
		int[] n = new int[] {1,4,8,2};
		
		printTwoSum(n, 9);
	}
}
