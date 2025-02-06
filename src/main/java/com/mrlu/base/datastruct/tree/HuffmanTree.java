package com.mrlu.base.datastruct.tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 简单de快乐
 * @create 2025-02-06 13:25
 *
 * 赫夫曼树
 */
public class HuffmanTree {

    private HuffmanNode root;

    public HuffmanTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        if (this.root != null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }

    /**
     * 根据给定的数组创建
     * @param arr
     * @return
     */
    public static HuffmanTree  createHuffmanTree(int[] arr) {
        // 把数组的元素存储到HuffmanNode并保存到List
        ArrayList<HuffmanNode> list = new ArrayList<>();
        for (int el : arr) {
            HuffmanNode node = new HuffmanNode(el);
            list.add(node);
        }

        while(list.size() > 1){
            //（1）把序列每个数据看做一个结点，每个结点都是一棵最简单的二叉树，序列按照权值从小到大排序
            Collections.sort(list);

            //（2）取出权值最小的两个结点，也就是取出根结点权值最小的二叉树。（排序后前两个就是权值最小的结点）
            HuffmanNode leftNode = list.get(0);
            HuffmanNode rightNode = list.get(1);
            list.remove(leftNode);
            list.remove(rightNode);

            //（3）将两个结点的值相加，得到一个新的结点，即新的二叉树的根结点，把最小值的结点设置到新的结点的left，
            //     次小值的结点设置到的结点的right
            HuffmanNode node = new HuffmanNode(leftNode.getValue() + rightNode.getValue());
            node.setLeft(leftNode);
            node.setRight(rightNode);

            //（4）新的节点加入序列
            list.add(node);

            //不断重复（1）~（4）的步骤，直到序列的所有元素都处理完，只剩下一个元素。
        }

        HuffmanNode root = list.get(0);
        return new HuffmanTree(root);
    }

}
