package a.b.algorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 最大映射
 */
import java.util.Scanner;

public class TouTiao {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = scanner.next();
		}
		Long max = getMax(strs,n);
		System.out.println(max);
	}

	private static Long getMax(String[] strs, int n) {
		HashMap<Character,Long> map = new HashMap<Character, Long>();
		HashSet<Character> headSet = new HashSet<Character>();
		
		for (int i = 0; i < n; i++) {
			String str = strs[i];
			headSet.add(str.charAt(0));
			// 遍历时的权
			Long weight = 1L;
			for (int j = str.length()-1; j>=0; j--) {
				char c = str.charAt(j);
				if (map.containsKey(c)) {
					map.put(c, map.get(c)+weight);
				}else {
					map.put(c, weight);
				}
				weight*=10;
			}
		}
		ArrayList<Map.Entry<Character,Long>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Character,Long>>() {
			@Override
			public int compare(Entry<Character, Long> o1, Entry<Character, Long> o2) {
				return -o1.getValue().compareTo(o2.getValue());
			}
			
		});
		// 当10个字母全部出现，取出权重最小的为0
		if (list.size()==10) {
			for (int i = 9; i >= 0; i--) {
				if (!headSet.contains(list.get(i).getKey())) {
					list.remove(i);
					break;
				}
			}
		}
		long res = 0;
		int i = 0;
		int a = 9;
		while (list.size()> i) {
			res += (list.get(i++).getValue())*(a--);
		}		
		return res;
	}
}
