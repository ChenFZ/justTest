package test.design_pattern.factory;

public class CircleFactory implements Factory{

	@Override
	public Shape getShape() {
		
		return new Circle();
	}
}
