package com.mrlu.base.algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 简单de快乐
 * @create 2025-02-19 23:19
 *
 * 最长回文子序列
 */
public class LCSProblem {

    public static void main(String[] args) {
        String s1 = "ABCDBAB";
        //String s2 = "BDWA";
        String s2 = "BDCABC";
        System.out.println(lcs(s1, s2));

        //printSeq(buildDp(s1, s2), s1, s2);

        // 获取所有结果
        Set<String> list = getAll(buildDp(s1, s2), s1, s2);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static int lcs(String s1, String s2) {
        int[][] dp = buildDp(s1, s2);

        // 打印一下，看看结果
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("=============================");
        return dp[s1.length()][s2.length()];
    }

    /**
     * 构建dp表格
     * @param s1
     * @param s2
     * @return
     */
    private static int[][] buildDp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();

        // 定义dp[i][j]表示s1的前i个字符和s2的前j个字符的最长公共子序列
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1chars[i - 1] == s2chars[j - 1]) {
                    //如果s1的末尾字母s1[i-1]等于s2的末尾字母[j-1]，只需考虑s1的前i-1个字母和s2的前j-1个字母，
                    //如果知道它们的最长公共子序列，那么s1和s2的最长公共子序列 = s1的前i-1个字母和s2的前j-1个字母最长公共子序列 + 1。
                    dp[i][j] = dp[i-1][j-1] + 1;
                }  else {
                    // 要么舍弃 s1的最后一个字符，要么舍弃s2的最后一个字符。舍弃后，谁的公共子序列长度最大，就舍弃谁。
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    /**
     * 输出单个回文子串的结果
     * @param dp
     * @param s1
     * @param s2
     */
    public static void printSeq(int[][] dp,
                                String s1,
                                String s2) {
        int i = s1.length();
        int j = s2.length();
        StringBuilder builder = new StringBuilder();
        // 回溯
        while (i > 0 && j > 0) {
            // 最大长度肯定是在最后的位置。但是最后位置的值是怎么来的呢？？
            // 可能来自左边，上边，也可能是左上角
            // 如果 s1.charAt[i] 等于 s2.charAt[j], 说明是来自左上角，s1.charAt[i]属于子序列，则拼接，i--，j--
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                builder.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                // 不相等，如果上边的值大，则i--。如果左边的值大，则j--。这里我们把等于的情况，也归到j--
                if (dp[i][j-1] < dp[i-1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        // builder 反转后就是最长公共子序列
        System.out.println(builder.reverse());
    }

    /**
     * 获取所有可能的回文子串结果。因为不止一个
     * @param dp
     * @param s1
     * @param s2
     * @return
     */
    public static Set<String> getAll(int[][] dp,
                                     String s1,
                                     String s2) {
        Set<String> rt = getAll(dp, s1, s2, s1.length(), s2.length(), new StringBuilder());
        return rt.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toSet());
    }

    // 获取所有可能的结果。因为不止一个
    public static Set<String> getAll(int[][] dp,
                                     String s1,
                                     String s2,
                                     int m,
                                     int n,
                                     StringBuilder source) {
        int i = m;
        int j = n;
        StringBuilder builder = new StringBuilder(source);
        HashSet<String> rt = new HashSet<>();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                builder.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                // 不相等，如果上边的值大，则i--。如果左边的值大，则j--。
                // 关键的地方，相等的情况要分开了，因为有可能有不同的序列。
                if (dp[i][j-1] < dp[i-1][j]) {
                    i--;
                } else if (dp[i][j-1] > dp[i-1][j]) {
                    j--;
                } else {
                    // 相等的情况。
                    // (1) 获取往上走的所有结果
                    Set<String> r1 = getAll(dp, s1, s2, i - 1, j, builder);
                    rt.addAll(r1);
                    // (2) 获取往左走的所有结果
                    Set<String> r2 = getAll(dp, s1, s2, i, j - 1, builder);
                    rt.addAll(r2);
                    return rt;
                }
            }
        }
        rt.add(builder.toString());
        return rt;
    }
}
