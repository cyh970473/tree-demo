package org.eason.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @Desc:
 * @DateTime: 2018/10/29 14:33
 * @Author chen
 * @Version 1.0
 */
public class Producer extends Thread {
    private volatile boolean isRunning = true;
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (isRunning) {
            try {
                String s = "data-" + i++;
                queue.put(s);
                System.out.println("生产数据：" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopNow() {
        this.isRunning = false;
    }
}
