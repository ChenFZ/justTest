/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: MyPrintNumAndChar1
 * Author:   cheny
 * Date:     2019/3/5 15:41
 * Description: LockSupport实现多线程合作打印
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.interview.print;

import java.util.concurrent.locks.LockSupport;

/**
 * 〈一句话功能简述〉<br>
 * 〈LockSupport实现多线程合作打印〉
 *
 * @author cheny
 * @create 2019/3/5
 * @since 1.0.0
 */
public class MyPrintNumAndChar1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        PrintChar printChar = new PrintChar(chars);
        PrintNum printNum = new PrintNum(nums);
        printNum.setPrintChar(printChar);
        printChar.setPrintNum(printNum);
        printNum.start();
        printChar.start();

    }

    public static class PrintNum extends Thread {
        private int[] nums;
        private Thread printChar;

        public PrintNum(int[] nums) {
            this.nums = nums;
        }

        public void setPrintChar(Thread printChar) {
            this.printChar = printChar;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count++;
                System.out.print(nums[i]);
                if (count == 2) {
                    count = 0;
                    LockSupport.unpark(printChar);
                    LockSupport.park();
                }
            }
            LockSupport.unpark(printChar);
        }
    }

    public static class PrintChar extends Thread {
        private char[] chars;
        private Thread printNum;

        public PrintChar(char[] chars) {
            this.chars = chars;
        }

        public void setPrintNum(Thread printNum) {
            this.printNum = printNum;
        }

        @Override
        public void run() {
            LockSupport.park();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                count++;
                System.out.print(chars[i]);
                if (count == 1) {
                    count = 0;
                    LockSupport.unpark(printNum);
                    LockSupport.park();
                }
            }
            LockSupport.unpark(printNum);
        }
    }
}
