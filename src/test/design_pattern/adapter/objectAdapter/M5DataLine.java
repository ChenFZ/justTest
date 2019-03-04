package test.design_pattern.adapter.objectAdapter;

import test.design_pattern.adapter.Target;

class M5DataLine implements Target{
	
	@Override
	public void connection() {
		System.out.println("使用小米5数据线连接...");
	}
	
}