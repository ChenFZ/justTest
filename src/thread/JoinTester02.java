package thread;
/**
 * 可以看出，Join方法实现是通过wait（小提示：Object 提供的方法）。 当main线程调用t.join时候，
 * main线程会获得线程对象t的锁（wait 意味着拿到该对象的锁),
 * 调用该对象的wait(等待时间)，直到该对象唤醒main线程 ，比如退出后。这就意味着main 线程调用t.join时，
 * 必须能够拿到线程t对象的锁。
 * 
 * main线程执行了thread.join()，按理说要获取到thread的对象锁，但是被getLockThread提前获取了
 * 因此不光是要等待thread执行完，还要等到getLockThread释放thread的对象锁
 * @author cheny
 *
 */
public class JoinTester02 implements Runnable {

	Thread thread;

	public JoinTester02(Thread thread) {
		this.thread = thread;
	}

	public void run() {
		synchronized (thread) {
			System.out.println(Thread.currentThread().getName()+"getObjectLock");
			try {
				Thread.sleep(9000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"ReleaseObjectLock");
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new JoinTester01("Three"));
		Thread getLockThread = new Thread(new JoinTester02(thread),"LockThread");

		getLockThread.start();
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main finished!");
	}

}