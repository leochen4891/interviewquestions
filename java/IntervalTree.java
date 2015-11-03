import java.util.ArrayList;
import java.util.List;

public class IntervalTree<T extends Comparable<T>> {

	public static void main(String[] args) {
		IntervalTree<Double> t = new IntervalTree<>();
		t.addInterval(15.0, 20.0);
		t.addInterval(10.0, 30.0);
		t.addInterval(17.0, 19.0);
		t.addInterval(5.0, 20.0);
		t.addInterval(12.0, 15.0);
		t.addInterval(30.0, 40.0);

		for (ITNode<Double> i : t.queryInterval(6.0, 17.0)) {
			System.out.println(i);
		}
	}

	ITNode<T> root;

	public IntervalTree() {
		root = null;
	}

	public void addInterval(T low, T high) {
		this.root = addInterval(this.root, low, high);
	}

	public ITNode<T> addInterval(ITNode<T> root, T low, T high) {
		if (null == root) {
			return new ITNode<T>(low, high, high);
		}

		if (low.compareTo(root.low) <= 0) {
			root.left = addInterval(root.left, low, high);
		} else {
			root.right = addInterval(root.right, low, high);
		}
		return root;
	}

	public void removeInterval(T low, T high) {

	}

	public List<ITNode<T>> queryInterval(T low, T high) {
		List<ITNode<T>> ret = new ArrayList<>();
		return queryInterval(this.root, low, high, ret);
	}

	private List<ITNode<T>> queryInterval(ITNode<T> root, T low, T high, List<ITNode<T>> ret) {
		if (null == root)
			return ret;

		if (root.intersects(low, high)) {
			ret.add(root);
		}

		queryInterval(root.left, low, high, ret);
		queryInterval(root.right, low, high, ret);

		return ret;
	}
}
