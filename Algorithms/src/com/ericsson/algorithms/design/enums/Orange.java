package com.ericsson.algorithms.design.enums;

public enum Orange {
	NAVEL(5), TEMPLE(8), BLOOD(16);
	
	private final int value;
	
	Orange(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return super.toString() + " value = " + value;
	}
}
