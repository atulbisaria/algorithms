package com.ericsson.algorithms.careermonk.searching;

public class FindInRotated {

	// 6,7,8,9,10,1,2,3,4,5
	public static boolean find(int[] n, int F, int start, int end) {
		
		int middle = -1;
		while(start < end && (end - start) > 1) {
			middle = start + ((end - start) >> 1);
			if(n[middle] == F)
				return true;
			else {
				if(n[start] > n[end]) { // we are still in rotated part
					if(F < n[end]) {
						start = middle;
					} else {
						end = middle;
					}
				} else { // we are in sorted part
					if(F > n[middle]) {
						start = middle;
					} else {
						end = middle;
					}
				}
			}
		}
		
		if(n[start] == F || n[end] == F)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] n = new int[] {6,7,8,9,10,1,2,3,4,5};
		
		System.out.println(find(n, 10, 0, n.length - 1));
	}
}
