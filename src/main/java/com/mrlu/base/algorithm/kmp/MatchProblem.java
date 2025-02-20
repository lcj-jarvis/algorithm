package com.mrlu.base.algorithm.kmp;

/**
 * @author 简单de快乐
 * @create 2025-02-18 21:27
 *
 * KMP算法解决字符串匹配问题
 */
public class MatchProblem {

    public static void main(String[] args) {
        //String str1 = "ABCDEABD";
        //String str2 = "ABD";

        String str1 = "ABCDEABGABEABDFF";
        String str2 = "EA";

        System.out.println(match(str1, str2));
        System.out.println(kmp(str1, str2));
    }

    /**
     * 暴力匹配
     * @param str1 文本串
     * @param str2 模式串
     * @return 返回模式串在文本串的位置。如果不存在，返回-1
     */
    public static int match(String str1, String str2) {
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            char e1 = str1.charAt(i);
            char e2 = str2.charAt(j);
            if (e1 == e2) {
                i++;
                j++;
            } else {
                // 不匹配。进行回溯
                i = i - j + 1;
                j = 0;
            }
        }

        // 匹配成功，返回模式串在文本串的位置
        if (str2.length() == j) {
            return i- j;
        }
        // 返回-1表示不匹配
        return -1;
    }


    public static int kmp(String t, String p) {
        // 最大公共前后缀长度数组
        int[] D = getMaxLengthArray(p);
        int i = 0;
        int j = 0;
        char[] char1 = t.toCharArray();
        char[] char2 = p.toCharArray();
        while (i < t.length()) {
            if (char1[i] == char2[j]) {
                // 匹配成功，i和j右移
                i++;
                j++;
                if (j == p.length()) {
                    // 完全匹配，找到了 i- j 的位置
                    return i - j;
                }
            } else {
                if (j > 0) {
                    // 模式串移动 j - D[j-1] 个位置。
                    j = D[j - 1];
                } else {
                    i++;
                }
            }
        }
        // 返回-1表示没有找到。因为我们的i是不会轻易变动的，当i移动完整个T串，如果还没有找到，说明就是不匹配了
        return -1;
    }

    // 数组D的元素不可能超出模式串的长度的，优化一下写法。
    //public static int kmp(String t, String p) {
    //    // 最大公共前后缀长度数组
    //    int[] D = getMaxLengthArray(p);
    //    int i = 0;
    //    int j = 0;
    //    char[] char1 = t.toCharArray();
    //    char[] char2 = p.toCharArray();
    //    while (i < t.length() && j < p.length()) {
    //        if (char1[i] == char2[j]) {
    //            // 匹配成功，i和j右移
    //            i++;
    //            j++;
    //        } else {
    //            if (j > 0) {
    //                // 模式串移动 j - D[j-1] 个位置。
    //                j = D[j - 1];
    //            } else {
    //                i++;
    //            }
    //        }
    //    }
    //    if (j == p.length()) {
    //        // 完全匹配，找到了 i- j 的位置
    //        return i - j;
    //    }
    //    // 返回-1表示没有找到。因为我们的i是不会轻易变动的，当i移动完整个T串，如果还没有找到，说明就是不匹配了
    //    return -1;
    //}

    /**
     * 求最大公共前后缀长度数组
     * 定义D[i] 表示 P[0] 到 P[i] 区间的最大公共前后缀的长度，即表示 P串的 前 i + 1 个字符的最大公共前后缀的长度
     */
    public static  int[] getMaxLengthArray(String p) {
        int[] D = new int[p.length()];
        D[0] = 0;
        int i = 1;
        int j = 0;
        char[] P = p.toCharArray();
        while (i < p.length()) {
            if (P[i] == P[j]) {
                // 设置最长公共前缀。i向右移动
                D[i] = ++j;
                i++;
            } else {
                if (j > 0) {
                    // P2向右移动，j的位置变动
                    j = D[j - 1];
                } else {
                    // 设置最长公共前缀长度为0。i向右移动。因为int数组默认为0，所以设置D[i] = 0 这步通常被省略掉
                    D[i] = 0;
                    i++;
                }
            }
        }
        return D;
    }


}
