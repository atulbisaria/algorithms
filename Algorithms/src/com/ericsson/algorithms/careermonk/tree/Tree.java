package com.ericsson.algorithms.careermonk.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

	private static int STATE_WHITE = 0;
	private static int STATE_GRAY = 1;
	private static int STATE_BLACK = 2;
	
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public void insert(Node parent, Node child) {
		parent.getChildren().add(child);
	}
	
	private Node dfsVisit(Node source, Node a, Node b, int[] states) {
		

		states[source.id] = STATE_GRAY;
		
		Node leastCommonAncestor = null;
		List<Node> children = source.getChildren();
		for (Node child : children) {
			if(states[child.id] == STATE_WHITE) {
				leastCommonAncestor = dfsVisit(child, a, b, states);
				if(leastCommonAncestor != null)
					break;
				else {
					// checking if source is lca
					if(states[source.id] == STATE_GRAY) {
						if (states[a.id] == STATE_BLACK && states[b.id] == STATE_BLACK) {
							return source;
						} else if(source.equals(a) && states[b.id] == STATE_BLACK)  {
							return a;
						} else if(source.equals(b) && states[a.id] == STATE_BLACK) {
							return b;
						}
					}
				}
			}
		}
		
		states[source.id] = STATE_BLACK;
		return leastCommonAncestor;
	}
	
	public Node leastCommonAncestor(Node root, Node a, Node b, int[] states) {
		
		Node leastCommonAncestor = null;
		states[root.id] = STATE_GRAY;

		List<Node> children = root.getChildren();
		for (Node child : children) {
			if(states[child.id] == STATE_WHITE) {
				leastCommonAncestor = dfsVisit(child, a, b, states);
				if(leastCommonAncestor != null)
					break;
			}
		}
		
		return leastCommonAncestor;
	}
	
	public Node leastCommonAncestor(Node root, Node a, Node b) {
		
		Node leastCommonAncestor = null;

		List<Node> children = root.getChildren();
		for (Node child : children) {
			boolean isADescendant = isDescendant(child, a);
			boolean isBDescendant = isDescendant(child, b);
			if(isADescendant && isBDescendant)
				return leastCommonAncestor(child, a, b);
			else 
				return root;
		}
		
		return leastCommonAncestor;
	}
	
	public boolean isDescendant(Node source, Node node) {
		
		List<Node> children = source.getChildren();
		if(children.contains(node))
			return true;
		
		for (Node child : children) {
			if(isDescendant(child, node))
				return true;
		}
		
		return false;
	}
	
	public void preOrderIterative(Node root) {
		
		if(root != null) {
			System.out.println(root + ", ");

		}
	}
	
	public static void main(String[] args) {
		
		Node node1 = new Node(0);
		Node node2 = new Node(1);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(4);
		Node node6 = new Node(5);
		Node node7 = new Node(6);
		Node node8 = new Node(7);
		Node node9 = new Node(8);
		Node node10 = new Node(9);
		
		Tree tree = new Tree(node1);
		
		tree.insert(node1, node2);
		tree.insert(node1, node3);
		tree.insert(node1, node4);
		
		tree.insert(node2, node5);
		tree.insert(node2, node6);
		
		tree.insert(node3, node7);
		tree.insert(node4, node8);
		tree.insert(node6, node9);
		tree.insert(node7, node10);
		
		System.out.println("LCA = " + tree.leastCommonAncestor(node1, node5, node9));
		//System.out.println("Is Descendant = " + tree.isDescendant(node3, node9));
	}
	
}

class Node {
	public int id;
	private List<Node> children;
	
	public Node(int id) {
		this.id = id;
		children = new ArrayList<Node>();
	}

	public List<Node> getChildren() {
		return children;
	}
	
	@Override
	public String toString() {
		return (id + 1) + "";
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return id == node.id;
	}
}
