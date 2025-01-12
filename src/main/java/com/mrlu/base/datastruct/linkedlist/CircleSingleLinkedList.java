package com.mrlu.base.datastruct.linkedlist;

/**
 * @author 简单de快乐
 * @create 2025-01-11 22:45
 */
public class CircleSingleLinkedList {

    private CircleNode first;

    /**
     * 构建环形队列
     * @param num 需要构建的元素数量
     */
    public CircleSingleLinkedList(int num) {
        if (num < 1) {
            throw new RuntimeException("num必须大于或等于1");
        }
        CircleNode current = null;
        for (int i = 1; i <= num; i++) {
            CircleNode node = new CircleNode(i);
            if (i == 1) {
                //创建第一个节点时，用first指向第一个节点，通过first.next指向自己
                //用current记录当前节点
                first = node;
                first.next = first;
                current = first;
            } else {
                // 创建新的节点node，node.next指向头结点first。
                // 设置current.next = node，然后current往后移动current = node
                current.next = node;
                node.next = first;
                current = node;
            }
        }
    }

    /**
     * 环形链表遍历
     */
    public void list() {
        //从first节点开始，借助临时变量temp遍历，当temp.next等于first的时候，遍历结束.
        if (first == null) {
            System.out.println("环形链表为空~~~");
            return;
        }

        CircleNode temp = this.first;
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != first);
    }

    /**
     * @param k 起始位置，从1开始
     * @param m 数几下出圈
     */
    public void deQueue(int k, int m) {
        // 1、判断k和m是否合法
        if (k < 1 || m < 1) {
            throw new RuntimeException("k或m必须大于或等于1");
        }

        // 2、找到环形链表的最后一个节点last
        CircleNode last = null;
        CircleNode temp = first;
        while (temp.next != null) {
            if (temp.next == first) {
                last = temp;
                break;
            }
            temp = temp.next;
        }

        // 3、last和first移动k-1次，指向新的位置。即移动到first和last的起始位置。让头节点移动到第k个位置，作为开始的位置。
        int move = k - 1;
        for (int i = 0; i < move; i++) {
            first = first.next;
            last = last.next;
        }

        // 4、循环出队。知道first = last才结束。
        // (1)first和last移动m-1次，获取出队元素node
        // (2)元素出队。出队元素node的next作为新的first。last的next指向新的first。
        move = m - 1;
        while (first != last) {
            // (1)first和last移动m-1次，获取出队元素node
            for (int i = 0; i < move; i++) {
                first = first.next;
                last = last.next;
            }
            CircleNode node = first;

            //（2）元素出队，出队元素node的next作为新的first。last的next指向新的first。
            System.out.println(node);
            first = node.next;
            last.next = first;
        }

        //5、输出最后剩下的元素
        System.out.println(first);
    }
}
