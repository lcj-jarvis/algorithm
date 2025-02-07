package com.mrlu.base.datastruct.tree;

/**
 * @author 简单de快乐
 * @create 2025-02-06 15:28
 *
 * 赫夫曼编码节点
 */
public class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {

    private Byte data;
    private int weight;
    private HuffmanCodeNode left;
    private HuffmanCodeNode right;

    public HuffmanCodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanCodeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanCodeNode left) {
        this.left = left;
    }

    public HuffmanCodeNode getRight() {
        return right;
    }

    public void setRight(HuffmanCodeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(HuffmanCodeNode o) {
        // 从小到大排序
        return this.weight - o.weight;
    }
}
