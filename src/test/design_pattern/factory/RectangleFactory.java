package test.design_pattern.factory;

public class RectangleFactory implements Factory{

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}
}
