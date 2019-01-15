package org.eason.queue;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @Desc:
 * @DateTime: 2018/10/29 14:33
 * @Author chen
 * @Version 1.0
 */
public class Consumer extends Thread {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                String s = this.queue.take();
                System.out.println("消费数据：" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
