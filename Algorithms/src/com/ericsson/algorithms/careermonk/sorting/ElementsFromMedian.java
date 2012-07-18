package com.ericsson.algorithms.careermonk.sorting;

import java.util.Arrays;

public class ElementsFromMedian {

	public static void print(int[] numbers, int k) {
		
		int medianPointer = find(numbers, numbers.length / 2, 0, numbers.length - 1);
		System.out.println("medianPointer = " + medianPointer);
		int kthLargestAfterMedian = find(numbers, k - 1, medianPointer, numbers.length - 1);
		System.out.println("kthLargestAfterMedian = " + kthLargestAfterMedian);
		
		for (int i = medianPointer; i <= kthLargestAfterMedian; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println();
	}
	
	public static int find(int[] numbers, int k, int start, int end) {
		
		int middle = start + (end - start) / 2;
		int middleValue = numbers[middle];
		
		int temp = numbers[middle];
		numbers[middle] = numbers[end];
		numbers[end] = temp;
		
		int count = start;
		for (int i = start; i < end; i++) {
			if(numbers[i] <= middleValue) {
				temp = numbers[count];
				numbers[count] = numbers[i];
				numbers[i] = temp;
				
				count++;
			}
		}
		
		temp = numbers[count];
		numbers[count] = numbers[end];
		numbers[end] = temp;
		
		if(count == (k + start))
			return count;
		else if(count > (k + start))
			return find(numbers, k, start, count - 1);
		else
			return find(numbers, (k + start) - count - 1, count + 1, end);
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] {4,8,2,9,0,6,3};
		//System.out.println(find(numbers.clone(), numbers.length / 2, 0, 6));
		print(numbers.clone(), 2);
		
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
	}
}
