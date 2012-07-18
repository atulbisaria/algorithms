package com.ericsson.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {

	public static void sort(int[] array, int numberOfBuckets) {
		
		Map<Integer, List<Integer>> buckets = new HashMap<Integer, List<Integer>>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(array[i] < min)
				min = array[i];
			if(array[i] > max)
				max = array[i];
		}
			
		for (int i = 0; i < array.length; i++) {
			int bucketIndex = bucketIndex(array[i], min, max, numberOfBuckets);
			List<Integer> values = buckets.get(bucketIndex);
			if(values == null) {
				values = new ArrayList<Integer>();
				buckets.put(bucketIndex, values);
			}
			
			values.add(array[i]);
		}
		
		System.out.println(buckets);
		
	}
	
	private static int bucketIndex(int value, int min, int max, int numberOfBuckets) {
		int index = (int)(((float)(value - min) / (float)(max - min)) * numberOfBuckets);
		return index == numberOfBuckets ? index - 1 : index;
	}
	
	public static void main(String[] args) {
		
		int[] array = {5, 7, 1, 4, 3, 9};
		
		sort(array, 2);
	}
}
