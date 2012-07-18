package com.ericsson.algorithms.tree;

public class MaxHeap {

	public static void main(String a[]) {
		int i;
		int arr[] = { 1, 3, 4, 5, 2 };

		System.out.println("\n  Heap Sort\n---------------\n");
		System.out.println("\n  Unsorted Array\n\n");
		
		for (i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		for (i = arr.length; i > 1; i--) {
			heapify(arr, i - 1);
		}
		System.out.println("\n  Sorted array\n---------------\n");
		for (i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
	}

	public static void heapify(int array[], int end) {
		int i, j;
		int lChild, rChild, mChild, root, temp;
		root = (end - 1) / 2;

		for (j = root; j >= 0; j--) {
			for (i = root; i >= 0; i--) {
				lChild = (2 * i) + 1;
				rChild = (2 * i) + 2;
				if ((lChild <= end) && (rChild <= end)) {
					if (array[rChild] >= array[lChild])
						mChild = rChild;
					else
						mChild = lChild;
				} else {
					if (rChild > end)
						mChild = lChild;
					else
						mChild = rChild;
				}

				if (array[i] < array[mChild]) {
					temp = array[i];
					array[i] = array[mChild];
					array[mChild] = temp;
				}
			}
		}
		temp = array[0];
		array[0] = array[end];
		array[end] = temp;
		return;
	}

}
