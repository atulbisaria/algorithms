package com.ericsson.algorithms;

public class DivisibleByThree {

	public static boolean isDivisibleByThree(int n) {
		
		if(n == 0)
			return true;
		else if(n == 1)
			return false;
		
		// find if least significant bit is 1
		if((n & 1) == 1) 
			return isDivisibleByThree(((n ^ 1) >> 1) - 1);
		else {
			while((n & 1) != 1) 
				n = n >> 1;
			return isDivisibleByThree(n);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isDivisibleByThree(9));
		
		System.out.println(Integer.toBinaryString(27));

	}

}
