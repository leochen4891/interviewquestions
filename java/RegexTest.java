

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int groupId = 1;
		String line = "{\"ResetGroupFileToOriginal\":{\"groupId\":\"" + groupId + "}}";
		String regex = "\\{\"ResetGroupFileToOriginal.*";
		System.out.println(line.matches(regex));

	}
}
