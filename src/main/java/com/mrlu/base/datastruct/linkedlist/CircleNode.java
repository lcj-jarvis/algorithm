package com.mrlu.base.datastruct.linkedlist;

/**
 * @author 简单de快乐
 * @create 2025-01-11 22:45
 */
public class CircleNode {

    public int no;

    public CircleNode next;


    public CircleNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public CircleNode getNext() {
        return next;
    }

    public void setNext(CircleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no + "}";
    }
}
