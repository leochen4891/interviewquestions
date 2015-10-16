package org.leochen.algorithms;

public class Graph {
	public enum NodeStatus {
		UNDISCOVERED, DISCOVERED, PROCESSED
	}

	int numOfNodes;
	EdgeNode[] edgeNodes;
	NodeStatus[] nodeStatus;
	boolean directed;

	public Graph(int n, boolean directed) {
		this.numOfNodes = n;
		this.edgeNodes = new EdgeNode[n];
		this.directed = directed;
		this.nodeStatus = new NodeStatus[n];
		clearNodesStatus();
	}

	public void clearNodesStatus() {
		for (int i = 0; i < numOfNodes; i++) {
			this.nodeStatus[i] = NodeStatus.UNDISCOVERED;
		}
	}

	public void addEdge(int n1, int n2) {
		addEdge(n1, n2, 1);
	}

	public void addEdge(int n1, int n2, int weight) {
		EdgeNode head = this.edgeNodes[n1];
		this.edgeNodes[n1] = new EdgeNode(n2, weight);
		this.edgeNodes[n1].next = head;
		if (!directed) {
			head = this.edgeNodes[n2];
			this.edgeNodes[n2] = new EdgeNode(n1);
			this.edgeNodes[n2].next = head;
		}
	}

	// @formatter:off 
	/*
	 * A full binary tree
	 *      0
	 *    1   2
	 *   3 4 5 6
	 */
	//@formatter:on
	public static Graph getUndirectedBinaryTree() {
		Graph g = new Graph(7, false);
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 6);
		g.addEdge(2, 5);
		return g;
	}

	public static Graph getDirectedBinaryTree() {
		Graph g = new Graph(7, true);
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 6);
		g.addEdge(2, 5);
		return g;
	}

	public static Graph getDirectedBinaryTreeWithBackEdge() {
		Graph g = new Graph(7, true);
		g.addEdge(4, 1);

		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 6);
		g.addEdge(2, 5);
		return g;
	}

	// @formatter:off 
	/*                  weight
	 *      5 - 3     : 1
	 *     / \ / \    : 1, 2, 2, 1
	 *    1 - 0 - 2   : 2, 2
	 *     \ / \ /    : 1, 2, 2, 1 
	 *      6 - 4     : 1
	 */
	//@formatter:on

	public static Graph getUndirectedHexagonWeighted() {
		int size = 7;
		Graph g = new Graph(size, false);
		g.addEdge(0, 6, 2);
		g.addEdge(0, 5, 2);
		g.addEdge(0, 4, 2);
		g.addEdge(0, 3, 2);
		g.addEdge(0, 2, 2);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 5, 1);
		g.addEdge(1, 6, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 5, 1);
		g.addEdge(4, 6, 1);
		return g;
	}
}
