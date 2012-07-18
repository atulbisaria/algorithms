package com.ericsson.algorithms;

public class Problem1 {

	public static int find(int n) {
		
		if(n == 1)
			return 1;
		
		boolean isEven = (n % 2 == 0);

		if(isEven)
			return 2 * find(n / 2);
		else {
			int next = n / 2;
			boolean isPowerOfTwo = (next != 0 && (next & (next - 1)) == 0);
			int a = (isPowerOfTwo ? 0 : 2);
			
			return a * find(next) + 2;
		}
			
	}
	
	public static void main(String[] args) {
		System.out.println(find(17));

	}
}
