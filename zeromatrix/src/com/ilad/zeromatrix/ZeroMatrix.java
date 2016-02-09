package com.ilad.zeromatrix;

import java.util.Random; //column

import org.apache.xpath.operations.String;

public class ZeroMatrix {
	public static void zeroMatrix(int[][] matrix) {
		boolean isRowZero = false;
		boolean isColumnZero = false;
		int i;
		int j;
		int length = matrix.length;
		int width = matrix[0].length;
		
		for(i = 0; i < length; ++i) {
			for(j = 0; j < width; ++j) {
				if(0 == matrix[i][j]) {
					if(0 == i || 0 == j) {
						if(0 == i) {
							isRowZero = true;
						}
						if(0 == j) {
							isColumnZero = true;
						}
					}
					else {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}
		}
		
		for(i = 1; i < length; ++i) {
			if(0 == matrix[i][0]) {
				for(j = 1; j < width; ++j) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(j = 1; j < width; ++j) {
			if(0 == matrix[0][j]) {
				for(i = 1; i < length; ++i) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(isRowZero) {
			for(j = 0; j < width; ++j) {
				matrix[0][j] = 0;
			}
		}
		
		if(isColumnZero) {
			for(i = 0; i < length; ++i) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		final int LENGTH = 5;
		final int WIDTH = 5;
		final int RAND = 5;
		int[][] matrix = new int[LENGTH][WIDTH];
		Random random = new Random();
		int i;
		int j;
		for(i = 0; i < LENGTH; ++i) {
			for(j = 0; j < WIDTH; ++j) {
				matrix[i][j] = random.nextInt(RAND);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		zeroMatrix(matrix);
		System.out.println();
		System.out.println("After zeroMatrix");
		System.out.println();
		for(i = 0; i < LENGTH; ++i) {
			for(j = 0; j < WIDTH; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
