

class FizzBuzz {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			boolean three = (i % 3) == 0;
			boolean five = (i % 5) == 0;
			if (three && five) {
				System.out.println("FizzBuzz");
			} else if (three) {
				System.out.println("Fizz");
			} else if (five) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}