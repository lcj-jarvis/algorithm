package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-02-07 15:02
 */
public class BinarySortTreeTest {

    @Test
    public void testAdd() {
        int[] array = {7,3,10,12,5,1,9};
        BinarySortTree tree = new BinarySortTree();
        for (int el : array) {
            BSTNode node = new BSTNode(el);
            tree.add(node);
        }
        tree.infixOrder();
    }

    @Test
    public void testSearch() {
        int[] array = {7,3,10,12,5,1,9, 8 , 2, 11, 13};
        BinarySortTree tree = new BinarySortTree();
        for (int el : array) {
            BSTNode node = new BSTNode(el);
            tree.add(node);
        }

        BSTNode node = tree.search(10);
        System.out.println(node);
    }

    @Test
    public void testSearchParent() {
        int[] array = {7,3,10,12,5,1,9, 8, 2, 11, 13};
        BinarySortTree tree = new BinarySortTree();
        for (int el : array) {
            BSTNode node = new BSTNode(el);
            tree.add(node);
        }

        BSTNode node = tree.searchParent(3);
        System.out.println(node);
    }

    @Test
    public void testDelLeaf() {
        int[] array = {7,3,10,12,5,1,9, 8, 2, 11, 13};
        BinarySortTree tree = new BinarySortTree();
        for (int el : array) {
            BSTNode node = new BSTNode(el);
            tree.add(node);
        }
        tree.delNode(2);
        tree.delNode(1);
        tree.delNode(5);
        tree.delNode(8);
        tree.delNode(11);
        tree.delNode(13);
        tree.delNode(9);
        tree.delNode(3);
        tree.delNode(12);
        tree.delNode(10);
        tree.delNode(7);
        tree.infixOrder();
    }

    @Test
    public void testDelSingleLeafNode() {
        int[] array = {7,3,10,12,5,1,9, 8, 2, 11, 13};
        //int[] array = {7,3,10,12,5,4,9, 8, 11, 13};
        BinarySortTree tree = new BinarySortTree();
        for (int el : array) {
            BSTNode node = new BSTNode(el);
            tree.add(node);
        }
        tree.delNode(1);
        tree.delNode(9);
        tree.infixOrder();
    }

    @Test
    public void testDelDoubleNode() {
        int[] array = {7,3,10,12,5,1,9, 8, 2, 11, 13};
        //int[] array = {7,3,10,12,5,4,9, 8, 11, 13};
        BinarySortTree tree = new BinarySortTree();
        for (int el : array) {
            BSTNode node = new BSTNode(el);
            tree.add(node);
        }
        tree.delNode(10);
        tree.delNode(3);
        tree.delNode(12);
        tree.delNode(7);
        tree.delNode(11);
        tree.delNode(5);
        tree.infixOrder();
    }

}
