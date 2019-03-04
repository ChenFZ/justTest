package test.design_pattern.factory;

import org.apache.commons.lang.StringUtils;

/**
 * 简单工厂 这样的实现有个问题，如果我们新增产品类的话，就需要修改工厂类中的getShape（）方法，
 * 这很明显不符合 开放-封闭原则 。
 * 
 * @author chenfz
 *
 */
public class ShapeFactory {

	public static Shape getShape(String shape) {
		if (StringUtils.isBlank(shape)) {
			return null;
		}
		if ("circle".equalsIgnoreCase(shape)) {
			return new Circle();
		} else if ("rectangle".equalsIgnoreCase(shape)) {
			return new Rectangle();
		}
		return null;
	}
}
