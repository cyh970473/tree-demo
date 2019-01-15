package org.eason.leakyBucket.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @Desc:
 * @DateTime: 2019/1/10 17:04
 * @Author chen
 * @Version 1.0
 */
public class Generator extends Thread {
    public Generator(BlockingQueue queue) {
        this.queue = queue;
    }
    private BlockingQueue queue;

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                queue.put(i + 1);
                System.out.println("生产->" + (i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
