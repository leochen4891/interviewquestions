public class IsSameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode[] nodesP = new TreeNode[5];
		nodesP[0] = new TreeNode(3);
		nodesP[1] = new TreeNode(9);
		nodesP[2] = new TreeNode(20);
		nodesP[3] = new TreeNode(15);
		nodesP[4] = new TreeNode(7);

		nodesP[0].left = nodesP[1];
		nodesP[0].right = nodesP[2];
		nodesP[2].left = nodesP[3];
		nodesP[2].right = nodesP[4];

		TreeNode[] nodesQ = new TreeNode[5];
		nodesQ[0] = new TreeNode(3);
		nodesQ[1] = new TreeNode(9);
		nodesQ[2] = new TreeNode(20);
		nodesQ[3] = new TreeNode(15);
		nodesQ[4] = new TreeNode(7);

		nodesQ[0].left = nodesQ[1];
		nodesQ[0].right = nodesQ[2];
		nodesQ[2].left = nodesQ[3];
		nodesQ[2].right = nodesQ[4];

		TreeNode p = nodesP[0];
		TreeNode q = nodesQ[0];

		System.out.println(isSameTree(p, q));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (null == p && null == q) {
			return true;
		}

		if ((null == p && null != q) || (null == q && null != p)) {
			return false;
		}

		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}

}
