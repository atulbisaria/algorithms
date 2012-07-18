package com.ericsson.algorithms.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestUniqueSubstring {
	private static int[] present = new int[128];

	private static void clearPresent() {
		Arrays.fill(present, -1);
	}

	public static String getLargestUniqueString(String str) {
		String output = "";
		clearPresent();
		int lastStartPosition = 0;
		int maxStartPosition = 0;
		int maxEndPosition = 0;
		// store presence of a particular character in substring
		// start with 1 position 1
		int iterator = 1;
		present[str.charAt(0)] = 0;
		while (iterator < str.length()) {
			// if this character present in last longest substring
			int presentIndex = present[str.charAt(iterator)];
			if (presentIndex > -1 && presentIndex >= lastStartPosition) {
				lastStartPosition = presentIndex + 1;
			}
			
			present[str.charAt(iterator)] = iterator;
			if (iterator - lastStartPosition > maxEndPosition
					- maxStartPosition) {
				maxEndPosition = iterator;
				maxStartPosition = lastStartPosition;
			}
			iterator++;
		}
		output = str.substring(maxStartPosition, maxEndPosition + 1);
		return output;

	}
	
	public static String longestUniqueSubstring1(String input) {
		
		Map<Character, Integer> charPositionMap = new HashMap<Character, Integer>();
		
		int finalStartIndex = 0;
		int finalEndIndex = 0;
		int startIndex = 0;
		
		for (int i = 1; i < input.length(); i++) {
			Integer position = charPositionMap.get(input.charAt(i));
			if(position != null && position >= finalStartIndex) {
				startIndex = position + 1;
			}
			
			charPositionMap.put(input.charAt(i), i);
			if(i - startIndex > finalEndIndex - finalStartIndex) {
				finalStartIndex = startIndex;
				finalEndIndex = i;
			}
		}
		
		return input.substring(finalStartIndex, finalEndIndex + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestUniqueSubstring1("asderdfstringydeflep"));
		//System.out.println(getLargestUniqueString("abcxbrtbdefgghju"));
	}
}
