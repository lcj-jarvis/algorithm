package com.mrlu.base.algorithm.dp;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-02-17 18:10
 *
 * (0-1)背包问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weights = {1, 4, 3};
        int[] prices = {1500, 3000, 2000};
        int[][] path = put(weights, prices, 4);
        //行的最大下标
        int i = path.length- 1;
        //列的最大下标
        int j = path[0].length- 1;
        //从 path 的最后开始找. 最大价值一定在最后
        while(i > 0 && j > 0 ) {
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j-= weights[i-1];
            }
            i--;
        }
    }

    /**
     * 1、假设商品的重量依次保存在数组weight中，即int[]  weight = {1,4,3}
     * 2、商品的价格依次保存在数组prices中，即int[] prices = {1500, 3500, 2000}
     * 3、商品的个数 int size = weight.lenght
     * 4、背包容量 int bagSize = 4;
     * 5、创建网格（二维数组）int[][] tables = new int[size + 1][bagSize + 1];
     * 说明：这么为什么是size + 1，group + 1？？？
     * 这里我们补充一行和一列，分别表示（1）不存在商品时，背包的最大价值。 （2）背包容量为0时候，最大的价值
     * 6、因为额外添加多了一行和一列，所以设置网格的第一行和第一列为0
     * 7、从第二行和第二列开始遍历，设置网格的每个单元格的。
     *    根据行索引i，获取当前商品的重量w，w等于weight[i-1]，列索引j就是背包容量j。
     *    (1)如果当前商品重量w大于背包容量j，背包容量 j 的最大价值 等于 "背包容量为 j 时，之前装入商品的最大价值"
     *    即 tables[i][j] = tables[i-1][j]
     *    (2)如果当前商品重量w小于背包容量j，背包容量 j 的最大价值 等于 = max { 当前商品的价值 + 剩余容量的最大价值， 背包容量为j时，之前商品的最大价值}
     *    剩余容量 = 背包容量j - 当前商品容量 = j - weight[i-1]
     *    当前商品的价值 + 剩余容量的最大价值 = prices[i-1] + tables[i-1][j - weight[i-1]]
     *    背包容量为 j 时，之前装入商品的最大价值 = tables[i-1][j]
     *    即 tables[i][j]  = max{prices[i-1] + tables[i-1][j - weight[i-1]], tables[i-1][j]}
     *    说明：为什么是i-1呢，因为我们是从1开始遍历的，weight数组和prices数组的索引是从0开始的。
     * 8、遍历tables检查
     * @param weights
     * @param prices
     * @param bagSize
     */
    public static int[][] put(int[] weights, int[] prices, int bagSize) {
        int size = weights.length;
        int[][] tables = new int[size + 1][bagSize + 1];

        //因为额外添加多了一行和一列，所以设置网格的第一行和第一列为0
        // 设置多一行和一列，表示物品数量为0和背包磅数为0时的情况。并进行初始化
        // 设置第一行为0
        for (int j = 0; j < tables[0].length; j++) {
            tables[0][j] = 0;
        }
        // 设置第一列为0
        for (int i = 0; i < tables.length; i++) {
            tables[i][0] = 0;
        }

        // 记录放入商品的情况
        int[][] path = new int[size+1][bagSize+1];

        for (int i = 1; i < tables.length; i++) {
            int[] row = tables[i];
            for (int j = 1; j < row.length; j++) {
                int weight = weights[i - 1];
                if (weight <= j) {
                    // 待放入的物品的重量小于等于当前背包的重量

                    // 背包容量为j时，现在可以装入的最大价值 = 当前商品的价值 + 剩余空间的最大价值
                    // 剩余空间 = 背包容量j - 当前商品的容量 = j - weight[i - 1]
                    int price = prices[i - 1];
                    int current = price + tables[i-1][j- weight];

                    // 背包容量为j时，之前可以装入的物品的最大价值
                    int beforeMax = tables[i - 1][j];

                    int max;
                    if (beforeMax < current) {
                        max = current;

                        // 记录放入当前情况
                        path[i][j] = 1;
                    } else {
                        max = beforeMax;
                    }

                    // 设置背包容量为j时的最大价值
                    tables[i][j] = max;
                } else {
                    // 待放入的物品的重量大于当前背包的重量
                    // 设置”背包容量为j时的最大价值“为”背包容量为j时，之前可以装入的物品的最大价值“
                    int beforeMax = tables[i - 1][j];
                    tables[i][j] = beforeMax;
                }
            }
        }


        // 输出结果
        for (int[] ints : tables) {
            System.out.println(Arrays.toString(ints));
        }

        return path;
    }
}
