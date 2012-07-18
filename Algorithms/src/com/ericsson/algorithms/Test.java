package com.ericsson.algorithms;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;


public class Test {

	public static void main(String[] args) {
		
		

		int[][] matrix = new int[][] {new int[] {1,2,3}, new int[] {1,2,3,4}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < 4; j++) {
				if(!(i == 0 && j == 3))
					System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}


		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
	       NotificationEmitter emitter = (NotificationEmitter) mbean;
	       MyNotificationListener listener = new MyNotificationListener();
	       emitter.addNotificationListener(listener, null, null);
	       
	}
}

class MyNotificationListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		
		
	}
	
}
