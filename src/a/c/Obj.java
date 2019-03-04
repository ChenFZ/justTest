package a.c;

import java.math.BigDecimal;

public class Obj {
	public static void main(String[] args) {
//		test1();
		DeductType deductType = DeductType.get("DEDUCT_EVERY");
		if (deductType!=null) {
			String type = deductType.toString();
			System.out.println(type);
		}
	}

	private static void test1() {
		Student stu1 = new Student(1, "小明", 8888.00);
		Student stu2 = stu1;
		System.out.println(stu2);
		stu2.setName("小王");
		System.out.println(stu1);
		System.out.println(stu2);
		
		BigDecimal bigDecimal = new BigDecimal(1);
		System.out.println(bigDecimal.toString());
		Long t = 1L;
		System.out.println(String.valueOf(t));
	}
}
