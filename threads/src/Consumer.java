
public class Consumer extends Thread {
	private Resource res;

	public Consumer(Resource res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Consumer: getting data: " + res.getData());
		}
	}
}
