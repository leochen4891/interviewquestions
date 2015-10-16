import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Graph {
	Map<Integer, Vertex> vertices;

	public Graph() {
		vertices = new ConcurrentHashMap<Integer, Vertex>();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vertex v : vertices.values()) {
			sb.append(v.id).append(": ");
			for (Vertex adj : v.adj.values()) {
				sb.append(adj).append(", ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public boolean addVertex(Vertex v) {
		if (vertices.containsKey(v.id)) {
			return false;
		}

		vertices.put(v.id, v);
		return true;
	}

	public boolean addDirectedEdge(Vertex v1, Vertex v2) {
		if (null == v1 || null == v2)
			return false;

		if (vertices.containsKey(v1.id) && vertices.containsKey(v2.id)) {
			v1.adj.put(v2.id, v2);
		}
		return true;
	}

	public boolean addUndirectedEdge(Vertex v1, Vertex v2) {
		if (null == v1 || null == v2)
			return false;

		if (vertices.containsKey(v1.id) && vertices.containsKey(v2.id)) {
			v1.adj.put(v2.id, v2);
			v2.adj.put(v1.id, v1);
		}
		return true;
	}

	public void setMarked(boolean marked) {
		for (Vertex v : vertices.values()) {
			v.setMarked(marked);
		}
	}

	public void BFS() {
		setMarked(false);

		for (Vertex root : vertices.values()) {
			if (root.isMarked())
				continue;

			Queue<Vertex> queue = new LinkedList<Vertex>();
			queue.add(root);
			root.setMarked(true);

			while (!queue.isEmpty()) {
				Vertex v = queue.poll();

				System.out.println(v);

				for (Vertex adj : v.adj.values()) {
					if (!adj.isMarked()) {
						queue.offer(adj);
						adj.setMarked(true);
					}
				}
			}
		}
	}

	public void DFS() {
		setMarked(false);

		for (Vertex root : vertices.values()) {
			if (root.isMarked())
				continue;

			root.DFS();
		}
	}

	public void DFS_Iterative() {
		setMarked(false);

		for (Vertex root : vertices.values()) {
			if (root.isMarked())
				continue;

			Stack<Vertex> stack = new Stack<Vertex>();
			stack.push(root);
			root.setMarked(true);

			while (!stack.isEmpty()) {
				Vertex v = stack.pop();

				System.out.println(v);

				for (Vertex adj : v.adj.values()) {
					if (!adj.isMarked()) {
						stack.push(adj);
						adj.setMarked(true);
					}
				}
			}
		}
	}

	public boolean hasCycle() {
		setMarked(false);

		HashSet<Integer> recSet = new HashSet<Integer>();

		for (Vertex v : vertices.values()) {
			if (v.hasCycle(recSet))
				return true;
		}

		return false;
	}

	//@formatter:off
	/**
	 * 0---1 <br>
	 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/|<br>
	 * |&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;|<br>
	 * |&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;|<br>
	 * 2---3---4<br>
	 * @return
	 */
	//@formatter:on
	public static Graph getUndirectedTestGraph1() {
		Graph ret = new Graph();

		int SIZE = 5;
		Vertex[] arr = new Vertex[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = new Vertex();
			arr[i].id = i;
			ret.addVertex(arr[i]);
		}

		ret.addUndirectedEdge(arr[0], arr[1]);
		ret.addUndirectedEdge(arr[0], arr[2]);
		ret.addUndirectedEdge(arr[1], arr[2]);
		ret.addUndirectedEdge(arr[1], arr[3]);
		ret.addUndirectedEdge(arr[2], arr[3]);
		ret.addUndirectedEdge(arr[3], arr[4]);

		return ret;
	}

	//@formatter:off
	/**
	 * 0---1 <br>
	 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/|<br>
	 * |&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;|<br>
	 * |&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;|<br>
	 * 2---3---4<br>
	 * @return
	 */
	//@formatter:on

	public static Graph getDirectedTestGraph1(boolean hasCycle) {
		Graph ret = new Graph();

		int SIZE = 5;
		Vertex[] arr = new Vertex[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = new Vertex();
			arr[i].id = i;
			ret.addVertex(arr[i]);
		}

		ret.addDirectedEdge(arr[0], arr[1]);
		ret.addDirectedEdge(arr[0], arr[2]);
		ret.addDirectedEdge(arr[1], arr[2]);
		ret.addDirectedEdge(arr[1], arr[3]);
		ret.addDirectedEdge(arr[2], arr[3]);
		ret.addDirectedEdge(arr[3], arr[4]);

		if (hasCycle) {
			ret.addDirectedEdge(arr[3], arr[1]); // create cycle
		}

		return ret;
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
	public static Graph getUndirectedTestGraph2() {
		Graph ret = new Graph();

		int SIZE = 10;
		Vertex[] arr = new Vertex[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = new Vertex();
			arr[i].id = i;
			ret.addVertex(arr[i]);
		}

		ret.addUndirectedEdge(arr[0], arr[1]);
		ret.addUndirectedEdge(arr[0], arr[2]);
		ret.addUndirectedEdge(arr[1], arr[3]);
		ret.addUndirectedEdge(arr[1], arr[4]);
		ret.addUndirectedEdge(arr[2], arr[5]);
		ret.addUndirectedEdge(arr[2], arr[6]);
		ret.addUndirectedEdge(arr[3], arr[7]);
		ret.addUndirectedEdge(arr[3], arr[8]);
		ret.addUndirectedEdge(arr[4], arr[9]);

		return ret;

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
	public static Graph getDirectedTestGraph2(boolean hasCycle) {
		Graph ret = new Graph();

		int SIZE = 10;
		Vertex[] arr = new Vertex[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = new Vertex();
			arr[i].id = i;
			ret.addVertex(arr[i]);
		}

		ret.addDirectedEdge(arr[0], arr[1]);
		ret.addDirectedEdge(arr[0], arr[2]);
		ret.addDirectedEdge(arr[1], arr[3]);
		ret.addDirectedEdge(arr[1], arr[4]);
		ret.addDirectedEdge(arr[2], arr[5]);
		ret.addDirectedEdge(arr[2], arr[6]);
		ret.addDirectedEdge(arr[3], arr[7]);
		ret.addDirectedEdge(arr[3], arr[8]);
		ret.addDirectedEdge(arr[4], arr[9]);

		if (hasCycle) {
			ret.addDirectedEdge(arr[9], arr[0]); // create cycle
		}

		return ret;

	}

	//@formatter:off
	/**
	 * DAG for topological sorting <br> <br>
	 * &nbsp;/-->&nbsp;2<br>
	 * 5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\&nbsp;<br>
	 * &nbsp;\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;V<br>
	 * &nbsp;&nbsp;->&nbsp;&nbsp;0&nbsp;&nbsp;&nbsp;3<br>
	 * &nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/<br>
	 * 4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;V<br>
	 * &nbsp;\--->&nbsp;1<br>
	 * @return
	 */
	//@formatter:on
	public static Graph getDirectedTestGraph3() {
		Graph ret = new Graph();

		int SIZE = 6;
		Vertex[] arr = new Vertex[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = new Vertex();
			arr[i].id = i;
			ret.addVertex(arr[i]);
		}

		ret.addDirectedEdge(arr[5], arr[0]);
		ret.addDirectedEdge(arr[5], arr[2]);
		ret.addDirectedEdge(arr[4], arr[0]);
		ret.addDirectedEdge(arr[4], arr[1]);
		ret.addDirectedEdge(arr[2], arr[3]);
		ret.addDirectedEdge(arr[3], arr[1]);

		return ret;
	}
}
