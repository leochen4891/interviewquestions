public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	private static TreeNode testTree1 = null;
	private static TreeNode testTree2 = null;

	//@formatter:off
	/**        
	 *
	 * &nbsp;&nbsp;&nbsp;		3<br>
	 * &nbsp;&nbsp;		   / \<br>
	 * 	                   9 &nbsp; 20<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; /  \<br>
	 * &nbsp;&nbsp;   15 &nbsp; 7<br>
	 * 
	 * @return
	 */
	//@formatter:on
	public static TreeNode getTestTree1() {
		if (testTree1 == null) {
			TreeNode[] nodes = new TreeNode[5];
			nodes[0] = new TreeNode(3);
			nodes[1] = new TreeNode(9);
			nodes[2] = new TreeNode(20);
			nodes[3] = new TreeNode(15);
			nodes[4] = new TreeNode(7);

			nodes[0].left = nodes[1];
			nodes[0].right = nodes[2];
			nodes[2].left = nodes[3];
			nodes[2].right = nodes[4];

			testTree1 = nodes[0];
		}

		return testTree1;
	}

	//@formatter:off
	/**
	 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0 <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/ &nbsp;&nbsp;&nbsp;\<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<br>
	 *  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/ &nbsp;\ &nbsp;&nbsp;&nbsp;&nbsp;/ &nbsp;\ <br>
	 *  &nbsp;&nbsp;&nbsp;&nbsp;3 &nbsp;&nbsp;&nbsp;4 &nbsp;&nbsp;&nbsp;5 &nbsp;&nbsp;&nbsp;6<br>
	 *  &nbsp;&nbsp;/ &nbsp;\ &nbsp;&nbsp;/<br>
	 *  7 &nbsp;&nbsp;&nbsp;8 &nbsp;9<br>
	 * 
	 * @return
	 */
	//@formatter:on
	public static TreeNode getTestTree2() {
		if (testTree2 == null) {
			final int SIZE = 10;
			TreeNode[] nodes = new TreeNode[SIZE];
			for (int i = 0; i < SIZE; i++) {
				nodes[i] = new TreeNode(i);
			}

			nodes[0].left = (nodes[1]);
			nodes[0].right = (nodes[2]);

			nodes[1].left = (nodes[3]);
			nodes[1].right = (nodes[4]);

			nodes[2].left = (nodes[5]);
			nodes[2].right = (nodes[6]);

			nodes[3].left = (nodes[7]);
			nodes[3].right = (nodes[8]);

			nodes[4].left = (nodes[9]);
			nodes[4].right = (null);

			testTree2 = nodes[0];
		}

		return testTree2;
	}
}
