package com.mrlu.base.datastruct.stack;

/**
 * @author 简单de快乐
 * @create 2025-01-12 22:17
 */
public class ArrayStack {

    private int[] arr;

    private int top;

    /**
     * 构建栈
     * @param maxSize 栈的深度/长度
     */
    public ArrayStack(int maxSize) {
        arr = new int[maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param element
     */
    public void push(int element) {
        // 1、栈是否满
        if (isFull()) {
            System.out.println("栈已满~");
            return;
        }
        // 2、栈针上移，添加元素到栈针所指的数组位置
        top++;
        arr[top] = element;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        // 1、栈是否为空
        if (isEmpty()) {
            System.out.println("栈已空，返回-1表示为空");
            return -1;
        }
        // 2、获取栈针所指的数组位置的元素。栈针下移。
        int element = arr[top];
        top--;
        return element;
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
        return arr[top];
    }

    /**
     * 判断栈是否满，当top等于maxSize - 1时，栈满
     * @return
     */
    public boolean isFull() {
        return top == arr.length - 1;
    }

    /**
     * 判断栈是否为空，当top等于-1时，栈为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * 栈的遍历
     */
    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

}
