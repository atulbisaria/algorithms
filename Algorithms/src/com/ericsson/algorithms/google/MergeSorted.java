package com.ericsson.algorithms.google;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSorted {

	
	public static int[] merge(List<int[]> arrays) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int[] pointers = new int[arrays.size()];
		
		int totalSize = 0;
		for (int i = 0; i < arrays.size(); i++) {
			totalSize += arrays.get(i).length;
			if(arrays.get(i).length > 0) 
				queue.add(arrays.get(i)[0]);
		}
		
		int count = 0;
		int[] result = new int[totalSize];

		while(!queue.isEmpty()) {
			int next = queue.poll();
			result[count++] = next;
			
			for (int i = 0; i < pointers.length; i++) {
				int[] array = arrays.get(i);
				if(array.length > 0 && pointers[i] < array.length) {
					if(next == array[pointers[i]]) {
						pointers[i]++;
						if(pointers[i] < array.length) {
							queue.add(array[pointers[i]]);
							break;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
		
		return result;
	}
	
	public static void main(String[] args) {

		List<int[]> arrays = new ArrayList<int[]>();

		int[] array1 = {1, 4, 6, 8, 15, 21, 57, 58};
		int[] array2 = {3, 7, 8, 11, 35, 84, 102};
		int[] array3 = {16, 18, 22, 30, 89, 101};
		int[] array4 = {11, 56, 91, 100};
		
		arrays.add(array1);
		arrays.add(array2);
		arrays.add(array3);
		arrays.add(array4);
		
		merge(arrays);
		
	}
}
