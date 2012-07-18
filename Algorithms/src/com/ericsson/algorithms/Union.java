package com.ericsson.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Union {

	public static boolean merge(Integer[] one, Integer[] two) {
		
		Integer[] leftRange = one.get(0);
		Integer[] rightRange = two.get(0);
	}
	
	public static List<Integer[]> union(List<Integer[]> ranges) {

//		if(ranges.size() <= 1)
//			return ranges;
//		
//		Integer[] firstRange = ranges.remove(0);
//		
//		boolean addFirstRange = false;
//		List<Integer[]> remainingUnion = union(ranges);
//		for (int i = 0; i < remainingUnion.size(); i++) {
//			
//		}
		
		if(ranges.size() <= 1)
			return ranges;
		
		int middle = ranges.size() / 2;
		
		List<Integer[]> leftRanges = new ArrayList<Integer[]>();
		List<Integer[]> rightRanges = new ArrayList<Integer[]>();
		
		for (int i = 0; i < middle; i++) 
			leftRanges.add(ranges.get(i));
		for (int i = middle; i < ranges.size(); i++) 
			rightRanges.add(ranges.get(i));
		
		List<Integer[]> unionLeft = union(leftRanges);
		List<Integer[]> unionRight = union(rightRanges);
		
		for (int i = 0; i < unionLeft.size(); i++) {
			
		}
		
		
		
//		if(leftRanges.size() == 1 && rightRanges.size() == 1) {
//			Integer[] leftRange = leftRanges.get(0);
//			Integer[] rightRange = rightRanges.get(0);
//			
//			if(leftRange[0] < rightRange[0]) {
//				if(leftRange[1] < rightRange[0]) {
//					List<String[]> union = new ArrayList<String[]>();
//					union
//				}
//					return 
//					
//			}
//		}
//			return leftRanges;
//		if(rightRanges.size() <= 1)
//			return rightRanges;
		
		//return union(leftRanges) + union(rightRanges);

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
