package thread.interview.print;


/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15.
 * 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75. 程序的输出结果应该为:
 * 
 * @author chenfz
 *
 */
public class PrintNum {
	public static void main(String[] args) {
		new Thread(new Print(1)).start();
		new Thread(new Print(2)).start();
		new Thread(new Print(3)).start();
	}
}

class Print implements Runnable{
	
	private static volatile int num = 0;
	private int threadId;
	
	public Print(int threadId) {
		super();
		this.threadId = threadId;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while (num<750) {
				if (num/5%3 + 1 == threadId) {
					for (int i = 0; i < 50; i++) {
						System.out.println("线程"+threadId+"打印了"+(++num));
					}
					this.notifyAll();
				}else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
