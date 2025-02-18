package com.mrlu.base.algorithm.div;

/**
 * @author 简单de快乐
 * @create 2025-02-16 23:28
 *
 * 数组求和，使用分治算法完成
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int[] arr = {1};
        int totalSum = sum(arr);
        System.out.println("数组的总和为：" + totalSum);
        System.out.println("数组的最大值为：" + max(arr));
    }

    /**
     * 分治算法求和
     * @param arr
     * @return
     */
    public static int sum(int[] arr) {
        return sum(arr, 0, arr.length - 1);
    }

    private static int sum(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int mid = (left + right) / 2;
        return sum(array, left, mid) + sum(array, mid + 1, right);
    }

    /**
     * 分治算法求数组中最大值
     * @param arr
     * @return
     */
    public static int max(int[] arr) {
        return max(arr, 0, arr.length - 1);
    }

    private static int max(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int e1 = max(arr, left, mid);
        int e2 = max(arr, mid + 1, right);
        return e1 <= e2 ? e2 : e1;
    }

}
