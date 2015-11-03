import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	/*
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
	 * of one or more dictionary words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> dict = new HashSet<>();
		dict.addAll(Arrays.asList(new String[] { "leet", "code" }));
		System.out.println(wb.wordBreak("leetcode", dict));
	}

	Map<String, Boolean> records = new HashMap<String, Boolean>();

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (null == s || s.length() <= 0) {
			return true;
		}
		if (records.containsKey(s))
			return records.get(s);

		for (int i = 1; i < s.length() + 1; i++) {
			String prefix = s.substring(0, i);
			if (wordDict.contains(prefix)) {
				String remain = s.substring(i);
				boolean ret = wordBreak(remain, wordDict);
				records.put(remain, ret);
				if (ret) {
					return true;
				}
			}
		}
		return false;
	}
}
