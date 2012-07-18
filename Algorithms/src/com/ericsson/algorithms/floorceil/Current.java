package com.ericsson.algorithms.floorceil;

public class Current implements Comparable<Current> {

	private String alphabets;

	public Current(String alphabets) {
		this.alphabets = alphabets;
	}

	public String getAlphabets() {
		return alphabets;
	}

	@Override
	public int compareTo(Current current) {
		
		if(alphabets.length() > current.getAlphabets().length())
			return 1;
		else if(alphabets.length() < current.getAlphabets().length())
			return -1;
		else {
			char char1 = alphabets.charAt(0);
			char char2 = current.getAlphabets().charAt(0);
			
			if(char1 < char2)
				return -1;
			else if(char1 > char2)
				return 1;
			else
				return 0;
		}
	}
	
	@Override
	public String toString() {
		return alphabets;
	}

}
