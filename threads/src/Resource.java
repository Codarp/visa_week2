
public class Resource {
	private int data;
	private boolean flag;

	public synchronized int getData() {
		while (!isFlag()) {
			System.out.println("No data as of now... waiting for Producer.");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setFlag(false);
		notify();
		return data;
	}

	public synchronized void setData(int data) {
		while (isFlag()) {
			System.out.println("Data not yet taken by Consumer.");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setFlag(true);
		this.data = data;
		System.out.println("Data set: " + data);
		notify();
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
