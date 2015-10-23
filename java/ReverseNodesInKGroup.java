public class ReverseNodesInKGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ReverseNodesInKGroup s = new ReverseNodesInKGroup();
		System.out.println(s.reverseKGroup(n1, 1));
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (null == head || null == head.next || k <= 1)
			return head;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode left = dummyHead;
		ListNode right = head;
		ListNode ret;
		int nodeCount = 0;
		while (null != right) {
			right = right.next;
			nodeCount++;
			if (nodeCount == k) {
				ret = reverseKNodes(left, right, k);
				left = ret;
				nodeCount = 0;
			}
		}
		// if (nodeCount > 0)
		// reverseKNodes(left, right, nodeCount);
		return dummyHead.next;
	}

	// pre --> | 1st --> 2nd --> 3rd -->... kth | --> next
	// within the |...|, reverse each link, and connect pre and next
	// pre --> | 1st <-- 2nd <-- 3rd <--... kth | next
	// pre --> | kth --> (k-1)th --> ...... 1st | --> next
	public ListNode reverseKNodes(ListNode left, ListNode right, int k) {
		if (null == left || null == left.next)
			return null;
		if (k <= 1)
			return left.next;

		ListNode ret = left.next;
		ListNode pre = left.next; // 1st node
		ListNode cur = pre.next; // 2nd node
		ListNode next = cur.next; // 3rd node
		for (int i = 0; i < k - 1; i++) { // k nodes, k-1 edges
			cur.next = pre;
			pre = cur;
			cur = next;
			if (null != next)
				next = next.next;
		}

		left.next.next = right;
		left.next = pre;
		return ret;
	}

}
