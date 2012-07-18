package com.ericsson.algorithms.careermonk.dynamic;

public class ZeroOneKnapsack {

	// Think from thief picking up max value items perspective
	// M[i][0] = 0;
	// M[i][j] = M[i - 1][j] if s[i] > j
	// M[i][j] = max {M[i - 1][j], M[i - 1][j - s[i]] + v[i]} if s[i] <= j
	public static void findMaxValueCombination(int[] s, int[] v, int C) {
		
		int n = v.length;
		int[][] M = new int[n][C]; 
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= C; j++) {
				if(s[i] > j) 
					M[i][j] = M[i - 1][j];
				else 
					M[i][j] = Math.max(M[i - 1][j], M[i - 1][j - s[i]] + v[i]);
			}
		}
		
		int maxValue = 0;
		for (int j = 0; j < C; j++) {
			if(M[n - 1][j] > maxValue)
				maxValue = M[n - 1][j];
		}
		
		System.out.println(maxValue);
	}
}
