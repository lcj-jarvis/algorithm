package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-16 14:41
 *
 * (直接)插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {17, 3, 25, 14 , 20, 9};


        // 第一次比较插入操作
        int t2 = 1;
        int t1 = t2 - 1;

        int e2 = arr[t2];

        int e1 = arr[t1];
        // e1 > e2
        while (compare(e1, e2) > 0) {
            arr[t1 + 1] = e1;

            // t1 向前移动
            t1--;
            if (t1 < 0) {
                // 移动完整个有序列表了。跳出循序。把e2插入到t1的下一个位置。
                break;
            }
            // 重新获取e1
            e1 = arr[t1];
        }
        arr[t1 + 1] = e2;
        System.out.println("第" + t2 + "次比较插入操作完成，最后结果：");
        System.out.println(Arrays.toString(arr));



        // 第二次比较插入操作
        t2 = 2;
        t1 = t2 - 1;

        e2 = arr[t2];

        e1 = arr[t1];
        // e1 > e2
        while (compare(e1, e2) > 0) {
            arr[t1 + 1] = e1;

            // t1 向前移动
            t1--;
            if (t1 < 0) {
                // 移动完整个有序列表了。跳出循序。把e2插入到t1的下一个位置。
                break;
            }
            // 重新获取e1
            e1 = arr[t1];
        }
        arr[t1 + 1] = e2;
        System.out.println("第" + t2 + "次比较插入操作完成，最后结果：");
        System.out.println(Arrays.toString(arr));


        // 第三次比较插入操作
        t2 = 3;
        t1 = t2 - 1;

        e2 = arr[t2];

        e1 = arr[t1];
        // e1 > e2
        while (compare(e1, e2) > 0) {
            arr[t1 + 1] = e1;

            // t1 向前移动
            t1--;
            if (t1 < 0) {
                // 移动完整个有序列表了。跳出循序。把e2插入到t1的下一个位置。
                break;
            }
            // 重新获取e1
            e1 = arr[t1];
        }
        arr[t1 + 1] = e2;
        System.out.println("第" + t2 + "次比较插入操作完成，最后结果：");
        System.out.println(Arrays.toString(arr));

        // 第四次比较插入操作
        t2 = 4;
        t1 = t2 - 1;

        e2 = arr[t2];

        e1 = arr[t1];
        // e1 > e2
        while (compare(e1, e2) > 0) {
            arr[t1 + 1] = e1;

            // t1 向前移动
            t1--;
            if (t1 < 0) {
                // 移动完整个有序列表了。跳出循序。把e2插入到t1的下一个位置。
                break;
            }
            // 重新获取e1
            e1 = arr[t1];
        }
        arr[t1 + 1] = e2;
        System.out.println("第" + t2 + "次比较插入操作完成，最后结果：");
        System.out.println(Arrays.toString(arr));


        // 第五次比较插入操作
        t2 = 5;
        t1 = t2 - 1;

        e2 = arr[t2];

        e1 = arr[t1];
        // e1 > e2
        while (compare(e1, e2) > 0) {
            arr[t1 + 1] = e1;

            // t1 向前移动
            t1--;
            if (t1 < 0) {
                // 移动完整个有序列表了。跳出循序。把e2插入到t1的下一个位置。
                break;
            }
            // 重新获取e1
            e1 = arr[t1];
        }
        arr[t1 + 1] = e2;
        System.out.println("第" + t2 + "次比较插入操作完成，最后结果：");
        System.out.println(Arrays.toString(arr));

        // 总结
        //for (int t2 = 1; t2 < arr.length; t2++) {
        //    int e2 = arr[t2];
        //
        //    // 往前获取有序序列L1的元素e1，与e2比较
        //    int t1 = t2 - 1;
        //    int e1 = arr[t1];
        //    while (compare(e1, e2) > 0) {
        //        // e1 > e2, 则把t1下一个位置的元素设置为e1。然后t1向前移动
        //        arr[t1 + 1] = e1;
        //        t1--;
        //
        //        if (t1 < 0) {
        //            // 移动完整个有序列表了。跳出循序。把e2插入到t1的下一个位置。
        //            break;
        //        }
        //        // 重新获取e1
        //        e1 = arr[t1];
        //    }
        //    // 把e2插入到t1的下一个位置。
        //    arr[t1 + 1] = e2;
        //
        //    //System.out.println("第" + t2 + "次比较插入操作完成，最后结果：");
        //    //System.out.println(Arrays.toString(arr));
        //}
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 直接插入排序-移动式
     * 时间复杂度O(n^2)
     * @param arr
     */
    public static void insertSort(int[] arr) {
        // 初始时t2在数组的第二个位置
        /*for (int t2 = 1; t2 < arr.length; t2++) {
            // 获取e2
            int e2 = arr[t2];
            // 获取t1的初始位置
            int t1 = t2 - 1;
            // 获取t1位置所在的元素e1
            int e1 = arr[t1];

            // 执行一次完整的e2插入过程如下：
            // 比较e1和e2。
            while (compare(e1, e2) > 0) {
                // e1 > e2, 则把t1下一个位置的元素设置为e1，然后t1往前移动
                // t1下一个位置的元素设置为e1
                arr[t1 + 1] = e1;
                // t1往前移动
                t1--;

                if (t1 < 0) {
                    // 移动完了整个有序列表L1。跳出循环。把e2插入到t1的下一个位置。
                    break;
                }

                // 重新获取e1
                e1 = arr[t1];
            }
            // 把e2插入到t1的下一个位置。
            arr[t1 + 1] = e2;
        }*/

        // 最终优化版本写法
        for (int t2 = 1; t2 < arr.length; t2++) {
            // 获取e2
            int e2 = arr[t2];
            // 获取t1的初始位置
            int t1 = t2 - 1;
            while (t1 >= 0 && compare(arr[t1], e2) > 0) {
                // 把t1下一个位置的元素设置为"t1位置所在的元素"
                arr[t1 + 1] = arr[t1];
                // t1往前移动
                t1--;
            }
            // 把e2插入到t1的下一个位置。
            arr[t1 + 1] = e2;
        }
    }

    /**
     * 直接插入排序-交换式
     * 效率低于移动式
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && compare(arr[j], arr[j + 1]) > 0; j--) {
                swap(arr, j, j + 1);
            }
        }
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

}
