/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: Test
 * Author:   cheny
 * Date:     2019/3/8 14:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package test.design_pattern_practice.factory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author cheny
 * @create 2019/3/8
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        AKFactory akFactory = new AKFactory();
        Gun ak = akFactory.produceGun();
        ak.shooting();
        Bullet ak_bullet = akFactory.produceBullet();
        ak_bullet.load();
    }
}
