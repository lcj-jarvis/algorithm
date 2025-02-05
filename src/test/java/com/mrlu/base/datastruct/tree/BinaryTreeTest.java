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
        BinaryTree tree = getBinaryTree();

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

    @Test
    public void testOrder() {
        BinaryTree tree = getBinaryTree();

        // 1 2 3 4 5 6
        System.out.println("前序遍历：");
        tree.preOrderUseStack();

        // 2 1 4 3 6 5
        System.out.println("中序遍历：");
        tree.infixOrderUseStack();

        // 2 4 6 5 3 1
        System.out.println("后序遍历：");
        tree.postOrderUseStack();
    }

    @Test
    public void testSearch() {
        BinaryTree tree = getBinaryTree();
        System.out.println("前序遍历查找：");
        System.out.println(tree.preOrderSearch(9));

        System.out.println("中序遍历查找：");
        System.out.println(tree.infixOrderSearch(1));

        System.out.println("后序遍历查找：");
        System.out.println(tree.postOrderSearch(2));
    }

    /**
     * 测试二叉树的删除，树的结构如下
     *          1
     *    2          3
     * 10   11    4       7
     *          5   6   8   9
     */
    @Test
    public void testSimpleDeleteNode() {
        BinaryTree binaryTree = getBinaryTreeForDelete();
        System.out.println("前序遍历：");
        binaryTree.preOrder();

        binaryTree.simpleDeleteNode(3);
        System.out.println("删除后：");
        binaryTree.preOrder();
    }

    private BinaryTree getBinaryTreeForDelete() {
        // 先手动构建树
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.setLeft(n2);
        n1.setRight(n3);

        n3.setLeft(n4);
        n3.setRight(n7);

        n4.setLeft(n5);
        n4.setRight(n6);

        n7.setLeft(n8);
        n7.setRight(n9);

        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        n2.setLeft(n10);
        n2.setRight(n11);

        BinaryTree tree = new BinaryTree(n1);
        return tree;
    }

    /**
     * 测试二叉树的删除，树的结构如下
     *          1
     *    2          3
     * 10   11    4       7
     *          5   6   8   9
     */
    @Test
    public void testDeleteNode() {
        BinaryTree binaryTree = getBinaryTreeForDelete();

        System.out.println("前序遍历：");
        binaryTree.preOrder();

        System.out.println(binaryTree.deleteNode(3));
        System.out.println("删除后：");
        binaryTree.preOrder();
    }

    private BinaryTree getBinaryTree() {
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
        return tree;
    }
}
