package test.design_pattern.builder;
/**
 * 创建一个Product对象的各个部件指定的抽象接口。
 * @author chenfz
 *
 */
public abstract class MealBuilder {

	Meal meal = new Meal();
	
	public abstract void buildFood();
	
	public abstract void buildDrink();
	
	public Meal getMeal(){
		return meal;
	}
}
