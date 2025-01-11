package com.mrlu.base.datastruct.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-01-10 19:29
 */
public class SingleLinkedListTest {

    @Test
    public void testAdd() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }

    @Test
    public void testAddByNo() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero2);
        //singleLinkedList.addByNo(hero2);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.list();
    }


    @Test
    public void testUpdate() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
        System.out.println("修改后~~~~~~~~~~~~~~~~~~~");
        singleLinkedList.update(new HeroNode(2, "小卢", "小麒麟"));
        singleLinkedList.update(new HeroNode(3, "小吴用", "小智多星"));
        singleLinkedList.list();
        singleLinkedList.update(new HeroNode(5, "鲁智深", "花和尚"));
    }

    @Test
    public void testDelete() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
        System.out.println("删除后~~~~~~~~~~~~~~~~~~~");
        singleLinkedList.delete(2);
        singleLinkedList.list();
        System.out.println("删除后~~~~~~~~~~~~~~~~~~~");
        singleLinkedList.delete(3);
        singleLinkedList.list();
        System.out.println("删除后~~~~~~~~~~~~~~~~~~~");
        singleLinkedList.delete(1);
        singleLinkedList.list();
        System.out.println("删除后~~~~~~~~~~~~~~~~~~~");
        singleLinkedList.delete(4);
        singleLinkedList.list();
        singleLinkedList.delete(5);
    }

    /**********************************************单链表常见面试题**************************************************/
    @Test
    public void testSize() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        System.out.println("size：" + singleLinkedList.size());
    }


    @Test
    public void testGetLastIndexNode() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        int k = 4;
        System.out.printf("倒数第%s个=%s", k, singleLinkedList.getLastIndexNode(k));
    }

    @Test
    public void testReverse() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.reverse();
        singleLinkedList.list();
    }

    @Test
    public void testPrintFromTailToHead() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
        System.out.println("=================================================");
        singleLinkedList.printFromTailToHead();
        System.out.println("=================================================");
        singleLinkedList.list();
    }

    @Test
    public void testMergeSortedList() {
        SingleLinkedList list1 = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(4, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(6, "林冲", "豹子头");
        list1.add(hero1);
        list1.add(hero2);
        list1.add(hero3);
        list1.add(hero4);

        SingleLinkedList list2 = new SingleLinkedList();
        //先创建节点
        HeroNode hero5 = new HeroNode(2, "宋江01", "及时雨");
        HeroNode hero6 = new HeroNode(5, "卢俊义01", "玉麒麟");
        HeroNode hero7 = new HeroNode(7, "吴用01", "智多星");
        list2.add(hero5);
        list2.add(hero6);
        list2.add(hero7);

        SingleLinkedList sortedList = SingleLinkedList.mergeSortedList(list1, list2);
        sortedList.list();
    }

    @Test
    public void testMerge() {
        SingleLinkedList list1 = new SingleLinkedList();
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        list1.add(hero1);
        list1.add(hero2);
        list1.add(hero3);
        list1.add(hero4);


        SingleLinkedList list2 = new SingleLinkedList();
        //先创建节点
        HeroNode hero5 = new HeroNode(2, "宋江01", "及时雨");
        HeroNode hero6 = new HeroNode(7, "卢俊义01", "玉麒麟");
        HeroNode hero7 = new HeroNode(6, "吴用01", "智多星");
        list2.add(hero5);
        list2.add(hero6);
        list2.add(hero7);
        SingleLinkedList merge = SingleLinkedList.merge(list1, list2);
        merge.list();
    }
    /**********************************************单链表常见面试题**************************************************/

}
