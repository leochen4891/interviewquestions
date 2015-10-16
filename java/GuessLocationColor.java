

public class GuessLocationColor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Guess solution = new Guess(0, 1, 2, 2);
		Guess g1 = new Guess(2, 1, 3, 3);
		Guess g2 = new Guess(0, 1, 2, 2);

		System.out.println(g1.getResponse(solution));
		System.out.println(g2.getResponse(solution));
	}
}

class Guess {
	private static int BALL_SIZE = 4;
	private static int COLOR_SIZE = 4;

	public int[] balls = null;

	public Guess() {
		balls = new int[BALL_SIZE];
	}

	public Guess(int... args) {
		balls = new int[BALL_SIZE];
		if (args.length == BALL_SIZE) {
			for (int i = 0; i < args.length; i++) {
				balls[i] = args[i];
			}
		}
	}

	public Response getResponse(Guess solution) {
		int locationMatch = 0;
		int colorMatch = 0;
		int[] guessColors = new int[COLOR_SIZE];
		int[] solutionColors = new int[COLOR_SIZE];
		for (int i = 0; i < BALL_SIZE; i++) {
			if (balls[i] == solution.balls[i]) {
				locationMatch++;
			} else {
				int guessColor = balls[i];
				int solutionColor = solution.balls[i];
				guessColors[guessColor]++;
				solutionColors[solutionColor]++;
			}
		}
		for (int i = 0; i < COLOR_SIZE; i++) {
			int min = Math.min(guessColors[i], solutionColors[i]);
			colorMatch += min;
		}

		Response response = new Response();
		response.locationMatch = locationMatch;
		response.colorMatch = colorMatch;

		return response;
	}
}

class Response {
	int locationMatch;
	int colorMatch;

	public String toString() {
		return "location = " + locationMatch + ", color = " + colorMatch;
	}
}