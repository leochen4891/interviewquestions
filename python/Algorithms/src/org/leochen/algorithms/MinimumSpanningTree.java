package org.leochen.algorithms;

public class MinimumSpanningTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Graph g = Graph.getUndirectedHexagonWeighted();
		Graph g = prims(g, 0);
	}

	public static Graph prims(Graph g, int src) {

	}
}
