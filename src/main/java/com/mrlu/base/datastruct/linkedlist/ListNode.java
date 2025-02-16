package com.mrlu.base.datastruct.linkedlist;

/**
 * @author 简单de快乐
 * @create 2025-01-12 20:16
 *
 * 力扣题目
 */
public class ListNode {

      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

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

    public static ListNode reverseList(ListNode head) {
        // 1、构建哑节点（养成习惯）
        head = new ListNode(0, head);
        ListNode temp = head.next;

        // 2、反转的链表
        ListNode newHead = null;
        while (temp != null) {
            // 暂存当前节点的下一个节点
            ListNode next = temp.next;
            // 将当前节点插入新链表
            temp.next = newHead;
            // 更新新链表的头
            newHead = temp;
            // 继续遍历原链表
            temp = next;
        }
        // 返回反转后的链表
        return newHead;
    }

    // 打印链表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 构建原链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原链表:");
        printList(head);

        // 反转链表
        ListNode reversed = reverseList(head);

        System.out.println("反转后的链表:");
        printList(reversed);
    }
}
