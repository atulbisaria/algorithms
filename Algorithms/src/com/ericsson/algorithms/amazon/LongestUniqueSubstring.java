package com.ericsson.algorithms.amazon;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

	public static void findMaxUniqueString(String s){
		HashMap<Character, Integer> charIdx =new HashMap<Character, Integer>();
		int maxLen = 0;
		int maxStart = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++){
			if (!charIdx.containsKey(s.charAt(i))){
				int lenghtOfUniqueString = i - start +1 ;
				if (maxLen < lenghtOfUniqueString){
					maxLen = lenghtOfUniqueString;
					maxStart = start;
				}
			}
			else{
				start = charIdx.get(s.charAt(i)) + 1;
			}
			charIdx.put(s.charAt(i), i);
		}
		for (int i = 0; i < maxLen; i++){
			System.out.print(s.charAt(maxStart + i));
		}
	}


	public static String longestUniqueSubstring(String input) {
		
		Map<Character, Integer> charPositionMap = new HashMap<Character, Integer>();
		//Set<Character> uniquSet = new HashSet<Character>();
		
		int finalStartIndex = 0;
		int finalEndIndex = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		int maxLength = Integer.MIN_VALUE;

		char[] characters = input.toCharArray();
		charPositionMap.put(characters[startIndex], startIndex);
		//uniquSet.add(characters[startIndex]);
		
		for (int i = 1; i < characters.length; i++) {
			Integer position = charPositionMap.get(characters[i]);
			if(position != null) {
				if(position >= finalStartIndex) {
					if(charPositionMap.size() > maxLength) {
						maxLength = charPositionMap.size();
						finalStartIndex = startIndex;
						finalEndIndex = endIndex;	
					}
					
					startIndex = endIndex = (position + 1);
				}
				else {
					endIndex = i;
					charPositionMap.put(characters[i], i);
				}
				
				//charPositionMap.clear();
//				for (int j = startIndex; j <= i; j++) {
//					//charPositionMap.e
//				}
				//charPositionMap.put(characters[startIndex], startIndex);
				//i = startIndex;
			}
			else {
				endIndex = i;
				charPositionMap.put(characters[i], i);
			}
		}
		
		char[] resultArr = new char[finalEndIndex - finalStartIndex + 1];
		for (int i = finalStartIndex; i <= finalEndIndex; i++) 
			resultArr[i - finalStartIndex] = characters[i];

		return new String(resultArr);
	}
	
	public static void main(String[] args) {
		
		String abc = "asderdfstringydeflepqzwvmkubcj";
		
		//findMaxUniqueString(abc);
		System.out.println(longestUniqueSubstring(abc));
	}
}
