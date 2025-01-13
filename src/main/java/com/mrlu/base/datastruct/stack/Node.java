package com.mrlu.base.datastruct.stack;

/**
 * @author 简单de快乐
 * @create 2025-01-12 22:40
 */
public class Node {

    public int no;

    public Node next;

    public Node() {
    }

    public Node(int no) {
        this.no = no;
    }

    public Node(int no, Node next) {
        this.no = no;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
