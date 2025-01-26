package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-01-26 22:32
 */
public class ThreadedBinaryTreeTest {

    /**
     * 测试二叉树的删除，树的结构如下
     *          1
     *    2          3
     * 10   11    4       7
     *          5   6   8   9
     */
    @Test
    public void test() {
        ThreadedBinaryTree tree = getThreadedBinaryTree();
        // 中序线索化与遍历
        //tree.infixOrderThreaded();
        //tree.inOrderTraverse();

        // 前序线索化与遍历
        //tree.preOrderThreaded();
        //tree.preOrderTraverse();

        tree.postOrderThreaded();
    }

    private ThreadedBinaryTree getThreadedBinaryTree() {
        // 先手动构建树
        ThreadedTreeNode n1 = new ThreadedTreeNode(1);
        ThreadedTreeNode n2 = new ThreadedTreeNode(2);
        ThreadedTreeNode n3 = new ThreadedTreeNode(3);
        ThreadedTreeNode n4 = new ThreadedTreeNode(4);
        ThreadedTreeNode n5 = new ThreadedTreeNode(5);
        ThreadedTreeNode n6 = new ThreadedTreeNode(6);
        ThreadedTreeNode n7 = new ThreadedTreeNode(7);
        ThreadedTreeNode n8 = new ThreadedTreeNode(8);
        ThreadedTreeNode n9 = new ThreadedTreeNode(9);
        n1.setLeft(n2);
        n1.setRight(n3);

        n3.setLeft(n4);
        n3.setRight(n7);

        n4.setLeft(n5);
        n4.setRight(n6);

        n7.setLeft(n8);
        n7.setRight(n9);

        ThreadedTreeNode n10 = new ThreadedTreeNode(10);
        ThreadedTreeNode n11 = new ThreadedTreeNode(11);
        n2.setLeft(n10);
        n2.setRight(n11);

        ThreadedBinaryTree tree = new ThreadedBinaryTree(n1);
        return tree;
    }
}
