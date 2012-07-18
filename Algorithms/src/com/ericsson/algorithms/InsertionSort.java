package com.ericsson.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			int j = i - 1;
			int k = i;
			while(j >= 0) {
				if(array[j] > value) {
					int temp = array[j];
					array[j] = array[k];
					array[k] = temp;
					
					k--;
				}
				else
					break;
				j--;
			}
		}
		
		return array;
	}
	
	public static void sort(List<Integer> values) {
		
		int lastIndex = values.size() - 1;
		int lastValue = values.get(lastIndex);
		
		int comparisonIndex = lastIndex - 1;
		
		while (comparisonIndex >= 0 && values.get(comparisonIndex) > lastValue) {
			int temp = values.get(comparisonIndex);
			values.set(comparisonIndex, values.get(comparisonIndex + 1));
			values.set(comparisonIndex + 1, temp);

			comparisonIndex--;

		}
	}
	
	public static void main(String[] args) {
		
//		int[] array = {5, 7, 1, 4, 3, 9};
//		sort(array);
		
		List<Integer> sortedArray = new ArrayList<Integer>();
		
		int counter = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(counter < 10) {
			int value = scanner.nextInt();
			sortedArray.add(value);
			sort(sortedArray);
			
			System.out.println(sortedArray);
			counter++;
		}
	}
}
