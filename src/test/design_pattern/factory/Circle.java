package test.design_pattern.factory;

public class Circle implements Shape{

	public Circle(){
		System.out.println("create circle");
	}
	
	@Override
	public void draw(){
		System.out.println("draw a circle");
	}
}
