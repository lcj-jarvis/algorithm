package com.mrlu.base.algorithm.search;

/**
 * @author 简单de快乐
 * @create 2025-01-20 22:39
 *
 * 顺序查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,5,6,6,7,8,9};
        System.out.println(seqSearch(arr, 5));
    }

    /**
     * 线性查找
     * @param arr
     * @param element
     * @return
     */
    public static int seqSearch(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

}
