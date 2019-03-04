/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: PrintNumAndChar
 * Author:   cheny
 * Date:     2019/3/4 17:10
 * Description: 按顺序打印数字和字母
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.interview.print;

/**
 * 〈一句话功能简述〉<br> 
 * 〈按顺序打印数字和字母〉
 * 数组A内容为 1,2,3,4...52 ,数组B内容为26个英文字母，使用两个线程分别输入两个数组，
 * 打印内容为：12a34b56c78e....... 这样的规律
 * @author cheny
 * @create 2019/3/4
 * @since 1.0.0
 */
import java.util.concurrent.atomic.AtomicBoolean;

public class PrintNumAndChar {

    public static void main(String[] args) {
        AtomicBoolean isNum = new AtomicBoolean(true);
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        char[] chars = { 'a', 'b', 'c', 'd', 'e' };
        new PrintNums(nums, isNum).start();
        new PrintChars(chars, isNum).start();

    }

    public static class PrintNums extends Thread {
        private int[] nums;
        private AtomicBoolean isNum;

        public PrintNums(int[] a1, AtomicBoolean isNum) {
            this.nums = a1;
            this.isNum = isNum;
        }

        public void run() {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!isNum.get()) {
                    Thread.yield();
                }
                System.out.print(nums[i]);
                count++;
                if (count == 2) {
                    isNum.set(false);
                    count = 0;
                }
            }
            isNum.set(false);
        }
    }

    public static class PrintChars extends Thread {
        private char[] chars;
        private AtomicBoolean isNum;

        public PrintChars(char[] a2, AtomicBoolean isNum) {
            this.chars = a2;
            this.isNum = isNum;
        }

        public void run() {
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                while (isNum.get()) {
                    Thread.yield();
                }
                System.out.print(chars[i]);
                count++;
                if (count == 1) {
                    isNum.set(true);
                    count = 0;
                }
            }
            isNum.set(true);
        }
    }
}
