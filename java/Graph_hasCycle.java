public class Graph_hasCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g1, g2;
		g1 = Graph.getDirectedTestGraph1(false);
		System.out.println(g1.hasCycle());
		g1 = Graph.getDirectedTestGraph1(true);
		System.out.println(g1.hasCycle());

		g2 = Graph.getDirectedTestGraph2(false);
		System.out.println(g2.hasCycle());
		g2 = Graph.getDirectedTestGraph2(true);
		System.out.println(g2.hasCycle());

	}

}
