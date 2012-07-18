package com.ericsson.algorithms;

import java.util.HashSet;

public class PairSum {


	public static boolean exists(int[] sortedArray, int sum) {
		HashSet<Integer> table = new HashSet<Integer>();
		
		for (int i = 0; i < sortedArray.length; i++) {
			int complement = sum - sortedArray[i];
			table.add(sortedArray[i]);
			if(table.contains(complement))
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		

	}

}
