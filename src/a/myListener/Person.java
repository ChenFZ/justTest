package a.myListener;
/**
 * 事件源
 * 
 * @author chenfz
 *
 */
public class Person {
	private String name;
	private int weight;
	private PersonListener listener;

	// 注册监听器
	public void addPersonListener(PersonListener listener) {
		this.listener = listener;
	}

	// 吃饭
	public void eat() {
		System.out.println(name+"开始吃饭");
		// 体重增加
		weight += 5;
		// 调用监听器监听方法
		if (listener != null) {
			// 监听器存在
			// 创建事件对象 --- 通过事件对象可以获得事件源
			PersonEvent event = new PersonEvent(this);
			listener.personEat(event);
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
