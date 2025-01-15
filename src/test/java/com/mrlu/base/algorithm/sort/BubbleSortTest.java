package com.mrlu.base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mrlu.base.algorithm.sort.BubbleSort.bubbleSort;
import static com.mrlu.base.algorithm.sort.BubbleSort.prefBubbleSort;

/**
 * @author 简单de快乐
 * @create 2025-01-15 17:28
 */
public class BubbleSortTest {

    @Test
    public void test() {
        int[] arr1 = {3, 9, -1, 10 ,-2, 0};
        bubbleSort(arr1);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(arr1));

        System.out.println("=======================");
        int[] arr2 = {1, 2, 3, 4 ,5, 6};
        bubbleSort(arr2);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(arr2));

        System.out.println("=======================");

        int[] arr3 = {3, 9, -1, 10 ,20};
        prefBubbleSort(arr3);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(arr3));

        System.out.println("=======================");

        int[] arr4 = {1, 2, 3, 4 ,5, 6};
        prefBubbleSort(arr4);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(arr4));
    }
}
