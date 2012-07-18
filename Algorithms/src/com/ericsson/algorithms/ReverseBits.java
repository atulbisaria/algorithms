package com.ericsson.algorithms;

public class ReverseBits {

	public static int reverseBits(int a) {
		
		int low = 0;
		int high = 31;
		
		while(low < high) {
			
			int lowNumber = 1 << low;
			int highNumber = 1 << high;
			
			if((a & lowNumber) != (a & highNumber)) {
				a = (a ^ lowNumber ^ highNumber);
			}
			
			low++;
			high--;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		
		int a = 99;
		
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(reverseBits(a)));
	}
}
