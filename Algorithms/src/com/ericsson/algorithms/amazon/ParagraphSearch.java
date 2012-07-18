package com.ericsson.algorithms.amazon;

import java.util.Arrays;

public class ParagraphSearch {

	public static void findSmallestSubText(String[] paragraph, String[] words, int[] wordsIndex) {
		
		int minLength = Integer.MAX_VALUE;
		int start = -1;
		
		int minStart = Integer.MAX_VALUE;
		int minEnd = -1;
		Arrays.fill(wordsIndex, -1);
		
		int foundCount = 0;
		boolean allFound = (foundCount == words.length);
		for (int i = 0; i < paragraph.length; i++) {
			int wordIndex = indexFor(words, paragraph[i]);
			if(wordIndex > -1) {
				if(wordsIndex[wordIndex] > -1) { // already found
					if(allFound) {
						if(paragraph[i].equals(paragraph[start]) && (i - start) > minLength) {
							minLength = i - start;
							start = i;
							wordsIndex[wordIndex] = i;
						}
					} else {
						wordsIndex[wordIndex] = i;
					}

				} else {
//					if(start == -1) 
//						start = i;
					wordsIndex[wordIndex] = i;
					foundCount++;
					allFound = (foundCount == words.length);
					if(i > minEnd)
						minEnd = i;
					if(i < minStart) {
						minStart = i;
					}
					if(allFound) {
						minLength = minEnd - minStart;
					}
				}
				
			}
		}
		
		System.out.println("Start = " + start);
		System.out.println("MinLength = " + minLength);
		System.out.println();
		System.out.println();
		for (int i = start; i < (start + minLength); i++) {
			System.out.print(paragraph[i] + " ");
		}
	}
	
	private static int indexFor(String[] words, String word) {
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(word))
				return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		String paragraph = "this is a test this is a programming test this is a programming test in any language";
		String words = "this a test programming";
		
		findSmallestSubText(paragraph.split(" "), words.split(" "), new int[words.split(" ").length]);
	}
}
