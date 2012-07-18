package com.ericsson.algorithms.google;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReaderWriter {

	public static Object reader = new Object();
	public static Object writer = new Object();
	
	public static int readCount = 0;
	public static String data = "init";
	
	public static void main(String[] args) {
		
		Thread tReader = new Thread(new Reader()) ;
		Thread tWriter = new Thread(new Writer());
		Thread tReader1 = new Thread(new Reader()) ;
		Thread tWriter1 = new Thread(new Writer());
		
		tReader.start();
		tWriter.start();
		tReader1.start();
		tWriter1.start();
		
		String abc = "abc";
		
		Integer def = 10;
		
		//LinkedBlockingQueue<E>
	}
	
}

class Reader implements Runnable {

	private static Lock readLock = new ReentrantLock();

	@Override
	public void run() {
		
		while(true) {
//			synchronized(ReaderWriter.reader) {
//				ReaderWriter.readCount++;
//			}
//			
//			System.out.println("Reading: " + ReaderWriter.data);
//			
//			synchronized(ReaderWriter.reader) {
//				ReaderWriter.readCount--;
//			}
			
			readLock.lock();
			try {
				
			}
			finally {
				readLock.unlock();
			}
		}

	}
	
}

class Writer implements Runnable {

	public static int count = 0;
	
	@Override
	public void run() {
		
		while(true) {
			synchronized(ReaderWriter.writer) {
				synchronized(ReaderWriter.reader) {
					if(ReaderWriter.readCount == 0) {
						ReaderWriter.data = "init" + count++;
						System.out.println("Writing: " + ReaderWriter.data);
					}
				}
			}
		}
		
	}
	
}
