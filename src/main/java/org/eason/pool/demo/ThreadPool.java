package org.eason.pool.demo;

/**
 * @Desc:
 * @DateTime: 2018/10/26 16:05
 * @Author chen
 * @Version 1.0
 */
public interface ThreadPool {
    int execute(Runnable runnable);
}
