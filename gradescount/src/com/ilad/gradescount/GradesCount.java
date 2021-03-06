package com.ilad.gradescount;

import java.util.Scanner;
import java.util.Vector;

public class GradesCount {
	private static Scanner scan;
	public static void main(String[] args) {
		int read = 0;
		scan = new Scanner(System.in);
		Vector<Integer> A = new Vector<Integer>();
		Vector<Integer> B = new Vector<Integer>();
		Vector<Integer> C = new Vector<Integer>();
		Vector<Integer> D = new Vector<Integer>();
		Vector<Integer> F = new Vector<Integer>();
		while(-1 != read) {
			System.out.println
					("Please enter a grade between 0 to 100 or -1 to quit:");
			read = scan.nextInt();
			if(read < 101 && read > -1) {
				switch(read / 10) {
				case 10:
				case 9:
					A.addElement(read);
					break;
				case 8:
					B.addElement(read);
					break;
				case 7:
					C.addElement(read);
					break;
				case 6:
					D.addElement(read);
					break;
				default:
					F.addElement(read);
				}
			}
		}
		int ASize = A.size();
		int total = ASize + B.size() + C.size() + D.size() + F.size();
		System.out.println("Total number of grades = " + total);
		System.out.println("Number of A = " + ASize);
		System.out.println("Number of B = " + B.size());
		System.out.println("Number of C = " + C.size());
		System.out.println("Number of D = " + D.size());
		System.out.println("Number of F = " + F.size());
		System.out.print("The A grades are: ");
		for(int i = 0; i < ASize; ++i) {
			System.out.print(A.elementAt(i));
			if(ASize - 1 != i) {
				System.out.print(", ");
			}
		}
	}	
}
