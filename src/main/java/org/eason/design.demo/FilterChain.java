package org.eason.design.demo;

/**
 * @Desc:
 * @DateTime: 2018/10/22 11:18
 * @Author chen
 * @Version 1.0
 */
public class FilterChain {
    private int n,pos,inc = 10;
    private Filter[] filters = new Filter[0];

    public void addFilter(Filter filter) {
        if(n == filters.length) {
            Filter[] dest = new Filter[n + inc];
            System.arraycopy(filters, 0, dest, 0, n);
            filters = dest;
        }
        filters[n++] = filter;
    }

    public void doFilter(String req, String res) {
        if(pos < n) {
            Filter filter = filters[pos++];
            filter.doFilter(req, res, this);
        }
    }
}
