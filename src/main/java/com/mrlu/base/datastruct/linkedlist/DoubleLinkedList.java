package com.mrlu.base.datastruct.linkedlist;

/**
 * The type Double linked list.
 *
 * @author 简单de快乐
 * @create 2025 -01-11 21:45
 */
public class DoubleLinkedList {

    /**
     * The Head.
     */
    public DoubleHeroNode head;

    /**
     * Instantiates a new Double linked list.
     */
    public DoubleLinkedList() {
        this.head = new DoubleHeroNode();
    }

    /**
     * Add.
     * 尾插入
     * @param node the node
     */
    public void add(DoubleHeroNode node) {
        // 1、遍历双向链表，找到尾部，设置到尾部
        DoubleHeroNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 2、设置到尾部：temp.next = node; node.pre = temp
        temp.next = node;
        node.prev = temp;
    }

    /**
     * Add by node.
     * 遍历双向链表，如果temp的下一个节点大于插入的节点，在temp的位置完成插入。
     * @param node the node
     */
    public void addByNode(DoubleHeroNode node) {
        DoubleHeroNode temp = this.head;
        boolean found = false;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                // temp的下一个节点比它大，找到
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
            // 将node的下一个节点指向比它大的节点
            node.next = temp.next;
            // 将node的上一个节点指向temp
            node.prev = temp;
            // 将“比node大的节点”的上一个节点指向node
            temp.next.prev = node;
            // 将temp的下一个节点指向node
            temp.next = node;
        } else {
            // 设置到尾部：temp.next = node; node.pre = temp
            temp.next = node;
            node.prev = temp;
        }
    }

    /**
     * Delete.
     *
     * @param no the no
     */
    public void delete(int no) {
        DoubleHeroNode temp = this.head.next;
        boolean found = false;
        while (temp != null) {
            if (temp.no == no) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
           // 将"temp的上一个节点"的next，指向temp的下一个节点
           temp.prev.next = temp.next;
           // 如果不是为尾部
           if (temp.next != null) {
               // 将"temp的下一个节点"的prev，指向temp的上一个节点
               temp.next.prev = temp.prev;
           }
            temp.prev = null;
            temp.next = null;
        } else {
            System.out.printf("删除的节点no=%s不存在", no);
        }
    }

    /**
     * Update.
     *
     * @param node the node
     */
    public void update(DoubleHeroNode node) {
        DoubleHeroNode temp = this.head.next;
        boolean found = false;
        while (temp != null) {
            if (temp.no == node.no) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found) {
            // 修改相应内容
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("修改的节点no=%s不存在", node.no);
        }
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        int counter = 0;
        DoubleHeroNode temp = this.head;
        while (temp.next != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    /**
     * List.
     */
    public void list() {
        DoubleHeroNode temp = this.head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

}
