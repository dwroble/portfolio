package com.recursion;

import java.util.Scanner;

//This class parses an alphanumeric phone number and converts the letters to numbers
/*
 * ALGORITHM:
 * 1: Input number from scanner
 * 2: Iterate through number and pull out chars, and insert into array. (Constraint of 10 remove any -'s)
 * 3: Convert chars to numbers according to chart
 * 		2 - ABC
 * 		3 - DEF
 * 		4 - GHI
 * 		5 - JKL
 * 		6 - MNO
 * 		7 - PQRS
 * 		8 - TUV
 * 		9 - WXYZ
 * 
 * 4: Print Output
 */
public class AlphaNum2Numeric {

	
	private static String phoneNumber; 
	
	public static void scan() {
		Scanner inputNum = new Scanner(System.in);
		System.out.println("Input a 10 digit phone number: ");
		if(inputNum.hasNext()) {
			String in = inputNum.next();
			
			if((in.length() == 12 || in.length() == 10)) {
				phoneNumber = in;
				System.out.println("You have entered: " + phoneNumber);
				convert();

				System.exit(0);
			}
			else {
				System.out.println("Error");
				scan();
			}
		}
	}
	
	private static void convert() {
		phoneNumber.toLowerCase();
		char[] numbersAndLettersArray = new char[10];
		char[] numbersOnlyArray = new char[10];
		int n = 0;
		
		//Populates the array with only 10 numbers if -'s are included
		for(int i = 0; i < phoneNumber.length(); i++) {
			if(phoneNumber.charAt(i) != '-') {
				numbersAndLettersArray[n] = phoneNumber.charAt(i);
				n++;
			}
		}
		int m = 0;
		for(char digit : numbersAndLettersArray) {
			
			switch(digit) {
			case '0':
				numbersOnlyArray[m] = '0';
				m++;
				break;
			case '1':
				numbersOnlyArray[m] = '1';
				m++;
				break;
			case '2':
				numbersOnlyArray[m] = '2';
				m++;
				break;
			case '3':
				numbersOnlyArray[m] = '3';
				m++;
				break;
			case '4':
				numbersOnlyArray[m] = '4';
				m++;
				break;
			case '5':
				numbersOnlyArray[m] = '5';
				m++;
				break;
			case '6':
				numbersOnlyArray[m] = '6';
				m++;
				break;
			case '7':
				numbersOnlyArray[m] = '7';
				m++;
				break;
			case '8':
				numbersOnlyArray[m] = '8';
				m++;
				break;
			case '9':
				numbersOnlyArray[m] = '9';
				m++;
				break;
			case 'a':
				numbersOnlyArray[m] = '2';
				m++;
				break;
			case 'b':
				numbersOnlyArray[m] = '2';
				m++;				
				break;
				
			case 'c':
				numbersOnlyArray[m] = '2';
				m++;
				break;
			case 'd':
				numbersOnlyArray[m] = '3';
				m++;
				break;
			case 'e':
				numbersOnlyArray[m] = '3';
				m++;
				break;
			case 'f':
				numbersOnlyArray[m] = '3';
				m++;
				break;
			case 'g':
				numbersOnlyArray[m] = '4';
				m++;
				break;
			case 'h':
				numbersOnlyArray[m] = '4';
				m++;
				break;
			case 'i':
				numbersOnlyArray[m] = '4';
				m++;
				break;
			case 'j':
				numbersOnlyArray[m] = '5';
				m++;
				break;
			case 'k':
				numbersOnlyArray[m] = '5';
				m++;
				break;
			case 'l':
				numbersOnlyArray[m] = '5';
				m++;
				break;
			case 'm':
				numbersOnlyArray[m] = '6';
				m++;
				break;
			case 'n':
				numbersOnlyArray[m] = '6';
				m++;
				break;
			case 'o':
				numbersOnlyArray[m] = '6';
				m++;
				break;
			case 'p':
				numbersOnlyArray[m] = '7';
				m++;
				break;
			case 'q':
				numbersOnlyArray[m] = '7';
				m++;
				break;
			case 'r':
				numbersOnlyArray[m] = '7';
				m++;
				break;
			case 's':
				numbersOnlyArray[m] = '7';
				m++;
				break;
			case 't':
				numbersOnlyArray[m] = '8';
				m++;
				break;
			case 'u':
				numbersOnlyArray[m] = '8';
				m++;
				break;
			case 'v':
				numbersOnlyArray[m] = '8';
				m++;
				break;
			case 'w':
				numbersOnlyArray[m] = '9';
				m++;
				break;
			case 'x':
				numbersOnlyArray[m] = '9';
				m++;
				break;
			case 'y':
				numbersOnlyArray[m] = '9';
				m++;
				break;
			case 'z':
				numbersOnlyArray[m] = '9';
				m++;
				break;
			
			}
		}
		
		
		
		
		
		
		
		//For Debugging purposes only
			for(char num : numbersOnlyArray) {
				System.out.print(num);
			}
			System.out.print("\n");

		//------------------------------
	}
}
