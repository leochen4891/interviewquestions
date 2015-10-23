public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val);
		ListNode cur = next;
		while (null != cur) {
			sb.append(" --> ");
			sb.append(cur.val);
			cur = cur.next;
		}
		return sb.toString();
	}
}
