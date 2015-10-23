public class RegularExpressionMatching {

	// @formatter:off
	/*
	Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") ? false
	isMatch("aa","aa") ? true
	isMatch("aaa","aa") ? false
	isMatch("aa", "a*") ? true
	isMatch("aa", ".*") ? true
	isMatch("ab", ".*") ? true
	isMatch("aab", "c*a*b") ? true

    */
	// @formatter:on
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a") == false);
		System.out.println(isMatch("aa", "aa") == true);
		System.out.println(isMatch("aaa", "aa") == false);
		System.out.println(isMatch("aa", "a*") == true);
		System.out.println(isMatch("aa", ".*") == true);
		System.out.println(isMatch("ab", ".*") == true);
		System.out.println(isMatch("ab", ".*c") == false);
		System.out.println(isMatch("aab", "c*a*b") == true);
		System.out.println(isMatch("aaa", "ab*a") == false);

		// System.out.println(isMatch("", "") == true);
		// System.out.println(isMatch("ab", "ab") == true);
		// System.out.println(isMatch("aa", "a*") == true);
		// System.out.println(isMatch("aa", ".*") == true);
		// System.out.println(isMatch("aa", "\\*b") == true);
		// System.out.println(isMatch("aa", "\\.b") == true);
		// System.out.println(isMatch("aa", "\\b") == true);
		// System.out.println(isMatch("aa", "\\.*b") == true);
		// System.out.println(isMatch("aa", "\\.\\*b") == true);
	}

	public static boolean isMatch(String s, String p) {
		try {

			System.out.println("s = " + s + ", p = " + p);
			// null of inputs
			if (null == s && null == p)
				return true;
			if (null == s || null == p)
				return false;

			// length of inputs are 0
			if (s.length() == 0 && p.length() == 0)
				return true;

			if (s.length() > 0 && p.length() == 0)
				return false;

			// use these two to indicate . and *
			// \. and \* are actual '.' and '*'
			boolean dot = false;
			boolean star = false;
			char pc;
			char sc = ' ';

			// get the first char
			pc = p.charAt(0);
			if (s.length() > 0)
				sc = s.charAt(0);
			p = p.substring(1);

			if (pc == '.') {
				dot = true;
				if (s.length() > 0)
					pc = s.charAt(0);
			} else if (pc == '\\') {
				pc = p.charAt(0);
				if (pc != '*' && pc != '.' && pc != '\\')
					throw new Exception("\\" + pc + " not allowed");
				p = p.substring(1);
			}

			// check if star applies
			if (p.length() > 0 && p.charAt(0) == '*') {
				star = true;
				p = p.substring(1);
			}

			System.out.println("pc = " + pc + ", dot = " + dot + ", star = " + star + ", p = " + p);

			if (star) {// both with or without matching c work
				// * = 0
				if (isMatch(s, p))
					return true;

				// * >= 1
				if (s.length() > 0) {
					while (s.length() > 0 && (dot || s.charAt(0) == pc)) {
						if (isMatch(s.substring(1), p)) {
							return true;
						}
						s = s.substring(1);
					}
				}
				return false;
			} else {
				if (s.length() == 0 || s.charAt(0) != pc)
					return false;

				return isMatch(s.substring(1), p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
