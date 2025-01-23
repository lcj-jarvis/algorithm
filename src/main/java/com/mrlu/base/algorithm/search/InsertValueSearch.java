package com.mrlu.base.algorithm.search;

/**
 * @author 简单de快乐
 * @create 2025-01-22 20:41
 *
 * 插值查找
 * 【注意】使用插值查找的前提是数组是有序的
 */
public class InsertValueSearch {


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int index = insertValueSearch(array, 0, array.length - 1, 1);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, 10);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, 3);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, -10);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, 100);
        System.out.println(index);
    }

    /**
     * 插值查找
     */
    public static int insertValueSearch(int[] array, int left, int right, int elment) {
        // value < array[left]与value > array[right]这两个条件是必须的，不然下面计算出来的mid，可能会出现数组下表越界
        if (left > right || elment < array[left] || elment > array[right]) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) * (elment - array[left]) / (array[right] - array[left]);
            if (array[mid] == elment) {
                return mid;
            } else if (array[mid] < elment) {
                // mid的右边找
                left = mid + 1;
            } else {
                // mid的左边找
                right = mid - 1;
            }
        }
        return -1;
    }
}
