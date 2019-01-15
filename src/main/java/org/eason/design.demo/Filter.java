package org.eason.design.demo;

/**
 * @Desc:
 * @DateTime: 2018/10/22 11:18
 * @Author chen
 * @Version 1.0
 */
@FunctionalInterface
public interface Filter {
    void doFilter(String req, String res, FilterChain chain);
}
