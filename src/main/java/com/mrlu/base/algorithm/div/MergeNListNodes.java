package com.mrlu.base.algorithm.div;

import com.mrlu.base.datastruct.linkedlist.ListNode;

import java.util.ArrayList;

/**
 * @author 简单de快乐
 * @create 2025-02-17 10:26
 *
 * 合并n个有序链表
 */
public class MergeNListNodes {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n1.next = n3;
        n3.next = n5;

        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n6 = new ListNode(88);
        n2.next = n4;
        n4.next = n6;

        //ListNode merge = merge(n1, n2);
        ////System.out.println(merge);
        //
        //while (merge != null) {
        //    System.out.println(merge);
        //    merge = merge.next;
        //}

        ListNode n8 = new ListNode(8);
        ListNode n100 = new ListNode(50);
        ListNode n200 = new ListNode(100);
        ListNode n201 = new ListNode(101);
        n8.next = n100;
        n100.next = n200;
        n200.next = n201;

        ListNode n11 = new ListNode(4);
        ListNode n12 = new ListNode(20);
        ListNode n13 = new ListNode(72);
        ListNode n14 = new ListNode(90);
        ListNode n15 = new ListNode(888);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;

        ArrayList<ListNode> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n8);
        nodes.add(n11);
        ListNode merge = merge(nodes.toArray(new ListNode[0]));

        while (merge != null) {
            System.out.println(merge);
            merge = merge.next;
        }
    }


    public static ListNode merge(ListNode[] nodes) {
        //return merge(nodes, 0);
        return merge(nodes, 0, nodes.length - 1);
    }

    /**
     * 效率低
     * @param nodes
     * @return
     */
    private static ListNode merge(ListNode[] nodes, int index) {
        if (index == nodes.length) {
            return null;
        }
        // 分解
        ListNode l1 = nodes[index];
        ListNode l2 = merge(nodes, index + 1);
        // 合并
        return merge(l1, l2);
    }

    /**
     * 这个分治效率更高
     * @param nodes
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode[] nodes, int left, int right) {
        if (left == right) {
            return nodes[left];
        }
        int mid = (left + right) / 2;
        // 分解
        ListNode l1 = merge(nodes, left, mid);
        ListNode l2 = merge(nodes, mid + 1, right);
        // 合并
        return merge(l1, l2);
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }


        ListNode temp1 = l1;
        ListNode temp2 = l2;


        ListNode current = new ListNode();
        ListNode head = current;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                current.next = temp1;
                current = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                current = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp1 != null) {
            current.next = temp1;
        }

        if (temp2 != null) {
            current.next = temp2;
        }

        return head.next;
    }

}
