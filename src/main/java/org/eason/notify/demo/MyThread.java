package org.eason.notify.demo;

/**
 * @Desc:
 * @DateTime: 2018/10/29 10:39
 * @Author chen
 * @Version 1.0
 */
public class MyThread extends Thread {
    private Object lock;
    private String name;

    public MyThread(Object lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run");
        synchronized(this.lock) {
            try {
                System.out.println(this.name + " wait");
                this.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " notified");
        }
    }
}
