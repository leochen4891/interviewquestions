import java.util.ArrayList;

class test {
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Hello, World!");
		strings.add("Welcome to CoderPad.");
		strings.add("This pad is running Java 8.");

		for (String string : strings) {
			System.out.println(string);
		}
	}
}