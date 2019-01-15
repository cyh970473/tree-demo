package org.eason.sort.demo;

/**
 * @Desc:
 * @DateTime: 2018/11/2 15:32
 * @Author chen
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{45, 2, 6, 12, 89};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
