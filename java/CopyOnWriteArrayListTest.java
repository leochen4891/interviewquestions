

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	private CopyOnWriteArrayList<Object> list;

	// private List<Object> list1;

	public CopyOnWriteArrayListTest() {
		this.list = new CopyOnWriteArrayList<Object>();
		// this.list1 = new ArrayList<Object>();
	}

	public void test() {
		List<Object> l1;
		List<Object> l2;
		System.out.println("list = " + list);
		System.out.println("list = " + Integer.toHexString(list.hashCode()));

		Object p1 = new Object();
		System.out.println("p1 = " + p1);
		list.add(p1);
		System.out.println("list = " + list);
		System.out.println("list = " + Integer.toHexString(list.hashCode()));

		Iterator it = list.iterator();
		it.next();

		l1 = list;
		System.out.println("l1 = " + l1);
		System.out.println("l1 = " + Integer.toHexString(l1.hashCode()));

		Object p2 = new Object();
		System.out.println("p2 = " + p2);
		list.add(p2);
		System.out.println("list = " + list);
		System.out.println("list = " + Integer.toHexString(list.hashCode()));

		l2 = list;

		Iterator it2 = l2.iterator();

		it2.next();
		it2.next();
		it2.next();

		System.out.println("l1 = " + l1);
		System.out.println("l1 = " + Integer.toHexString(l1.hashCode()));
		System.out.println("l2= " + l2);
		System.out.println("l2= " + Integer.toHexString(l2.hashCode()));

	}

	public int countIterator(Iterator it) {
		int count = 0;
		while (it.hasNext()) {
			it.next();
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		CopyOnWriteArrayListTest test = new CopyOnWriteArrayListTest();
		test.test();

	}

}
