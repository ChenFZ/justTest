package thread.interview;
/**
 * 生产者和消费者模型
 * 
 * @author chenfz
 *
 */
public class ProducerAndConsumer {

	private static Integer count = 0;
	private static final Integer full = 10;
	private static String lock = "LOCK";

	public static void main(String[] args) {
		ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
		new Thread(producerAndConsumer.new producer()).start();
		new Thread(producerAndConsumer.new producer()).start();
		new Thread(producerAndConsumer.new producer()).start();
		new Thread(producerAndConsumer.new consumer()).start();
		new Thread(producerAndConsumer.new producer()).start();
		new Thread(producerAndConsumer.new consumer()).start();
	}

	class producer implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lock) {
					while (count == full) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					count++;
					System.out.println(Thread.currentThread().getName() + "----生产者生产，目前总共有" + count);
					lock.notifyAll();
				}
			}
		}
	}
	class consumer implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lock) {
					while (count == 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					count--;
					System.out.println(Thread.currentThread().getName() + "----消费者消费，目前总共有" + count);
					lock.notifyAll();
				}
			}
		}
	}
}
