package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-19 21:13
 */
public class RadixSortTest {

    @Test
    public void test() {
        int[] arr = {53,3,542,748,14,214,66,68,16,168};
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 基数排序支持负数的情况
    @Test
    public void testNegativeSort() {
        int[] arr = {53,3,542,748,-2,214,0,-100,16,168,-20};
        RadixSort.radixSortWithNegative(arr);
        System.out.println(Arrays.toString(arr));
    }

}
