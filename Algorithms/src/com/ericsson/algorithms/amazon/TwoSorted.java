package com.ericsson.algorithms.amazon;

import java.util.Arrays;
import java.util.List;

public class TwoSorted {

	// find kth largest in 2 sorted arrays in log(m) + log(n)
	public static int find(int[] numbers1, int[] numbers2, int k) {

		int indexStart1 = 0;
		int indexEnd1 = numbers1.length - 1;
		int indexStart2 = 0;
		int indexEnd2 = numbers2.length - 1;

		while(true) {
			int index1 = indexStart1 + (indexEnd1 - indexStart1) / 2;
			int index2 = indexStart2 + (indexEnd2 - indexStart2) / 2;
			
			int value1 = numbers1[index1];
			int value2 = numbers2[index2];
			
			if(value1 < value2) {
				// value2 is at atleast (index1 + index2)
				// value1 is at atmost (index1 + index2 - 1)
				if(k > (index1 + index2 + 1)) {
					indexStart1 = index1 + 1;
					indexStart2 = index2;
				} else if(k < (index1 + index2 + 1)) {
					indexEnd1 = index1;
					indexEnd2 = index2 - 1;
				} else {
					return value2;
				}
			} else if(value2 < value1) {
				// value1 is at atleast (index1 + index2)
				// value2 is at atmost (index1 + index2 - 1)
				if(k > (index1 + index2 + 1)) {
					indexStart1 = index1;
					indexStart2 = index2 + 1;
				} else if(k < (index1 + index2 + 1)) {
					indexEnd1 = index1 - 1;
					indexEnd2 = index2;
				} else {
					return value1;
				}
			} else {
				if(k > (index1 + index2)) {
					indexStart1 = index1;
					indexStart2 = index2;
				} else if(k < (index1 + index2)) {
					indexEnd1 = index1;
					indexEnd2 = index2;
				} else {
					return value1;
				}
			}
		}

		
	}
	
	public static void main(String[] args) {
		
		int[] sorted1 = new int[] {1,3,5,7,9,11,13,15};
		int[] sorted2 = new int[] {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30};
//		int[] sorted1 = new int[] {1,3,5};
//		int[] sorted2 = new int[] {2,4,6};
		
		System.out.println(find(sorted1, sorted2, 5));
		
		List<Integer> list = Arrays.asList(new Integer[] {1,2});
	}
}
