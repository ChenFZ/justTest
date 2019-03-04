package a.c;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestArray {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);// 插入第一个元素
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);// 打印list数组
		list.add(2, 7);
		System.out.println(list);
	}
	@Test
	public void tet(){
		String str = "ABC";
		String substring = str.substring(0, 1);
		str = str.substring(1);
		System.out.println(str+substring);
	}
}