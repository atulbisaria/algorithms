package com.ericsson.algorithms.careermonk.tree;


public class BinaryTreeNode {
	public int id;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int id) {
		this.id = id;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
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
		BinaryTreeNode node = (BinaryTreeNode) obj;
		return id == node.id;
	}
}
