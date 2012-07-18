package com.ericsson.algorithms.amazon;

import java.util.Stack;

public class Add {

	public static String add(String A, String B) {

		if (A != null && B != null) {
			int index = 0;
			int aSize = A.length();
			int bSize = B.length();

			Stack<Integer> stack = new Stack<Integer>();

			int carry = 0;
			while (index < aSize || index < bSize) {
				int aNumber = 0;
				int bNumber = 0;

				if (index < aSize)
					aNumber = Integer.parseInt(String.valueOf(A.charAt(aSize
							- index - 1)));
				if (index < bSize)
					bNumber = Integer.parseInt(String.valueOf(B.charAt(bSize
							- index - 1)));

				int result = aNumber + bNumber + carry;
				if (result >= 10) {
					stack.add(result - 10);
					carry = 1;
				} else {
					stack.add(result);
					carry = 0;
				}

				index++;
			}

			if (carry == 1)
				stack.add(carry);

			StringBuilder builder = new StringBuilder();
			while (!stack.isEmpty()) {
				builder.append(stack.pop());
			}

			return builder.toString();
		}

		return null;
	}

	public static void main(String[] args) {

		String a = "1111";
		String b = "9999";

		System.out.println(add(a, b));
	}
}
