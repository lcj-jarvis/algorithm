package com.mrlu.base.algorithm.div;

/**
 * @author 简单de快乐
 * @create 2025-02-17 14:34
 *
 * 汉诺塔
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num,char a,char b,char c) {
        if (num == 1) {
            // 如果只有一个塔
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            // 先把最上面的盘 A -> B
            hanoiTower(num - 1, a, c, b);
            // 把最下面的盘 A -> C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            // 把B塔的所有盘 B -> C
            hanoiTower(num - 1, b, a, c);
        }
    }

}
