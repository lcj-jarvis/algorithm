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
        //int[] arr = {53,3,542,748,14,214,66,68,16,168};
        int[] arr = {53,3,542,748,-2,214,0,-100,16,168,-20};

        int min = arr[0];
        for (int el : arr) {
            if (el < min) {
                min = el;
            }
        }
        System.out.println(min);

        // 是否有负数
        boolean hasNegative = min < 0;
        int offset = hasNegative ? -min : 0;
        if (hasNegative) {
            // 所有元素加上偏移量，变成非负数
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + offset;
            }
        }

        RadixSort.radixSort(arr);

        if (hasNegative) {
            // 所有元素减去偏移量，还原成非负数
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - offset;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
