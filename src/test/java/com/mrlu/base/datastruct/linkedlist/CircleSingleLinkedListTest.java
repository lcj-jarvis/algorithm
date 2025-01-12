package com.mrlu.base.datastruct.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-01-12 14:47
 */
public class CircleSingleLinkedListTest {


    @Test
    public void test() {
        CircleSingleLinkedList list = new CircleSingleLinkedList(5);
        list.list();
        System.out.println("=============================================");
        //list.deQueue(1, 2);

        list.antiClockWiseDeQueue(1, 2);
    }

}
