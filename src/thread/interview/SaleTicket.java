package thread.interview;

/**
 * 模拟多线程卖票程序
 * @author chenfz
 *
 */
public class SaleTicket {
	
	public static void main(String[] args) {
		tickets tickets = new tickets(100);
		for (int i = 0; i < 10; i++) {
			new Thread(tickets,"窗口"+(i+1)).start();
		}
	}
	
}

class tickets implements Runnable{
	
	private int amount;
	
	public tickets(int amount) {
		super();
		this.amount = amount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (this) {
				if (amount > 0) {
					System.out.println(Thread.currentThread().getName()+"正在售卖第"+amount+"张票");
					sale();
				}else {
					System.out.println(Thread.currentThread().getName()+"退出售票");
					break;
				}
			}
		}
	}
	
	// 卖票方法
	private void sale(){
		amount--;
	}
}
