package utils.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 *  给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
	你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	示例:
	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
 * @author 陈方正
 *
 */
public class TowSum {
	public static void main(String[] args) {
		int[] nums = {2, 6, 7, 15};
		System.out.println(Arrays.toString(towSum(nums, 9)));
	}
	
	public static int[] towSum(int[] nums,int target){
		int[] arr = new int[2];
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				arr[1] = i;
				arr[0] = map.get(nums[i]);
			}
			map.put(target - nums[i], i);
		}
		return arr;
	}
}
