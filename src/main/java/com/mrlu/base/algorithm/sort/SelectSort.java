package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-15 17:57
 *
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        // 使用逐步推导的方式来讲解选择排序
        // 算法：先简单 --> 再复杂。 把一个复杂的算法拆分成简单的问题，再逐个解决。
        // 假设这是待排序的数组
        int[] array = {3,9,0,10,-1};
        // 第一次
        int t1 = 0;
        int min = 3;
        int minIndex = 0;
        int t2 = t1 + 1;
        for (int i = t2; i < array.length; i++) {
            if (compare(min, array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        if (minIndex != t1) {
            // 交换
            swap(array, t1, minIndex);
        }
        System.out.println("第 1 轮后~~");
        System.out.println(Arrays.toString(array));


        //[-1, 9, 0, 10, 3]
        // 第二次
        t1 = 1;
        min = 9;
        minIndex = 1;
        t2 = t1 + 1;
        for (int i = t2; i < array.length; i++) {
            if (compare(min, array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        if (minIndex != t1) {
            // 交换
            swap(array, t1, minIndex);
        }
        System.out.println("第 2 轮后~~");
        System.out.println(Arrays.toString(array));


        // [-1, 0, 9, 10, 3]
        // 第三次
        t1 = 2;
        min = 9;
        minIndex = 2;
        t2 = t1 + 1;
        for (int i = t2; i < array.length; i++) {
            if (compare(min, array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        if (minIndex != t1) {
            // 交换
            swap(array, t1, minIndex);
        }
        System.out.println("第 3 轮后~~");
        System.out.println(Arrays.toString(array));


        // [-1, 0, 3, 10, 9]
        // 第四次
        t1 = 3;
        min = 10;
        minIndex = 3;
        t2 = t1 + 1;
        for (int i = t2; i < array.length; i++) {
            if (compare(min, array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        if (minIndex != t1) {
            // 交换
            swap(array, t1, minIndex);
        }
        System.out.println("第 4 轮后~~");
        System.out.println(Arrays.toString(array));


        // 经过逐步推导，总结规律
        //for (int t1 = 0; t1 < array.length - 1; t1++) {
        //    int min = array[t1];
        //    int minIndex = t1;
        //    int t2 = t1 + 1;
        //    for (int i = t2; i < array.length; i++) {
        //        if (compare(min, array[i]) > 0) {
        //            min = array[i];
        //            minIndex = i;
        //        }
        //    }
        //    if (minIndex != t1) {
        //        // 交换
        //        swap(array, t1, minIndex);
        //    }
        //}
        //System.out.println(Arrays.toString(array));
    }

    /**
     * 时间复杂度O(n^2)
     * @param arr
     */
    public static void selectSort(int[]  arr) {
        // 需要进行arr.length - 1次选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            // 假设这是最小的元素
            int min = arr[i];
            // 假设这是最小的元素所在的索引位置
            int minIndex = i;

            // 找到需要交换的元素。即找到更小的元素
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[j];
                // 比较。大于0，说明temp小于min。
                if (compare(min, temp) > 0) {
                    // 找到更小的元素。更新min和minIndex
                    min = temp;
                    minIndex = j;
                }
            }

            boolean found = minIndex != i;
            if (found) {
                // 交互位置
                swap(arr, i , minIndex);
            }
        }
    }

    /**
     * 数组元素arr[t1]和arr[t2]交换位置
     */
    private static void swap(int[] arr, int t1, int t2) {
        // 先记录t1位置的元素
        int temp = arr[t1];
        // 把t2位置的元素设置到t1位置
        arr[t1] = arr[t2];
        // 把t1位置的元素设置到t2位置
        arr[t2] = temp;
    }

    /**
     * 比较元素e1和e2。
     * 返回的结果小于0，说明元素e1小于e2。反之，说明元素e1大于e2。
     * @param e1
     * @param e2
     * @return
     */
    private static int compare(int e1, int e2) {
        return e1 - e2;
    }

}
