package com.seive;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Sieve {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer value:");
		int val = in.nextInt();
		ArrayList<Integer> list = init(val);
		System.out.println("List of prime numbers between 0 and " + val + ": " + list);
		
	}
	
	public static ArrayList<Integer> init(int inVal) {
		ArrayList<Integer> output = new ArrayList<Integer>((int) Math.ceil(Math.sqrt(inVal)));
		boolean [] bool1 = new boolean[inVal];
		
		for (int i = 0; i < inVal; i++) {
			bool1[i] = true;
		}
		for (int i = 2; i < Math.ceil((int)Math.sqrt(inVal)); i++) {
			if(bool1[i] == true) {
				int k = 0;
				for (int j = (int) Math.pow(i, 2); j < inVal; j = (int) (Math.pow(i, 2) + (i*k))) {
					k++;
					bool1[j] = false;
				}
			}
		}
		
		for (int i = 0; i < inVal; i++) {

			if(bool1[i] == true) {
				output.add(i);
			}
		}
		
		return output;
	}

}
