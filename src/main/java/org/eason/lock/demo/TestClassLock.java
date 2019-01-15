package org.eason.lock.demo;

/**
 * @Desc: 测试类锁
 * @DateTime: 2019/1/15 16:44
 * @Author chen
 * @Version 1.0
 */
public class TestClassLock {
    public static synchronized void running() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");
        }
    }

    public static synchronized void call() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("call");
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            TestClassLock.running();
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            new TestClassLock().call();
        });
        t2.start();
    }
}
