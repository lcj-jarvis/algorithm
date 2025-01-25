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

    /**
     * 前序遍历查找
     */
    public TreeNode preOrderSearch(int no) {
        //（1）如果当前节点的no等于查找的no，则返回当前节点，否则，继续往下执行
        System.out.println("前序遍历查找~~~");
        if (this.no == no) {
            return this;
        }

        //（2）如果当前节点的左子树不等于空，则递归左子树进行查找，如果查找的结果不为空，则返回，否则，继续往下执行
        TreeNode result = null;
        if (this.left != null) {
            result = this.left.preOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        //（3）如果当前节点的右子树不等于空，则递归右子树进行查找，如果查找的结果不为空，则返回，否则，返回null
        if (this.right != null) {
            result = this.right.preOrderSearch(no);
        }
        return result;
    }

    /**
     * 中序遍历查找
     */
    public TreeNode infixOrderSearch(int no) {
        //（1）如果当前节点的左子树不等于空，则递归左子树进行查找，如果查找的结果不为空，则返回，否则，继续往下执行
        TreeNode result = null;
        if (this.left != null) {
            result = this.left.infixOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        //（2）如果当前节点的no等于查找的no，则返回当前节点，否则，继续往下执行
        System.out.println("中序遍历查找~~~");
        if (this.no == no) {
            return this;
        }

        //（3）如果当前节点的右子树不等于空，则递归右子树进行查找，如果查找的结果不为空，则返回，否则，返回null
        if (this.right != null) {
            result = this.right.infixOrderSearch(no);
        }
        return result;
    }

    /**
     * 后序遍历查找
     */
    public TreeNode postOrderSearch(int no) {
        //（1）如果当前节点的左子树不等于空，则递归左子树进行查找，如果查找的结果不为空，则返回，否则，继续往下执行
        TreeNode result = null;
        if (this.left != null) {
            result = this.left.postOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        //（2）如果当前节点的右子树不等于空，则递归右子树进行查找，如果查找的结果不为空，则返回，否则，继续往下执行
        if (this.right != null) {
            result = this.right.postOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        System.out.println("后序遍历查找~~~");
        //（3）如果当前节点的no等于查找的no，则返回当前节点，否则，返回null
        if (this.no == no) {
            result = this;
        }
        return result;
    }

}
