package com.ericsson.algorithms.directi;

public class Notatri {

	public static void main(String[] args) {
		
//		int numSticks = 4;
//		int[] sizes = new int[] {5, 2, 9, 6};
		int numSticks = 3;
		int[] sizes = new int[] {4, 2, 10};
		
		int numSubsets = 1 << numSticks;
		int count = 0;
		for (int i = 0; i < numSubsets; i++) {
			int[] sides = new int[3];
			int k = 0;
			int bitCount = 0;
			for (int j = 0; j < numSticks; j++) {
				if ((i & (1 << j)) == (1 << j)) {
					if(bitCount < 3)
						sides[k++] = sizes[j];
					bitCount++;
				}
			}

			if (bitCount == 3
					&& !(sides[0] + sides[1] >= sides[2]
							&& sides[1] + sides[2] >= sides[0] && sides[0]
							+ sides[2] >= sides[1])) {
				count++;
			}
				
		}
		
		System.out.println(count);
	}

}
