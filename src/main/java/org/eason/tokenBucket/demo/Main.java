package org.eason.tokenBucket.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc: 令牌桶限流算法
 *         支持时间窗口内的访问量限制，
 *         比如限制一个接口每秒只能接受100个请求（100 QPS），
 *         一个独立线程会以10ms的频率往令牌桶里放入1个Token（100 QPS = 每10毫秒一个请求），
 *         系统每接收到1个请求，从令牌桶消费1个Token
 * @DateTime: 2019/1/10 17:50
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> tokenBucket = new LinkedBlockingQueue<>();

        new TokenBucket(tokenBucket).start();
        while (true) {
            //每接受到一个请求，消耗一个token
            System.out.println(tokenBucket.take());
        }
    }
}
