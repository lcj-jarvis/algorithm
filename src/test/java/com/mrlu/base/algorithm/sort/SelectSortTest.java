package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mrlu.base.algorithm.sort.SelectSort.selectSort;

/**
 * @author 简单de快乐
 * @create 2025-01-15 21:40
 */
public class SelectSortTest {

    @Test
    public void test() {
        int[] arr1 = {3, 9, -1, 10 ,-2, 0};
        selectSort(arr1);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(arr1));
    }
}
