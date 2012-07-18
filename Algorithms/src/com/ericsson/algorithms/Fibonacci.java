package com.ericsson.algorithms;

public class Fibonacci {

	public static int nextHigherNumberWithSameBitCount(int x) {
		int smallest, ripple, new_smallest, ones;

		if (x == 0)
			return 0;
		smallest = (x & -x);
		ripple = x + smallest;
		new_smallest = (ripple & -ripple);
		ones = ((new_smallest / smallest) >> 1) - 1;
		return ripple | ones;
	}

	public static int countFibonacci(int low, int high) {

		int a = 0;
		int b = 1;

		int count = 0;
		while (true) {
			int N = a + b; // N is the next fibonacci number
			a = b;
			b = N;

			int numberWithNBitsSet = (1 << N) - 1;
			if (numberWithNBitsSet < high) {
				while (true) {
					if (numberWithNBitsSet > high)
						break;
					else {
						if (numberWithNBitsSet >= low
								&& numberWithNBitsSet <= high)
							count++;
						numberWithNBitsSet = nextHigherNumberWithSameBitCount(numberWithNBitsSet);
					}
				}
			} else {
				break;
			}
		}

		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 15;
		int b = 17;

		System.out.println(countFibonacci(a, b));
	}

}
