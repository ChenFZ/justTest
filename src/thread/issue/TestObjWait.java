/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: TestObjWait
 * Author:   cheny
 * Date:     2019/3/5 16:40
 * Description: 测试一下ThreadPoolExecutor类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.issue;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试一下ThreadPoolExecutor类〉
 *
 * @author cheny
 * @create 2019/3/5
 * @since 1.0.0
 */
public class TestObjWait {

    public static void main(String[] args)throws Exception {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

        //corePoolSize:池内线程初始值与最小值，就算是空闲状态，也会保持该数量线程。
        //maximumPoolSize:线程最大值，线程的增长始终不会超过该值。
        //keepAliveTime：当池内线程数高于corePoolSize时，经过多少时间多余的空闲线程才会被回收。回收前处于wait状态
        //unit：
        //时间单位，可以使用TimeUnit的实例，如TimeUnit.MILLISECONDS
        //workQueue:待入任务（Runnable）的等待场所，该参数主要影响调度策略，如公平与否，是否产生饿死(starving)
        //threadFactory:线程工厂类，有默认实现，如果有自定义的需要则需要自己实现ThreadFactory接口并作为参数传入。
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.SECONDS, queue);

        Future<String> future = poolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "hello";
            }
        });
        String result = future.get();
        System.out.println(result);

    }

}
