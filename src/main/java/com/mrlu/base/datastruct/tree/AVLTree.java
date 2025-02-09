package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-02-07 22:23
 */
public class AVLTree {


    /**
     * 根结点
     */
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    /**
     *  2、创建添加方法，方法参数为Node node
     *     （1）如果二叉排序树的root属性为空，则设置node为root，结束添加
     *     （2）反之，通过root调用add方法，传入node
     * @param node
     */
    public void add(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历方法
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

    /**
     * 根据value查询某个结点
     * @param value
     * @return
     */
    public AVLNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 根据value查询某个结点的父结点
     * @param value
     * @return
     */
    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 根据value删除结点
     * @param value
     */
    public void delNode(int value) {
        //第一步：找到删除的结点targetNode。如果删除的结点不存在，则直接结束。
        AVLNode targetNode = search(value);
        if (targetNode == null) {
            return;
        }

        //第二步：targetNode存在，如果二叉排序树的根节点的left和right都等于null
        //说明二叉排序树只有一个结点，而且是删除该结点，置空二叉排序树的根结点，直接结束
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }

        //第三步: 获取删除结点targetNode的父结点parent
        AVLNode parent = searchParent(value);
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {
            //删除叶子结点。即targetNode的left和right都等于null。
            if (parent.getLeft() != null && targetNode.getValue() == parent.getLeft().getValue()) {
                //1、如果parent的左结点不为空，而且删除的结点targetNode是parent的左结点，则设置parent.left等于null
                parent.setLeft(null);
            } else {
                //2、如果删除的结点targetNode是parent的右结点，则设置parent.right等于null
                parent.setRight(null);
            }
        } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            //方案一：
            //1、从targetNode的右子树开始寻找，找到最小的结点min。
            //即从右子树的左边一直找，找到最左边的结点，就是最小的结点min
            //2、删除min结点，返回min结点的value
            //3、设置targetNode的value的为min结点的value，就可以完成删除。
            int min = delMinNode(targetNode.getRight());
            targetNode.setValue(min);

            //方案二：
            //1、从targetNode的左子树开始寻找，找到最大的结点max。
            //即从左子树的右边一直找，找到最右边的结点，就是最大的结点max
            //2、删除max结点，返回max结点的value
            //3、设置targetNode的value的为max结点的value，就可以完成删除。
            //int max = delMaxNode(targetNode.getLeft());
            //targetNode.setValue(max);
        } else {
            //情况二：删除只有一棵子树的结点。（除了情况一和情况三外，就是情况二了）
            // 1、如果删除的结点targetNode只有left结点
            //    如果parent不是空，说明不是删除的根节点，则执行一下逻辑
            //     （1）如果删除的结点targetNode是parent的左结点，则设置parent.left等于targetNode.left
            //      (2) 如果删除的结点targetNode是parent的右结点，则设置parent.right等于targetNode.left
            //    parent为空，说明删除的是根节点，则设置root等于targetNode.left
            // 2、如果删除的结点targetNode只有right结点
            //    如果parent不是空，说明不是删除的根节点，则执行一下逻辑
            //   （1）如果删除的结点targetNode是parent的左结点，则设置parent.left等于targetNode.right
            //   （2）如果删除的结点targetNode是parent的右结点，则设置parent.right等于targetNode.right
            //    parent为空，说明删除的是根节点，则设置root等于targetNode.right
            if (targetNode.getLeft() != null) {
                if (parent != null) {
                    if (parent.getLeft() != null && targetNode.getValue() == parent.getLeft().getValue()) {
                        // targetNode是左结点
                        parent.setLeft(targetNode.getLeft());
                    } else {
                        // targetNode是右结点
                        parent.setRight(targetNode.getLeft());
                    }
                }  else {
                    root = targetNode.getLeft();
                }
            } else {
                if (parent != null) {
                    if (parent.getLeft() != null && targetNode.getValue() == parent.getLeft().getValue()) {
                        // targetNode是左结点
                        parent.setLeft(targetNode.getRight());
                    } else {
                        // targetNode是右结点
                        parent.setRight(targetNode.getRight());
                    }
                } else {
                    root = targetNode.getRight();
                }
            }
        }
    }

    /**
     * 找到以node为根结点的子树的最小结点，删除并返回它的value
     * @param node 以node为根结点
     * @return
     */
    private int delMinNode(AVLNode node) {
        AVLNode min = node;
        // 在node左边一直找
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        int value = min.getValue();
        delNode(value);
        return value;
    }

    /**
     * 找到以node为根结点的子树的最大结点，删除并返回它的value
     * @param node 以node为根结点
     * @return
     */
    private int delMaxNode(AVLNode node) {
        AVLNode max = node;
        // 在node左边一直找
        while (max.getRight() != null) {
            max = max.getRight();
        }
        int value = max.getValue();
        delNode(value);
        return value;
    }
    
}
