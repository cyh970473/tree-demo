package org.eason.pool.demo;

/**
 * @Desc:
 * @DateTime: 2018/10/26 16:20
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPoolExecutor();
        threadPool.execute(() -> {
            int i = 5;
            while (i > 0) {
                System.out.println("处理业务1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
        });
        threadPool.execute(() -> {
            int i = 5;
            while (i > 0) {
                System.out.println("处理业务2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
        });
    }
}
