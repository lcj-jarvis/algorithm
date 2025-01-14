package com.mrlu.base.algorithm.recursion;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-14 17:19
 *
 * 假设此时正准备摆放第n个皇后，放第n个皇后时候，从第一列开始放。并和前面已经放过的n-1个皇后比较，
 *  判断是否冲突？
 *    （1）冲突的话，移动到第二列，再次判断，直到找到不冲突的列为止。
 *        如果8列都摆放了，但是还没有找到不冲突的列，
 *        就回退到第n-1个皇后，从当前位置的下一个位置开始摆放，直到找到不冲突的位置，再继续放第n个皇后。
 *        如果第n-1个皇后也没找到合适的列，继续回退到第n-2个皇后，直到往前回退的皇后找到合适的位置，再重新往后放皇后。
 *    （2）不冲突，则开始放下一个皇后，下一个皇后也是从第一列开始，继续上述过程。
 *  一直重复上述过程，直到放满8个皇后。
 *
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.put(0);
        // 92种摆法
        System.out.println(count);
    }

    int max = 8;

    int[] arr;

    static int count = 0;

    public NQueens() {
        arr = new int[8];
    }


    public void put(int n) {
        if (n == max) {
            // 八个皇后都摆好了
            System.out.println(Arrays.toString(arr));
            count++;
            return;
        }

        // 从第一列开始摆放
        for (int i = 0; i < max; i++) {
            // 设置”待摆放的皇后“所在的列
            arr[n] = i;
            // 判断是否和已经摆的皇后冲突。true说明不冲突
            if (isValid(n)) {
                // 不冲突，则继续摆放下一个皇后
                put(n+1);
            }

            // 冲突。移动列继续摆放。
        }
    }

    public boolean isValid(int n) {
        boolean valid = true;
        // 判断是否和已经摆的皇后冲突
        for (int i = 0; i < n; i++) {
            // 获取”已经摆的皇后“的列
            int column = arr[i];
            // （1）判断”已经摆的皇后“的列和”待摆放的皇后“的列是否相等
            // （2）判断”待摆放的皇后“是否与”已经摆的皇后“处在对角线（计算行和列差值的绝对值是否相等即可，因为是n*n的矩阵，差值的相等说明是正方形，连接两点就是处在对角线）
            if (column == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - column)) {
                // 满足条件，说明冲突，”待摆放的皇后“所在的列arr[n]无效，需要向后摆放，再次判断。
                valid = false;
                break;
            }
        }
        return valid;
    }

}
