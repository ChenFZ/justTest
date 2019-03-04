
package thread;

public class Test {
	
	public static void main(String[] args) {
//		Thread thread1 = new Thread(new MyThread(),"线程1");
//		Thread thread2 = new Thread(new MyThread(),"线程2");
//		
//		thread2.setDaemon(true);
//		
//		thread1.start();
//		thread2.start();
//		
//		
//		System.out.println(Thread.currentThread().getName());
		final Test test = new Test();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.testWait();
			}
		}).start();
	}
	
	public synchronized void testWait(){
		System.out.println("---------start");
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----------end");
	}
	
}
