import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = TreeNode.getTestTree2();

		System.out.println(preorderTraversal(root));
		System.out.println(preorderTraversalIterative(root));
		System.out.println(postorderTraversal(root));
		System.out.println(postorderTraversalIterative(root));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		preorderTraversal(root, ret);
		return ret;
	}

	private static void preorderTraversal(TreeNode root, List<Integer> ret) {
		if (null == root)
			return;
		ret.add(root.val);
		preorderTraversal(root.left, ret);
		preorderTraversal(root.right, ret);
	}

	public static List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (null == root) {
			return ret;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ret.add(node.val);

			if (null != node.right) {
				stack.push(node.right);
			}

			if (null != node.left) {
				stack.push(node.left);
			}
		}

		return ret;
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		postorderTraversal(root, ret);
		return ret;
	}

	private static void postorderTraversal(TreeNode root, List<Integer> ret) {
		if (null == root)
			return;
		postorderTraversal(root.left, ret);
		postorderTraversal(root.right, ret);
		ret.add(root.val);
	}

	public static List<Integer> postorderTraversalIterative(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (null == root) {
			return ret;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			if (null != node.left) {
				stack.push(node.left);
			}
			if (null != node.right) {
				stack.push(node.right);
			}

			ret.add(node.val);
		}
		Collections.reverse(ret);

		return ret;
	}

}
