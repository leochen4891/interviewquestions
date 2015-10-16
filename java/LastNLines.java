import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class LastNLines {
	private static final String input = "line 0\n" + "line 1\n" + "line 2\n" + "line 3\n" + "line 4\n" + "line 5\n"
			+ "line 6\n" + "line 7\n" + "line 8\n" + "line 9\n" + "line 10\n" + "line 11\n" + "line 12\n" + "line 13\n"
			+ "line 14\n";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		System.out.println(getLastNLines(br, 3));
	}

	public static Queue<String> getLastNLines(BufferedReader rd, int N) {
		Queue<String> ret = new LinkedList<String>();

		if (null != rd && N > 0) {
			String line = null;
			try {
				line = rd.readLine();
				while (null != line) {
					if (ret.size() >= N) {
						ret.poll();
					}
					ret.offer(line);
					line = rd.readLine();
				}
			} catch (IOException e) {
				ret.clear();
				e.printStackTrace();
			}
		}
		return ret;
	}
}
