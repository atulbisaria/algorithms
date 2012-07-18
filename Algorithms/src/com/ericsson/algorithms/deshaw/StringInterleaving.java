package com.ericsson.algorithms.deshaw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class StringInterleaving {

	public static boolean isInterleaved(String interleaved, String a, String b) {

		int aIndex = -1;
		int bIndex = -1;

		char DUMMY = (char) -1;

		int commonCount = 0;
		Queue<Character> q = new LinkedBlockingQueue<Character>();

		for (int i = 0; i < interleaved.length(); i++) {
			char next = interleaved.charAt(i);
			char aNext = aIndex + 1 < a.length() ? a.charAt(aIndex + 1) : DUMMY;
			char bNext = bIndex + 1 < b.length() ? b.charAt(bIndex + 1) : DUMMY;

			if (aNext != DUMMY && bNext != DUMMY && next == aNext
					&& next == bNext) {
				aIndex++;
				bIndex++;
				q.add(next);
				commonCount++;
			} else if (aNext != DUMMY && next == aNext) {
				aIndex++;
				bIndex = bIndex - commonCount;
				if (commonCount > 0) {
					commonCount = 0;
					q.clear();
				}
			} else if (bNext != DUMMY && next == bNext) {
				bIndex++;
				aIndex = aIndex - commonCount;
				if (commonCount > 0) {
					commonCount = 0;
					q.clear();
				}
			} else {
				if (aNext == DUMMY && bNext == DUMMY) {
					if (q.isEmpty() || next != q.poll())
						return false;
				} else {
					if (!q.isEmpty()) {
						q.poll();
						commonCount--;
					} else
						return false;
				}
			}
		}

		return q.isEmpty() && aIndex == a.length() - 1
				&& bIndex == b.length() - 1;
	}

	public static void main(String[] args) {

		String A = "abc";
		String B = "axy";
		// System.out.println(A.substring(0, A.length() - 1));
		// String I = "abcaxy";

		// String I = "abacxy";
		String I = "aabcxy";

		// String A= "aabccabc";
		// String B = "dbbabc";
		//
		// String I = "aabdbbccababcc";

		// String A= "abc";
		// String B = "abc";
		//
		// String I = "ababcc";

		// String A= "abc";
		// String B = "abc";
		//
		// String I = "abcabc";

		LinkedList<Character> iList = new LinkedList<Character>();
		for (int j = 0; j < I.length(); j++) {
			iList.addLast(I.charAt(j));
		}

		LinkedList<Character> aList = new LinkedList<Character>();
		for (int j = 0; j < A.length(); j++) {
			aList.addLast(A.charAt(j));
		}

		LinkedList<Character> bList = new LinkedList<Character>();
		for (int j = 0; j < B.length(); j++) {
			bList.addLast(B.charAt(j));
		}

		System.out.println(isInterleaved(I, A, B));
	}
}
