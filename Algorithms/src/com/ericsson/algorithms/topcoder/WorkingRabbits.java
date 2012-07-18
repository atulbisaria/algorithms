package com.ericsson.algorithms.topcoder;

public class WorkingRabbits {

	public static double getEfficiency(String[] profit) {
		
		if(profit == null || profit.length == 1)
			return 0.0;
		
		int n = profit.length;
		int numPairs = (n * (n - 1)) >> 1;
		
		int totalEfficiency = 0;
		int start = 1;
		for (int i = 0; i < n; i++) {
			int pointer = start;
			while(pointer < n) {
				totalEfficiency += profit[i].charAt(pointer) - 48;
				pointer++;
			}
			start++;
		}
		
		return (double)totalEfficiency / (double)numPairs;
	}
	
	public static void main(String[] args) {
		
		String[] profit = { "06390061", 
				  "60960062", 
				  "39090270", 
				  "96900262", 
				  "00000212", 
				  "00222026", 
				  "66761201", 
				  "12022610" };
		
		System.out.println(getEfficiency(profit));
	}
}
