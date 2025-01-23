package com.mrlu.base.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 简单de快乐
 * @create 2025-01-20 22:41
 *
 * 二分查找
 * 【注意】使用二分查找的前提是数组是有序的
 *
 * 可以对比java的
 * @see java.util.Arrays#binarySearch(int[], int)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,5,6,6,7,8,9};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 7));
        System.out.println(search(arr, 0, arr.length - 1, 7));
        System.out.println(binarySearchAll(arr, 0, arr.length - 1, 6));
    }

    /**
     * 二分查找-递归版本
     * @param arr
     * @param left
     * @param right
     * @param element
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int element) {
        if (left > right) {
            // 没有找到返回-1
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > element) {
            // 在中间元素的左边找
            return binarySearch(arr, left, mid - 1, element);
        } else if (arr[mid] < element) {
            // 在中间元素的右边找
            return binarySearch(arr, mid + 1, right, element);
        } else {
            // 找到目标元素位置
            return mid;
        }
    }

    /**
     * 二分查找-非递归版本
     * @param arr
     * @param left
     * @param right
     * @param element
     * @return
     */
    public static int search(int[] arr, int left, int right, int element) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > element) {
                // 在中间元素的左边找
                right = mid - 1;
            } else if (arr[mid] < element) {
                // 在中间元素的右边找
                left = mid + 1;
            } else {
                // 找到目标元素位置
                return mid;
            }
        }
        // 没有找到返回-1
        return -1;
    }


    /**
     * 二分查找-递归版本：返回所有等于element元素的位置
     * @param arr
     * @param left
     * @param right
     * @param element
     * @return
     */

    public static List<Integer> binarySearchAll(int[] arr,
                                                int left,
                                                int right,
                                                int element) {
        if (left > right) {
            return Collections.emptyList();
        }

        List<Integer> locations = new ArrayList<>();
        int mid = (left + right) / 2;
        if (arr[mid] > element) {
            // 左边找
            locations.addAll(binarySearchAll(arr, left, mid - 1, element));
        } else if (arr[mid] < element) {
            // 右边找
            locations.addAll(binarySearchAll(arr, mid + 1, right, element));
        } else {
            // 从mid的往左找，直到找到不等于element的元素
            int index = mid - 1;
            while (arr[index] == element) {
                index--;
            }
            for (int i = index + 1; i < mid; i++) {
                locations.add(i);
            }
            // 记录中间位置
            locations.add(mid);

            // 从mid的往右找，直到找到不等于element的元素
            index = mid + 1;
            while (arr[index] == element) {
                index++;
            }
            for (int i = mid + 1; i < index; i++) {
                locations.add(i);
            }
        }
        return locations;
    }

}
