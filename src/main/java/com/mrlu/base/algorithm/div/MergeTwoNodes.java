package com.mrlu.base.algorithm.div;

import com.mrlu.base.datastruct.linkedlist.ListNode;

/**
 * @author 简单de快乐
 * @create 2025-02-17 12:41
 */
public class MergeTwoNodes {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n5 = new ListNode(50);
        n1.next = n3;
        n3.next = n5;

        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n6 = new ListNode(60);
        ListNode n7 = new ListNode(88);
        n2.next = n4;
        n4.next = n6;
        n6.next = n7;

        ListNode merge = merge(n1, n2);
        //System.out.println(merge);

        while (merge != null) {
            System.out.println(merge);
            merge = merge.next;
        }
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        } else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }

}
