package test.design_pattern.adapter.objectAdapter;

import test.design_pattern.adapter.Target;

/**
 * 对象适配器
 * @author chenfz
 *
 */
class M5DataLineAdapter implements Target {

	private Target target;
	public M5DataLineAdapter(Target target){
		this.target = target;
	}
	
	@Override
	public void connection() {
		System.out.println("插入 type-c 转接头");
		target.connection();
	}
}