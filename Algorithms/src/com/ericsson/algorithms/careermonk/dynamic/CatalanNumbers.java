package com.ericsson.algorithms.careermonk.dynamic;

public class CatalanNumbers {

	public static int findCatalanNumber(int n) {
		
		int[] T = new int[n + 1];
		T[0] = T[1] = 1;
		for (int i = 2; i < (n + 1); i++) {
			for (int j = 0; j < i; j++) {
				T[i] += T[i - j - 1] * T[j];
			}
		}
		
		return T[n];
	}
	
	public static void main(String[] args) {
		
		System.out.println(findCatalanNumber(7));
	}
}
