package utils;

public class Demo {

	public static void main(String[] args) {
		String format = String.format("%.2f", 0.89*100)+"%";
		System.out.println(format);
		
		System.out.println((double)3/12);
		
		if (42 == 42.0) { // true
			System.out.println("true");
		}
	}
}
