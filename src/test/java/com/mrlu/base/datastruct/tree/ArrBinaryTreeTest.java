package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-01-25 16:45
 */
public class ArrBinaryTreeTest {

    @Test
    public void test() {
        int[] arr = {100,101,102,103,104,105,106};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        System.out.println("前序遍历：");
        tree.preOrder();
        System.out.println("中序遍历：");
        tree.infixOrder();
        System.out.println("后序遍历：");
        tree.postOrder();
    }
}
