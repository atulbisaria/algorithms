package com.ericsson.algorithms.careermonk.dynamic;

public class DuplicateKnapsack {

	// M[i] = max {v[j] + M[i - s[j]}
	public static void findMaxValueCombination(int[] s, int[] v, int C) {
		
		int[] M = new int[C];
		M[0] = 0;
		int max = M[0];
		for (int i = 0; i < C; i++) {
			max = 0;
			for (int j = 0; j < v.length; j++) {
				int value = v[j] + M[i - s[j]];
				if(value >= max)
					max = value;
			}
			
			M[i] = max;
		}
	}
}
