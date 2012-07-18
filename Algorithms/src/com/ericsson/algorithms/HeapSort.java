package com.ericsson.algorithms;

public class HeapSort {

	public static void minHeapify(int[] array, int index) {
		
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int min = index;
		
		if(left < array.length && array[left] < array[min])
			min = left;
		if(right < array.length && array[right] < array[min])
			min = right;
		
		if(min != index) {
			int temp = array[min];
			array[min] = array[index];
			array[index] = temp;
			
			minHeapify(array, min);
		}
	}
	
	public static int[] heapify(int[] array, int startIndex) {
		
		int index = (startIndex - 1) / 2;
		for (int i = index; i >= 0; i--) 
			minHeapify(array, i);

		return array;
	}
	
	public static int[] siftUp(int[] array, int index) {
		
		int parent = (index - 1) / 2;
		if(parent >= 0) {
			if(array[parent] > array[index]) {
				int temp = array[parent];
				array[parent] = array[index];
				array[index] = temp;
				
				return siftUp(array, parent);
			}
		}
		
		return array;
	}
	
	public static void heapSort(int[] array) {
		
		int[] finalArray = array;
		for (int i = 0; i < array.length; i++) {
			finalArray = siftUp(array, i);
		}
//		for (int i = 0; i < array.length; i++) {
//			array = heapify(array, i);
//		}
		
		array = finalArray;
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = {5, 7, 1, 4, 3, 9};
		//int[] array = {5, 4, 7, 9};
		
		//heapify(array, 0, array.length - 1);
		heapSort(array);
	}
}
