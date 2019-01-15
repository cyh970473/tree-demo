package org.eason.pool.demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc:
 * @DateTime: 2018/10/26 16:06
 * @Author chen
 * @Version 1.0
 */
public class ThreadPoolExecutor implements ThreadPool {
    public static volatile int DEFAULT_WORK_NUM = 10;
    private static LinkedBlockingQueue<Runnable> QUEUE = new LinkedBlockingQueue<>();
    private WorkThread[] workThreads;

    public ThreadPoolExecutor() {
        workThreads = new WorkThread[DEFAULT_WORK_NUM];
        for (int i = 0; i < DEFAULT_WORK_NUM; i++) {
            WorkThread workThread = new WorkThread();
            workThreads[i] = workThread;
            workThread.setName("线程" + (i + 1));
            workThread.start();
            System.out.println(workThread.getName() + "已启动");
        }
    }

    @Override
    public int execute(Runnable runnable) {
        synchronized (QUEUE) {
            QUEUE.offer(runnable);
            QUEUE.notifyAll();
        }
        return 1;
    }

    static class WorkThread extends Thread {
        volatile boolean isRunning = true;

        @Override
        public void run() {
            while (true) {
                if (isRunning) {
                    synchronized (QUEUE) {
                        if(isRunning && QUEUE.isEmpty()) {
                            try {
                                QUEUE.wait(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(getName() + "等待中");
                        } else {
                            Runnable r = QUEUE.poll();
                            if(r != null) {
                                r.run();
                                System.out.println(getName() + "执行任务中");
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
