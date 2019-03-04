package a.b.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 木条拼图
 * 判断几条边能否组成一个简单多边形的基本条件为最长边的值maxLen小于其他边的和,
 * 亦即是maxLen*2<sumLen(所有边的和)
 *
 * @author chenfz
 *
 */
public class Ticks {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (scanner.hasNext()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			long sum = 0;
			int maxLen = 0;
			for (int i = 0; i < n; i++) {
				int operation = scanner.nextInt();
				int length = scanner.nextInt();
				if (operation == 1) {
					list.add(length);
					sum+=length;
					if (length>maxLen) {
						maxLen = length;
					}
				}else {
					list.remove((Integer)length);
					if (length == maxLen) {
						getMaxLen(list);
					}
					sum-=length;
				}
				if (list.size()<3) System.out.println("NO");
				else if (sum>2*maxLen) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		scanner.close();
	}
	
	public static int getMaxLen(ArrayList<Integer> list){
		int maxLen = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)>maxLen) {
				maxLen = list.get(i);
			}
		}
		return maxLen;
	}
}
