package com.ericsson.algorithms.careermonk.dynamic;

public class MaximumValueSubsequence {
	
	public static void findMaximumValueSubsequence(int[] N) {
		
		int[] start = new int[N.length];
		int[] sum = new int[N.length];
		
		sum[0] = N[0];
		int maxSum = sum[0];
		int maxEnd = 0;
		for (int i = 1; i < N.length; i++) {
			
			if(sum[i - 1] >= 0) {
				start[i] = start[i - 1];
				sum[i] = sum[i - 1] + N[i];
			}
			else {
				start[i] = i;
				sum[i] = N[i];
			}
			
			if(sum[i] > maxSum) {
				maxSum = sum[i];
				maxEnd = i;
			}
		}
		
		for (int i = start[maxEnd]; i <= maxEnd; i++) {
			System.out.print(N[i] + ", ");
		}
	}
	
	public static void findMaximumValueSubsequenceTwoDiscontinuous(int[] N) {
		
		int[] start = new int[N.length];
		int[] sum = new int[N.length];
		
		sum[0] = N[0];
		sum[1] = N[1];
		start[1] = 1;
		int maxSum = (sum[0] >= sum[1] ? sum[0] : sum[1]);
		int maxEnd = 0;
		for (int i = 2; i < N.length; i++) {
			
			if(sum[i - 2] >= 0) {
				start[i] = start[i - 2];
				sum[i] = sum[i - 2] + N[i];
			}
			else {
				start[i] = i;
				sum[i] = N[i];
			}
			
			if(sum[i] > maxSum) {
				maxSum = sum[i];
				maxEnd = i;
			}
		}
		
		for (int i = start[maxEnd]; i <= maxEnd; i = i + 2) {
			System.out.print(N[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] {-2, 11, -4, 13, -5, 2};
		//int[] numbers = new int[] {1, -3, 4, -2, -1, 6};
		//findMaximumValueSubsequence(numbers);
		findMaximumValueSubsequenceTwoDiscontinuous(numbers);
	}
}
