package com.mrlu.base.datastruct.hash;

/**
 * @author 简单de快乐
 * @create 2025-01-23 21:12
 *
 * 员工链表
 */
public class EmpLinkedList {

    // 有效的头节点，非哑节点，默认为null
    private Emp head;

    /**
     * 添加emp到链表
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = emp;
    }

    /**
     * 按no的顺序添加
     * @param emp
     */
    public void addByNo(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp temp = this.head;
        boolean find = false;
        while (temp.next != null) {
            if (temp.next.no > emp.no) {
                find = true;
                break;
            }
            temp = temp.next;
        }
        if (find) {
            emp.next = temp.next;
        }
        temp.next = emp;
    }

    /**
     * 根据no删除元素
     * @param no
     */
    public void delete(int no) {
        if (head == null) {
            System.out.printf("需要删除的元素no=[%s]不存在~", no);
            System.out.println();
            return;
        }
        if (head.no == no) {
            head = head.next;
            return;
        }

        Emp temp = this.head;
        boolean found = false;
        while (temp.next != null) {
            if (temp.next.no == no) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("需要删除的元素no=[%s]不存在~", no);
            System.out.println();
        }
    }


    /**
     * 根据no修改元素
     */
    public void update(Emp emp) {
        Emp temp = this.head;
        boolean found = false;
        while (temp != null) {
            if (temp.no == emp.no) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
            // 修改
            temp.name = emp.name;
        } else {
            System.out.printf("需要修改的元素[%s]不存在~", emp);
            System.out.println();
        }
    }

    /**
     * 根据no查找
     */
    public Emp findByNo(int no) {
        Emp temp = this.head;
        boolean found = false;
        while (temp != null) {
            if (temp.no == no) {
                // 找到
                found = true;
                break;
            }
            temp = temp.next;
        }
        return found ? temp : null;
    }

    /**
     * 返回元素个数
     * @return
     */
    public int size() {
        int size = 0;
        Emp temp = this.head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 遍历节点
     */
    public void list(int index) {
        if (head == null) {
            System.out.println("index=" + index + "位置的EmpLinkedList为空~");
            return;
        }

        System.out.print("index=" + index + "位置的EmpLinkedList：");
        Emp temp = this.head;
        while (temp != null) {
            // 为了输出效果更好看
            System.out.print(temp);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }


}
