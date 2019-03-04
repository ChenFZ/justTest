package thread.interview;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

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
public class ProducerAndConsumer_PipedInputStream {

	final PipedInputStream pis = new PipedInputStream();
	final PipedOutputStream pos = new PipedOutputStream();
	{
		try {
			pis.connect(pos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		ProducerAndConsumer_PipedInputStream producerAndConsumer = new ProducerAndConsumer_PipedInputStream();
		new Thread(producerAndConsumer.new producer()).start();
		new Thread(producerAndConsumer.new consumer()).start();
	}

	class producer implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (true) {
					Thread.sleep(3000);
					int num = (int) (Math.random() * 255);
					System.out.println(Thread.currentThread().getName() + "----生产者生产了一个数字，该数字为" + num);
					pos.write(num);
					pos.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pos.close();
					pis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	class consumer implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					Thread.sleep(3000);
					int num = pis.read();
					System.out.println(Thread.currentThread().getName() + "----消费者消费了一个数字，该数字为" + num);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pos.close();
					pis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
