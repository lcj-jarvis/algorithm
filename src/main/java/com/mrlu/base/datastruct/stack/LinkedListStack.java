package com.mrlu.base.datastruct.stack;

/**
 * @author 简单de快乐
 * @create 2025-01-12 22:40
 */
public class LinkedListStack {

    // 虚拟的头节点（哑节点）
    private Node head;

    public LinkedListStack() {
        this.head = new Node();
    }

    /**
     * 入栈
     * @param element
     */
    public void push(int element) {
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
    }


    /**
     * 出栈。即取出链表的尾部节点
     */
    public int pop() {
        // 1、栈是否为空
        if (isEmpty()) {
            System.out.println("栈已空，返回-1表示为空");
            return -1;
        }
        // 2、找到尾节点
        Node temp = this.head;
        while (temp.next != null) {
            if(temp.next.next == null) {
                break;
            }
            temp = temp.next;
        }
        int no = temp.next.no;
        temp.next = null;
        return no;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("栈已空，返回-1表示为空");
            return -1;
        }
        // 2、获取栈针所指的数组位置的元素。
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.no;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 栈的元素的输出：建立一个临时的反向链表，遍历新的链表。
     * 反转链表方式一
     */
    /*public void list() {
        // 构建反转后的链表
        Node temp = this.head.next;

        Node reverse = new Node();
        while (temp != null) {
            // 复制节点的数据
            Node node = copy(temp);
            node.next = reverse.next;
            reverse.next = node;
            temp = temp.next;
        }

        temp = reverse.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }*/

    /**
     * 栈的元素的输出：建立一个临时的反向链表，遍历新的链表。
     * 反转链表方式二
     */
    public void list() {
        // 构建反转后的链表
        Node temp = this.head.next;

        Node newHead = null;
        while (temp != null) {
            // 先记录temp的下一个位置
            Node next = temp.next;

            // 复制节点的数据
            Node node = copy(temp);
            // 设置node的下一个节点为newHead
            node.next = newHead;
            // 头节点移动
            newHead = node;

            // 后移
            temp = next;
        }

        temp = newHead;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public Node copy(Node source) {
        return new Node(source.no);
    }

    /*******************************************栈的应用******************************************************/
    /**
     * 返回中缀表达式计算的结果（不考虑括号的情况）。
     * 1、将字符串转字符数组，通过index遍历字符
     * 2、如果遍历获取到的字符是一个数字，则从字符数组中算出连续的数字（因为有可能是多位数，也有可能是个位数），放入数栈numStack
     * 3、如果遍历获取到的是一个操作符，分为以下情况
     * 3.1 如果操作符栈为空，则把操作符入栈
     * 3.2 如果操作符栈不为空，获取操作符栈顶的操作符、当前操作符的优先级
     * 3.2.1 如果当前操作符的优先级大于操作符栈顶的操作符的优先级，将当前操作符压入操作符栈
     * 3.2.2 如果当前操作符的优先级小于或等于操作符栈顶的操作符的优先级，则需要从数栈中弹出两个数，以及从操作符栈中弹出一个操作符，进行运算，将运算的结果放入数栈。 如果操作符栈为空，则结束并把当前操作符压入操作符栈。否则继续执行上述过程。
     *
     * 3.1与3.2总结：循环判断是否满足“栈不为空而且当前操作符的优先级而且小于或等于操作符栈顶的操作符的优先级”，
     *         满足的话，则进入循环，执行从数栈中弹出两个数，以及从操作符栈中弹出一个操作符，进行运算，将运算的结果放入数栈。
     *         不满足的话，则不进入循环，把当前操作符压入操作符栈。
     * 4、遍历完成后，从数栈中pop出两个元素，和操作符栈中pop出一个元素，计算出新的结果，再放入数栈，将直到操作符栈为空，在数栈的最后一个元素就是最后的运算结果。
     * @param expression
     * @return
     */
    public static int calculateWithInfixExpression(String expression) {
        char[] arr = expression.toCharArray();
        LinkedListStack numStack = new LinkedListStack();
        LinkedListStack operStack = new LinkedListStack();
        int i = 0;
        while (i < arr.length) {
            char element = arr[i];
            if (isOperator(element)) {
                //if (operStack.isEmpty()) {
                //    //3.1 如果操作符栈为空，则把操作符入栈
                //    operStack.push(element);
                //} else {
                //    //3.2 如果操作符栈不为空，获取操作符栈顶的操作符、当前操作符的优先级
                //    boolean calculate = getPriority(element) <= getPriority((char) operStack.peek());
                //    if (!calculate) {
                //        // 3.2.1 如果当前操作符的优先级大于操作符栈顶的操作符的优先级，将当前操作符压入操作符栈
                //        operStack.push(element);
                //    } else {
                //        //3.2.2 如果当前操作符的优先级小于或等于操作符栈顶的操作符的优先级，
                //        //则需要从数栈中弹出两个数，以及从操作符栈中弹出一个操作符，进行运算，将运算的结果放入数栈。
                //        //如果操作符栈为空，则结束并把当前操作符压入操作符栈。否则继续执行上述过程。
                //        while (calculate) {
                //            int op = operStack.pop();
                //            int first = numStack.pop();
                //            int second = numStack.pop();
                //            int result = calculate(first, second, (char) op);
                //            numStack.push(result);
                //            if (operStack.isEmpty()) {
                //                break;
                //            }
                //            calculate = getPriority(element) <= getPriority((char) operStack.peek());
                //        }
                //        operStack.push(element);
                //    }
                //}

                //3.1与3.2总结：循环判断是否满足“栈不为空而且当前操作符的优先级而且小于或等于操作符栈顶的操作符的优先级”，
                //满足的话，则进入循环，执行从数栈中弹出两个数，以及从操作符栈中弹出一个操作符，进行运算，将运算的结果放入数栈。
                //不满足的话，则不进入循环，把当前操作符压入操作符栈。
                while (!operStack.isEmpty() &&  getPriority(element) <= getPriority((char) operStack.peek())) {
                    int op = operStack.pop();
                    int first = numStack.pop();
                    int second = numStack.pop();
                    int result = calculate(first, second, (char) op);
                    numStack.push(result);
                }
                operStack.push(element);

                // 数组后移
                i++;
            } else {
                // 找到连续的数字。
                StringBuilder builder = new StringBuilder();
                builder.append(element);
                // 开始寻找的位置。
                int j = i + 1;
                for (int n = j; n < arr.length; n++) {
                    char el = arr[n];
                    if (isOperator(el)) {
                        break;
                    }
                    builder.append(el);
                }
                int num = Integer.parseInt(builder.toString());
                numStack.push(num);

                // 更新i的位置
                i = i + builder.length();
            }
        }

        // 计算获取最后的结果
        while (!operStack.isEmpty()) {
            int op = operStack.pop();
            int first = numStack.pop();
            int second = numStack.pop();
            int result = calculate(first, second, (char) op);
            numStack.push(result);
        }
        return numStack.pop();
    }

    private static final char add = '+';
    private static final char sub = '-';
    private static final char mul = '*';
    private static final char div = '/';

    /**
     * 获取两个出栈数的运算结果
     * @param first 先出栈的数
     * @param second 后出栈的数
     * @param op 运算符
     * @return 返回运算结果
     */
    private static int calculate(int first, int second, char op) {
        int rt;
        switch (op) {
            case add:
               rt = first + second;
               break;
            case sub:
                // 注意是second - first。因为second先入栈
                rt = second - first;
                break;
            case mul:
                rt = first * second;
                break;
            case div:
                // 注意是second / first。因为second先入栈
                rt = second / first;
                break;
            default:
                throw new RuntimeException("运算法不合法");
        }
        return rt;
    }

    /**
     *  数字越大，优先级越高
     * @param op
     * @return
     */
    private static int getPriority(char op) {
        if (add == op || sub == op) {
            return 0;
        }
        if (mul == op || div == op) {
            return 1;
        }
        return -1;
    }

    /**
     * 是否是运算符
     * @return
     */
    private static boolean isOperator(char element) {
        return element == '+' || element == '-' || element == '*' || element == '/';
    }
    /*******************************************栈的应用******************************************************/

}
