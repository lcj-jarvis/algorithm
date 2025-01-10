package com.mrlu.base.datastruct.queue;

/**
 * The type Array queue.
 *
 * @author 简单de快乐
 * @create 2025 -01-10 12:12
 */
public class ArrayQueue {

    /**
     * 队列的最大容量
     */
    private final int maxSize;

    /**
     * 队列头部
     */
    private int front;

    /**
     *  队列尾部
     */
    private int rear;

    /**
     * 队列数组
     */
    private final int[] arr;

    /**
     * Instantiates a new Array queue.
     * 创建容量为maxSize的队列
     * @param maxSize the max size
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        // 指示队列头部（队列刚创建的时候，指向队列头部的前一个位置）
        this.front = -1;
        //指示队列尾部，队列刚创建的时候，初始值为-1
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    /**
     * Add queue.
     * 入队
     * @param element the element
     */
    public void addQueue(int element) {
        // 判断队列是否已满，已满则不允许添加
        if (isFull()) {
            System.out.println("队列已满~");
            return;
        }
        // rear加一
        rear++;
        // 设置元素
        arr[rear] = element;
    }

    /**
     * Is full boolean.
     * 判断队列是否满
     * @return the boolean
     */
    public boolean isFull() {
        // 判断队列是否已满
        return rear == maxSize - 1;
    }

    /**
     * De queue int.
     * 出队
     * @return the int
     */
    public int deQueue() {
        // 判断队列是否为空，为空则提示为空，返回-1表示结束
        if (isEmpty()) {
            System.out.println("队列已空,返回-1表示为空~");
            // 这里返回-1表示为空。
            return -1;
        }

        // front向后移动一位
        front++;
        // 出队
        return arr[front];
    }


    /**
     * 判断队列是否为空
     * @return
     */
    private boolean isEmpty() {
        return front == rear;
    }

    /**
     * Head int.
     * 返回队列的头部元素
     * @return the int
     */
    public int head() {
        // 判断队列是否为空，为空则提示为空，返回-1表示结束
        if (isEmpty()) {
            System.out.println("队列已空,返回-1表示为空~");
            // 这里返回-1表示为空。
            return -1;
        }
        return arr[front + 1];
    }

    /**
     * List.
     *
     * 遍历队列
     */
    public void list() {
        // 判断队列是否为空，为空则提示为空结束
        if (isEmpty()) {
            System.out.println("队列已空~");
            return;
        }
        // （1）定义临时指针temp，初始位置和front位置一样。
        // （2）temp向后移动，读取队列元素，直到移动到rear的位置。
        int temp = front;
        while (temp < rear) {
            // 加加表示向后移动
            temp++;
            int el = arr[temp];
            System.out.printf("[%s]", el);
        }
        System.out.println();
    }


}
