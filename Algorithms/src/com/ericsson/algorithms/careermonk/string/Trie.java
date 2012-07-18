package com.ericsson.algorithms.careermonk.string;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private static final char EMPTY_CHARACTER = " ".toCharArray()[0];
	private Node root;

	public Trie() {
		this.root = new Node(EMPTY_CHARACTER);
	}

	public void put(String key) {
		char[] characters = key.toCharArray();
		Node current = root;
		for (int i = 0; i < characters.length; i++) {
			boolean nodeFound = false;
			List<Node> children = current.getChildren();
			for (Node child : children) {
				if(child.getData() == characters[i]) {
					current = child;
					nodeFound = true;
					break;
				}
			}
			
			if(!nodeFound) {
				Node newNode = new Node(characters[i]);
				current.getChildren().add(newNode);
				current = newNode;
			}
		}
	}
	
	public List<String> findStringsWithPrefix(String prefix) {
		
		char[] characters = prefix.toCharArray();
		Node current = root;
		
		for (int i = 0; i < characters.length; i++) {
			boolean nodeFound = false;
			List<Node> children = current.getChildren();
			for (Node child : children) {
				if(child.getData() == characters[i]) {
					current = child;
					nodeFound = true;
					break;
				}
			}
			
			if(!nodeFound)
				return null;
			
		}
		
		List<String> returnValues = new ArrayList<String>();
		List<String> subValues = findAllPathsFromNode(current);
		for (String subValue : subValues) {
			returnValues.add(prefix + subValue);
		}
		return returnValues;
	}
	
	private List<String> findAllPathsFromNode(Node node) {
		
		List<String> returnValues = new ArrayList<String>();
		
		List<Node> children = node.getChildren();
		for (Node child : children) {
			List<String> values = findAllPathsFromNode(child);
			for (String value : values) {
				returnValues.add(child.getData() + value);
			}
		}
		
		if(returnValues.isEmpty())
			returnValues.add("");
		return returnValues;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.put("abcd");
		trie.put("abxy");
		System.out.println(trie.findStringsWithPrefix("b"));
	}
}

class Node {
	private char data;
	private List<Node> children;

	public Node(char data) {
		this.data = data;
	}
	
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public List<Node> getChildren() {
		if(children == null)
			children = new ArrayList<Node>();
		return children;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}
	
	
}
