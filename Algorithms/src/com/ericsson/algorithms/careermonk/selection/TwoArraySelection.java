package com.ericsson.algorithms.careermonk.selection;

public class TwoArraySelection {

	public static int findMedianTwoSorted(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
		
		int middleA = startA + (endA - startA) >> 1;
		int middleB = startB + (endB - startB) >> 1;
		
		if((middleA + middleB) == (k - 1)) {
			if(A[middleA] <= B[middleB])
				return A[middleA];
			else
				return B[middleB];
		}
		
		if(A[middleA] < B[middleB]) {
			return findMedianTwoSorted(A, middleA, endA, B, startB, middleB, k);
		} else if(A[middleA] < B[middleB]) {
			return findMedianTwoSorted(A, startA, middleA, B, middleB, endB, k);
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		int[] A = new int[] {1,3,5,7,9};
		int[] B = new int[] {2,4,6,8,10};
		
		int k = 2;
		int end = (k > A.length ? A.length - 1 : k);
		
		System.out.println(findMedianTwoSorted(A, 0, end, B, 0, end, k));
	}
}
