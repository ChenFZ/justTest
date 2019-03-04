package test.design_pattern.builder;

public class Demo {

	public static void main(String[] args) {
		// 建造者模式
		KFCWaiter waiter = new KFCWaiter(new MealB());
		Meal meal = waiter.construct();
		System.out.println("套餐B：食物为"+meal.getFood()+"，饮料为"+meal.getDrink());
	}
}
