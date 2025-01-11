package com.mrlu.base.datastruct.linkedlist;

/**
 * @author 简单de快乐
 * @create 2025-01-11 21:44
 */
public class DoubleHeroNode {

    public int no;

    public String name;

    public String nickName;

    public DoubleHeroNode next;

    public DoubleHeroNode prev;

    public DoubleHeroNode() {
    }

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + "'}";
    }
}
