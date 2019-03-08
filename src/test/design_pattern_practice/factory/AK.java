/**
 * Copyright (C), 2015-2019, 航天广信有限公司
 * FileName: AK
 * Author:   cheny
 * Date:     2019/3/8 14:45
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
public class AK implements Gun {
    @Override
    public void shooting() {
        System.out.println("AK shooting...");
    }
}
