package org.eason.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc:
 * @DateTime: 2018/10/29 14:37
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        Producer p1 = new Producer(queue);
        p1.start();
        new Consumer(queue).start();
        Thread.sleep(10000);
        p1.stopNow();
    }
}
