

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	int i = 0;

	private int getValue() {
		return i;
	}

	private synchronized void eventIncrease() {
		i++;
		i++;
	}

	@Override
	public void run() {
		while (true) {
			eventIncrease();
		}

	}

	public static void main(String[] args) {
		final AtomicityTest test = new AtomicityTest();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(test);

		while (true) {
			int ret = test.getValue();
			if (ret % 2 != 0) {
				System.out.println("i = " + ret);
				// break;
			}
		}

	}

}
