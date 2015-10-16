package org.leochen.algorithms;

public class EdgeNode {
	int otherEnd;
	int weight;
	EdgeNode next;

	public EdgeNode(int otherEnd) {
		this(0, otherEnd);
	}

	public EdgeNode(int otherEnd, int weight) {
		this.otherEnd = otherEnd;
		this.weight = weight;
		this.next = null;
	}
}
