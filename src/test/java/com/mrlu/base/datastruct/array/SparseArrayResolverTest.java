package com.mrlu.base.datastruct.array;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author 简单de快乐
 * @create 2025-01-03 15:37
 */
public class SparseArrayResolverTest {

    @Test
    public void test() throws IOException {
        // 创建一个原始的二维数组 8 * 8
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int rowNum = 8;
        int colNum = 8;
        int[][] originalArray = new int[rowNum][colNum];
        originalArray[0][1] = 1;
        originalArray[2][3] = 1;
        originalArray[4][1] = 2;
        originalArray[5][5] = 2;
        originalArray[1][4] = 1;
        originalArray[6][6] = 2;
        originalArray[7][2] = 2;
        SparseArrayResolver resolver = new SparseArrayResolver();

        // 1、获取稀疏数组
        int[][] sparseArray = resolver.resolve(originalArray);
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("==============================");

        // 2、解析并保存稀疏数组
        String fileName = "F:\\code\\algorithm\\src\\test\\java\\com\\mrlu\\base\\datastruct\\array\\sparseArray.txt";
        resolver.resolveAndSave(originalArray, fileName);

        // 3、从指定文件读取稀疏数组还原成原始数组
        originalArray = resolver.restore(fileName);
        for (int[] ints : originalArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("==============================");

        // 4、还原稀疏数组为原始数组
        originalArray = resolver.restore(sparseArray);
        for (int[] ints : originalArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

}
