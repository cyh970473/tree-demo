package org.eason.design.demo;

/**
 * @Desc:
 * @DateTime: 2018/10/22 11:27
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Filter f1 = (req, res, chain) -> {
            System.out.println("我是f1");
            chain.doFilter(req, res);
        };
        Filter f2 = (req, res, chain) -> {
            System.out.println("我是f2");
            chain.doFilter(req, res);
        };
        Filter f3 = (req, res, chain) -> {
            System.out.println("我是f3");
            chain.doFilter(req, res);
        };

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(f1);
        filterChain.addFilter(f2);
        filterChain.addFilter(f3);

        filterChain.doFilter("a", "b");
    }
}
