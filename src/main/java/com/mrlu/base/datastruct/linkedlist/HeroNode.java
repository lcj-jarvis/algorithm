package com.mrlu.base.datastruct.linkedlist;

/**
 * @author 简单de快乐
 * @create 2025-01-10 17:51
 */
public class HeroNode {

    public int no;

    public String name;

    public String nickName;

    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + "'}";
    }

}
