import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Vertex {
	Integer id;
	Map<Integer, Vertex> adj;
	private boolean marked;

	public Vertex() {
		this.adj = new ConcurrentHashMap<Integer, Vertex>();
	}

	public boolean hasEdgeTo(Vertex v) {
		return adj.containsKey(v.id);
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public String toString() {
		return Integer.toString(id);
	}

	public void DFS() {
		setMarked(true);
		System.out.println(this);
		for (Vertex v : adj.values()) {
			if (!v.isMarked()) {
				v.setMarked(true);
				v.DFS();
			}
		}
	}

	public boolean hasCycle(Set<Integer> recSet) {
		if (recSet.contains(this.id))
			return true;

		recSet.add(this.id);

		for (Vertex v : adj.values()) {
			if (v.hasCycle(recSet)) {
				return true;
			}
		}
		recSet.remove(this.id);

		return false;
	}
}
