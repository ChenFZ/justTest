package a.b;

import java.util.Arrays;

/**
 * 快速排序 先挖坑，再分治
 * 快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，通常称其为分治法(Divide-and-ConquerMethod)。
该方法的基本思想是：
1．先从数列中取出一个数作为基准数。
2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
3．再对左右区间重复第二步，直到各区间只有一个数。
稳定: 否
时间复杂度:
最优时间: O(nlog(n))
最坏时间: O(n^2)
平均时间: O(nlog(n))
 * @author chenfz
 *
 */
public class Quicksort {
	public static void main(String[] args) {
		int[] s = {48, 6, 57, 88, 60, 42, 83, 73, 88, 85};
		System.out.println(Arrays.toString(s));
		quicksort(s,0,s.length-1);
		System.out.println(Arrays.toString(s));
	}
	public static void quicksort(int[] s, int l, int r) {
		if (l < r) {
			int i = l;
			int j = r;
			int x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x) 
					j--;
				if (i < j) s[i++] = s[j];
				
				while (i < j && s[i] <= x) 
					i++;
				if (i < j) s[j--] = s[i];
			}
			s[i] = x;
			quicksort(s, l, i - 1);
			quicksort(s, j + 1, r);
		}
	}
}
