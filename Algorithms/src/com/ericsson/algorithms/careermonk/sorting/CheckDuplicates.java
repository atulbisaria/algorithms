package com.ericsson.algorithms.careermonk.sorting;


public class CheckDuplicates {

	public static boolean hasDuplicates(int[] numbers) {
//		Arrays.sort(numbers);
//		
//		for (int i = 1; i < numbers.length; i++) {
//			if(numbers[i] == numbers[i - 1])
//				return true;
//		}
//		
//		return false;
		
		for (int i = 0; i < numbers.length; i++) {
			if(i != numbers[i] && numbers[i] == numbers[numbers[i]])
				return true;
			else {
				int temp = numbers[i];
				numbers[i] = numbers[numbers[i]];
				numbers[temp] = temp;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] {5,7,4,0,2,3,7,6};
		System.out.println(hasDuplicates(numbers));
	}
}
