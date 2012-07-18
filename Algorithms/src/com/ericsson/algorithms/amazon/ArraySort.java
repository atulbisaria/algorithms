package com.ericsson.algorithms.amazon;

public class ArraySort {

	private int[] A;
	
	public int get(int index) {
		return A[index];
	}
	
	public void reverse(int start, int end) {
		while(start <= end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			
			start++;
			end--;
		}
	}
	
	public void sort() {
		
	}
}
