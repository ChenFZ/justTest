package test.design_pattern.singleton;

public class Demo {

	public static void main(String[] args) {
		EnumSingleton singleton = EnumSingleton.INSTANCE;
		singleton.doSomething("emmm");
		testSwitch('b');
	}
	
	/**
	 * 先匹配，再寻找break，没有就继续往下执行
	 * @param s
	 */
	public static void testSwitch(char s){
		switch (s) {
			case 'a' :
				System.out.println("优秀");
				break;
			case 'b' :
			case 'c' :
				System.out.println("良好");
				break;
			case 'd' :
				System.out.println("及格");
			default :
				System.out.println("未知");
				break;
		}
	}
}
