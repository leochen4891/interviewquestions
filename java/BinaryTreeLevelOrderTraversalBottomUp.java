import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalBottomUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = TreeNode.getTestTree1();
		// for (int i = 0; i < 10; i++) {
		// List<Integer> ret = new LinkedList<Integer>();
		// addNodesByLevel(root, i, ret);
		// System.out.println(ret);
		// }

		List<List<Integer>> ret = levelOrderBottom(root);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}

	}

	// {3,9,20,#,#,15,7}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		int MAX_LEVEL = 100;
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (null == root) {
			return null;
		}

		for (int i = 0; i < MAX_LEVEL; i++) {
			ret.add(new LinkedList<Integer>());
			addNodesByLevel(root, i, ret.get(i));
			if (ret.get(i).size() <= 0) {
				ret.remove(i);
				break;
			}
		}

		Collections.reverse(ret);

		return ret;
	}

	private static void addNodesByLevel(TreeNode root, int level, List<Integer> ret) {
		if (null == root) {
			return;
		}
		if (0 == level) {
			ret.add(root.val);
		} else {
			addNodesByLevel(root.left, level - 1, ret);
			addNodesByLevel(root.right, level - 1, ret);
		}
		return;
	}

}
