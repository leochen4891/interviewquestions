

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A tri-nary tree is much like a binary tree but with three child nodes for each parent instead of two -- with the left
 * node being values less than the parent, the right node values greater than the parent, and the middle nodes values
 * equal to the parent.
 * <p>
 * public void insert (int value)<br>
 * public boolean delete (int value)<br>
 * 
 * @author Lei Chen
 */
public class TriTree {
	Node root;

	public TriTree() {
		this.root = null;
	}

	public void insert(int value) {
		if (null == root) {
			root = new Node(value);
		} else {
			root.insert(value);
		}
	}

	public boolean delete(int value) {
		if (null == root)
			return false;
		else {
			if (value == root.getValue() && null == root.getMid()) {
				root = null;
			} else {
				root.delete(value, null);
			}
		}
		return true;
	}

	// BFS the tree
	public String toString() {
		if (null == root)
			return null;

		StringBuilder sb = new StringBuilder();
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			sb.append(node + ", ");
			if (null != node.getLeft())
				queue.add(node.getLeft());
			if (null != node.getMid())
				queue.add(node.getMid());
			if (null != node.getRight())
				queue.add(node.getRight());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		TriTree tree = new TriTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(9);
		tree.insert(5);
		tree.insert(7);
		tree.insert(2);
		tree.insert(2);

		System.out.println(tree.toString());
	}
}

// Node for a TriTree
class Node {
	private int value;
	private Node left;
	private Node mid;
	private Node right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.mid = null;
		this.right = null;
	}

	public int getValue() {
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getMid() {
		return mid;
	}

	public Node getRight() {
		return right;
	}

	public void insert(int value) {
		if (this.value == value) { // mid
			if (null == this.mid) {
				this.mid = new Node(value);
			} else {
				this.mid.insert(value);
			}
		} else if (this.value > value) { // left
			if (null == this.left) {
				this.left = new Node(value);
			} else {
				this.left.insert(value);
			}
		} else { // right
			if (null == this.right) {
				this.right = new Node(value);
			} else {
				this.right.insert(value);
			}
		}
	}

	public boolean delete(int value, Node parent) {
		if (this.value > value) { // left
			if (null == left) {
				return false;
			} else {
				return left.delete(value, this);
			}
		} else if (this.value < value) { // right
			if (null == right) {
				return false;
			} else {
				return right.delete(value, this);
			}
		} else { // this.value = value
			if (null != this.mid) {
				this.mid = this.mid.mid;
			} else { // null == mid
				if (null != left) { // has left
					int max = left.getMax();
					this.value = max;
					this.left.delete(max, this);
				} else if (null != right) { // has right
					int min = right.getMin();
					this.value = min;
					this.right.delete(min, this);
				} else { // both left and right are null
					// leaf node, remove if from its parent
					if (null != parent) {
						parent.removeLeafChild(value);
					}
				}
			}
			return true;
		}
	}

	private void removeLeafChild(int value) {
		if (null != left && left.value == value) {
			this.left = null;
		} else if (null != mid && mid.value == value) {
			this.mid = null;
		} else { // right
			this.right = null;
		}
	}

	private int getMin() {
		if (null != left) {
			return left.getMin();
		}
		return this.value;
	}

	private int getMax() {
		if (null != right) {
			return right.getMax();
		}
		return this.value;
	}

	public String toString() {
		return Integer.toString(this.value);
	}
}
