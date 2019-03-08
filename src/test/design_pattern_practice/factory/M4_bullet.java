/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: M4_bullet
 * Author:   cheny
 * Date:     2019/3/8 14:44
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
public class M4_bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("M4 loading bullet");
    }
}
