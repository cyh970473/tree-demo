package org.eason.bloom.filter;

import java.util.BitSet;

/**
 * @Desc: 简单布隆过滤器实现
 * @DateTime: 2019/4/22 16:31
 * @Author chen.yihua
 * @Version 1.0
 */
public class BloomFilter {
    private BitSet bitSet = new BitSet();
    private int[] numArr = {23, 67, 34, 89, 12 , 69};
    private Hash[] hashArr = new Hash[numArr.length];

    BloomFilter() {
        //初始化算法数组
        for (int i = 0; i < numArr.length; i++) {
            hashArr[i] = new Hash(numArr[i]);
        }
    }

    public boolean contains(String str) {
        boolean flag = true;
        for (Hash hash : hashArr) {
            flag = flag && bitSet.get(hash.hash(str));
        }
        return flag;
    }

    public void put(String str) {
        for (Hash hash : hashArr) {
            bitSet.set(hash.hash(str));
        }
    }
}

class Main {
    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();
        for (int i = 0; i < 100 * 10000; i++) {
            bloomFilter.put("测试字符串-" + i);
        }

        for (int i = 0; i < 100 * 10000; i++) {
            System.out.println(bloomFilter.contains("测试字符串-" + i));
        }
        System.out.println(bloomFilter.contains("不存在"));
    }
}
