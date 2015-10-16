package org.leochen.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.leochen.algorithms.Graph.NodeStatus;

public class GraphTraversal {

	public static void main(String[] args) {
		Graph g = Graph.getUndirectedBinaryTree();
		System.out.println(BFS(g, 0));

		g.clearNodesStatus();
		System.out.println(DFS(g, 0));

		g.clearNodesStatus();
		System.out.println(DFSRecursive(g, 0));
		printTimes();
	}

	static int[] entry_time = null;
	static int[] exit_time = null;
	static int time = 0;

	private static void printTimes() {
		for (int i = 0; i < entry_time.length; i++) {
			System.out.println("entry time of node " + i + " is " + entry_time[i]);
			System.out.println("exit time of node  " + i + " is " + exit_time[i]);
		}
	}

	private static List<Integer> DFSRecursive(Graph g, int src) {
		List<Integer> ret = new ArrayList<Integer>();
		int[] parent = new int[g.numOfNodes];

		time = 0;
		entry_time = new int[g.numOfNodes];
		exit_time = new int[g.numOfNodes];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		parent[src] = -1;
		DFSRecursionHelper(g, src, ret, parent);

		return ret;
	}

	private static void DFSRecursionHelper(Graph g, int src, List<Integer> ret, int[] parent) {
		if (src < 0 || src >= g.numOfNodes)
			return;
		g.nodeStatus[src] = NodeStatus.DISCOVERED;
		ret.add(src);
		entry_time[src] = time++;

		EdgeNode e = g.edgeNodes[src];
		while (null != e) {
			int end = e.otherEnd;
			if (g.nodeStatus[end] == NodeStatus.UNDISCOVERED) {
				parent[e.otherEnd] = src;
				DFSRecursionHelper(g, e.otherEnd, ret, parent);
			}
			e = e.next;
		}

		exit_time[src] = time++;
		g.nodeStatus[src] = NodeStatus.PROCESSED;
	}

	private static List<Integer> DFS(Graph g, int src) {
		List<Integer> ret = new ArrayList<Integer>(g.numOfNodes);

		Stack<Integer> s = new Stack<Integer>();
		s.push(src);
		g.nodeStatus[src] = NodeStatus.DISCOVERED;

		while (!s.isEmpty()) {
			int node = s.pop();
			g.nodeStatus[node] = NodeStatus.PROCESSED;
			ret.add(node);

			EdgeNode e = g.edgeNodes[node];
			while (null != e) {
				int end = e.otherEnd;
				if (g.nodeStatus[end] == NodeStatus.UNDISCOVERED) {
					s.push(end);
					g.nodeStatus[end] = NodeStatus.DISCOVERED;
				}
				e = e.next;
			}
		}
		return ret;
	}

	private static List<Integer> BFS(Graph g, int src) {
		List<Integer> ret = new ArrayList<Integer>(g.numOfNodes);

		// pick any node to be the start node
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(src);
		g.nodeStatus[src] = NodeStatus.DISCOVERED;
		while (!q.isEmpty()) {
			int node = q.poll();
			g.nodeStatus[node] = NodeStatus.PROCESSED;
			ret.add(node);

			EdgeNode e = g.edgeNodes[node];
			while (null != e) {
				int end = e.otherEnd;
				if (g.nodeStatus[end] == NodeStatus.UNDISCOVERED) {
					q.offer(end);
					g.nodeStatus[end] = NodeStatus.DISCOVERED;
				}
				e = e.next;
			}
		}

		return ret;
	}
}
