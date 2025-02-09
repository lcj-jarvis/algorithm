package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-02-07 22:10
 */
public class AVLNode {

    private int value;

    private AVLNode left;

    private AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
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
     *  （4）必要时进行旋转
     * @param node
     */
    public void add(AVLNode node) {
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

        // 必要时进行旋转
        doRotateIfNecessary();
    }

    /**
     * 必要时进行旋转
     */
    private void doRotateIfNecessary() {
        // 当前结点的右子树高度 - 左子树高度 > 1 ,进行左旋转
        if (this.rightHeight() - this.leftHeight() > 1) {
            //  如果当前结点存在右子树，而且“当前结点的右子树”的“左子树”的高度大于“当前结点的右子树”的"右子树“的高度，
            //  当前结点的右子树需要先进行右旋转，最后再对当前结点进行左旋转
            if (this.right != null &&this.right.leftHeight()  > this.right.rightHeight()) {
                this.right.rightRotate();
            }
            this.leftRotate();

            // 【重点】旋转完后，要直接结束！！！，不能走下面的逻辑
            return;
        }
        // 当前结点的左子树高度 - 右子树高度 > 1 ,进行右旋转
        if (this.leftHeight() - this.rightHeight() > 1) {
            // 如果当前结点存在左子树，而且“当前结点的左子树”的“右子树”的高度大于“当前结点的左子树”的“左子树”的高度
            // 当前结点的左子树需要先进行左旋转，最后再对当前节点进行右旋转
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
            }
            this.rightRotate();
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
    public AVLNode search(int value) {
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
    public AVLNode searchParent(int value) {
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


    /**
     * 计算以当前结点为根节点的树的高度
     * @return
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height() , this.right == null ? 0 : this.right.height()) + 1;
    }

    /**
     * 计算当前结点的左子树的高度
     * @return
     */
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * 计算当前结点的右子树的高度
     * @return
     */
    public int rightHeight() {
        if (this.right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /*****************************************************以下是AVL树特有的********************************************************/
    /**
     * 左旋转
     * 1、根据当前结点current的值，创建一个新的结点node
     * 2、设置新的结点的left为当前结点current的left，即node.left = current.left
     * 3、设置新的结点的right为当前结点current的右子树的左子树，即node.right = current.right.left
     * 4、设置当前结点的value为当前结点的右子树的value，即current.value = current.right.value
     * 5、设置当前结点的left为新的结点node
     * 6、设置当前结点的right为当前结点的右子树的右子树，即current.right = current.right.right
     */
    public void leftRotate() {
        AVLNode node = new AVLNode(this.value);
        node.left = this.left;
        node.right = this.right.left;
        this.value = this.right.value;
        this.left = node;
        this.right = this.right.right;
    }

    /**
     * 右旋转
     * 1、根据当前结点current的值，创建一个新的结点node
     * 2、设置新的结点的right为当前结点current的right，即node.right=current.right
     * 3、设置新的结点的left为当前结点current的左子树的右子树，即node.left=current.left.right
     * 4、设置当前结点的value为当前结点的左子树的value，即current.value=current.left.value
     * 5、设置当前结点的right为新的结点
     * 6、设置当前结点的left为当前结点的左子树的左子树，即current.left = current.left.left
     */
    public void rightRotate() {
        AVLNode node = new AVLNode(this.value);
        node.right = this.right;
        node.left = this.left.right;
        this.value = this.left.value;
        this.right = node;
        this.left = this.left.left;
    }
    /*****************************************************以下是AVL树特有的********************************************************/


}
