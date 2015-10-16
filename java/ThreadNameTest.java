

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class MyThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable arg0) {
		Thread t = new Thread(arg0);
		t.setName("my thread");
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread arg0, Throwable arg1) {
				System.out.println("Caught exception " + arg1.getMessage() + " in thread " + arg0.getName());
			}
		});
		return t;
	}
}

public class ThreadNameTest {

	public static void main(String[] args) {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("before exception");
				throw new RuntimeException("haha");
			}
		};

		ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());
		exec.submit(run);
		exec.shutdown();
	}
}
