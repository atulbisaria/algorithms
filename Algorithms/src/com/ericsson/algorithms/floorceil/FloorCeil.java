package com.ericsson.algorithms.floorceil;

import java.util.ArrayList;
import java.util.List;

public class FloorCeil {

	public static Current floor(List<Current> sortedList, Current floor) {
		
		if(sortedList.size() == 0) 
			return null;
		
		int middle = sortedList.size() / 2;
		Current middleItem = sortedList.get(middle);
		
		int comparison = middleItem.compareTo(floor);
		if(sortedList.size() == 1){
			if(comparison == 0 || comparison > 0)
				return null;
			else
				return sortedList.get(0);
		}

		List<Current> leftList = new ArrayList<Current>();
		List<Current> rightList = new ArrayList<Current>();
		
		for (int i = 0; i < middle; i++) 
			leftList.add(sortedList.get(i));
		for (int i = middle; i < sortedList.size(); i++) 
			rightList.add(sortedList.get(i));
		
		if(comparison == 0 || comparison > 0) 
			return floor(leftList, floor);
		else
			return floor(rightList, floor);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Current> sortedList = new ArrayList<Current>();
		
		//Set<Current> sortedList = new TreeSet<Current>();
		
		sortedList.add(new Current("a"));
		sortedList.add(new Current("b"));
		sortedList.add(new Current("c"));
		sortedList.add(new Current("d"));
		sortedList.add(new Current("aa"));
		sortedList.add(new Current("bb"));
		sortedList.add(new Current("cc"));
		
		//System.out.println(sortedList);
		System.out.println(floor(sortedList, new Current("dd")));
		

	}

}
