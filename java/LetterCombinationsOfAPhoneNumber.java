import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();
		System.out.println(s.letterCombinations("23"));
	}

	private static final String[] digit2Char = { "", "", "abc", "def", "ghi",
			"jkl", "mno", "pqrs", "tuv", "wxyz", "", " ", "" };

	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		if (null == digits || digits.length() <= 0)
			return ret;
		
		ret.add("");

		for (int i = 0; i < digits.length(); i++) {
			int d = digits.charAt(i) - '0';
			String chars = digit2Char[d];

			List<String> newRet = new ArrayList<>();
			for (int j = 0; j < chars.length(); j++) {

				char c = chars.charAt(j);
				for (String cur : ret) {
					newRet.add(cur + c);
				}
			}
			ret = newRet;
		}
		return ret;
	}
}
