package com.ericsson.algorithms;

public class MatrixSearch {

	private int[][] matrix;

	public MatrixSearch() {
		this.matrix = new int[3][3];
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 5;
		matrix[1][0] = 3;
		matrix[1][1] = 4;
		matrix[1][2] = 6;
		matrix[2][0] = 8;
		matrix[2][1] = 9;
		matrix[2][2] = 10;
	}
	
	public void search(int number) {
		
		int row = -1;
		int col = -1;
		
		while(row < 3 && col < 3 && ((row == -1 && col == -1) || matrix[row][col] != number)) {
			if(row == -1 && col == -1) {
				row = 0;
				col = 0;
			}
			else {
				int newRow = row + 1;
				if(matrix[newRow][col] == number) {
					row = newRow;
					break;
				}

				int newCol = col + 1;
				if(matrix[row][newCol] == number) {
					col = newCol;
					break;
				}

				row = newRow;
				col = newCol;
			}
		}
		
		System.out.println("Matrix [" + row + "," + col + "]");
	}
	
	public static void main(String[] args) {
		new MatrixSearch().search(11);
	}
	
}
