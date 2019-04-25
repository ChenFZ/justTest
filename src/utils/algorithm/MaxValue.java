/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MaxValue
 * Author:   chenfz
 * Date:     2019/3/20 11:07
 * Description: 背包问题，最大价值
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package utils.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈背包问题，最大价值〉
 *
 * @author chenfz
 * @create 2019/3/20
 * @since 1.0.0
 */
public class MaxValue {

    public static void main(String[] args) {
        int i = MaxValue();
        System.out.println(i);
    }

    public static int MaxValue() {
        int maxValue = 0;
        Scanner scanner1 = new Scanner(System.in);
        int high = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        String arrStr = scanner2.nextLine();
        String[] split = arrStr.split(" ");
        List<Integer> list = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            maxValue += list.get(i);
            if (maxValue > high) {
                maxValue -= list.get(i);
            }
        }

        // 递归调用，每次在允许的情况下只放入一件物品
//            int res = 0;
//            while ((res = setBag(arr,high-maxValue))!=0){
//                maxValue+=res;
//            }
//            counter++;
//        }
        return maxValue;
    }

//    private static int setBag(int[] arr, int high) {
//        if (high==0 || arr.length==0) return 0;
//        int result = 0;
//        int site = -1;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]!=0 && arr[i]<high && arr[i]>result){
//                result = arr[i];
//                site = i;
//            }
//        }
//        if (site!=-1)
//            arr[site] = 0;
//        return result;
//    }
}
