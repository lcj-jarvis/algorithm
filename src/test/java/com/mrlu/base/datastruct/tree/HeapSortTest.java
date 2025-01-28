package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mrlu.base.algorithm.sort.HeapSort.heapSort;

/**
 * @author 简单de快乐
 * @create 2025-01-28 17:18
 */
public class HeapSortTest {

    @Test
    public void test() {
        //int arr[] = {49, 38, 65, 97, 76, 13, 27, 49};
        int arr[] = {49, 38, 65, 97, 76, 13, 27, 49, -1, 0, 66, 666, 888};
        heapSort(arr);
        // [13, 38, 27, 49, 76, 65, 49, 97]
        System.out.println(Arrays.toString(arr));
    }

}
