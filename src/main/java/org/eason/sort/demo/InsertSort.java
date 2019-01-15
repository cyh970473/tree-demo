package org.eason.sort.demo;

/**
 * @Desc:
 * @DateTime: 2018/11/2 17:24
 * @Author chen
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{45, 2, 6, 12, 89};
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
