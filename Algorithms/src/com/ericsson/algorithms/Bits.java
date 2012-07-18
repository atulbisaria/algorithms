package com.ericsson.algorithms;

import java.util.LinkedHashMap;

public class Bits {

	public static void main(String[] args) {

		int y = (1 << 29);
		System.out.println(y);
		int b = 9;
		
		System.out.println("0 - y = " + Integer.toBinaryString(y));
		
		y = y | (y >> 1);
		System.out.println("1 - y = " + Integer.toBinaryString(y));
		y = y | (y >> 2);
		System.out.println("2 - y = " + Integer.toBinaryString(y));
		y = y | (y >> 4);
		System.out.println("3 - y = " + Integer.toBinaryString(y));
		y = y | (y >> 8);
		System.out.println("4 - y = " + Integer.toBinaryString(y));
		y = y | (y >> 16);
		System.out.println("5 - y = " + Integer.toBinaryString(y));
		
		y =  ( y + 1 ) >> 1;
		System.out.println("MSB = " + Integer.toBinaryString(y));
		

//		System.out.println("a = " + Integer.toBinaryString(a));
//		System.out.println("a - 1 = " + Integer.toBinaryString(a - 1));
//		//System.out.println("b = " + Integer.toBinaryString(b));
//		System.out.println("x&(x-1) = " + Integer.toBinaryString(a & (a - 1)));
//		System.out.println("x^(x&(x-1)) = " + Integer.toBinaryString(a ^ (a & (a - 1))));
	}

}
