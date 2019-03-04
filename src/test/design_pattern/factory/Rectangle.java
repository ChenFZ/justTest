package test.design_pattern.factory;

public class Rectangle implements Shape {

	public Rectangle(){
		System.out.println("create rectangle");
	}
	
	public void draw(){
		System.out.println("draw a rectangle");
	}
}
