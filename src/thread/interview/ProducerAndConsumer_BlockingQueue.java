package thread.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者和消费者模型 阻塞队列BlockingQueue的实现
 * BlockingQueue即阻塞队列，从阻塞这个词可以看出，在某些情况下对阻塞队列的访问可能会造成阻塞。被阻塞的情况主要有如下两种:
 * 
 * 当队列满了的时候进行入队列操作 当队列空了的时候进行出队列操作
 * 因此，当一个线程对已经满了的阻塞队列进行入队操作时会阻塞，除非有另外一个线程进行了出队操作，
 * 当一个线程对一个空的阻塞队列进行出队操作时也会阻塞，除非有另外一个线程进行了入队操作。 从上可知，阻塞队列是线程安全的。
 * 下面是BlockingQueue接口的一些方法:
 * 
 * 由阻塞队列实现的生产者消费者模型,这里我们使用take()和put()方法，这里生产者和生产者，消费者和消费者之间不存在同步，
 * 所以会出现连续生成和连续消费的现象
 * 
 * @author chenfz
 *
 */
public class ProducerAndConsumer_BlockingQueue {

	private static Integer count = 0;
	// 阻塞队列
	final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {

		ProducerAndConsumer_BlockingQueue producerAndConsumer = new ProducerAndConsumer_BlockingQueue();
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
				try {
					blockingQueue.put(1);
					count++;
					System.out.println(Thread.currentThread().getName() + "----生产者生产，目前总共有" + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
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
				try {
					blockingQueue.take();
					count--;
					System.out.println(Thread.currentThread().getName() + "----消费者消费，目前总共有" + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
