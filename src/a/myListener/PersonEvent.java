package a.myListener;
/**
 * 	事件
 */
public class PersonEvent {
	private Object source;

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}
	
	// 自定义的构造方法
	public PersonEvent(Person person){
		this.source = person;
	}
}
