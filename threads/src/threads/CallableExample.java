package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) {
		
		// Max 2 threads in the pool.
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = service.submit(new Sumer(1, 100));
		Future<Integer> f2 = service.submit(new Sumer(900, 1300));
		
		try {
			// Some others have also been given like isDone()
			System.out.println(f1.get()); // Blocked statement.
			System.out.println(f2.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Threads might wait for a long time for a new task to be submitted.
		service.shutdown();
	}

}
