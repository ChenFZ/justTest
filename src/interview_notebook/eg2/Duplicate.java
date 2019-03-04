package interview_notebook.eg2;

import java.util.Arrays;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组
 * {2, 3, 1, 0, 2, 5}，那么对应的输出是第一个重复的数字 2。
 * 
 * 要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度
 * O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。牛客网讨论区这一题的首票答案使用 nums[i] + length
 * 来将元素标记，这么做会有加法溢出问题。
 * 
 * @author 陈方正
 *
 */
public class Duplicate {
	public static void main(String[] args) {
		int[] n = {3,2,4,5,1,1};
		int[] d = new int[1];
		System.out.println(duplicate(n,6,d));
		System.out.println(Arrays.toString(d));
	}

	public static boolean duplicate(int[] nums,int length,int[] duplicate) {
		if (nums==null || length<0)
			return false;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[i] != nums[nums[i]]) {
					swap(nums, i, nums[i]);
				}else {
					duplicate[0] = nums[i];
					return true;
				}
			}
		}
		return false;
	}
	
	private static void swap(int[] nums, int i, int j) {
	    int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
	}

}
