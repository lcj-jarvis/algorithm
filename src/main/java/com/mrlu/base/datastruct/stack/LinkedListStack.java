package com.mrlu.base.datastruct.stack;

/**
 * @author 简单de快乐
 * @create 2025-01-12 22:40
 */
public class LinkedListStack {

    // 虚拟的头节点（哑节点）
    private Node head;

    public LinkedListStack() {
        this.head = new Node();
    }

    /**
     * 入栈
     * @param element
     */
    public void push(int element) {
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
    }


    /**
     * 出栈。即取出链表的尾部节点
     */
    public int pop() {
        // 1、栈是否为空
        if (isEmpty()) {
            System.out.println("栈已空，返回-1表示为空");
            return -1;
        }
        // 2、找到尾节点
        Node temp = this.head;
        while (temp.next != null) {
            if(temp.next.next == null) {
                break;
            }
            temp = temp.next;
        }
        int no = temp.next.no;
        temp.next = null;
        return no;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("栈已空，返回-1表示为空");
            return -1;
        }
        // 2、获取栈针所指的数组位置的元素。
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.no;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 栈的元素的输出：建立一个临时的反向链表，遍历新的链表
     */
    public void list() {
        // 构建反转后的链表
        Node temp = this.head.next;

        Node reverse = new Node();
        while (temp != null) {
            // 复制节点的数据
            Node node = copy(temp);
            node.next = reverse.next;
            reverse.next = node;
            temp = temp.next;
        }

        temp = reverse.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public Node copy(Node source) {
        return new Node(source.no);
    }


}
