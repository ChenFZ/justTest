package test.design_pattern.singleton;
/**
 * 枚举法
 * @author chenfz
 *
 */
public enum EnumSingleton {
	
	INSTANCE;
	
	public void doSomething(String s){
		System.out.println("执行dosomething方法："+s);
	}
}
