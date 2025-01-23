package com.mrlu.base.algorithm.search;

import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.search.SeqSearch.seqSearch;

/**
 * @author 简单de快乐
 * @create 2025-01-21 22:58
 */
public class SeqSearchTest {

    @Test
    public void test() {
        int[] arr = {1,2,2,3,4,5,5,5,6,6,7,8,9};
        System.out.println(seqSearch(arr, 5));
    }
}
