package com.ericsson.algorithms.careermonk.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjacencyList {

	private static int STATE_WHITE = 0;
	private static int STATE_GRAY = 1;
	private static int STATE_BLACK = 2;
	
	private int nodeCount;
	private boolean isDirected;
	private Map<Node, List<Node>> adjacencyList;
	private Node[] nodes;
	
	private static int[] distance;
	
	public AdjacencyList(int nodeCount, boolean isDirected) {
		this.nodeCount = nodeCount;
		this.isDirected = isDirected;
		
		this.adjacencyList = new HashMap<Node, List<Node>>();
		this.nodes = new Node[nodeCount];
		for (int i = 0; i < nodeCount; i++) {
			nodes[i] = new Node(i);
			adjacencyList.put(nodes[i], new ArrayList<Node>());
		}

		
		distance = new int[nodeCount];
	}
	
	public void add(Node node1, Node node2) {
		adjacencyList.get(node1).add(node2);
		if(!isDirected)
			adjacencyList.get(node2).add(node1);
	}
	
	public void remove(Node node) {
		adjacencyList.remove(node);
	}
	
	public void breadthFirstSearch() {
		
		Queue<Node> breadthQueue = new PriorityQueue<Node>();
		int[] states = new int[nodeCount];
		
		for (int i = 1; i < states.length; i++) 
			states[i] = STATE_WHITE;
		
		states[0] = STATE_GRAY;
		distance[0] = 0;
		breadthQueue.add(nodes[0]);
		
		while(!breadthQueue.isEmpty()) {
			Node node = breadthQueue.remove();

			List<Node> adjacentNodes = adjacencyList.get(node);
			for (Node adjacentNode : adjacentNodes) {
				if(states[adjacentNode.id] == STATE_WHITE) {
					distance[adjacentNode.id] = distance[adjacentNode.id - 1] + 1;
					breadthQueue.add(adjacentNode);
					states[adjacentNode.id] = STATE_GRAY;
				}
			}
		}
		
	}
	
	public void depthFirstSearch(Node node, int[] states) {
		
		states[node.id] = STATE_GRAY;
		
		List<Node> adjacentNodes = adjacencyList.get(node);
		for (Node adjacentNode : adjacentNodes) {
			if(states[adjacentNode.id] == STATE_WHITE) {
				depthFirstSearch(adjacentNode, states);
			}
		}
	}
	
	
	private static List<Integer> sortedList = new ArrayList<Integer>();
	
	public void topologicalSort(List<Integer> rootNodes) {
		
//		for (Integer rootNode : rootNodes) {
//			sortedList.add(rootNode);
//			
//			List<Integer> adjacentNodes = adjacencyList.remove(rootNode);
//			
//		}
	}
	
	public boolean pathExists(Node source, Node destination) {
		
		if (source.equals(destination))
			return true;

		boolean pathExists = false;
		for (int i = 0; i < nodes.length; i++) {
			if (!source.equals(nodes[i]) && adjacencyList.get(source).contains(nodes[i])) {
				pathExists = pathExists || pathExists(nodes[i], destination);
				if (pathExists)
					break;
			}
		}

		return pathExists;
	}
	
	private boolean dfsForCycleUndirected(Node node, int[] states) {
		
		states[node.id] = STATE_GRAY;
		boolean hasCycle = false;
		
		List<Node> adjacentNodes = adjacencyList.get(node);
		for (Node adjacentNode : adjacentNodes) {
			if(states[adjacentNode.id] == STATE_WHITE) {
				hasCycle = hasCycle || dfsForCycleUndirected(adjacentNode, states);
			}
			else if(states[adjacentNode.id] == STATE_BLACK)
				return true;
		}
		
		states[node.id] = STATE_BLACK;
		return hasCycle;
	}
	
	public boolean hasCycleUndirected() {
		
		int[] states = new int[nodes.length];
		Arrays.fill(states, STATE_WHITE);
		boolean hasCycle = false;
		
		for (int i = 0; i < nodes.length; i++) {
			if(states[i] == STATE_WHITE)
				hasCycle = hasCycle || dfsForCycleUndirected(nodes[i], states);
		}
		
		return hasCycle;
	}
	
	private boolean dfsForCycleDirected(Node node, int[] states) {
		
		states[node.id] = STATE_GRAY;
		boolean hasCycle = false;
		
		List<Node> adjacentNodes = adjacencyList.get(node);
		for (Node adjacentNode : adjacentNodes) {
			if(states[adjacentNode.id] == STATE_WHITE) {
				hasCycle = hasCycle || dfsForCycleDirected(adjacentNode, states);
			}
			else if(states[adjacentNode.id] == STATE_GRAY)
				return true;
		}
		
		states[node.id] = STATE_BLACK;
		return hasCycle;
	}
	
	public boolean hasCycleDirected() {
		
		int[] states = new int[nodes.length];
		Arrays.fill(states, STATE_WHITE);
		boolean hasCycle = false;
		
		for (int i = 0; i < nodes.length; i++) {
			if(states[i] == STATE_WHITE)
				hasCycle = hasCycle || dfsForCycleDirected(nodes[i], states);
		}
		
		return hasCycle;
	}
	
	public static void main(String[] args) {
		
		AdjacencyList adjacencyList = new AdjacencyList(6, true);
		
		Node node1 = new Node(0);
		Node node2 = new Node(1);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(4);
		Node node6 = new Node(5);
		
		adjacencyList.add(node1, node2);
		//adjacencyList.add(node1, node3);
		//adjacencyList.add(node1, node4);
		adjacencyList.add(node2, node4);
		//adjacencyList.add(node2, node5);
		adjacencyList.add(node4, node3);
		adjacencyList.add(node4, node5);
		adjacencyList.add(node5, node6);
		
		adjacencyList.add(node5, node2);
		
		
//		Node source = node1;
//		Node destination = node6;
//
//		System.out.println("Does link between node" + source + " and node"
//				+ destination + " exists? = "
//				+ adjacencyList.pathExists(source, destination));
		
		System.out.println(adjacencyList.hasCycleDirected());
		
//		adjacencyList.breadthFirstSearch();
//		
//		System.out.println(distance[5]);
	}
	
}
