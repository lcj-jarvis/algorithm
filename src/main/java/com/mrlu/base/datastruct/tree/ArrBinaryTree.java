package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-01-25 16:39
 *
 * 顺序存储二叉树
 */
public class ArrBinaryTree {

    //顺序存储二叉树的数组
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(0);
    }

    /**
     * 前序遍历
     * @param index 数组的索引
     */
    private void preOrder(int index) {
        // （1）输出当前节点
        System.out.println(arr[index]);

        // （2）计算当前节点的左子节点索引，然后递归输出左子节点
        int leftNodeIndex = 2 * index + 1;
        if (leftNodeIndex < arr.length) {
            preOrder(leftNodeIndex);
        }

        // （2）计算当前节点的右子节点索引，然后递归输出右子节点
        int rightNodeIndex = 2 * index + 2;
        if (rightNodeIndex < arr.length) {
            preOrder(rightNodeIndex);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        infixOrder(0);
    }

    /**
     * 中序遍历
     * @param index 数组的索引
     */
    private void infixOrder(int index) {
        // （1）计算当前节点的左子节点索引，然后递归输出左子节点
        int leftNodeIndex = 2 * index + 1;
        if (leftNodeIndex < arr.length) {
            infixOrder(leftNodeIndex);
        }

        // （2）输出当前节点
        System.out.println(arr[index]);

        // （3）计算当前节点的右子节点索引，然后递归输出右子节点
        int rightNodeIndex = 2 * index + 2;
        if (rightNodeIndex < arr.length) {
            infixOrder(rightNodeIndex);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(0);
    }

    /**
     * 后序遍历
     * @param index 数组的索引
     */
    private void postOrder(int index) {
        // （1）计算当前节点的左子节点索引，然后递归输出左子节点
        int leftNodeIndex = 2 * index + 1;
        if (leftNodeIndex < arr.length) {
            postOrder(leftNodeIndex);
        }

        // （2）计算当前节点的右子节点索引，然后递归输出右子节点
        int rightNodeIndex = 2 * index + 2;
        if (rightNodeIndex < arr.length) {
            postOrder(rightNodeIndex);
        }

        // （3）输出当前节点
        System.out.println(arr[index]);
    }


}
