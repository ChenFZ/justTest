package a.b.algorithm;

import java.util.Scanner;

/**
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * 
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
 * 
 * 结论一：x+y = x|y --> x&y=0 
 * 结论二：把k表示成二进制数，填入x取0的比特位，x取1的比特位保持为0，得到y。
 * 
 * @author chenfz
 *
 */
public class Add {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int k = scanner.nextInt();
		int bitNum = 1;
		long ans = 0;
		while (k > 0) {
			if ((x & bitNum) == 0) {
				ans += bitNum*(k&1);
				k = k >>> 1;
			}
			bitNum = bitNum << 1;
		}
		System.out.println(ans);
	}
}
