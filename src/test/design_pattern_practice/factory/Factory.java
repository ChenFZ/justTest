/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Factory
 * Author:   cheny
 * Date:     2019/3/8 14:42
 * Description: 抽象工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package test.design_pattern_practice.factory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈抽象工厂〉
 *
 * @author cheny
 * @create 2019/3/8
 * @since 1.0.0
 */
public interface Factory {
    Gun produceGun();
    Bullet produceBullet();
}
