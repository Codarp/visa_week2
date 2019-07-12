
public class Producer extends Thread {
	
	private Resource res;
	
	public Producer(Resource res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			res.setData(i);
		}
	}
}
