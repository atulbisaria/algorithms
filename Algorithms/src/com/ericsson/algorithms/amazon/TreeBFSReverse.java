package com.ericsson.algorithms.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TreeBFSReverse {

	public static void printLevelOrder(Node<String> root) {
		
		Map<Node<String>, String> state = new HashMap<Node<String>, String>();
		Stack<Node<String>> stack = new Stack<Node<String>>();
		
		TreeQueue<Node<String>> queue = new TreeQueue<Node<String>>();
		queue.push(root);
		
		while(!queue.isEmpty()) {
			//queue.print();
			
			Node<String> node = queue.pop();
			System.out.print(node);
			state.put(node, "visited");
			stack.push(node);
			List<Node<String>> children = node.getChildren();
			for (Node<String> child : children) {
				if(state.get(child) == null) {
					queue.push(child);
				}
			}
		}
		
		System.out.println();
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}
	
	public static void main(String[] args) {
		
		Node<String> node1 = new TreeNode<String>("1");
		Node<String> node2 = new TreeNode<String>("2");
		Node<String> node3 = new TreeNode<String>("3");
		Node<String> node4 = new TreeNode<String>("4");
		Node<String> node5 = new TreeNode<String>("5");
		Node<String> node6 = new TreeNode<String>("6");
		Node<String> node7 = new TreeNode<String>("7");
		Node<String> node8 = new TreeNode<String>("8");
		Node<String> node9 = new TreeNode<String>("9");
		Node<String> node10 = new TreeNode<String>("10");
		
		node1.getChildren().add(node4);
		node1.getChildren().add(node3);
		node1.getChildren().add(node2);
		
		node2.getChildren().add(node6);
		node2.getChildren().add(node5);
		
		node3.getChildren().add(node8);
		node3.getChildren().add(node7);
		
		node4.getChildren().add(node10);
		node4.getChildren().add(node9);
		
		printLevelOrder(node1);
	}
}

interface Node<T> {
	
	public T getNodeData();

	public List<Node<T>> getChildren();
}

class TreeNode<T> implements Node<T> {

	private T data;
	private List<Node<T>> children;

	public TreeNode(T data) {
		this.data = data;
		this.children = new ArrayList<Node<T>>();
	}

	@Override
	public T getNodeData() {
		return data;
	}

	@Override
	public List<Node<T>> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return data.toString() + ", ";
	}
}

class TreeQueue<E> {
	
	private LinkedList<E> queue;

	public TreeQueue() {
		queue = new LinkedList<E>();
	}
	
	public void push(E node) {
		queue.addFirst(node);
	}
	
	public E pop() {
		return queue.removeLast();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public void print() {
		System.out.println(queue.toString());
	}
}
