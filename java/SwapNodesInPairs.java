public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n3.next = n4;
		n4.next = n5;

		SwapNodesInPairs s = new SwapNodesInPairs();
		System.out.println(n1);
		System.out.println(s.swapPairs(n1));
		System.out.println(n3);
		System.out.println(s.swapPairs(n3));
	}

	public ListNode swapPairs(ListNode head) {
		if (null == head || head.next == null)
			return head;

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		ListNode pre = dummyHead;
		ListNode cur = pre.next; // head
		ListNode next = cur.next; // head.next

		while (null != next) {
			cur.next = next.next;
			next.next = cur;
			pre.next = next;

			pre = pre.next.next;
			cur = pre.next;
			next = (null != cur && null != cur.next) ? cur.next : null;
		}

		return dummyHead.next;
	}

}
