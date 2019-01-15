package org.eason.leakyBucket.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @Desc:
 * @DateTime: 2019/1/10 17:24
 * @Author chen
 * @Version 1.0
 */
public class Handler extends Thread {

    public Handler (BlockingQueue target) {
        this.target = target;
    }

    private BlockingQueue target;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
                System.out.println("消费->" + target.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
