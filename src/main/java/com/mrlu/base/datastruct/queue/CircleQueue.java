package com.mrlu.base.datastruct.queue;

/**
 * @author 简单de快乐
 * @create 2025-01-10 13:37
 *
 * 环形队列实现
 */
public class CircleQueue {

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

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
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
        // 添加元素
        arr[rear] = element;
        // 更新rear的位置
        rear = (rear + 1) % maxSize;
    }

    /**
     * Is full boolean.
     * 判断队列是否满
     * @return the boolean
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        // 获取头部元素。
        int element = arr[front];
        // 更新front位置
        front = (front + 1) % maxSize;
        return element;
    }


    /**
     * 判断队列是否为空
     * @return
     */
    private boolean isEmpty() {
        return rear == front;
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
        // 返回头部元素。【注意】无需更新front
        int element = arr[front];
        return element;
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
        // (1) 创建临时指针temp，temp初始位置等于front。front ∈ [0, maxSize - 1]
        // (2) 获取temp处的元素。更新temp。temp = (temp + 1) % maxSize.
        // (3) 遍历循环执行步骤(2)，元素个数就是循环次数。
        int temp = front;
        int size = size();
        for (int i = 0; i < size; i++) {
            int el = arr[temp];
            System.out.printf("arr[%s]=[%s]", temp, el);
            temp = (temp + 1) % maxSize;
        }
        System.out.println();
    }

    /**
     * 获取队列元素个数
     * @return
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }


}
