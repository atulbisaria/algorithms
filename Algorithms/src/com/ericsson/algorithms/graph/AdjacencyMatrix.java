package com.ericsson.algorithms.graph;

public class AdjacencyMatrix {

	private int[][] graph;
	private boolean isDirected;

	public AdjacencyMatrix(int size, boolean isDirected) {
		this.graph = new int[size][size];
		this.isDirected = isDirected;
	}
	
	public void add(int node1, int node2) {
		graph[node1][node2] = 1;
		if(!isDirected)
			graph[node2][node1] = 1;
	}
	
	public boolean breadthFirstSearch(int node) {
		boolean isPresent = false;
		
		
		
		
		return isPresent;
	}
	
}
