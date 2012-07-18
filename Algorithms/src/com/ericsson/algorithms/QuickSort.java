package com.ericsson.algorithms;


public class QuickSort {

	public static int partition(int[] array, int leftIndex, int rightIndex, int pivotIndex) {
		
		int pivotValue = array[pivotIndex];
		
		int temp = array[pivotIndex];
		array[pivotIndex] = array[rightIndex];
		array[rightIndex] = temp;
		
		int store = leftIndex;
		for (int i = leftIndex; i < rightIndex; i++) {
			if(array[i] < pivotValue) {
				temp = array[i];
				array[i] = array[store];
				array[store] = temp;
				
				store++;
			}
		}

		temp = array[rightIndex];
		array[rightIndex] = array[store];
		array[store] = temp;
		
		return store;
	}
	
	public static <T extends Comparable<T>> int partition(T[] array, int leftIndex, int rightIndex, int pivotIndex) {
		
		T pivotValue = array[pivotIndex];
		
		T temp = array[pivotIndex];
		array[pivotIndex] = array[rightIndex];
		array[rightIndex] = temp;
		
		int store = leftIndex;
		for (int i = leftIndex; i < rightIndex; i++) {
			if(array[i].compareTo(pivotValue) < 0) {
				temp = array[i];
				array[i] = array[store];
				array[store] = temp;
				
				store++;
			}
		}

		temp = array[rightIndex];
		array[rightIndex] = array[store];
		array[store] = temp;
		
		return store;
	}
	
	public static <T extends Comparable<T>> void quickSortInPlace(T[] array, int leftIndex, int rightIndex) {
		
		if(array.length > 1 && leftIndex < rightIndex) {
			int pivotIndex = leftIndex + (rightIndex - leftIndex) / 2;
			int newPivotIndex = partition(array, leftIndex, rightIndex, pivotIndex);
			
			quickSortInPlace(array, leftIndex, newPivotIndex - 1);
			quickSortInPlace(array, newPivotIndex + 1, rightIndex);
		}
	}
	
	public static void quickSortInPlace(int[] array, int leftIndex, int rightIndex) {
		
		if(array.length > 1 && leftIndex < rightIndex) {
			int pivotIndex = leftIndex + (rightIndex - leftIndex) / 2;
			int newPivotIndex = partition(array, leftIndex, rightIndex, pivotIndex);
			
			quickSortInPlace(array, leftIndex, newPivotIndex - 1);
			quickSortInPlace(array, newPivotIndex + 1, rightIndex);
		}
	}
	
	public static int[] quickSortRecursive(int[] array) {
		
		if(array.length <= 1)
			return array;
		
		int middle = array.length / 2;
		
		int[] left = new int[middle];
		int[] right = new int[array.length - (middle + 1)];
		
		for (int i = 0; i < middle; i++) 
			left[i] = array[i];
		for (int i = (middle + 1); i < array.length; i++) 
			right[i - (middle + 1)] = array[i];
		
		int[] returnArray = new int[array.length];
		
		int[] leftSorted = quickSortRecursive(left);
		int[] rightSorted = quickSortRecursive(right);
		
		for (int i = 0; i < array.length; i++) {
			if(i < middle)
				returnArray[i] = leftSorted[i];
			else if(i == middle)
				returnArray[i] = array[middle];
			else
				returnArray[i] = rightSorted[i - (middle + 1)];
		}
		
		return returnArray;
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {4,5,3,9,1};
		
//		quickSortInPlace(array, 0, array.length - 1);
//		
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + ",");
//		}
		
		int[] sorted = quickSortRecursive(array);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + ",");
		}
	}
}
