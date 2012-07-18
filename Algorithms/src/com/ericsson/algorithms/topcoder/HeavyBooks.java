package com.ericsson.algorithms.topcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HeavyBooks {

	public static int[] findWeight(int[] books, int[] moves) {
		
		int bookCount = moves[0];
		List<Integer> booksList = new ArrayList<Integer>();
		for (int i = 0; i < books.length; i++) {
			booksList.add(books[i]);
		}
		
		List<Integer> tomek = new ArrayList<Integer>();
		List<Integer> wozak = new ArrayList<Integer>();
		
		List<Integer> selectedBooks = topN(booksList, bookCount);
		wozak.addAll(selectedBooks);
		
		boolean tomekToWozak = false;
		for (int i = 1; i < moves.length; i++) {
			
			if(!tomekToWozak) {
				selectedBooks = topN(wozak, moves[i]);
				wozak.removeAll(selectedBooks);
				tomek.addAll(selectedBooks);
			} else {
				selectedBooks = topN(tomek, moves[i]);
				tomek.removeAll(selectedBooks);
				wozak.addAll(selectedBooks);
			}
			
			tomekToWozak = !tomekToWozak;
		}
		
		System.out.println(tomek);
		System.out.println(wozak);
		
		return null;
	}
	
	private static List<Integer> topN(List<Integer> array, int n) {
		
		if(n <= 0 || n > array.size())
			return null;
		
		// TODO: find better algo for finding top n
		Collections.sort(array);
		List<Integer> topN = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) 
			topN.add(array.get(array.size() - 1 - i));
		
		return topN;
	}
	
	public static void main(String[] args) {
		
		
		//findWeight(new int[]{5,2,3,1}, new int[]{3,2,1,1,1});
		
		findWeight(new int[]{500,500,500,500}, new int[]{4,1,1,3,2});
	}
}
