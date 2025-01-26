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

    public int getNo() {
        return no;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
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


    /**
    *  3、因为二叉树是单向的，所以我们是要判断当前节点的子节点是否为需要删除的节点，而不是判断当前节点是否为需要删除的节点
    *  4、如果当前节点的左子节点不为空，而且是要删除的节点，则设置当前节点的左子节点为空，返回true表示删除成功，否则继续往下执行
    *  5、如果当前节点的右子节点不为空，而且是要删除的节点，则设置当前节点的右子节点为空，返回true表示删除成功，否则继续往下执行
    *  6、如果当前节点的左子节点不为空，则进行递归删除。如果删除成功，直接结束，否则继续往下执行
    *  7、如果当前节点的右子节点不为空，则进行递归删除
    */
    public boolean simpleDeleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return true;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return true;
        }

        boolean success = false;
        if (this.left != null) {
            success = this.left.simpleDeleteNode(no);
        }
        if (!success && this.right != null) {
            success = this.right.simpleDeleteNode(no);
        }
        return success;
    }


    /**
     * 3、如果当前节点的左子节点不为空，而且当前节点的左子节点是要删除的节点，则进行以下操作
     * （1）如果当前节点的左子节点的左子节点不为空，右子节点为空，设置当前节点的左子节点的左子节点为当前节点的左子节点
     * （2）如果当前节点的左子节点的右子节点不为空，左子节点为空，设置当前节点的左子节点的右子节点为当前节点的左子节点
     * （3）如果当前节点的左子节点的左子节点、右子节点都不为空，设置当前节点的左子节点的左子节点为当前节点的左子节点，
     * 然后把当前节点的左子节点的右子节点挂到新的当前节点的左子节点的最右边。
     * （4）如果当前节点的左子节点的左子节点、右子节点都为空，则设置当前节点的左子节点为空
     * 最后返回true表示删除成功。
     *
     * 4、如果当前节点的右子节点不为空，而且当前节点的右子节点是要删除的节点，则进行以下操作
     * （1）如果当前节点的右子节点的左子节点不为空，右子节点为空，设置当前节点的右子节点的左子节点为当前节点的右子节点
     * （2）如果当前节点的右子节点的右子节点不为空，左子节点为空，设置当前节点的右子节点的右子节点为当前节点的右子节点
     * （3）如果当前节点的右子节点的左子节点、右子节点都不为空，设置当前节点的右子节点的左子节点为当前节点的右子节点，
     * 然后把当前节点的左子节点的右子节点挂到新的当前节点的左子节点的最右边的根部。
     * （4）如果当前节点的左子节点的左子节点、右子节点都为空，则设置当前节点的右子节点为空
     * 最后返回true表示删除成功。
     *
     * 5、如果当前节点的左子节点不为空，则进行递归删除。如果删除成功，直接结束，否则继续往下执行
     * 6、如果当前节点的右子节点不为空，则进行递归删除
     * @param no
     * @return
     */
    public boolean deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.left != null && this.left.right != null) {
                TreeNode newLeft = this.left.left;
                TreeNode temp = newLeft;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = this.left.right;

                this.left = newLeft;
            }  else if (this.left.left != null) {
               this.left = this.left.left;
            }  else if (this.left.right != null) {
                this.left = this.left.right;
            }  else {
                this.left = null;
            }
            return true;
        }

        if (this.right != null && this.right.no == no) {
            if (this.right.left != null && this.right.right != null) {
                TreeNode newLeft = this.right.left;
                TreeNode temp = newLeft;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = this.right.right;

                this.right = newLeft;
            }  else if (this.right.left != null) {
                this.right = this.right.left;
            }  else if (this.right.right != null) {
                this.right = this.right.right;
            }  else {
                this.right = null;
            }
            return true;
        }

        boolean success = false;
        if (this.left != null) {
            success = this.left.deleteNode(no);
        }
        if (!success && this.right != null) {
            success = this.right.deleteNode(no);
        }
        return success;
    }

}
