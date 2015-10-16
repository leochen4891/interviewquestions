public class Graph_BFS_DFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = Graph.getUndirectedTestGraph2();
		System.out.println("- - - - - - - - - - - Graph - - - - - - - - - ");
		System.out.println(g);

		System.out.println("- - - - - - - - - - - DFS - - - - - - - - - - ");
		g.DFS();

		System.out.println("- - - - - - - - DFS Iterative - - - - - - - - ");
		g.DFS_Iterative();

		System.out.println("- - - - - - - - - - - BFS - - - - - - - - - - ");
		g.BFS();
	}

}
