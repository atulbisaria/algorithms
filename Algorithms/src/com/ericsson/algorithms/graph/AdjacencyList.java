package com.ericsson.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjacencyList {

	private static int STATE_UNDISCOVERED = 0;
	private static int STATE_DISCOVERED = 1;
	
	private int nodeCount;
	private boolean isDirected;
	private Map<Integer, List<Integer>> adjacencyList;
	
	private static int[] distance;
	
	public AdjacencyList(int nodeCount, boolean isDirected) {
		this.nodeCount = nodeCount;
		this.isDirected = isDirected;
		
		this.adjacencyList = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nodeCount; i++) 
			adjacencyList.put(i, new ArrayList<Integer>());
		
		distance = new int[nodeCount];
	}
	
	public void add(int node1, int node2) {
		adjacencyList.get(node1).add(node2);
		if(!isDirected)
			adjacencyList.get(node2).add(node1);
	}
	
	public void remove(int node) {
		adjacencyList.remove(node);
	}
	
	public void breadthFirstSearch() {
		
		Queue<Integer> breadthQueue = new PriorityQueue<Integer>();
		int[] states = new int[nodeCount];
		
		for (int i = 1; i < states.length; i++) 
			states[i] = STATE_UNDISCOVERED;
		
		states[0] = STATE_DISCOVERED;
		distance[0] = 0;
		breadthQueue.add(0);
		
		while(!breadthQueue.isEmpty()) {
			int node = breadthQueue.remove();

			List<Integer> adjacentNodes = adjacencyList.get(node);
			for (Integer adjacentNode : adjacentNodes) {
				if(states[adjacentNode] == STATE_UNDISCOVERED) {
					distance[adjacentNode] = distance[adjacentNode - 1] + 1;
					breadthQueue.add(adjacentNode);
					states[adjacentNode] = STATE_DISCOVERED;
				}
			}
		}
		
	}
	
	public void depthFirstSearch(int node, int[] states) {
		
		states[node] = STATE_DISCOVERED;
		
		List<Integer> adjacentNodes = adjacencyList.get(node);
		for (Integer adjacentNode : adjacentNodes) {
			if(states[adjacentNode] == STATE_UNDISCOVERED) {
				depthFirstSearch(adjacentNode, states);
			}
		}
	}
	
	
	private static List<Integer> sortedList = new ArrayList<Integer>();
	
	public void topologicalSort(List<Integer> rootNodes) {
		
		for (Integer rootNode : rootNodes) {
			sortedList.add(rootNode);
			
			List<Integer> adjacentNodes = adjacencyList.remove(rootNode);
			
		}
	}
	
	public static void main(String[] args) {
		
		AdjacencyList adjacencyList = new AdjacencyList(6, true);
		
		adjacencyList.add(0, 1);
		adjacencyList.add(0, 3);
		adjacencyList.add(1, 4);
		adjacencyList.add(2, 5);
		adjacencyList.add(2, 4);
		adjacencyList.add(3, 1);
		adjacencyList.add(4, 3);
		
//		adjacencyList.breadthFirstSearch();
//		
//		System.out.println(distance[5]);
	}
	
}
