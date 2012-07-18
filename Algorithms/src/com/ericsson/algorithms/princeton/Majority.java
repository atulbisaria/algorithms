package com.ericsson.algorithms.princeton;

public class Majority {

	public static String majority(String[] strings) {
		
		int count = 0;
		String major = null;
		
		for (int i = 0; i < strings.length; i++) {
			if(count == 0)
				major = strings[i];
			else if(major.equals(strings[i]))
				count++;
			else
				count--;
			
		}
		
		if(count > strings.length / 2)
			return null;
		return major;
	}
	
	public static void main(String[] args) {
		
		String[] strings = new String[] {"a", "a", "b", "c", "a", "d", "d", "d", "a", "f", "b", "b", "b", "b", "a", "a", "a", "a", "a", "a", "a"};
		System.out.println(strings.length);
		
		System.out.println(majority(strings));
	}
}
