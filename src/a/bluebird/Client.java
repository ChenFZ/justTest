/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Client
 * Author:   chenfz
 * Date:     2019/3/15 17:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package a.bluebird;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author chenfz
 * @create 2019/3/15
 * @since 1.0.0
 */
public class Client {
    final void show(){
        System.out.println();
    }
}

class Facher{
    final void show(){
        System.out.println("father show");
        synchronized (this){

    }
}
class Child extends Facher{
    }
}

