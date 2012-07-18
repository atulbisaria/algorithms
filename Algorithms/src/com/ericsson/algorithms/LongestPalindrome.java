package com.ericsson.algorithms;

public class LongestPalindrome {

	
	public static String reverse(String input) {
		
		char[] array = input.toCharArray();
		
		int start = 0;
		int end = array.length - 1;
		
		while(start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			
			start++;
			end--;
		}
		
		return new String(array);
	}
	
	public static void main(String[] args) {
		String gene = "C,A,C,A,A,T,T,C,C,C,A,T,G,G,G,T,T,G,T,G,G,A,G";
		String opposite = "G,A,G,G,T,G,T,T,G,G,G,T,A,C,C,C,T,T,A,A,C,A,C";
		
		//System.out.println(reverse(gene));
	}
}
