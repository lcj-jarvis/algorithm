package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-15 14:49
 *
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 时间复杂度：O(n^2)
     * 缺点：假如在冒泡的过程中，数组已经是有序的，还会进行后续冒泡过程。
     * 优化：在每一次冒泡过程开始前，设置一个标识flag，默认为false，表示没有进行元素交换过。
     *      如果在冒泡的操作中，进行过元素交换，则设置为true。
     *      在一次冒泡过程后，判断flag是否还是false，如果是说明已经有序了，无需进行后续冒泡过程，直接结束。
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 需要冒泡的元素个数
        int bubbleNum = arr.length - 1;
        // i表示已冒泡的元素个数
        // 循环一次，表示一次完整的冒泡过程
        for (int i = 0; i < bubbleNum; i++) {

            // 循环一次，表示一次冒泡操作。
            // 从t1位置，开始执行冒泡操作，初始时t1在第一个位置。直到t1到达“未冒泡好的元素组成的数组的末端”才结束
            // 未冒泡好的元素组成的数组的末端 = arr.length - 已冒泡的元素个数 - 1
            for (int t1 = 0; t1 < arr.length - i - 1 ; t1++) {
                int e1 = arr[t1];

                // 获取t1的下一个位置t2的元素e2
                int t2 = t1 + 1;
                int e2 = arr[t2];

                // 比较。如果t1位置的元素e1 > t2位置的元素e2，则进行交换
                if (compare(e1, e2) > 0) {
                    // 交换e1和e2的位置
                    swap(arr, t1, t2);
                }
            }

            System.out.println("第i=" + (i + 1) + "次冒泡排序后");
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 冒泡排序优化
     * @param arr
     */
    public static void prefBubbleSort(int[] arr) {
        // 需要冒泡的元素个数
        int bubbleNum = arr.length - 1;
        // i表示已冒泡的元素个数
        // 循环一次，表示一次完整的冒泡过程
        for (int i = 0; i < bubbleNum; i++) {

            // 定义一个标识指定有没有交换过。false表示没有
            boolean flag = false;

            // 循环一次，表示一次冒泡操作。
            // 从t1位置，开始执行冒泡操作，初始时t1在第一个位置。直到t1到达“未冒泡好的元素组成的数组的末端”才结束
            // 未冒泡好的元素组成的数组的末端 = arr.length - 已冒泡的元素个数 - 1
            for (int t1 = 0; t1 < arr.length - i - 1 ; t1++) {
                int e1 = arr[t1];

                // 获取t1的下一个位置t2的元素e2
                int t2 = t1 + 1;
                int e2 = arr[t2];

                // 比较。如果t1位置的元素e1 > t2位置的元素e2，则进行交换
                if (compare(e1, e2) > 0) {
                    // 交换e1和e2的位置
                    swap(arr, t1, t2);

                    // 交换过，设置为true
                    flag = true;
                }
            }

            if(!flag) {
                // 没有交换过，说明排序好了
                break;
            }

            System.out.println("第i=" + (i + 1) + "次冒泡排序后");
            System.out.println(Arrays.toString(arr));
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
