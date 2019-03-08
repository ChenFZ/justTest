/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: TestLockSupport
 * Author:   cheny
 * Date:     2019/3/5 16:07
 * Description: 测试LockSupport类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.issue;

import java.util.concurrent.locks.LockSupport;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试LockSupport类〉
 *
 * @author cheny
 * @create 2019/3/5
 * @since 1.0.0
 */
public class TestLockSupport {
    public static void main(String[] args)throws Exception{
        Object o = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                //synchronized (o){
                //    try {
                //        o.wait();
                //    } catch (InterruptedException e) {
                //        e.printStackTrace();
                //    }
                //}
                LockSupport.park();
                System.out.println(sum);
            }
        });
        A.start();
        //Thread.sleep(1000);
        //synchronized (o){
        //    o.notify();
        //}
        LockSupport.unpark(A);
    }
}
