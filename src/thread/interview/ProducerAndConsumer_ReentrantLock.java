package thread.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者模型 
 * 可重入锁ReentrantLock的实现
 * 
 * @author chenfz
 *
 */
public class ProducerAndConsumer_ReentrantLock {

	private static Integer count = 0;
	private static final Integer full = 10;
	// 锁对象
	private Lock lock = new ReentrantLock();
	//创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空 
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	
	public static void main(String[] args) {
		
		ProducerAndConsumer_ReentrantLock producerAndConsumer = new ProducerAndConsumer_ReentrantLock();
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
				lock.lock();
				try {
					while (count == full) {
						try {
							System.out.println(Thread.currentThread().getName() + "----生产者停止生产，目前总共有" + count);
							notFull.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					count++;
					System.out.println(Thread.currentThread().getName() + "----生产者生产，目前总共有" + count);
					notEmpty.signal();
				}finally{
					lock.unlock();
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
				lock.lock();
				try {
					while (count == 0) {
						try {
							System.out.println(Thread.currentThread().getName() + "----消费者停止消费，目前总共有" + count);
							notEmpty.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					count--;
					System.out.println(Thread.currentThread().getName() + "----消费者消费，目前总共有" + count);
					notFull.signal();
				} finally{
					lock.unlock();
				}
			}
		}
	}
}
