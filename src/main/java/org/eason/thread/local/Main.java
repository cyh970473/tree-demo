package org.eason.thread.local;

public class Main {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set("线程A");
            System.out.println(threadLocal.get());
        }).start();

        new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set("线程B");
            System.out.println(threadLocal.get());
        }).start();;
    }
}
