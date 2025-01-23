package com.mrlu.base.datastruct.hash;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author 简单de快乐
 * @create 2025-01-23 21:55
 */
public class EmpHashMapTest {

    @Test
    public void test() {
        //创建哈希表
        EmpHashMap hashMap = new EmpHashMap(8);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("a: 添加雇员");
            System.out.println("abyno: 顺序添加");
            System.out.println("l: 显示雇员");
            System.out.println("f: 查找雇员");
            System.out.println("d: 删除雇员");
            System.out.println("u: 修改雇员");
            System.out.println("s: 获取总数");
            System.out.println("e: 退出系统");
            System.out.println("请输入选项：");
            key = scanner.next();
            switch (key) {
                case "a":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashMap.add(emp);
                    break;
                case "abyno":
                    System.out.println("输入 id");
                    int no = scanner.nextInt();
                    System.out.println("输入名字");
                    String temp = scanner.next();
                    //创建 雇员
                    hashMap.addByNo(new Emp(no, temp));
                    break;
                case "u":
                    System.out.println("输入 id");
                    int no1 = scanner.nextInt();
                    System.out.println("输入名字");
                    String temp1 = scanner.next();
                    //修改 雇员
                    hashMap.update(new Emp(no1, temp1));
                    break;
                case "l":
                    hashMap.list();
                    break;
                case "f":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    System.out.println(hashMap.findByNo(id));
                    break;
                case "d":
                    System.out.println("请输入要删除的 id");
                    id = scanner.nextInt();
                    hashMap.delete(id);
                    break;
                case "s":
                    System.out.println("雇员总数为：");
                    System.out.println(hashMap.size());
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}
