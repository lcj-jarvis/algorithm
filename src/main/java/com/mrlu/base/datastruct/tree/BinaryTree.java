package com.mrlu.base.datastruct.tree;

import java.util.Stack;

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

    /**
     * 要求：
     * （1）如果删除的节点是叶子节点，则删除该节点
     * （2）如果删除的节点是非叶子节点，则删除该子树
     *
     * 1、如果树是空树，不允许删除，返回false表示删除失败
     * 2、如果根节点的no等于要删除的no，则把整棵树置空，即root=null，返回true表示删除成功
     * @param no
     * @return
     */
    public boolean simpleDeleteNode(int no) {
        if (root == null) {
            return false;
        }
        if (root.getNo() == no) {
            this.root = null;
            return true;
        }
        return this.root.simpleDeleteNode(no);
    }

    /**
     * 1、如果树是空树，不允许删除，返回false表示删除失败，直接结束
     * 2、如果根节点是要删除的节点，
     *    (1)如果根节点的左子节点不为空，右子节点为空，则把根节点的左子节点设置为新的根节点
     *    (2)如果根节点的右子节点不为空，左子节点为空，则把根节点的右子节点设置为新的根节点
     *    (3)如果根节点的左子节点不为空，根节点的右子节点不为空，
     *        则在根节点的左子节点的右边一直往后找，直到最后，然后把根节点的右子节点挂过去
     *    (4)如果根节点的左子节点的左子节点、右子节点都为空，则设置根节点为空
     *    最后返回true表示删除成功。
     * @param no
     * @return
     */
    public boolean deleteNode(int no) {
        if (root == null) {
            return false;
        }

        if (root.getNo() == no) {
            if (root.getLeft() != null && root.getRight() != null) {
                TreeNode newRoot = root.getLeft();
                TreeNode tempNode = newRoot;
                while (tempNode.getRight() != null) {
                    tempNode = tempNode.getRight();
                }
                tempNode.setRight(root.getRight());
                root = newRoot;
            } else if (root.getLeft() != null) {
                root = root.getLeft();
            } else if (root.getRight() != null){
                root = root.getRight();
            } else {
                root = null;
            }
            return true;
        }
        return this.root.deleteNode(no);
    }

    //====================================================================================
    /**
     * 前序遍历
     */
    public void preOrderUseStack() {
        TreeNode node = this.root;
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node);
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    /**
     * 中序遍历
     *
     */
    public void infixOrderUseStack() {
        TreeNode node = this.root;
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        // Traverse the tree
        while (node != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            // Pop the top node from the stack and visit it
            node = stack.pop();
            System.out.println(node);

            // Now, visit the right subtree of the node
            node = node.getRight();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderUseStack() {
        TreeNode node = this.root;
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        // 记录输出结果
        Stack<TreeNode> output = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            // root right left
            output.push(node);
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        while (!output.isEmpty()) {
            System.out.println(output.pop());
        }
    }

}
