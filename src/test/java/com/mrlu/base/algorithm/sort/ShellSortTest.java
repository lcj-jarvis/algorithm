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
    }

}
