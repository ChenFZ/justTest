package test.design_pattern.adapter;
/**
 * 类适配器
1.首先定义M4DataLine 代表是Micro USB，我们目的就是通过适配器能够用米4数据线连接米5手机
 * @author chenfz
 *
 */
public class M4DataLine {

	public void connection(){
		System.out.println("使用小米4数据线连接...");
	}
}
