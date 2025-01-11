package com.mrlu.base.datastruct.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-01-11 21:51
 */
public class DoubleLinkedListTest {

    @Test
    public void testAdd() {
        DoubleLinkedList list = new DoubleLinkedList();
        //先创建节点
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);

        list.list();
    }

    @Test
    public void testAddByNode() {
        DoubleLinkedList list = new DoubleLinkedList();
        //先创建节点
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(3, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(2, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(8, "林冲", "豹子头");
        DoubleHeroNode hero5 = new DoubleHeroNode(6, "林冲01", "豹子头");
        list.addByNode(hero1);
        list.addByNode(hero2);
        list.addByNode(hero3);
        list.addByNode(hero4);
        list.addByNode(hero5);

        list.list();
    }

    @Test
    public void testDelete() {
        DoubleLinkedList list = new DoubleLinkedList();
        //先创建节点
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);

        list.list();
        System.out.println("=====================");
        list.delete(4);
        list.list();

        System.out.println("=====================");
        list.delete(2);
        list.list();

        System.out.println("=====================");
        list.delete(1);
        list.list();

        System.out.println("=====================");
        list.delete(3);
        list.list();
    }


    @Test
    public void testUpdate() {
        DoubleLinkedList list = new DoubleLinkedList();
        //先创建节点
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);

        list.list();
        System.out.println("=====================");
        list.update(new DoubleHeroNode(2, "武松", "玉麒麟"));
        list.update(new DoubleHeroNode(3, "鲁智深", "玉麒麟"));
        list.list();
    }


    @Test
    public void testSize() {
        DoubleLinkedList list = new DoubleLinkedList();
        //先创建节点
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        System.out.println(list.size());
    }
}
