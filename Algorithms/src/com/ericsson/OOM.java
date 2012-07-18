package com.ericsson;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.List;


public class OOM {

	public static List<Integer> list;
	private static Tracker tracker;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		tracker = new Tracker();
		tracker.start();
		
		list = new ArrayList<Integer>();
		while (true) {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				synchronized (list) {
					list.add(i);
				}
			}
		}

	}
}

class Tracker extends Thread {
	
	@Override
	public void run() {
		MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
		long max = bean.getHeapMemoryUsage().getMax();
		
		boolean reached = false;
		while(true) {
			long used = bean.getHeapMemoryUsage().getUsed();
			double perc = (double)used / (double)max;
			if(perc > 0.7) {
				if(!reached) {
					System.out.println(" --- Threshold reached");
					reached = true;
					synchronized (OOM.list) {
						OOM.list.clear();
					}
				}
			} else {
				if(reached) {
					System.out.println(" ---- Threashold cleared");
					reached = false;
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
