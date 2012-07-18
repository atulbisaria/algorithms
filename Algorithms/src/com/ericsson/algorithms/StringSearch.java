package com.ericsson.algorithms;

public class StringSearch {

	
	public static int search(String input, String text) {
		
		int count = 0;
		
		int indexSearch = 0;
		int indexText = 0;
		
		while(indexText < text.length()) {
			char searchChar = input.charAt(indexSearch);
			char textChar = text.charAt(indexText);
			
			indexText++;
			if(textChar == searchChar) {
				if(indexSearch == (input.length() - 1)) {
					indexSearch = 0;
					count++;
				} else
					indexSearch++;
			}
			else {
				indexSearch = 0;
			}
		}

		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		String search = "abc";
		String text = "abddefghtcabchjlirnanngklrabcf";
		
		System.out.println(search(search, text));
	}

}
