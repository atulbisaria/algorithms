package com.ericsson.algorithms.topcoder;

public class EllysXors {

	public static long getXor(long L, long R) {
		
		long result = L;
		for (long i = (L + 1); i <= R; i++) {
			result ^= i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getXor(3, 10));
	}
}
