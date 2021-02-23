package com.practice.datastructure;

public class LinkedListTest {
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	void printMiddle(){
		Node slow_pointer = head;
		Node fast_pointer = head;
		if(head != null){
			while(slow_pointer != null && fast_pointer != null){
				fast_pointer = fast_pointer.next.next;
				slow_pointer = slow_pointer.next;
			}
			System.out.println("Middle Node is : "+slow_pointer.data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
