package com.recursion;

import java.util.LinkedList;
import java.util.Scanner;


public class JosephusProblem {

	public static void scan() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of soldiers:");
		int numSoldiers = input.nextInt();
		System.out.println("\nEnter iteration:");
		int iteration = input.nextInt();
		System.out.println(calculate(numSoldiers, iteration));
	}
	
	private static int calculate(int inNumSoldiers, int inIterationCount) {
		int position = 0;
		LinkedList<Integer> list = new MyLinkedList<Integer>();
		for(int i = 0; i < inNumSoldiers; i++) {
			list.add(i);
		}
		
		if(inNumSoldiers == 1) {
			return position;
		}else {
			position += inIterationCount;
			list.remove(position);
			System.out.println(list);
			return calculate(inNumSoldiers - 1, inIterationCount);
		}
	}
}

class MyLinkedList<Integer> extends LinkedList<Integer>{
	
	Node head;
	Node tail;
	
	public MyLinkedList(){
		this.head = newNode(0, 1, 0);
		this.tail = newNode(0, this.head.getAddr(), 5555);
	}
	
	private Node newNode(int data, int next, int inAddr) {
		Node newNode = new Node(data, next, inAddr);
		return newNode;
	}
}

class Node{
	
	private int data;
	private int next;
	private int addr;
	
	public Node(int inData, int inNext, int inAddr) {
		this.data = inData;
		this.next = inNext;
		this.addr = inAddr;		
	}
	
	public int getNodeData() {
		return this.data;
	}
	public int getNextNode() {
		return this.next;
	}
	public int getAddr() {
		return this.addr;
	}
}