package com.ericsson.algorithms.directi;

public class Sqrt {

	
	public static double sqrt(int n) {
		
		double low = 0;
		double high = Integer.MAX_VALUE;
		
		double precision = Math.pow(10.0, -9);
		
		while(high - low > precision) {
			double mid = low + (high - low) / 2;
			double square = mid * mid;
			
			if(square > n) 
				high = mid;
			else if(square < n) 
				low = mid;
			else return mid;
		}
		
		return low;
	}
	
	public static void main(String[] args) {
		
		System.out.println(sqrt(16));

	}

}
