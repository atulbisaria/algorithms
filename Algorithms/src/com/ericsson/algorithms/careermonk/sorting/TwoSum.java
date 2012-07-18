package com.ericsson.algorithms.careermonk.sorting;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

	public static boolean twoSumExists(int[] A, int[] B, int k) {
		Set<Integer> integerSet = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; i++) 
			integerSet.add(k - A[i]);
		
		for (int i = 0; i < B.length; i++) {
			if(integerSet.contains(B[i]))
				return true;
		}
		
		return false;
	}
}
