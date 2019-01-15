package org.eason.thread.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc:
 * @DateTime: 2018/10/27 14:49
 * @Author chen
 * @Version 1.0
 */
public class Main {
    private static final int CAPACITY = 5;

    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread producer1 = new Producer("P-1", queue, CAPACITY);
//        Thread producer2 = new Producer("P-2", queue, CAPACITY);
        Thread consumer1 = new Consumer("C1", queue, CAPACITY);
//        Thread consumer2 = new Consumer("C2", queue, CAPACITY);
//        Thread consumer3 = new Consumer("C3", queue, CAPACITY);

        producer1.start();
//        producer2.start();
        consumer1.start();
//        consumer2.start();
//        consumer3.start();
    }
}
