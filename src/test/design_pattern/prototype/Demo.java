package test.design_pattern.prototype;
/**
 * Main类首先生成Manager实例。接着，在Manager实例中通过`register方法注册了UnderlinePen类的实例（带名字）
 * 和MessageBox类的实例（带名字）。
 * 
 * @author chenfz
 *
 */
public class Demo {

	public static void main(String[] args) {
		Manager manager = new Manager();
		UnderlinePen strongPen = new UnderlinePen('~');
		MessageBox wBox = new MessageBox('*');
		MessageBox sBox = new MessageBox('/');
		manager.register("strong message", strongPen);
		manager.register("warning box", wBox);
		manager.register("slash box", sBox);
		Product p1 = manager.create("strong message");
		p1.use("hello world");
		Product p2 = manager.create("warning box");
		p2.use("hello world");
		Product p3 = manager.create("slash box");
		p3.use("hello world");
	}
}
