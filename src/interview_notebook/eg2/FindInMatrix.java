package interview_notebook.eg2;

import java.util.Arrays;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 
 * 从右上角开始查找。因为矩阵中的一个数，它左边的数都比它小，下边的数都比它大。因此，从右上角开始查找，就可以根据 target
 * 和当前元素的大小关系来缩小查找区间。
 * 
 * @author 陈方正
 *
 */
public class FindInMatrix {

	public static void main(String[] args) {
		int[][] a = {
		             {1,   4,  7, 11, 15},
		             {2,   5,  8, 12, 19},
		             {3,   6,  9, 16, 22},
		             {10, 13, 14, 17, 24},
		             {18, 21, 23, 26, 30}
					};
		int[] b = new int[2];
		System.out.println(find(18, a, b));
		System.out.println(Arrays.toString(b));
	}
	
	public static boolean find(int target,int[][] matrix,int[] position){
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int r = 0,c = col-1;
		while (r < row-1 && c>0) {
			if (matrix[r][c]==target) {
				position[0] = r;
				position[1] = c;
				return true;
			}else if (matrix[r][c]<target) {
				r++;
			}else {
				c--;
			}
		}
		return false;
	}
}
