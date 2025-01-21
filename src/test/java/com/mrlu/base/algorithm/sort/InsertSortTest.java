package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-16 15:42
 */
public class InsertSortTest {

    @Test
    public void test() {
        int[] arr1 = {17, 3, 25, 14 , 20, 9};
        InsertSort.insertSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {101,34,119,1,-1,89, 101};
        //InsertSort.insertSort(arr2);
        InsertSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
