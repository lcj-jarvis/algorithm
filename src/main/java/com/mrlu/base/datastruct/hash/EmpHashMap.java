package com.mrlu.base.datastruct.hash;

/**
 * @author 简单de快乐
 * @create 2025-01-23 21:41
 *
 * 员工哈希表
 */
public class EmpHashMap {

    private EmpLinkedList[] empLinkedListArray;

    // 容量
    private int capacity;

    /**
     * 创建hash表
     * @param capacity 初始容量
     */
    public EmpHashMap(int capacity) {
        // 初始化emp哈希表的数组
        this.capacity = capacity;
        empLinkedListArray = new EmpLinkedList[capacity];
        // 数组每个位置设置EmpLinkedList链表
        for (int i = 0; i < capacity; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 散列函数：计算数组下标
    public int hash(int no) {
        return no % capacity;
    }

    /**
     * 添加emp到链表
     * @param emp
     */
    public void add(Emp emp) {
        // 通过散列函数，获取数组下标
        int index = hash(emp.no);
        // 获取下标对应的链表，通过链表添加
        empLinkedListArray[index].add(emp);
    }

    /**
     * 按no的顺序添加
     * @param emp
     */
    public void addByNo(Emp emp) {
        // 通过散列函数，获取数组下标
        int index = hash(emp.no);
        // 获取下标对应的链表，通过链表添加
        empLinkedListArray[index].addByNo(emp);
    }

    /**
     * 根据no删除元素
     * @param no
     */
    public void delete(int no) {
        // 通过散列函数，获取数组下标
        int index = hash(no);
        // 获取下标对应的链表，通过链表删除
        empLinkedListArray[index].delete(no);
    }


    /**
     * 根据no修改元素
     */
    public void update(Emp emp) {
        // 通过散列函数，获取数组下标
        int index = hash(emp.no);
        // 获取下标对应的链表，通过链表修改
        empLinkedListArray[index].update(emp);
    }

    /**
     * 根据no查找
     */
    public Emp findByNo(int no) {
        // 通过散列函数，获取数组下标
        int index = hash(no);
        // 获取下标对应的链表，通过链表寻找
        return empLinkedListArray[index].findByNo(no);
    }

    /**
     * 返回节点元素个数
     * @return
     */
    public int size() {
        // 每个位置的链表元素个数相加
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            EmpLinkedList empLinkedList = empLinkedListArray[i];
            size += empLinkedList.size();
        }
        return size;
    }

    /**
     * 遍历节点
     */
    public void list() {
        for (int i = 0; i < capacity; i++) {
            EmpLinkedList empLinkedList = empLinkedListArray[i];
            empLinkedList.list(i);
        }
    }


}
