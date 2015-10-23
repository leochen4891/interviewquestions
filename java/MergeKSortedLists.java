import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MergeKSortedLists s = new MergeKSortedLists();
		ListNode[] lists = new ListNode[3];
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		lists[0] = n1;
		lists[1] = n2;
		lists[2] = n3;
		n1.next = n4;
		n2.next = n5;
		n3.next = n6;

		ListNode newHead = s.mergeKLists(lists);
		newHead = s.mergeKLists(null);
		System.out.println(newHead);
	}

	class Feeder {
		ListNode list;

		public Feeder(ListNode head) {
			this.list = head;
		}

		public boolean hasNext() {
			return null != list;
		}

		public ListNode next() {
			if (!hasNext())
				return null;
			ListNode cur = list;
			list = list.next;
			return cur;
		}

		public int peekNext() {
			return list.val;
		}
	}

	class FeederComparator implements Comparator<Feeder> {
		@Override
		public int compare(Feeder f1, Feeder f2) {
			Integer i1 = f1.hasNext() ? f1.peekNext() : null;
			Integer i2 = f2.hasNext() ? f2.peekNext() : null;
			if (null == i1 && null == i2)
				return 0;
			if (null == i1)
				return -1;
			if (null == i2)
				return 1;
			return i1 - i2;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (null == lists || lists.length <= 0)
			return null;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = null;
		ListNode tail = dummyHead;

		PriorityQueue<Feeder> pq = new PriorityQueue<>(new FeederComparator());
		for (int i = 0; i < lists.length; i++) {
			Feeder f = new Feeder(lists[i]);
			pq.add(f);
		}

		while (!pq.isEmpty()) {
			Feeder minFeeder = pq.poll();
			ListNode min = minFeeder.next();
			if (null != min) {
				tail.next = min;
				tail = tail.next;
			}
			// put feeder back
			if (minFeeder.hasNext()) {
				pq.add(minFeeder);
			}
		}

		return dummyHead.next;
	}
}
