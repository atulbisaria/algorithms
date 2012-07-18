package com.ericsson.algorithms.amazon;

import java.util.Arrays;

public class Problem1 {

	public static void findMissingAndDuplicate(int[] array) {
		
		int N = 0;
		int S = 0;
		for (int i = 0; i < array.length; i++) {
			N ^= (i + 1);
			S ^= array[i];
		}
		
		int C = N ^ S;
		
		//Arrays.sort(a)
		
		System.out.println("Missing = " + (C ^ 4));
		System.out.println("Duplicate = " + (C ^ 6));
	}
	
	/**
	 * Given a 10GB file of integers and a RAM that can hold only 4GB values, 
	 * how would you sort the integers in the file.
	 */
	public static void main(String[] args) {

		int[] array = new int[] {1,2,3,4,5,4,7};
		
		findMissingAndDuplicate(array);
//		int a = 7;
//		int b = 19;
//		int c = 12;
//		
//		int x = a ^ b ^ c;
//		System.out.println(x);
//		x = x ^ b;
//		System.out.println(x);
//		x = x ^ c;
//		System.out.println(x);

	}

}
