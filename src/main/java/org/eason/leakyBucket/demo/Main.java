package org.eason.leakyBucket.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc: 漏桶限流算法
 *         水先进入到漏桶里，漏桶以一定的速度出水(Handler的响应速率)，
 *         当水流入速度过大会直接溢出(这里，程序表现是阻塞)(访问频率超过Handler响应速率)，
 *         漏桶算法能强行限制数据的传输速率
 * @DateTime: 2019/1/10 16:59
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(1000);

        new Generator(queue).start();
        new Handler(queue).start();
    }
}
