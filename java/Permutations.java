import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(permutations("123"));
		List<String> input = new ArrayList<>();
		input.add("ab");
		input.add("cd");
		input.add("ef");
		System.out.println(permutations(input));
	}

	public static List<String> permutations(String str) {
		List<String> ret = new ArrayList<>();
		generatePermutations("", str, ret);
		return ret;
	}

	private static void generatePermutations(String prefix, String remain, List<String> list) {
		if (null == remain || remain.length() == 0) {
			list.add(prefix);
			return;
		}

		int size = remain.length();
		for (int i = 0; i < size; i++) {
			char c = remain.charAt(i);
			generatePermutations(prefix + c, remain.substring(0, i) + remain.substring(i + 1), list);
		}
	}

	public static List<String> permutations(List<String> strs) {
		List<String> ret = new ArrayList<>();
		generatePermutations("", strs, ret);
		return ret;
	}

	private static void generatePermutations(String prefix, List<String> remain, List<String> list) {
		if (null == remain || remain.size() == 0) {
			list.add(prefix);
			return;
		}

		int size = remain.size();
		for (int i = 0; i < size; i++) {
			String s = remain.get(i);
			List<String> newRemain = new ArrayList<>(remain);
			newRemain.remove(i);
			generatePermutations(prefix + s, newRemain, list);
		}
	}
}
