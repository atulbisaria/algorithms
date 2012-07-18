package com.ericsson.algorithms.amazon;

public class EvaluateExpression {

	public static int evaluate(String expression) {
		
		char plus = "+".charAt(0);
		char minus = "-".charAt(0);
		char multiply = "*".charAt(0);
		char start = "(".charAt(0);
		char end = ")".charAt(0);
		
		String left = null;
		String right = null;
		String op = null;
		
		int indexStart = -1;
		int indexEnd = -1;
		int bracketCount = 0;
		char[] characters = expression.toCharArray();
		
		// evaluate sub-expressions
		for (int i = 0; i < characters.length; i++) {
			if(characters[i] == start) {
				if(indexStart == -1) {
					indexStart = start;
					bracketCount++;
				} 
			} else if(characters[i] == end) {
				
			}
			
			
		}
	}
}
