/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: MyPrintNumAndChar
 * Author:   cheny
 * Date:     2019/3/5 10:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.interview.print;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author cheny
 * @create 2019/3/5
 * @since 1.0.0
 */
public class MyPrintNumAndChar {

    public static void main(String[] args) {
        // 自旋锁
        AtomicBoolean isNum = new AtomicBoolean(true);
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] chars = { 'a', 'b', 'c', 'd', 'e' };
        new PrintNum(nums,isNum).start();
        new printChar(chars,isNum).start();
    }

    static class PrintNum extends Thread{

        private int[] nums;
        private AtomicBoolean isNum;

        public PrintNum(int[] nums, AtomicBoolean isNum) {
            this.nums = nums;
            this.isNum = isNum;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                // isNum为true时，打印数字
                while (!isNum.get()){
                    Thread.yield();
                }
                System.out.print(nums[i]);
                count++;
                if (count==2){
                    isNum.set(false);
                    count = 0;
                }
            }
            isNum.set(false);
        }
    }

    static class printChar extends Thread{

        private char[] chars;
        private AtomicBoolean isNum;

        public printChar(char[] chars, AtomicBoolean isNum) {
            this.chars = chars;
            this.isNum = isNum;
        }

        @Override
        public void run() {
            //int count = 0;
            for (int i = 0; i < chars.length; i++) {
                // isNum为false时，打印字母
                while (isNum.get()){
                    Thread.yield();
                }
                System.out.print(chars[i]);
                //count++;
                //if (count==1){
                    isNum.set(true);
                    //count = 0;
                //}
            }
            isNum.set(true);
        }
    }

}
