package com.recursion;

import java.util.Scanner;

public class RecursiveReverse {

	private static String word;
	
	public void inputWord() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word: ");
		word = input.next();
		reverse(word.length() - 1);
		System.out.println("\n");
	}
	
	public static String reverse(int n) {	
		//base case
		if(n == 0) {		
			System.out.print(word.charAt(n));
			return "\nDone";
		//recursive case
		}else {
			System.out.print(word.charAt(n));
			return reverse(n - 1);
		}	
	}
}
