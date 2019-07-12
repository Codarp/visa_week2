
public class ConsumerProducerExample {

	public static void main(String[] args) {
		Resource res = new Resource();
		Consumer c = new Consumer(res);
		Producer p = new Producer(res);
		
		c.start();
		p.start();
	}

}
