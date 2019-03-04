package test.design_pattern.adapter;
/**
 * 3.创建适配器类，继承了被适配类，同时实现标准接口
 * @author chenfz
 *
 */
public class M5DataLineAdapter extends M4DataLine implements Target {

	@Override
	public void connection() {
		System.out.println("插入 type-c 转接头");
		super.connection();
	}
	
	
}
