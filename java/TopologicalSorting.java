import java.util.Stack;

public class TopologicalSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = Graph.getDirectedTestGraph3();
		g.setMarked(false);
		Vertex root = g.vertices.get(4);

		Stack<Vertex> s = topologicalSort(g, root);
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

	public static Stack<Vertex> topologicalSort(Graph g, Vertex root) {
		Stack<Vertex> stack = new Stack<Vertex>();

		for (Vertex v : g.vertices.values()) {
			if (v.isMarked())
				continue;
			topologicalSort(g, v, stack);
		}

		return stack;
	}

	private static void topologicalSort(Graph g, Vertex root, Stack<Vertex> stack) {
		if (null == g || null == root || null == stack)
			return;

		root.setMarked(true);

		for (Vertex v : root.adj.values()) {
			if (!v.isMarked()) {
				topologicalSort(g, v, stack);
			}
		}

		stack.push(root);
	}
}
