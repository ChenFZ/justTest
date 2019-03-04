package a.b;

import java.util.Arrays;

import com.sun.scenario.effect.Merge;

/**
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(
 * divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * 稳定: 是
时间复杂度:
最优时间: O(nlog(n))
最坏时间: O(nlog(n))
平均时间: O(nlog(n))
 * @author chenfz
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {2, 1, 7, 6, 5, 4, 3, 9, 8};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		// 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		int[] temp = new int[arr.length];
		sort(arr, 0, arr.length - 1, temp);
	}

	private static void sort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 左边归并排序，使得左子序列有序
			sort(arr, left, mid, temp);
			// 右边归并排序，使得右子序列有序
			sort(arr, mid + 1, right, temp);
			// 将两个有序子数组合并操作
			merge(arr, left, mid, right, temp);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left, j = mid + 1, x = 0;
		// 先将左右两边的数据比较，从小到大
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[x++] = arr[i++];
			} else {
				temp[x++] = arr[j++];
			}
		}
		// 左边剩余，全部填入temp
		while (i <= mid) {
			temp[x++] = arr[i++];
		}
		while (j <= right) {
			temp[x++] = arr[j++];
		}
		// 将temp数组中的数据拷贝到原数组
		x = 0;
		while (left<=right) {
			arr[left++] = temp[x++];
		}
	}

}
