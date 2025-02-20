package com.mrlu.base.algorithm.dp;

/**
 * @author 简单de快乐
 * @create 2025-02-19 21:30
 *
 * 求取斐波那契数列的第n项。
 */
public class FibProblem {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    /**
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            // 状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
