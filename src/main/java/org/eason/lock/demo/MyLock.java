package org.eason.lock.demo;

/**
 * @Desc: 不可重入锁
 * @DateTime: 2019/1/15 17:00
 * @Author chen
 * @Version 1.0
 */
public class MyLock {
    private boolean isLocked = false;

    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }


    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t1 running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();


        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t2 running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();
    }
}
