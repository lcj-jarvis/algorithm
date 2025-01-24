package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-01-24 22:06
 *
 * 二叉树节点
 */
public class TreeNode {

    private int no;

    /**
     * 左子结点
     */
    private TreeNode left;

    /**
     * 右子结点
     */
    private TreeNode right;

    public TreeNode(int no) {
        this.no = no;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        // （1）先输出当前节点
        System.out.println(this);
        // （2）当前节点的左子节点不为空，递归左子节点
        if (this.left != null) {
            this.left.preOrder();
        }
        // （3）当前节点的右子节点不为空，递归右子节点
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        // （1）当前节点的左子节点不为空，递归左子节点
        if (this.left != null) {
            this.left.infixOrder();
        }
        // （2）输出当前节点
        System.out.println(this);
        // （3）当前节点的右子节点不为空，递归右子节点
        if (this.right != null) {
            // 输出右子节点
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        // （1）当前节点的左子节点不为空，递归左子节点
        if (this.left != null) {
            this.left.postOrder();
        }
        // （2）当前节点的右子节点不为空，递归右子节点
        if (this.right != null) {
            // 输出右子节点
            this.right.postOrder();
        }
        // （3）输出当前节点
        System.out.println(this);
    }

}
