package com.mrlu.base.algorithm.search;

import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.search.BinarySearch.*;

/**
 * @author 简单de快乐
 * @create 2025-01-22 19:22
 */
public class BinarySearchTest {

    @Test
    public void test() {
        int[] arr = {1,2,2,3,4,5,5,5,6,6,7,8,9};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 7));
        System.out.println(search(arr, 0, arr.length - 1, 7));
        System.out.println(binarySearchAll(arr, 0, arr.length - 1, 6));
        System.out.println(binarySearchAll(arr, 0, arr.length - 1, 6666));
    }


}
