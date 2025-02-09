package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-02-07 14:54
 *
 * 二叉排序树结点
 */
public class BSTNode {

    private int value;

    private BSTNode left;

    private BSTNode right;

    public BSTNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "value=" + value +
                '}';
    }

    /**
     *  4、创建将给定的结点node从当前结点的开始添加的add方法
     *  （1）如果node为空，直接结束
     *  （2）如果node结点的value小于当前结点的value，则执行以下逻辑：
     *       如果当前结点的left等于null，则设置node为当前结点的left。反之，使用当前结点的left，并传入node，递归调用添加方法
     *  （3）反之，说明node结点的value大于等于当前结点的value，则执行以下逻辑：
     *       如果当前结点的right等于null，则设置node为当前结点的right。反之，使用当前结点的right，并传入node，递归调用添加方法
     * @param node
     */
    public void add(BSTNode node) {
        if (node == null) {
            return;
        }

        if (node.getValue() < this.getValue()) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 根据value查找某个结点。
     * 具体逻辑：传入需要查找的value，如果当前结点的value等于查找的value，则返回当前结点。
     *        如果查找的value小于当前结点的value，当前结点的left为null，则返回null，否则递归查询当前结点的左子树。
     *        如果查找的value大于等于当前结点的value，当前结点的right为null，则返回null，否则递归查询当前结点的右子树。
     * @param value
     * @return
     */
    public BSTNode search(int value) {
        if (this.value == value) {
            return this;
        }

        if (value < this.value) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(value);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(value);
            }
        }
    }

    /**
    * 根据value查找某个结点的父节点。
    *
    * 传入需要查找的value，如果当前结点的left不等于null，而且left.value等于value
    * 或者当前结点的right不等于null，而且right.value等于value，则返回当前结点
    *
    *  否则，执行以下逻辑
    * （1）如果left不等于null，而且当前结点的value，则递归查询当前结点的左子树
    * （2）如果right不等于null，而且当前结点的value，则递归查询当前结点的右子树
    * （3）剩余的情况，返回null，说明没有找到父节点
    * @param value
    * @return
    */
    public BSTNode searchParent(int value) {
        if (this.left != null && this.left.value == value
            || this.right != null && this.right.value == value) {
            return this;
        } else {
            if (this.left != null && value < this.value) {
                return this.left.searchParent(value);
            } else if (this.right != null && value >= this.value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

}
