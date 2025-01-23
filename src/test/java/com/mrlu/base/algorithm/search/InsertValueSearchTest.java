package com.mrlu.base.algorithm.search;

import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.search.InsertValueSearch.insertValueSearch;

/**
 * @author 简单de快乐
 * @create 2025-01-23 20:16
 */
public class InsertValueSearchTest {

    @Test
    public void test() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int index = insertValueSearch(array, 0, array.length - 1, 1);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, 10);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, 3);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, -10);
        System.out.println(index);

        index = insertValueSearch(array, 0, array.length - 1, 100);
        System.out.println(index);
    }
}
