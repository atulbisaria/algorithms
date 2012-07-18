package com.ericsson.algorithms.careermonk.string;

public class TernarySearchTree {

	private TSTNode root;
	
	public void insert(TSTNode current, String s, int position) {
		if(current == null) {
			current = new TSTNode(s.charAt(position));
			if(root == null)
				root = current;
		}
		
		if(current.getData() < s.charAt(position)) {
			insert(current.getLokid(), s, position + 1);
		} else if(current.getData() > s.charAt(position)) {
			insert(current.getHikid(), s, position + 1);
		} else {
			if(position == (s.length() - 1)) {
				current.setEndOfTree(true);
			} else {
				insert(current.getEqkid(), s, position + 1);
			}
		}
//		char[] characters = s.toCharArray();
//		if(characters.length > 0) {
//			if(root == null) {
//				root = new TSTNode(characters[0]);
//			}
//			
//			TSTNode current = root;
//			while(current.getData() != characters[0]) {
//				if(characters[0] < current.getData()) {
//					if(current.getLokid() == null)
//						current.setLokid(new TSTNode(characters[0]));
//					current = current.getLokid();
//				}
//				else {
//					if(current.getHikid() == null)
//						current.setHikid(new TSTNode(characters[0]));
//					current = current.getHikid();
//				}
//			}
//			
//			// current should point to characters[0] node
//			
//			for (int i = 1; i < characters.length; i++) {
//
//				if (current.getData() < characters[i - 1]) {
//					if (current.getHikid() == null)
//						current.setHikid(new TSTNode(characters[i]));
//					current = current.getHikid();
//				} else if (current.getData() > characters[i - 1]) {
//					if (current.getLokid() == null)
//						current.setLokid(new TSTNode(characters[i]));
//					current = current.getLokid();
//				} else {
//					if (current.getEqkid() == null)
//						current.setEqkid(new TSTNode(characters[i]));
//					current = current.getEqkid();
//				}
//				
//				if(i == (characters.length - 1)) {
//					current.setEndOfTree(true);
//				}
//			}
//		}
	}
	
	public boolean isPresent(String s) {
		char[] characters = s.toCharArray();
		
		TSTNode current = root;
		for (int i = 0; i < characters.length; i++) {
			if(current == null)
				return false;
			
			if(characters[i] < current.getData()) {
				current = current.getLokid();
			} else if(characters[i] > current.getData()) {
				current = current.getHikid();
			} else {
				current = current.getEqkid();
			}
		}
		
		if(current.isEndOfTree())
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		TernarySearchTree tree = new TernarySearchTree();
		
		tree.insert("boats");
		tree.insert("boat");
		tree.insert("bat");
		tree.insert("bats");
		
		System.out.println(tree.isPresent("bats"));
	}
}

class TSTNode {
	private char data;
	private boolean isEndOfTree;
	
	private TSTNode lokid;
	private TSTNode eqkid;
	private TSTNode hikid;

	public TSTNode(char data) {
		this.data = data;
	}
	
	public TSTNode getLokid() {
		return lokid;
	}
	public void setLokid(TSTNode lokid) {
		this.lokid = lokid;
	}
	public TSTNode getEqkid() {
		return eqkid;
	}
	public void setEqkid(TSTNode eqkid) {
		this.eqkid = eqkid;
	}
	public TSTNode getHikid() {
		return hikid;
	}
	public void setHikid(TSTNode hikid) {
		this.hikid = hikid;
	}
	public char getData() {
		return data;
	}

	public boolean isEndOfTree() {
		return isEndOfTree;
	}

	public void setEndOfTree(boolean isEndOfTree) {
		this.isEndOfTree = isEndOfTree;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}