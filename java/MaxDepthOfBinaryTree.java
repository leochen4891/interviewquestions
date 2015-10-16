public class MaxDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = TreeNode.getTestTree1();
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		if (null == root)
			return -1;

		return maxDepth(root, 0);
	}

	private static int maxDepth(TreeNode root, int depth) {
		if (null == root) {
			return depth - 1;
		}

		if (null == root.left && null == root.right) {
			return depth;
		}

		int maxDepth = Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
		return maxDepth;
	}

}
