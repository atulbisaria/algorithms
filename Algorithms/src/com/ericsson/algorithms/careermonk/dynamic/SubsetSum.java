package com.ericsson.algorithms.careermonk.dynamic;


public class SubsetSum {

	public static boolean isSubsetSumPresent(int[] n, int T) {
		
		boolean[][] M = new boolean[n.length][T + 1];

		for (int i = 1; i < n.length; i++) {
			for (int j = 0; j <= T; j++) {
				if(n[i] > j)
					M[i][j] = M[i - 1][j];
				else if(n[i] < j)
					M[i][j] = M[i - 1][j] || M[i - 1][j - n[i]];
				else
					M[i][j] = true;
			}
		}
		
		return M[n.length - 1][T];
	}
	
	public static boolean isSubsetSumPresent(int[] n, int T, int start, int end) {
		
		if(start == end)
			return n[start] == T;
		
		int sum = 0;
		for (int i = 0; i <= start; i++) {
			sum += n[i];
		}
		
		boolean isPresent = isSubsetSumPresent(n, T - sum, start + 1, end);
		start++;
		return isPresent;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] {5, 11, 3, 9, 7};
		
		System.out.println(isSubsetSumPresent(numbers, 16, 0, numbers.length - 1));
		
		
	}
}
