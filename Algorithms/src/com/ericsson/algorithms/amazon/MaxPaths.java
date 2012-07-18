package com.ericsson.algorithms.amazon;

public class MaxPaths {

	public static int maxPaths(int x1, int x2, int y1, int y2) {
		
		if(x1 == x2 && y1 == y2)
			return 1;
		else if(x1 == x2 || y1 == y2)
			return 1;
		
		return 2 * maxPaths(x1, x2 - 1, y1, y2 - 1) + (x2 - x1) + (y2 - y1) - 2;
	}
	
	public static void main(String[] args) {
		
		System.out.println(maxPaths(0, 3, 0, 2));
		System.gc();
	}
}
