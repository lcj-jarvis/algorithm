package com.mrlu.base.datastruct.linkedlist;

import java.util.Stack;

/**
 * @author 简单de快乐
 * @create 2025-01-10 17:52
 *
 * 单向链表
 */
public class SingleLinkedList {

    public HeroNode head;

    public SingleLinkedList() {
        this.head = new HeroNode();
    }

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByNo(HeroNode node) {
        HeroNode temp = head;
        boolean found = false;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                found = true;
                break;
            } else if (temp.next.no == node.no) {
                throw new RuntimeException("no：" + node.no + "已经存在~~~");
            }
            temp = temp.next;
        }

        if (found) {
            node.next = temp.next;
        }
        //(1) 情况一：找到比node大的
        //(2) 情况二：到达了尾部。
        // 不管有没有找到，这行代码都是要的
        temp.next = node;
    }

    public void update(HeroNode node) {
        HeroNode temp = head;
        boolean found = false;
        while (temp.next != null) {
            if (temp.no == node.no) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("修改的节点%s不存在", node.no);
        }
    }

    public void delete(int no) {
        HeroNode temp = head;
        boolean found = false;
        while (temp.next != null) {
            if (temp.next.no == no) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
            //将被删除节点的用临时变量deleted保存起来
            HeroNode deleted = temp.next;
            //将temp的next指向下一个节点的下一个节点
            temp.next = deleted.next;
            //将被删除节点deleted的下一个节点设置为空
            deleted.next = null;
        } else {
            System.out.printf("删除的节点%s不存在", no);
        }
    }

    public void list() {
        HeroNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

   /**********************************************单链表常见面试题**************************************************/
   //（1）求单链表中节点的个数(如果是带头结点的链表，则不统计头节点)
   public int size() {
       // 思路；定义计数器，从头到尾遍历，每循环一次，计数器加一。
       HeroNode temp = this.head;
       int size = 0;
       while (temp.next != null) {
           size++;
           temp = temp.next;
       }
       return size;
   }

   //（2）查找单链表中的倒数第k个结点【新浪面试题】
   public HeroNode getLastIndexNode(int k) {
       // 思路：查找倒数第k个节点，就是查找从头到尾的第(size - k + 1)个节点
       int size = size();
       int target = size - k + 1;
       if (k < 0 || size - k < 0) {
           return null;
       }

       boolean found = false;
       HeroNode temp = this.head;
       int counter = 0;
       while (temp.next != null) {
           counter++;
           if (counter == target) {
               found = true;
               break;
           }
           temp = temp.next;
       }

       if (found) {
           return temp.next;
       } else {
           return null;
       }
   }

   //（3）单链表的反转【腾讯面试题】
   public void reverse() {
       // 注意这里是this.head.next。
       HeroNode temp = this.head.next;
       if (temp.next == null) {
           // 队列只有一个节点，无需反转。
           return;
       }

       // 构建一个反转后的链表。
       HeroNode reverseHead = new HeroNode();
       while (temp != null) {
           // 获取遍历的节点。
           HeroNode node = temp;
           // 先移动temp
           temp = temp.next;

           // 添加遍历的节点到反转后的链表。
           // （1）将遍历节点的next设置为反转后的链表的第一个节点(除头节点外)。
           node.next = reverseHead.next;
           // （2）设置遍历的节点为反转后的链表的第一个节点(除头节点外)。
           reverseHead.next = node;
       }
       // 将原来的链表头节点，指向反转后的链表。
       this.head.next = reverseHead.next;
   }

    private HeroNode buildReverseLinkedList(HeroNode temp) {
        // 构建一个反转后的链表。
        HeroNode reverseHead = new HeroNode();
        while (temp != null) {
            // 获取遍历的节点。
            // 构建新的节点（简单的copy）
            HeroNode node = buildNode(temp);

            // 先移动temp
            temp = temp.next;

            // 添加遍历的节点到反转后的链表。
            // （1）将遍历节点的next设置为反转后的链表的第一个节点(除头节点外)。
            node.next = reverseHead.next;
            // （2）设置遍历的节点为反转后的链表的第一个节点(除头节点外)。
            reverseHead.next = node;
        }
        return reverseHead;
    }

    private static HeroNode buildNode(HeroNode temp) {
        HeroNode node = new HeroNode();
        node.no = temp.no;
        node.name = temp.name;
        node.nickName = temp.nickName;
        return node;
    }

    //（4）从尾到头打印单链表
   public void printFromTailToHead() {
       // 方式一：构建反转后的链表，不影响原来的链表。
       //HeroNode heroNode = buildReverseLinkedList(this.head.next);
       // 遍历
       //HeroNode temp = heroNode;
       //while (temp.next != null) {
       //    System.out.println(temp.next);
       //    temp = temp.next;
       //}

       // 方式二：入栈。利用栈的后入先出
       HeroNode temp = this.head;
       Stack<HeroNode> stack = new Stack<>();
       while (temp.next != null) {
           stack.push(temp.next);
           temp = temp.next;
       }
       // 出栈
       while (!stack.isEmpty()) {
           System.out.println(stack.pop());
       }
   }
   //（5）合并两个有序的单链表，合并之后的链表依然有序
   // 方式一：合并无序链表或有序链表都可以
   public static SingleLinkedList merge(SingleLinkedList l1, SingleLinkedList l2) {
       SingleLinkedList singleLinkedList = new SingleLinkedList();
       HeroNode head = new HeroNode();
       singleLinkedList.head = head;
       HeroNode temp1 = l1.head.next;
       HeroNode temp2 = l2.head.next;
       // 1、遍历根据序号插入
       while (temp1 != null || temp2 != null) {
           if (temp1 != null) {
               // addByNo添加的节点是不能带有next属性的。copy一份
               addByNo(head, buildNode(temp1));
               temp1 = temp1.next;
           }
           if (temp2 != null) {
               // addByNo添加的节点是不能带有next属性的。copy一份
               addByNo(head, buildNode(temp2));
               temp2 =  temp2.next;
           }
       }
       return singleLinkedList;
   }


    private static void addByNo(HeroNode head, HeroNode target) {
        if (head.next == null) {
            head.next = target;
            return;
        }
        HeroNode temp = head.next;
        boolean found = false;
        while (temp.next != null) {
            if (temp.next.no > target.no) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
            target.next = temp.next;
        }
        temp.next = target;
    }

    //（5）合并两个有序的单链表，合并之后的链表依然有序
    // 方式二：
   //public static SingleLinkedList merge(SingleLinkedList first, SingleLinkedList second) {
   //    SingleLinkedList linkedList = new SingleLinkedList();
   //    // 选择second链表作为遍历的链表，合并到first链表中。
   //    HeroNode secondTemp = second.head.next;
   //    // mark的含义：链表中比secondTemp节点大的节点的前一个位置。
   //    HeroNode mark = first.head;
   //    while (secondTemp != null) {
   //        // 记录下个位置
   //        HeroNode node = secondTemp.next;
   //
   //        // 从标记位置开始判断
   //        HeroNode temp = mark;
   //        boolean found = false;
   //        while (temp.next != null) {
   //            if (temp.next.no > secondTemp.no) {
   //                found = true;
   //                break;
   //            }
   //            temp = temp.next;
   //        }
   //        if (found) {
   //            // 说明找到了，调整位置
   //            secondTemp.next = temp.next;
   //            temp.next = secondTemp;
   //
   //            // 因为是有序列表。secondTemp后面的节点都比它大，所以将secondTemp设置到新的列表后，标记为mark并从该位置开始找即可。
   //            mark = secondTemp;
   //        } else {
   //            // 没有找到比它大的。直接添加到尾部。
   //            temp.next = secondTemp;
   //        }
   //
   //        // 移动到下个位置
   //        secondTemp = node;
   //    }
   //
   //    linkedList.head = first.head;
   //    return linkedList;
   //}

    //（5）合并两个有序的单链表，合并之后的链表依然有序
    // 方式三
    public static SingleLinkedList mergeSortedList(SingleLinkedList l1, SingleLinkedList l2) {
        // 创建一个新的链表来存储合并后的结果。
        SingleLinkedList mergedList = new SingleLinkedList();
        // 使用虚拟头节点来简化合并过程。
        HeroNode mergedHead = mergedList.head;

        // 用两个指针分别遍历两个链表。
        HeroNode temp1 = l1.head.next;
        HeroNode temp2 = l2.head.next;

        // 遍历两个链表并按顺序合并节点。
        while (temp1 != null && temp2 != null) {
            // 比较哪个节点小，设置小的节点到头节点的next
            if (temp1.no <= temp2.no) {
                // 设置头节点的next为firstTemp
                mergedHead.next = temp1;
                temp1 = temp1.next;
            } else {
                // 设置头节点的next为secondTemp
                mergedHead.next = temp2;
                temp2 = temp2.next;
            }
            // 虚拟头节点向后移动
            mergedHead = mergedHead.next;
        }

        // 如果其中一个链表还有剩余节点，直接添加到合并链表的末尾。
        if (temp1 != null) {
            mergedHead.next = temp1;
        } else if (temp2 != null) {
            mergedHead.next = temp2;
        }

        return mergedList;
    }
    /**********************************************单链表常见面试题**************************************************/

}
