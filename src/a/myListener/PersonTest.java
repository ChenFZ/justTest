package a.myListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 测试
 * @author chenfz
 *
 */
public class PersonTest {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("小红");
		person.setWeight(50);
		
		person.addPersonListener(new PersonListener() {
			
			@Override
			public void personEat(PersonEvent event) {
				// TODO Auto-generated method stub
				System.out.println("进入了自定义体重监听器......");
				
				// 在监听方法中可以获得事件源对象，进而可以操作事件源对象
				Person person = (Person)event.getSource();
				System.out.println(person.getName());
				System.out.println(person.getWeight());
			}
		});
		
		person.eat();
	}
	
	@Test
	public void it(){
		Map<String, Object> resultMap = new HashMap();
		List list2 = new ArrayList<String>(); 
	}
}
