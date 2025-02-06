package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-02-06 13:38
 */
public class HuffmanTreeTest {

    @Test
    public void test() {
        int[] arr =  {13,7,8,3,29,6,1};
        HuffmanTree tree = HuffmanTree.createHuffmanTree(arr);
        tree.preOrder();
    }
}
