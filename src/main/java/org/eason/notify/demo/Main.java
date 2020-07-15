package org.eason.notify.demo;

/**
 * @Desc: 锁池、等待池
 * @DateTime: 2018/10/29 10:43
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        for (int i = 0; i < 5; i++) {
            new MyThread(lock, "thread-" + (i + 1)).start();
        }
        Thread.sleep(5000);
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
