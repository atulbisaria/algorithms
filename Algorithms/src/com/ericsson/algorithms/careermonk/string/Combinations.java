package com.ericsson.algorithms.careermonk.string;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<String> findCombinations(String S) {

		List<String> combinations = new ArrayList<String>();
		if(S.length() == 1) {
			combinations.add(S);
			return combinations;
		}
		
		char[] characters = S.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			int count = 0;
			char[] remaining = new char[characters.length - 1];
			for (int j = 0; j < characters.length; j++) {
				if(characters[j] != characters[i]) {
					remaining[count++] = characters[j];
				}
			}
			
			List<String> remainingCombinations = findCombinations(new String(remaining));
			for (String remainingCombination : remainingCombinations) {
				combinations.add(characters[i] + remainingCombination);
			}
		}
		
		return combinations;
	}
	
	public static void main(String[] args) {
		
		System.out.println(findCombinations("abc"));
	}
}
