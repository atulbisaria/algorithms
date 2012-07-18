package com.ericsson.algorithms.amazon;

public class FirstNonRepeatedCharacter {

	// T[i + 1] = 
	public static String findFirstNonRepeatedCharacter(String S) {
		
		int[] T = new int[256];
		for (int i = 0; i < S.length(); i++) {
			char next = S.charAt(i);
			T[next] = T[next] + 1;
		}
		
		for (int i = 0; i < S.length(); i++) {
			if(T[S.charAt(i)] == 1)
				return String.valueOf(S.charAt(i));
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(findFirstNonRepeatedCharacter("aabbccddhijk"));
	}
}
