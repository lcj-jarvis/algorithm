package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-01-24 22:12
 *
 * 二叉树
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    /**
     * 前序遍历查找
     */
    public TreeNode preOrderSearch(int no) {
        TreeNode result = null;
        if (root != null) {
            result = root.preOrderSearch(no);
        }
        return result;
    }

    /**
     * 中序遍历查找
     */
    public TreeNode infixOrderSearch(int no) {
        TreeNode result = null;
        if (root != null) {
            result = root.infixOrderSearch(no);
        }
        return result;
    }

    /**
     * 后序遍历查找
     */
    public TreeNode postOrderSearch(int no) {
        TreeNode result = null;
        if (root != null) {
            result = root.postOrderSearch(no);
        }
        return result;
    }


}
