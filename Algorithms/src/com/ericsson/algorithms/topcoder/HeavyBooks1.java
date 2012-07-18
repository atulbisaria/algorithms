package com.ericsson.algorithms.topcoder;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.AbstractList;
import java.util.Collections;

/**
 * Built using CHelper plug-in Actual solution is at the top
 * 
 * @author Egor Kulikov (egor@egork.net)
 */
public class HeavyBooks1 {

	public static int[] findWeight(int[] books, int[] moves) {
		int[] who = new int[moves[0]];
		Arrays.fill(who, 1);
		for (int i = 1; i < moves.length; i++) {
			int moveTo = i % 2 == 1 ? -1 : 1;
			int remainingMoves = moves[i];
			for (int j = 0; j < who.length && remainingMoves != 0; j++) {
				if (who[j] != moveTo) {
					who[j] = moveTo;
					remainingMoves--;
				}
			}
		}
		Collections.sort(Array.wrap(books), new ReverseComparator<Integer>());
		int[][] resultSum = new int[books.length + 1][who.length + 1];
		int[][] resultDifference = new int[books.length + 1][who.length + 1];
		ArrayUtils.fill(resultDifference, Integer.MIN_VALUE);
		resultDifference[0][0] = 0;
		resultSum[0][0] = 0;
		for (int i = 0; i < books.length; i++) {
			for (int j = 0; j <= i && j <= who.length; j++) {
				if (resultDifference[i + 1][j] < resultDifference[i][j]
						|| resultDifference[i + 1][j] == resultDifference[i][j]
						&& resultSum[i + 1][j] < resultSum[i][j]) {
					resultDifference[i + 1][j] = resultDifference[i][j];
					resultSum[i + 1][j] = resultSum[i][j];
				}
				if (j < who.length
						&& (resultDifference[i + 1][j + 1] < resultDifference[i][j]
								+ who[j] * books[i] || resultDifference[i + 1][j + 1] == resultDifference[i][j]
								+ who[j] * books[i]
								&& resultSum[i + 1][j + 1] < resultSum[i][j]
										+ books[i])) {
					resultDifference[i + 1][j + 1] = resultDifference[i][j]
							+ who[j] * books[i];
					resultSum[i + 1][j + 1] = resultSum[i][j] + books[i];
				}
			}
		}
		int tomek = (resultSum[books.length][who.length] - resultDifference[books.length][who.length]) / 2;
		int wojtek = resultSum[books.length][who.length] - tomek;
		return new int[] { tomek, wojtek };
	}
	
	public static void main(String[] args) {
		
		int[] weights = findWeight(new int[]{5,2,3,1}, new int[]{3,2,1,1,1});
		
		System.out.println(weights[0] + ", " + weights[1]);
	}

}

abstract class Array<T> extends AbstractList<T> {

	public static List<Integer> wrap(int... array) {
		return new IntArray(array);
	}

	protected static class IntArray extends Array<Integer> {
		protected final int[] array;

		protected IntArray(int[] array) {
			this.array = array;
		}

		public int size() {
			return array.length;
		}

		public Integer get(int index) {
			return array[index];
		}

		public Integer set(int index, Integer value) {
			int result = array[index];
			array[index] = value;
			return result;
		}
	}

}

class ReverseComparator<T extends Comparable<T>> implements Comparator<T> {
	public int compare(T o1, T o2) {
		return o2.compareTo(o1);
	}
}

class ArrayUtils {

	public static void fill(int[][] array, int value) {
		for (int[] row : array)
			Arrays.fill(row, value);
	}

}
