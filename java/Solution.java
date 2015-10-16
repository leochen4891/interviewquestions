import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		String[] strs = line.split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);

		List<List<Integer>> adjs = new ArrayList<List<Integer>>(n);
		for (int i = 0; i < n; i++) {
			adjs.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			line = in.readLine();
			strs = line.split(" ");
			int from = Integer.parseInt(strs[0]);
			int to = Integer.parseInt(strs[1]);
			adjs.get(from - 1).add(to);
		}

		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			List<Integer> edges = adjs.get(i);
			for (Integer v : edges) {
				out.println((i + 1) + " -> " + v);
			}
		}
		out.flush();
		out.close();
	}
}
