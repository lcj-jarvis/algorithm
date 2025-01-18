package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mrlu.base.algorithm.sort.QuickSort.quickSort;

/**
 * @author 简单de快乐
 * @create 2025-01-18 18:08
 */
public class QuickSortTest {

    @Test
    public void test() {
        int[] array = {23, 26 , 8, 11, 44, 41, 46, 25, 37, 12};
        //int[] array = {1, 2 , 3, 4, 5, 5, 6, 7, 8, 9};
        //int[] array = {1, 2 , 3, 4, 5, 6, 7, 8, 9};
        //int[] array = {9, 9 , 8, 7, 6, 5, 4, 3, 2};
        //int[] array = {9 , 8, 7, 6, 5, 4, 3, 2};
        //int[] array = {10 , 666, 2, 6, 5, 888, -1, -2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
