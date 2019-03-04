package test.design_pattern.adapter;
/**
 * 4.客户端代码，测试
 * @author chenfz
 *
 */
public class Demo {

	public static void main(String[] args) {
		
		M5DataLine m5DataLine = new M5DataLine();
		m5DataLine.connection();
		
		M5DataLineAdapter adapter = new M5DataLineAdapter();
		adapter.connection();
		
	}
}
