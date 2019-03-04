package utils.algorithm;
/**
 * 斐波那契数列: f(n)=f(n-1)+f(n-2); 
 * 				n>=2 f(0)=0; f(1)=1; 
 * 即有名的兔子繁衍问题。
 * 三种解法
 * @author chenfz
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(bFunc(50));
//		System.out.println(aFunc(30));
	}
	
	/*
	 * 1. 递归求解 :递归求解比较简单，是大家常见的一种解法。
	 * 时间复杂度 O(2^n)
	 */
	static long aFunc(int n) {
		if (n <= 0) {
			return 0L;
		}
		if (n==1) {
			return 1L;
		}
		return aFunc(n-1) + aFunc(n-2);
	}
	/*
	 * 2.进行循环计算减少时间复杂度  O(n)
	 */
	static long bFunc(int n) {
		if (n <= 0) {
			return 0L;
		}
		if (n==1) {
			return 1L;
		}
		long min = 0;
		long max = 1;
		int i = 2;
		long result = 0L;
		while (i<=n) {
			result = min + max;
			min = max;
			max = result;
			i++;
		}
		return result;
	}
	
	/*
	 * 还有一种时间复杂度更低的算法。 
	 */
	
}
