package com.ericsson.algorithms.multithreading;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		Executor executor = Executors.newFixedThreadPool(10);

	}
}

class Producer implements Runnable {

	private LinkedList<Integer> queue;
	
	public Producer(LinkedList<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		 while(true) {
			 synchronized (queue) {
				if(queue.size() < 10) {
					queue.addLast(50);
			}
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		
	}
	
}

class Consumer implements Runnable {

	private LinkedList<Integer> queue;
	
	public Consumer(LinkedList<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		 while(true) {
			 
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		
	}
	
}
