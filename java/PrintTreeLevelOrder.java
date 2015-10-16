

import java.util.Stack;

public class PrintTreeLevelOrder {
	private static BTNode tree;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		tree = initNodes();
		// for (int i = 0; i < 5; i++) {
		// System.out.print("\nlevel " + i + ": ");
		// printTreeLevel(tree, i);
		// }

		printTreeLevelZigZag(tree, true);
	}

	private static void printTreeLevel(BTNode tree, int level) {
		if (null == tree)
			return;
		if (level <= 0) {
			System.out.print(tree.getData() + " ");
		} else {
			printTreeLevel(tree.getLeft(), level - 1);
			printTreeLevel(tree.getRight(), level - 1);
		}
	}

	private static void printTreeLevelZigZag(BTNode tree, boolean left2Right) {
		if (null == tree) {
			return;
		}

		Stack<BTNode> stack1 = new Stack<BTNode>();
		Stack<BTNode> stack2 = new Stack<BTNode>();

		if (left2Right) {
			stack1.push(tree);
		} else {
			stack2.push(tree);
		}

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			BTNode node = null;
			if (left2Right) {
				if (stack1.isEmpty()) {
					left2Right = !left2Right;
				} else {
					node = stack1.pop();
				}
			} else {
				if (stack2.isEmpty()) {
					left2Right = !left2Right;
				} else {
					node = stack2.pop();
				}
			}
			if (null == node) {
				continue;
			}
			System.out.println(node.getData());

			if (left2Right) {
				if (node.hasLeft()) {
					stack2.push(node.getLeft());
				}
				if (node.hasRight()) {
					stack2.push(node.getRight());
				}
			} else {
				if (node.hasRight()) {
					stack1.push(node.getRight());
				}
				if (node.hasLeft()) {
					stack1.push(node.getLeft());
				}
			}
		}
	}

	private static BTNode initNodes() {
		int SIZE = 10;
		BTNode[] nodes = new BTNode[SIZE];
		for (int i = 0; i < SIZE; i++) {
			nodes[i] = new BTNode();
			nodes[i].setData(i);
		}
		nodes[0].setLeft(nodes[1]);
		nodes[0].setRight(nodes[2]);

		nodes[1].setLeft(nodes[3]);
		nodes[1].setRight(nodes[4]);

		nodes[2].setLeft(nodes[5]);
		nodes[2].setRight(nodes[6]);

		nodes[3].setLeft(nodes[7]);
		nodes[3].setRight(nodes[8]);

		nodes[4].setLeft(nodes[9]);
		nodes[4].setRight(null);

		return nodes[0];
	}
}