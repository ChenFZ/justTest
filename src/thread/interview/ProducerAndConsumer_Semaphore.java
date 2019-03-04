package thread.interview;

import java.util.concurrent.Semaphore;

/**
 * 生产者和消费者模型 信号量Semaphore的实现
 * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源
 * ，在操作系统中是一个非常重要的问题，可以用来解决哲学家就餐问题
 * 。Java中的Semaphore维护了一个许可集，一开始先设定这个许可集的数量，可以使用acquire
 * ()方法获得一个许可，当许可不足时会被阻塞，release
 * ()添加一个许可。在下列代码中，还加入了另外一个mutex信号量，维护生产者消费者之间的同步关系，保证生产者和消费者之间的交替进行
 * 
 * @author chenfz
 *
 */
public class ProducerAndConsumer_Semaphore {

	private static Integer count = 0;
	// 三个信号量
	private static Semaphore notFull = new Semaphore(10);
	private static Semaphore notEmpty = new Semaphore(0);
	private static Semaphore mutex = new Semaphore(1);

	public static void main(String[] args) {

		ProducerAndConsumer_Semaphore producerAndConsumer = new ProducerAndConsumer_Semaphore();
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
					notFull.acquire();
					mutex.acquire();
					count++;
					System.out.println(Thread.currentThread().getName() + "----生产者生产，目前总共有" + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					notEmpty.release();
					mutex.release();
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
					notEmpty.acquire();
                    mutex.acquire();
					count--;
					System.out.println(Thread.currentThread().getName() + "----消费者消费，目前总共有" + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally{
					notFull.release();
					mutex.release();
				}
			}
		}
	}
}
