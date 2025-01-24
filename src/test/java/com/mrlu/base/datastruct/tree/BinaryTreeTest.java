package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-01-24 22:17
 */
public class BinaryTreeTest {

    /**
     * 测试二叉树的前中后序遍历，树的结构如下
     *       1
     *   2       3
     *        4     5
     *           6
     */
    @Test
    public void test() {
        // 先手动构建树
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.setLeft(n2);
        n1.setRight(n3);
        n3.setLeft(n4);
        n3.setRight(n5);
        n5.setLeft(n6);
        BinaryTree tree = new BinaryTree(n1);

        // 1 2 3 4 5 6
        System.out.println("前序遍历：");
        tree.preOrder();

        // 2 1 4 3 6 5
        System.out.println("中序遍历：");
        tree.infixOrder();

        // 2 4 6 5 3 1
        System.out.println("后序遍历：");
        tree.postOrder();
    }
}
