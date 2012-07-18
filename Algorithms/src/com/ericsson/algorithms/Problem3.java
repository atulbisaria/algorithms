package com.ericsson.algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Problem3 {

	public static void main(String[] args) {
		
		ExecutorService executor1 = Executors.newCachedThreadPool();
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		ExecutorService executor3 = Executors.newSingleThreadExecutor();
	}

}
