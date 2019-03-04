package thread;

public class RunThree {

    public static void main(String[] args) {

        ThreadE a = new ThreadE();
        a.setName("A");
        a.start();

        ThreadF b = new ThreadF();
        b.setName("B");
        b.start();

    }

}

class ServiceA {

    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printB");
    }

}


class ThreadE extends Thread {
    @Override
    public void run() {
        ServiceA.printA();
    }

}


class ThreadF extends Thread {
    @Override
    public void run() {
        ServiceA.printB();
    }
}
