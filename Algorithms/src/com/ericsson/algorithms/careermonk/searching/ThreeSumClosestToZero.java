package com.ericsson.algorithms.careermonk.searching;

import java.util.Arrays;

public class ThreeSumClosestToZero {

	public static void find(int[] n) {
		
		Arrays.sort(n);
		
		int minSum = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i <= n.length - 3; i++) {
			int start = i + 1;
			int end = n.length - 1;
			while(start < end) {
				int sum = n[i] + n[start] + n[end];
				if(Math.abs(sum) < minSum) {
					minSum = Math.abs(sum);
					a = i;
					b = start;
					c = end;
				}
			}
		}
	}
}
