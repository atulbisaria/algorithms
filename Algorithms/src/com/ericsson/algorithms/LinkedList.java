package com.ericsson.algorithms;

public class LinkedList {

	private Node head;

	public LinkedList(Node head) {
		this.head = head;
	}

	public static void merge(Node headA, Node headB) {
		
		Node a = headA;
		Node b = headB;
		
		while(a != null && b != null) {
			if(a.data <= b.data) {
				Node c = headB;
				while(c.next.data <= b.data) {
					if(c.data > a.data) {
						Node temp = a.next;
						headB = headA;
						headA = temp;
						a.next = c;
						
						a = temp;

						break;
					}
					
					c = c.next;
				}
			} else {
				Node c = headA;
				while(c.data <= a.data) {
					if(c.data > b.data) {
						Node temp = b.next;
						headA = headB;
						headB = temp;
						b.next = c;
						
						b = temp;
						break;
					}
					
					c = c.next;
				}
			}
		}
		
		if(a != null) {
			print(headA);
		}
		else
			print(headB);
	}
	
	public Node reverse(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node afterHead = head.next;
		Node newHead = reverse(afterHead);
		
		afterHead.next = head;
		head.next = null;
		
		return newHead;
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.print(head.data + " --> ");
		}
	}
	
	public static void main(String[] args) {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		
		Node node4 = new Node(4);
		Node node10 = new Node(10);
		Node node15 = new Node(15);
		Node node18 = new Node(18);
		
		LinkedList listA = new LinkedList(node1);
		LinkedList listB = new LinkedList(node4);
		
		node1.next = node2;
		node2.next = node6;
		node6.next = node8;
		node8.next = node9;
		
		node4.next = node10;
		node10.next = node15;
		node15.next = node18;
		
		merge(node1, node4);
	}
}

class Node {
	
	public int data;
	public Node next;
	
	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return data + "";
	}
	
}
