/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: SingletonInnerClass
 * Author:   cheny
 * Date:     2019/3/8 10:47
 * Description: 使用内部类的形式来实现单例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package test.design_pattern.singletonTest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用内部类的形式来实现单例〉
 *
 * @author cheny
 * @create 2019/3/8
 * @since 1.0.0
 */
public class SingletonInnerClass {

    private SingletonInnerClass(){}
    private static class singletonHolder{
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }
    public static SingletonInnerClass getInstance(){
        return singletonHolder.instance;
    }
}
