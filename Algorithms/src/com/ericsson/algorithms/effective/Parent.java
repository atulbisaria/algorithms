package com.ericsson.algorithms.effective;

import java.util.Date;

public class Parent {

	private final Date date;
	private final int abc;

	public Parent(Date date) {
		this.date = new Date(date.getTime());
		this.abc = 1;
	}
	
	@Override
	public String toString() {
		return date.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Parent(new Date()));
	}
}
