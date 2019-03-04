package prototype;

public class Test {
	public static void main(String[] args) {
		ConcretePrototype prototype = new ConcretePrototype("abc");
		Prototype prototype2 = prototype.myClone();
		System.out.println(prototype2.toString());
	}
}
