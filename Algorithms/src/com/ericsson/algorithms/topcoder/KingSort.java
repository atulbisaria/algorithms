package com.ericsson.algorithms.topcoder;

import java.util.Arrays;

public class KingSort {

	public static String[] getSortedList(String[] kings) {
		
		if(kings == null)
			return null;
		
		String[] sortedKings = new String[kings.length];
		
		ExtendedString[] kingsNew = new ExtendedString[kings.length];
		for (int i = 0; i < kingsNew.length; i++) 
			kingsNew[i] = new ExtendedString(kings[i]);
		
		Arrays.sort(kingsNew);
		
		for (int i = 0; i < kingsNew.length; i++) {
			sortedKings[i] = kingsNew[i].getValue();
			System.out.print(sortedKings[i] + ", ");
		}

		return sortedKings;
	}
	
	public static void main(String[] args) {
		
		getSortedList(new String[] {"Philippe 9", "Philippe 2"});
	}
}

class ExtendedString implements Comparable<ExtendedString> {

	private String value;

	public ExtendedString(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int compareTo(ExtendedString o) {
		
		String name = value.substring(0, value.lastIndexOf(" "));
		String oName = o.getValue().substring(0, o.getValue().lastIndexOf(" "));
		
		int nameComparison = name.compareTo(oName);
		if(nameComparison != 0)
			return nameComparison;
		
		int number = Integer.valueOf(value.substring(value.lastIndexOf(" ") + 1, value.length()));
		int oNumber = Integer.valueOf(o.getValue().substring(o.getValue().lastIndexOf(" ") + 1, o.getValue().length()));
		
		return number - oNumber;
	}
	
}