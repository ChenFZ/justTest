package test.design_pattern.builder;
/**
 * 实现抽象接口，构建和装配各个部件
 * @author chenfz
 *
 */
public class MealA extends MealBuilder{

	@Override
	public void buildDrink() {
		meal.setDrink("可乐");
	}
	@Override
	public void buildFood() {
		meal.setFood("薯片");
	}
}
