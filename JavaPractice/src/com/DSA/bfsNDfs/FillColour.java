package com.DSA.bfsNDfs;

public class FillColour {
	// DFS
	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		backtrace(arr, 1, 1, 9, 1);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void backtrace(int[][] image, int sr, int sc, int targetColor, int baseColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != baseColor) {
			return;
		}

		image[sr][sc] = targetColor;
		// System.out.println("sr " + sr + "sc " + sc);
		backtrace(image, sr + 1, sc, targetColor, baseColor);
		backtrace(image, sr - 1, sc, targetColor, baseColor);
		backtrace(image, sr, sc + 1, targetColor, baseColor);
		backtrace(image, sr, sc - 1, targetColor, baseColor);
	}

}
