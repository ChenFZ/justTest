package test.design_pattern.prototype;
/**
 * 装饰方框样式的具体原型，实现了Product接口，实现复制现有实例并生成新实例的方法。
 * 
 * @author chenfz
 *
 */
public class MessageBox implements Product {

	private char decochar;
	
	public MessageBox(char decochar) {
		this.decochar = decochar;
	}
	
	@Override
	public void use(String s) {
		int length = s.length();
		for (int i = 0; i < length+4; i++) {
			System.out.print(decochar); 
		}
		System.out.println("");
	    System.out.println(decochar+" "+s+" "+decochar);
	    for (int i = 0; i < length+4; i++) {
	        System.out.print(decochar);
	    }
	    System.out.println("");
	}
	
	//该方法用于复制自己
	/**
	 * 只有类自己（或是它的子类）能够调用Java语言中定义的clone方法。
	 * 当其他类要求复制实例时，必须先调用createClone这样的方法，然后在该方法内部在调用clone方法。
	 */
	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}
