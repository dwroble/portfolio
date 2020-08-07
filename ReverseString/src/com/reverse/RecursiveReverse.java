package com.reverse;

import java.util.Scanner;


public class RecursiveReverse {

	private static String word;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word: ");
		word = input.next();
		reverse(word.length() - 1);
		input.close();
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
