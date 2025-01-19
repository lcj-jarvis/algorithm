package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-18 22:11
 *
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        //int[] arr = {1,2,3,4,5,6,7,8};
        //System.out.println(binarySearch(arr, 0 , arr.length - 1, 7));

        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序需要用到分而治之的思想，还需要递归，我们先写一个二分查找熟悉一下分而治之和递归
     * @param arr
     * @param left
     * @param right
     * @param element
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int element) {
        int mid = (left + right) / 2;
        if (arr[mid] == element) {
            return mid;
        }

        if (left > right) {
            // 表示不存在
            return - 1;
        }

        if (element < arr[mid]) {
            // 从左边找
            return binarySearch(arr, left, mid - 1, element);
        } else {
            // 从右边找到
            return binarySearch(arr, mid + 1, right, element);
        }
    }

    /**
     * 归并排序
     * 时间复杂度O(nlogn)
     * @param arr 序列
     * @param left 序列起点
     * @param right 序列终点
     * @param temp 临时数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左部分
            mergeSort(arr, left, mid, temp);
            // 右部分
            mergeSort(arr, mid + 1, right, temp);
            // 每分割一次，合并一次
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并治理。这里合并的思路和合并有序链表的思路是类似的
     * @param arr
     * @param left 左子序列起点索引
     * @param mid  左子序列终点索引
     * @param right 右子序列终点索引
     * @param temp 临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 准备：
        // (1)获取左子序列的起点t1，作为左子序列的遍历起点
        int t1 = left;
        // (2)获取右子序列的起点t2，作为右子序列的遍历起点。右子序列的起点 = 左子序列的终点 + 1 = mid + 1
        int t2 = mid + 1;
        //创建临时数组temp的保存起点index=0
        int index = 0;

        //第一步：使用t1和t2遍历左右子序列进行合并，保存合并的结果到临时数组temp
        //t2指向的元素 < t1指向的元素，把t2指向的元素保存到临时数组temp的index位置，index后移，t2后移
        //t1指向的元素 < t2指向的元素，把t1指向的元素保存到临时数组temp的index位置，index后移，t1后移
        //直到t1超出左序列的末端，或者t2超出右序列的末端。
        while (t1 <= mid && t2 <= right) {
            if (compare(arr[t1], arr[t2]) < 0) {
                //t1指向的元素 < t2指向的元素，把t1指向的元素保存到临时数组temp的index位置，index后移，t1后移
                temp[index] = arr[t1];
                index++;
                t1++;
            } else {
                //t2指向的元素 < t1指向的元素，把t2指向的元素保存到临时数组temp的index位置，index后移，t2后移
                temp[index] = arr[t2];
                index++;
                t2++;
            }
        }

        //第二步：把左子序列或者右子序列剩余的部分，保存到临时数组temp
        if (t2 > right) {
            //如果t2超出右子序列的末端，说明左子序列还有剩余的元素，把左子序列剩余的元素保存到临时数组temp。
            for (int i = t1;i <= mid; i++) {
                temp[index] = arr[i];
                index++;
            }
        }
        if (t1 > mid) {
            //如果t1超出左子序列的末端，说明右子序列还有剩余的元素，把右子序列剩余的元素保存到临时数组temp。
            for (int i = t2;i <= right; i++) {
                temp[index] = arr[i];
                index++;
            }
        }

        //第三步：把遍历临时数组temp的元素复制到原数组的相应位置
        //获取左子序列的起点，作为保存到原数组的起点位置。
        //遍历临时数组temp，从“保存到原数组的起点位置”开始保存遍历到的元素。
        int begin = left;
        for (int i = 0; i < index; i++) {
            arr[begin] = temp[i];
            begin++;
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

}
