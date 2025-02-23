package com.mrlu.base.algorithm.knighthood;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-02-24 0:02
 */
public class KnighthoodTest {

    @Test
    public void test() {
        // 8 * 8棋盘
        int n = 8;
        Knighthood knighthood = new Knighthood(n);
        //创建棋盘
        int[][] chessboard = new int[n][n];
        // 第一行
        int row = 1;
        // 第一列
        int column = 1;
        //测试一下耗时
        long start = System.currentTimeMillis();
        knighthood.traversal(chessboard, row- 1, column- 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end- start) + " 毫秒");
        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }
}
