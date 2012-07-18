package com.ericsson.algorithms.tw;

public class GameOfLife {

	public static void main(String[] args) {
		
		String input = "- X X X;X X X -";
//		String input = "X X X";
//		String input = "X X;X X";
//		String input = "X X -;X - X;- X -";
		
		if(input == null || input.trim().length() == 0) {
			System.out.println("No Input");
		} else {
			
			int numRows = input.split(";").length;
			int numColumns = input.split(";")[0].split(" ").length;
			
			String[][] seed = new String[numRows][numColumns];
			String[] rows = input.split(";");
			for (int i = 0; i < rows.length; i++) {
				String[] columns = rows[i].split(" ");
				for (int j = 0; j < columns.length; j++) {
					seed[i][j] = columns[j];
				}
			}
			
			Generation generation = new Generation(seed);
			generation.print();
			
			System.out.println();
			System.out.println();
			
			generation.tick();
			generation.print();
		}
	}
}
