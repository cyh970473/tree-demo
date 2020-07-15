package org.eason.thread.lock;

/**
 * @Desc: 简单死锁示例
 * @DateTime: 2020/7/15 16:42
 * @Author chen.yihua
 * @Version 1.0
 */
public class Lock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("t1");
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println("t2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
