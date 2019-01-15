package org.eason.lock.demo;

/**
 * @Desc: 测试对象锁
 * @DateTime: 2019/1/15 16:15
 * @Author chen
 * @Version 1.0
 */
public class TestObjectLock {
    public synchronized void running() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");
        }
    }

    public synchronized void call() {
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
        TestObjectLock testLock = new TestObjectLock();
        Thread t1 = new Thread(() -> {
            testLock.running();
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            testLock.call();
        });
        t2.start();
    }
}
