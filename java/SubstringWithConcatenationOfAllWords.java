import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	/*
	 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices
	 * of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening
	 * characters.
	 * 
	 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
	 * 
	 * You should return the indices: [0,9]. (order does not matter).
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sol = new SubstringWithConcatenationOfAllWords();
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };

		s = "barfoofoobarthefoobarman";
		words = new String[] { "bar", "foo", "the" };

		s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		words = new String[] { "fooo", "barr", "wing", "ding", "wing" };
		System.out.println(sol.findSubstring(s, words));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<Integer>();
		if (null == s || s.length() == 0 || null == words || words.length == 0)
			return ret;
		for (int i = 0; i < words[0].length(); i++) {
			findSubstring(s, words, i, ret);
		}
		return ret;
	}

	private void findSubstring(String s, String[] words, int offset, List<Integer> ret) {
		s = s.substring(offset);

		int wordSize = words[0].length();
		int wordCount = words.length;
		int permSize = wordSize * wordCount;
		if (s.length() < permSize)
			return;

		Map<String, Integer> allWords = new HashMap<String, Integer>();
		for (String w : words) {
			Integer count = allWords.get(w);
			if (null == count)
				count = 0;
			count++;
			allWords.put(w, count);
		}
		Map<String, Integer> curWords = new HashMap<String, Integer>();

		for (int i = 0; i <= s.length() / wordSize - wordCount; i++) {
			if (i == 0) {
				for (int j = 0; j < wordCount; j++) {
					String w = s.substring(j * wordSize, (j + 1) * wordSize);
					// System.out.println("w = " + w);
					if (allWords.keySet().contains(w)) {
						Integer count = curWords.get(w);
						if (count == null)
							count = 0;
						count++;
						curWords.put(w, count);
					}
				}
			}

			// System.out.println("i = " + i + ", cur = " + curWords);
			if (curWords.size() == allWords.size()) {
				boolean match = true;
				for (String w : curWords.keySet()) {
					if (curWords.get(w) != allWords.get(w)) {
						match = false;
						break;
					}
				}
				if (match)
					ret.add(i * wordSize + offset);
			}

			if (i >= s.length() / wordSize - wordCount)
				break;

			// next step
			String dels = s.substring(i * wordSize, (i + 1) * wordSize);
			String adds = s.substring((i + wordCount) * wordSize, (i + wordCount + 1) * wordSize);
			Integer count = curWords.get(dels);
			if (count == null || count == 1)
				curWords.remove(dels);
			else {
				count--;
				curWords.put(dels, count);
			}
			if (allWords.keySet().contains(adds)) {
				count = curWords.get(adds);
				if (count == null)
					count = 0;
				count++;
				curWords.put(adds, count);
			}
		}
	}
}
