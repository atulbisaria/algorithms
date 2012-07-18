package com.ericsson.algorithms.cormen;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private TreeNode root;
	
	public BinarySearchTree(List<TreeNode> nodes) {
		for (TreeNode treeNode : nodes) {
			insert(treeNode);
		}
	}
	
	public void printInOrder(TreeNode node) {
		
		if(node != null) {
			printInOrder(node.left);
			System.out.print(node.key + " ");
			printInOrder(node.right);
		}
	}
	
	public TreeNode getSmallest() {
		
		if(root != null) {
			TreeNode current = root;
			while(current.left != null)
				current = current.left;
			
			return current;
		}
		
		return null;
	}
	
	public void insert(TreeNode node) {
		
		if(root == null) 
			root = node;
		else {
			TreeNode current = root;
			TreeNode parent = root;
			
			while(current != null) {
				parent = current;
				parent.size++;
				if(node.key < current.key) 
					current = current.left;
				else 
					current = current.right;
			}
			
			if(node.key < parent.key)
				parent.left = node;
			else
				parent.right = node;
		}
	}
	
	public int findRank(TreeNode root, TreeNode node) {
		
		if(root != null && node != null) {
			int rootRank = (root.left == null ? 1 : root.left.size + 1);
			if(node.key == root.key)
				return rootRank;
			else if(node.key < root.key) 
				return findRank(root.left, node);
			else {
				int rightRank = findRank(root.right, node);
				if(rightRank != -1)
					return rootRank + rightRank;
			}
		}
		
		return -1;
	}
	
	public TreeNode findNode(TreeNode root, int rank) {
		
		if(root == null || rank > root.size)
			return null;

		int rootRank = (root.left == null ? 1 : root.left.size + 1);
		if(rank == rootRank)
			return root;
		else {
			if(rank < rootRank)
				return findNode(root.left, rank);
			else 
				return findNode(root.right, rank - rootRank);
		}
	}
	
	public TreeNode findNodeIteratively(int rank) {
		
		if(rank > root.size)
			return null;
		
		TreeNode current = root;
		int currentRank = (current.left == null ? 1 : current.left.size + 1);
		
		while(current != null && rank != currentRank) {
			if(rank < currentRank) {
				current = current.left;
				currentRank = (current.left == null ? 1 : current.left.size + 1);
			}
			else {
				current = current.right;
				rank = rank - currentRank;
				currentRank++;
			}
		}
		
		return current;
	}
	
	public static void main(String[] args) {
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(new TreeNode(10, null));
		nodes.add(new TreeNode(5, null));
		nodes.add(new TreeNode(8, null));
		nodes.add(new TreeNode(15, null));
		nodes.add(new TreeNode(12, null));
		nodes.add(new TreeNode(11, null));
		nodes.add(new TreeNode(3, null));
		nodes.add(new TreeNode(6, null));
		nodes.add(new TreeNode(2, null));
		nodes.add(new TreeNode(20, null));
		nodes.add(new TreeNode(17, null));
		nodes.add(new TreeNode(7, null));
		nodes.add(new TreeNode(12, null));

		BinarySearchTree tree = new BinarySearchTree(nodes);

		tree.printInOrder(tree.root);
		System.out.println();
		System.out.println(tree.findNodeIteratively(13));
//		System.out.println(tree.findRank(tree.root, node1));
//		System.out.println(tree.findRank(tree.root, tree.root));
//		System.out.println(tree.findRank(tree.root, tree.getSmallest()));
		
		
	}
}
