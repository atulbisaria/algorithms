package com.ericsson.algorithms.careermonk.searching;

public class IncreasingDecreasing {

	public static int find(int[] n, int start, int end) {
		
		int middle = -1;
		
		while(start < end && (end - start) > 1) {
			middle = start + ((end - start) >> 1);
			if(n[middle + 1] < n[middle] && n[middle - 1] < n[middle])
				return middle;
			else {
				if(n[middle + 1] > n[middle] && n[middle - 1] < n[middle]) {
					start = middle;
				} else {
					end = middle;
				}
			}
		}

		return middle;
	}
	
	public static void main(String[] args) {
		int[] n = new int[] {10,20,19};
		
		System.out.println(find(n, 0, n.length - 1));
	}
}
