package com.ericsson.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ArraySum {

	public static boolean isSumPresent(int[] sortedArray, int SUM) {
		
		Set<Integer> hashSet = new HashSet<Integer>();
		
		for (int i = 0; i < sortedArray.length; i++) {
			if(hashSet.contains(sortedArray[i]))
				return true;
			hashSet.add(SUM - sortedArray[i]);
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		

	}

}
