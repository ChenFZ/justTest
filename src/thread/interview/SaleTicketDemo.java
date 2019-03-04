package thread.interview;
/**
 * 模拟买票程序
 * @author cheny
 *
 */
public class SaleTicketDemo {

	public static void main(String[] args) {
		Ticket ticket = new Ticket(100);
		for (int i = 1; i < 11; i++) {
			new Thread(ticket,"窗口"+i).start();
		}
	}
}	
	class Ticket implements Runnable {
		
		private int amount;
		
		public Ticket(int amount){
			super();
			this.amount = amount;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized (this) {
					if (amount>0) {
						System.out.println(Thread.currentThread().getName()+"正在售卖第"+(amount--)+"张票");
					}else {
						System.out.println(Thread.currentThread().getName()+"退出售票");
						break;
					}
				}
			}
		}
		
	}

