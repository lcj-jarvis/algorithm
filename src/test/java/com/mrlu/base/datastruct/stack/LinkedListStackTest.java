package com.mrlu.base.datastruct.stack;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author 简单de快乐
 * @create 2025-01-12 23:10
 */
public class LinkedListStackTest {

    @Test
    public void test() {
        ///测试一下 ArrayStack 是否正确
        //先创建一个 ArrayStack 对象->表示栈
        LinkedListStack stack = new LinkedListStack();
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s: 表示显示栈");
            System.out.println("e: 退出程序");
            System.out.println("i: 表示添加数据到栈(入栈)");
            System.out.println("o: 表示从栈取出数据(出栈)");
            System.out.println("p: 表示查看栈顶元素");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "i":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "o":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "p":
                    int res = stack.peek();
                    System.out.printf("栈顶的数据是 %d\n", res);
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }

    @Test
    public void singleCalculateTest() {
        System.out.println(LinkedListStack.calculateWithInfixExpression("3+5-3*2+1"));
        System.out.println(LinkedListStack.calculateWithInfixExpression("3+2*6-2"));
        System.out.println(LinkedListStack.calculateWithInfixExpression("300+20*6-20"));
        System.out.println(LinkedListStack.calculateWithInfixExpression("3*2*3-3/3+1-2*1"));
    }

}
