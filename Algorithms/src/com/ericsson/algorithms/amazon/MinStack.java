package com.ericsson.algorithms.amazon;

public class MinStack<T extends Comparable<T>> {

	public StackNode<T> top;
	public StackNode<T> minStackTop;
	
	public void push(T data) {
		StackNode<T> node = new StackNode<T>(data);
		if(top != null)
			node.next = top;
		top = node;
		
		StackNode<T> minStackNode = new StackNode<T>(data);
		if(minStackTop != null) {
			if(node.data.compareTo(minStackTop.data) >= 0) {
				minStackNode = new StackNode<T>(minStackTop.data);
			}
			minStackNode.next = minStackTop;
		}
		minStackTop = minStackNode;
	}
	
	public T findMin() {
		if(minStackTop != null)
			return minStackTop.data;
		return null;
	}
}

class StackNode<T> {
	
	public T data;
	public StackNode<T> next;
	
	public StackNode(T data) {
		this.data = data;
	}
}
