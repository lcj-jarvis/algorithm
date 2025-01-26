package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-01-26 20:35
 */
public class ThreadedBinaryTree {

    /**
     * 根结点
     */
    private ThreadedTreeNode root;

    /**
     * 用于记录前驱节点
     */
    private ThreadedTreeNode prev;

    private static final int traverseType = 1;
    private static final int defaultType = 0;

    public ThreadedBinaryTree(ThreadedTreeNode root) {
        this.root = root;
    }

    /**
     * 前序线性化：
     * 1、如果当前节点为空，直接结束
     * 2、线性化当前节点
     * （1）如果当前节点的left等于null，则设置left为前驱节点prev，leftType设置为一，初始时候prev等于null
     * （2）如果prev不等于null，而且prev的right等于null，则设置prev的right等于当前节点node
     * （3）更新前驱节点prev为当前节点node
     * 3、如果当前节点的leftType等于0，则递归线性化当前节点的左子节点
     * 4、如果当前节点的rightType等于0，则递归线性化当前节点的右子节点
     */
    public void preOrderThreaded() {
        preOrderThreaded(root);
    }

    private void preOrderThreaded(ThreadedTreeNode node) {
        //1、如果当前节点为空，直接结束
        if (node == null) {
            return;
        }

        //2、线性化当前节点
        if (node.getLeft() == null) {
            node.setLeft(prev);
            node.setLeftType(traverseType);
        }
        if (prev != null && prev.getRight() == null) {
            prev.setRight(node);
            prev.setRightType(traverseType);
        }
        // 更新前驱节点
        prev = node;

        //3、如果当前节点的leftType等于0，则递归线性化当前节点的左子节点
        if (node.getLeftType() == defaultType) {
            preOrderThreaded(node.getLeft());
        }
        //4、如果当前节点的rightType等于0，则递归线性化当前节点的右子节点
        if (node.getRightType() == defaultType) {
            preOrderThreaded(node.getRight());
        }
    }

    /**
     * 前序线索化二叉树遍历
     */
    public void preOrderTraverse() {
        ThreadedTreeNode node = this.root;
        while (node != null) {
            // 输出当前节点
            System.out.println(node);
            // 如果当前节点的左子节点的类型为0，则更新当前节点为当前节点的左子节点。反之获取right属性
            if (node.getLeftType() == defaultType) {
                node = node.getLeft();
            }  else {
                node = node.getRight();
            }
        }
    }

    /**
    * 中序线性化：
    * 1、如果当前节点为空，直接结束
    * 2、如果当前节点的左子节点不为空，则递归线性化当前节点的左子节点
    * 3、线性化当前节点
    *（1）如果当前节点的left等于null，则设置left为前驱节点prev，leftType设置为一，初始时候prev等于null
    *（2）如果prev不等于null，而且prev的right等于null，则设置prev的right等于当前节点node
    *（3）更新前驱节点prev为当前节点node
    * 4、如果当前节点的右子节点不为空，则递归线性化当前节点的右子节点
    */
    public void infixOrderThreaded() {
        infixOrderThreaded(root);
    }

    private void infixOrderThreaded(ThreadedTreeNode node) {
        // 1、如果当前节点为空，直接结束
        if (node == null) {
            return;
        }

        // 2、如果当前节点的左子节点不为空，则递归线性化当前节点的左子节点
        infixOrderThreaded(node.getLeft());

        // 3、线性化当前节点
        if (node.getLeft() == null) {
            node.setLeft(prev);
            node.setLeftType(traverseType);
        }
        if (prev != null && prev.getRight() == null) {
            prev.setRight(node);
            prev.setRightType(traverseType);
        }
        // 更新前驱节点
        prev = node;

        // 4、如果当前节点的右子节点不为空，则递归线性化当前节点的右子节点
        infixOrderThreaded(node.getRight());
    }

    /**
     * 中序线索化二叉树遍历
     */
    public void inOrderTraverse() {
        ThreadedTreeNode node = this.root;
        while (node != null) {
            // 找到最左边
            while (node.getLeftType() == defaultType) {
                node = node.getLeft();
            }
            // 输出当前节点
            System.out.println(node);

            // 如果右指针等于后继节点，就一直输出
            while (node.getRightType() == traverseType) {
                // 获取当前节点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            // right等于0，替换后继节点
            node = node.getRight();
        }
    }

    /**
     * 后序线性化：
     * 1、如果当前节点为空，直接结束
     * 2、如果当前节点的左子节点不为空，则递归线性化当前节点的左子节点
     * 3、如果当前节点的右子节点不为空，则递归线性化当前节点的右子节点
     * 4、线性化当前节点
     *   （1）如果当前节点的left等于null，则设置left为前驱节点prev，leftType设置为一，初始时候prev等于null
     *   （2）如果prev不等于null，而且prev的right等于null，则设置prev的right等于当前节点node
     *   （3）更新前驱节点prev为当前节点node
     */
    public void postOrderThreaded() {
        postOrderThreaded(root);
    }

     private void postOrderThreaded(ThreadedTreeNode node) {
         // 1、如果当前节点为空，直接结束
         if (node == null) {
             return;
         }

         postOrderThreaded(node.getLeft());
         postOrderThreaded(node.getRight());
         // 3、线性化当前节点
         if (node.getLeft() == null) {
             node.setLeft(prev);
             node.setLeftType(traverseType);
         }
         if (prev != null && prev.getRight() == null) {
             prev.setRight(node);
             prev.setRightType(traverseType);
         }
         // 更新前驱节点
         prev = node;
     }

    /**
     * 后序线索化二叉树遍历比较复杂，先不实现
     * @link https://www.cnblogs.com/lishanlei/p/10707830.html
     */

}
