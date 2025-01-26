package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-01-26 20:34
 */
public class ThreadedTreeNode {

    private int no;

    public ThreadedTreeNode(int no) {
        this.no = no;
    }

    /**
     * 左子结点
     */
    private ThreadedTreeNode left;

    /**
     * 右子结点
     */
    private ThreadedTreeNode right;

    /**
     * leftType = 0 表示left指向该结点的左子结点
     * leftType = 1 表示left指向该结点的前驱
     */
    private int leftType;

    /**
     * rightType = 0 表示right指向该结点的右子节点
     * rightType = 1 表示right指向该结点的后继
     */
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ThreadedTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedTreeNode left) {
        this.left = left;
    }

    public ThreadedTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedTreeNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "ThreadedTreeNode{" +
                "no=" + no +
                '}';
    }
}
