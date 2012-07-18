package com.ericsson.algorithms.careermonk.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjacencyMatrix {

	private int[][] weights;
	private boolean isDirected;
	private Node[] nodes;

	public AdjacencyMatrix(int size, boolean isDirected) {
		this.weights = new int[size][size];
		this.nodes = new Node[size];
		this.isDirected = isDirected;

		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	public void add(Node node1, Node node2, int weight) {
		weights[node1.id][node2.id] = weight;
		if (!isDirected)
			weights[node2.id][node1.id] = weight;
	}

	private int[] dist;
	private Node[] previous;

	public int[] dijkstra(Node source) {

		dist = new int[nodes.length];
		previous = new Node[nodes.length];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[source.id] = 0;

		Queue<Node> queue = new PriorityQueue<Node>();
		for (int i = 0; i < nodes.length; i++) {
			queue.add(nodes[i]);
		}

		while (!queue.isEmpty()) {

			Node u = queue.poll();
			if (dist[u.id] == Integer.MAX_VALUE)
				break;

			for (int i = 0; i < nodes.length; i++) {
				if (!u.equals(nodes[i]) && weights[u.id][i] > 0) {

					int distance = dist[u.id] + weights[u.id][i];
					if (distance < dist[nodes[i].id]) {
						dist[nodes[i].id] = distance;
						previous[nodes[i].id] = u;
					}
				}
			}
		}

		return dist;
	}

	public boolean pathExists(Node source, Node destination) {

		if (source.equals(destination))
			return true;

		boolean pathExists = false;
		for (int i = 0; i < nodes.length; i++) {
			if (!source.equals(nodes[i]) && weights[source.id][i] > 0) {
				pathExists = pathExists || pathExists(nodes[i], destination);
				if (pathExists)
					break;
			}
		}

		return pathExists;
	}
	
	public int countPaths(Node source, Node destination) {
		if (source.equals(destination))
			return 1;
		
		 int count = 0;
			
		 for (int i = 0; i < nodes.length; i++) {
			 if (!source.equals(nodes[i]) && weights[source.id][i] > 0) {
				 count = count + countPaths(nodes[i], destination);
			 }
		 }
			
		 return count;
	}

	public static void main(String[] args) {

		AdjacencyMatrix matrix = new AdjacencyMatrix(6, true);

		Node node1 = new Node(0);
		Node node2 = new Node(1);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(4);
		Node node6 = new Node(5);

		matrix.add(node1, node2, 5);
		matrix.add(node1, node3, 3);
		matrix.add(node1, node4, 2);
		matrix.add(node2, node4, 9);
		matrix.add(node2, node5, 1);
		matrix.add(node4, node3, 1);
		matrix.add(node4, node5, 10);
		matrix.add(node5, node6, 8);

		// int[] distances = matrix.dijkstra(node1);
		// for (int i = 0; i < distances.length; i++) {
		// System.out.println("Distance of node" + (i+1) + " from node1 = " +
		// distances[i]);
		// }

		Node source = node1;
		Node destination = node3;

//		System.out.println("Does link between node" + source + " and node"
//				+ destination + " exists? = "
//				+ matrix.pathExists(source, destination));
		
		System.out.println("Number of paths between node" + source + " and node"
				+ destination + " = "
				+ matrix.countPaths(source, destination));
	}

}

class Node implements Comparable<Node> {
	public int id;

	public Node(int index) {
		this.id = index;
	}

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return (id + 1) + "";
	}

	@Override
	public int compareTo(Node o) {
		if (id > o.id)
			return 1;
		else if (id < o.id)
			return -1;
		return 0;
	}
}
