package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-02-07 22:24
 */
public class AVLTreeTest {


    /**
     *           7
     *      3          10
     *   1    5     9      12
     *     2      8     11     13
     *
     */
    @Test
    public void testHeight() {
        int[] array = {7,3,10,12,5,1,9, 8, 2, 11, 13};
        AVLTree tree = new AVLTree();
        for (int el : array) {
            AVLNode node = new AVLNode(el);
            tree.add(node);
        }
        AVLNode root = tree.getRoot();
        System.out.println("树的高度：" + root.height());
        System.out.println("左子树的高度：" + root.getLeft().height());
        System.out.println("右子树的高度：" + root.getRight().height());
    }

    /**
     * 调整前：
     *        4
     *     3    6
     *        5   7
     *               8
     *
     * 调整后：
     *          6
     *      4       7
     *    3   5        8
     */
    @Test
    public void testLeftRotate() {
        int[] array = {4, 3, 6, 5, 7, 8};
        AVLTree tree = new AVLTree();
        for (int el : array) {
            AVLNode node = new AVLNode(el);
            tree.add(node);
        }
        AVLNode root = tree.getRoot();
        System.out.println("树的高度：" + root.height());
        System.out.println("左子树的高度：" + root.getLeft().height());
        System.out.println("右子树的高度：" + root.getRight().height());
        System.out.println("调整后的根结点：" + tree.getRoot());
        tree.infixOrder();
    }

    /**
     * 调整前：
     *           10
     *       8       12
     *    7    9
     * 6
     *
     * 调整后：
     *           8
     *       7       10
     *    6       9      12
     */
    @Test
    public void testRightRotate() {
        int[] array = {10, 12, 8, 9, 7, 6};
        AVLTree tree = new AVLTree();
        for (int el : array) {
            AVLNode node = new AVLNode(el);
            tree.add(node);
        }
        AVLNode root = tree.getRoot();
        System.out.println("树的高度：" + root.height());
        System.out.println("左子树的高度：" + root.getLeft().height());
        System.out.println("右子树的高度：" + root.getRight().height());
        System.out.println("调整后的根结点：" + tree.getRoot());
        tree.infixOrder();
    }

    /**
     * 测试双旋转。
     * 情况一：
     *       10
     *   7       11
     * 6    8
     *        9
     *
     * 结点10进行右旋转前，需要先对左子树左旋转
     *           10
     *        8      11
     *     7    9
     *  6
     *
     * 结点10进行右旋转
     *          8
     *      7      10
     *   6       9   11
     *
     * 情况二：
     *       7
     *   3       12
     *      10      13
     *        11
     * 结点7进行左旋转前，需要先对右子树右旋转
     *       7
     *   3     10
     *            12
     *         11    13
     *
     *  结点7进行左旋转
     *         10
     *     7       12
     *  3       11   13
     *
     */
    @Test
    public void testDoubleRotate() {
        int[] array = { 10, 11, 7, 6, 8, 9 };
        //int[] array = {7,3,12,10,13,11};
        AVLTree tree = new AVLTree();
        for (int el : array) {
            AVLNode node = new AVLNode(el);
            tree.add(node);
        }
        AVLNode root = tree.getRoot();
        System.out.println("树的高度：" + root.height());
        System.out.println("左子树的高度：" + root.getLeft().height());
        System.out.println("右子树的高度：" + root.getRight().height());
        System.out.println("调整后的根结点：" + tree.getRoot());
        System.out.println("根结点的左结点：" + tree.getRoot().getLeft());
        System.out.println("根结点的右结点：" + tree.getRoot().getRight());
        tree.infixOrder();
    }
}
