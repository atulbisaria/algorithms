package com.ericsson.algorithms.careermonk.string;

import java.util.ArrayList;
import java.util.List;


public class Matrix {

	public static boolean isStringInMatrix(char[][] matrix, String S) {
		
		List<Position> roots = new ArrayList<Position>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == S.charAt(0)) 
					roots.add(new Position(i, j));
			}
		}
		
		for (Position root : roots) {
			if(findString(matrix, root, S, 1))
				return true;
		}
		
		return false;
	}
	
	private static boolean findString(char[][] matrix, Position root, String S, int index) {
		
		if(index > (S.length() - 1))
			return true;
		
		int matrixLength = matrix.length - 1;

		// find all characters around root which are equal to char at index
		List<Position> positions = new ArrayList<Position>();
		
		int rootRow = root.row;
		int rootCol = root.col;
		
		int lowRow = (rootRow - 1) < 0 ? 0 : rootRow - 1;
		int lowCol = (rootCol - 1) < 0 ? 0 : rootCol - 1;
		int highRow = (rootRow + 1) > matrixLength ? matrixLength : rootRow + 1;
		int highCol = (rootCol + 1) > matrixLength ? matrixLength : rootCol + 1;
		
		for (int i = lowRow; i <= highRow; i++) {
			for (int j = lowCol; j <= highCol; j++) {
				if(!(i == rootRow && j == rootCol) && matrix[i][j] == S.charAt(index)) {
					positions.add(new Position(i, j));
				}
			}
		}
		
		for (Position position : positions) {
			if(findString(matrix, position, S, index + 1))
				return true;
		}
		
		return false;
	}

	
	public static void main(String[] args) {
		
		char[][] matrix = new char[5][5];
		
		matrix[0][0] = "A".charAt(0);
		matrix[0][1] = "C".charAt(0);
		matrix[0][2] = "P".charAt(0);
		matrix[0][3] = "R".charAt(0);
		matrix[0][4] = "C".charAt(0);
		
		matrix[1][0] = "X".charAt(0);
		matrix[1][1] = "S".charAt(0);
		matrix[1][2] = "O".charAt(0);
		matrix[1][3] = "P".charAt(0);
		matrix[1][4] = "C".charAt(0);
		
		matrix[2][0] = "V".charAt(0);
		matrix[2][1] = "O".charAt(0);
		matrix[2][2] = "V".charAt(0);
		matrix[2][3] = "N".charAt(0);
		matrix[2][4] = "I".charAt(0);
		
		matrix[3][0] = "W".charAt(0);
		matrix[3][1] = "G".charAt(0);
		matrix[3][2] = "F".charAt(0);
		matrix[3][3] = "M".charAt(0);
		matrix[3][4] = "N".charAt(0);
		
		matrix[4][0] = "Q".charAt(0);
		matrix[4][1] = "A".charAt(0);
		matrix[4][2] = "T".charAt(0);
		matrix[4][3] = "I".charAt(0);
		matrix[4][4] = "T".charAt(0);
		
		String S = "MICROSOFT";
		
		System.out.println(isStringInMatrix(matrix, S));
	}
}

class Position {
	
	public int row;
	public int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public boolean equals(Object obj) {
		Position pos = (Position) obj;
		return row == pos.row && col == pos.col;
	}

	@Override
	public String toString() {
		return "Position [row=" + row + ", col=" + col + "]";
	}

}
