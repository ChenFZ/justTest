package test.design_pattern.factory;
/**
 * 正方形
 * @author chenfz
 *
 */
public class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
