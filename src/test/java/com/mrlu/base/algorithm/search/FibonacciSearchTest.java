package com.mrlu.base.algorithm.search;

import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.search.FibonacciSearch.fibonacciSearch;

/**
 * @author 简单de快乐
 * @create 2025-01-23 20:17
 */
public class FibonacciSearchTest {


    @Test
    public void test() {
        int[] arr = {1,2,2,3,4,5,5,5,6,6,7,8,9};
        System.out.println(fibonacciSearch(arr, 7));
        System.out.println(fibonacciSearch(arr,  2));
        System.out.println(fibonacciSearch(arr, 6));
        System.out.println(fibonacciSearch(arr, 1));
        System.out.println(fibonacciSearch(arr, 5));
        System.out.println(fibonacciSearch(arr, 9));
        System.out.println(fibonacciSearch(arr, -100));
    }
}
