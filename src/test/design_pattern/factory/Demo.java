package test.design_pattern.factory;

public class Demo {

	public static void main(String[] args) {
		// 简单工厂
		ShapeFactory.getShape("rectangle").draw();
		// 反射工厂
		((Shape) ShapeFactory2.getShape(Circle.class)).draw();
		// 工厂方法模式
		Shape shape = new SquareFactory().getShape();
		shape.draw();
		
		
	}
}
