package test.design_pattern.factory;
/**
 * 使用反射机制完善简单工厂
 * 
 * 这种方式的虽然符合了 开放-关闭原则 ，但是每一次传入的都是产品类的全部路径，这样比较麻烦。如果需要改善的话可以通过 反射+配置文件
 * 的形式来改善，这种方式使用的也是比较多的。
 * 
 * @author chenfz
 *
 */
public class ShapeFactory2 {

	public static Object getShape(Class<? extends Shape> clazz) {
		Object instance = null;
		try {
			instance = Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return instance;
	}
}
