package com.ericsson.algorithms.amazon;

public class FindCommon {

	private int[] data1;
	private int[] data2;
	private int[] data3;
	
	public FindCommon(int[] data1, int[] data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	
}

class FileReaderTask implements Runnable {

	public static final String FILE1 = "file1";
	public static final String FILE2 = "file2";
	
	private String fileName;

	public FileReaderTask(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		
		if(fileName.equals(FILE1));
	}
	
}
