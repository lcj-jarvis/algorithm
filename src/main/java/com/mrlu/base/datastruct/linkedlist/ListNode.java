package com.mrlu.base.datastruct.linkedlist;

/**
 * @author 简单de快乐
 * @create 2025-01-12 20:16
 *
 * 力扣题目
 */
public class ListNode {

      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    /**
     * 删除倒数第n个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //  构建哑节点，便于操作
        ListNode newHead = new ListNode(0, head);

        ListNode first = newHead;
        ListNode second = newHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return newHead.next;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //  构建哑节点，便于操作
        list1 = new ListNode(0, list1);
        list2 = new ListNode(0, list2);
        ListNode temp1 = list1.next;
        ListNode temp2 = list2.next;

        // 创建固定的头节点
        ListNode merge = new ListNode();
        // 创建可移动的当前节点。初始值为固定的头节点
        ListNode current = merge;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
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
        } else if (temp2 != null) {
            current.next = temp2;
        }
        return merge.next;
    }

    /**
     * 两数相加。给定的数字是逆序存在链表中的。
     *  // 342 + 465 = 807。给定链表如下，输出708
     *  // 2 -> 4 -> 3
     *  // 5 -> 6 -> 4
     *
     * // 0 + 0 = 0。给定链表如下，输出0
     * // 0
     * // 0
     *
     * // 9999999  + 9999 = 89990001。给定链表如下，输出89990001
     * // 9 -> 9 -> 9  -> 9 -> 9 -> 9  -> 9
     * // 9 -> 9 -> 9  -> 9
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode resultHead = new ListNode();
        int res = 0;
        while (temp1 != null || temp2 != null) {
            int rt = res;
            if (temp1 != null) {
                rt = rt + temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                rt = rt + temp2.val;
                temp2 = temp2.next;
            }

            // 余数就是相加的结果
            int mod = rt % 10;
            // 计算进位
            res = rt / 10;

            ListNode node = new ListNode(mod);
            ListNode temp = resultHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;

            // 最后一位。
            if (temp1 == null && temp2 ==null && res == 1) {
                node = new ListNode(res);
                temp.next.next = node;
            }
        }
        return resultHead.next;
    }
}
