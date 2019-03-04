package utils.algorithm;

import java.util.Arrays;
import org.junit.Test;

public class Demo {

	public static void main(String[] args) {
//		System.out.println(qcd(9, 6));
		
		int[] i ={1,3,4,2};
		Arrays.sort(i);
		System.out.println(Arrays.toString(i));
	}
	
	// 欧几里得算符
	/**
	 * 自然语言描述 计算两个非负整数 p 和 q 的最大公约数：若 q 是 0，则最大公约数为 p。否则，将 p 除以 q 得到余数 r，p 和 q
	 * 的最大公约数即为 q 和 r 的最大公约数。
	 */
	@Test
	public static int qcd(int p,int q){
		if (q == 0) return p;
		int r = p%q;
		return qcd(q, r);
	}
}
