package com.ericsson.algorithms.careermonk.dynamic;

// Using Dynamic Programming
// Time Complexity O(mn)
// Space Complexity O(mn)
public class MaxAreaSubMatrix {
	public static int findMaxAreaRectangle(int[][] A, int m, int n) {
		Rectangle[][] M = new Rectangle[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				M[i][j] = new Rectangle(0, 0, 0, 0);
			}
		}

		int x = 1;
		if (A[0][0] == 1) {
			M[0][0] = new Rectangle(0, 0, 1, 1);
			x = 0;
		}

		int k = x;
		for (int j = 1; j < n; j++) {
			if (A[0][j] == 0) {
				k = j + 1;
			}
			if (A[0][j] == 1) {
				M[0][j] = new Rectangle(0, k, 1, j + 1);
			}
		}

		k = x;
		for (int j = 1; j < m; j++) {
			if (A[j][0] == 0) {
				k = j + 1;
			}
			if (A[j][0] == 1) {
				M[j][0] = new Rectangle(k, 0, j + 1, 1);
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (A[i][j] == 1) {
					int topX2 = 0, topY2 = 0, topX3 = 0, topY3 = 0;
					
					if(M[i][j - 1].area() > 0 && M[i - 1][j].area() > 0)
					{
						topX2 = M[i][j - 1].topLeftX;
						topY2 = M[i][j - 1].topLeftY;
						
						topX3 = M[i - 1][j].topLeftX;
						topY3 = M[i - 1][j].topLeftY;
						
						M[i][j] = new Rectangle(Math.max(topX2, topX3), Math.max(topY2, topY3), i + 1, j + 1);
					}
					else if(M[i][j - 1].area() > 0)
					{
						M[i][j] = new Rectangle(i, M[i][j - 1].topLeftY, i + 1, j + 1);
					}
					else if(M[i - 1][j].area() > 0)
					{
						M[i][j] = new Rectangle(M[i - 1][j].topLeftX, j, i + 1, j + 1);
					}
					else
					{
						M[i][j] = new Rectangle(i, j, i + 1, j + 1);
					}
				}
			}
		}

		print(M, m ,n);
		
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (M[i][j].area() > maxArea) {
					maxArea = M[i][j].area();
				}
			}
		}

		return maxArea;
	}

	public static void print(Rectangle[][] M, int m, int n)
	{
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(M[i][j] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxAreaRectangle(new int[][] { { 1, 1, 1 },
															  { 1, 1, 1 }, 
															  { 1, 1, 1 } }, 3, 3));
	}
}

class Rectangle {
	protected int topLeftX;
	protected int topLeftY;
	protected int bottomRightX;
	protected int bottomRightY;

	public Rectangle(int topLeftX, int topLeftY, int bottomRightX,
			int bottomRightY) {
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		this.bottomRightX = bottomRightX;
		this.bottomRightY = bottomRightY;
	}

	public int area() {
		return (bottomRightX - topLeftX) * (bottomRightY - topLeftY);
	}
	
	@Override
	public String toString() 
	{
		return "(" + topLeftX + "," + topLeftY + ")|(" + bottomRightX + "," + bottomRightY + ")";
	}
}
