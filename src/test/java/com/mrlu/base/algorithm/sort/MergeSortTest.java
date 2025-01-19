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
    }
}
