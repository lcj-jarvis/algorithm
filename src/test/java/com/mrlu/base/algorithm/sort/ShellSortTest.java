package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-17 16:12
 */
public class ShellSortTest {

    @Test
    public void test() {
        int[] arr={8,9,1,7,2,3,5,4,6,0};
        ShellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1={1,2,3,4,5,6,7,8,9};
        ShellSort.shellSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2={9,8,7,6,5,4,3,2,1,1};
        ShellSort.shellSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
