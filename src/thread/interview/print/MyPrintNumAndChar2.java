/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: MyPrintNumAndChar2
 * Author:   cheny
 * Date:     2019/3/6 9:15
 * Description: 使用可重入锁解决
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.interview.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用可重入锁解决〉
 *
 * @author cheny
 * @create 2019/3/6
 * @since 1.0.0
 */
public class MyPrintNumAndChar2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        Lock lock = new ReentrantLock();
        Condition printNum = lock.newCondition();
        Condition printChar = lock.newCondition();
        new Thread(new PrintNum(nums, printNum, printChar, lock)).start();
        new Thread(new PrintChar(chars, printNum, printChar, lock)).start();
    }
    public static class PrintNum implements Runnable{

        private int[] nums;
        private Condition printNum;
        private Condition printChar;
        private Lock canPrint;

        public PrintNum(int[] nums, Condition printNum, Condition printChar, Lock canPrint) {
            this.nums = nums;
            this.printNum = printNum;
            this.printChar = printChar;
            this.canPrint = canPrint;
        }

        @Override
        public void run() {
            int count = 0;
            try {
                for (int i :  nums) {
                    if (count == 2){
                        canPrint.lock();
                        count = 0;
                        printChar.signal();
                        printNum.await();
                        canPrint.unlock();
                    }
                    System.out.print(i);
                    count++;
                }
                canPrint.lock();
                printChar.signal();
                canPrint.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class PrintChar implements Runnable{

        private char[] chars;
        private Condition printNum;
        private Condition printChar;
        private Lock canPrint;

        public PrintChar(char[] chars, Condition printNum, Condition printChar, Lock canPrint) {
            this.chars = chars;
            this.printNum = printNum;
            this.printChar = printChar;
            this.canPrint = canPrint;
        }

        @Override
        public void run() {
            int count = 0;
            try {
                //Thread.sleep(1000);
                for (char c :chars ) {
                    if (count == 1){
                        canPrint.lock();
                        count=0;
                        printNum.signal();
                        printChar.await();
                        canPrint.unlock();
                    }
                    System.out.print(c);
                    count++;
                }
                canPrint.lock();
                printNum.signal();
                canPrint.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
