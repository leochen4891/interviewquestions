

public class BTNode {
	private int data;
	private BTNode left;
	private BTNode right;

	public BTNode() {
		data = 0;
		left = null;
		right = null;
	}

	public BTNode(int data, BTNode left, BTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public BTNode getLeft() {
		return left;
	}

	public BTNode getRight() {
		return right;
	}

	public boolean hasLeft() {
		return null != left;
	}

	public boolean hasRight() {
		return null != right;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
}
