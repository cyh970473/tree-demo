package org.eason.tree.demo;

import java.util.Comparator;

/**
 * @Desc:
 * @DateTime: 2018/9/19 16:59
 * @Author chen
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> o1 - o2);
        treeMap.put(67, "67");
        treeMap.put(12, "12");
        treeMap.put(23, "23");
        treeMap.put(56, "561");
        treeMap.put(56, "562");
        treeMap.put(78, "78");
        treeMap.put(34, "34");
        treeMap.put(9, "9");
        System.out.println(treeMap.get(12));
        System.out.println(treeMap.containsKey(34));
        System.out.println(treeMap.size());
        System.out.println(treeMap.remove(9));
        System.out.println(treeMap.remove(12));
        System.out.println(treeMap.size());
    }
}
