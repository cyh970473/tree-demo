package org.eason.tokenBucket.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @Desc:
 * @DateTime: 2019/1/10 17:52
 * @Author chen
 * @Version 1.0
 */
public class TokenBucket extends Thread {

    private BlockingQueue<Integer> tokenBucket;

    public TokenBucket(BlockingQueue<Integer> tokenBucket) {
        this.tokenBucket = tokenBucket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //每10毫秒放入一个token
                Thread.sleep(10);
                tokenBucket.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
