package test.design_pattern.adapter.objectAdapter;
/**
 * 创建适配器类，实现标准接口，将这个调用委托给实现新接口的对象来处理
 * @author chenfz
 *
 */
public class AdapterMain {

    public static void main(String[] args) {
        // 使用特殊功能类，即适配类
        M5DataLineAdapter adapter = new M5DataLineAdapter(new M5DataLine());
        adapter.connection();
    }
}