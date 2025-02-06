package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-02-06 13:26
 *
 * 赫夫曼结点
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private int value;
    private HuffmanNode left;
    private HuffmanNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public HuffmanNode(int value) {
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 从小到大
        return this.value - o.value;
    }


    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }
}
