package org.eason.lock.demo;

/**
 * @Desc: 可重入锁
 * @DateTime: 2019/1/15 17:28
 * @Author chen
 * @Version 1.0
 */
public class MyReentrantLock {
    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockedCount = 0;

    public synchronized void lock() {
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy != thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockedBy = thread;
        lockedCount++;
    }

    public synchronized  void unlock() {
        if(Thread.currentThread() == lockedBy) {
            lockedCount--;
            if(lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }


    public static void main(String[] args) {
        MyReentrantLock lock = new MyReentrantLock();
        new Thread(() -> {
            lock.lock();
            lock.lock();
            try {
                System.out.println("t1 running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            lock.unlock();
        }).start();


        new Thread(() -> {
            lock.lock();
            lock.lock();
            try {
                System.out.println("t2 running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            lock.unlock();
        }).start();
    }
}
