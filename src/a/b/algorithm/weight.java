package a.b.algorithm;

import java.util.Scanner;

/**
 * 魔法权值 左移并判断是否相等
 * 
 * @author chenfz
 *
 */
public class weight {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int count = 1;
		int sum = 0;
		while (n-->0) {
			String str = scanner.next();
			String shift = shift(str);
			//
			while (!shift.equals(str)) {
				count++;
				shift = shift(shift);
			}
			if (count>=k) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	private static String shift(String str) {
		String substring = str.substring(0, 1);
		str = str.substring(1);
		return str+substring;
	}

}
