package com.recursion;

import java.util.Scanner;

public class MainClass {

	//static boolean correctChoice = false;
	static String returnSelection;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanInput();
	}
	
	public static void scanInput() {
		Scanner input = new Scanner(System.in);
		int selection = 0;
		System.out.println("Select a program to run:\n" + 
				"1: Reverse String\n" + 
				"2: Calculate Hours From Seconds\n" +
				"3: Convert Alphanumeric Phone Number to Numeric Format\n");
				
//				+
//				"4: Josephus Problem");
		
		if(input.hasNextInt()) {
			selection = input.nextInt();
			//correctChoice = true;
		}else {
			System.out.println("You must select a number! Try Again.");
			scanInput();
		}
		
		switch(selection) {
		case 1:
			RecursiveReverse reverse = new RecursiveReverse();
			reverse.inputWord();
			break;
		case 2:
			convertHours();
			break;
		case 3:
			AlphaNum2Numeric.scan();
//		case 4:
//			JosephusProblem.scan();
		}
		
		returnSelection = null;
		System.out.println("Would you like to make another selection Y/N?");
		
		//if(input.hasNext()) {
		returnSelection = input.next();
		//}
		
		if(returnSelection.equalsIgnoreCase("Y")) {
			scanInput();
		}else {
			System.out.println("Goodbye");
			input.close();
			return;
		}
		
		
	}

	public static void convertHours() {
		int inHours = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter number of hours to convert to seconds.");
		if(input.hasNextInt()) {
			inHours = input.nextInt();
		}
		Hours2Seconds convert = new Hours2Seconds();
		convert.returnSeconds(inHours);
	}


}

