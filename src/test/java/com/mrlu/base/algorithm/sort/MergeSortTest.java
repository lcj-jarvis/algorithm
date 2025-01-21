package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mrlu.base.algorithm.sort.MergeSort.mergeSort;

/**
 * @author 简单de快乐
 * @create 2025-01-19 14:34
 */
public class MergeSortTest {

    @Test
    public void test() {
        int[] arr = {8,4,5,7,1,3,6,2,1,-1,0,666};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1,2,3,4,5,6,7,8,9};
        int[] temp2 = new int[arr2.length];
        mergeSort(arr2, 0, arr2.length - 1, temp2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {9,8,7,6,5,4,3,2,1};
        int[] temp3 = new int[arr3.length];
        mergeSort(arr3, 0, arr3.length - 1, temp3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {888,168,1,-666,0,10,99,233,1};
        int[] temp4 = new int[arr4.length];
        mergeSort(arr4, 0, arr4.length - 1, temp4);
        System.out.println(Arrays.toString(arr4));

    }
}
