package com.mrlu.base.algorithm.dp;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-02-20 13:02
 *
 * 最长回文子串
 */
public class LongestPalindromeProblem {


    public static void main(String[] args) {
        //String s = "abcabcbb";
        //System.out.println(solve(s));

        //System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        //1、定义dp[][]。 dp[i][j] 表示 索引i到j的位置的子串，是否是回文子串，true说明是，false不是
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 2、初始化。i == j ，说明是单个字符串，当个字符属于回文子串。进行初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        // 3、状态转移方程。
        //  (1) 当s[i] != s[j]，不会是回文子串， dp[i][j] = false
        // （2） 当s[i] == s[j] ，如果 i 和 j，之间没有字符，或者有一个字符，则都是回文子串。即 j - i < 3 , dp[i][j] = true
        //  (3) 当s[i] == s[j]，如果i和j之间的字符数超过1，看 i+1 ~ j-1 位置的串是不是回文子串，如果是，说明i~j位置的子串是回文子串
        //      即dp[i][j] = dp[i+1][j-1]

        // 定义最长回文子串长度为1
        int maxLength = 1;
        // 定义最长回文子串起始位置
        int start = 0;

        // 4、填表
        //由于dp[i][j] 参考的是它左下角的值。填的时候，是一列列填的。 即先固定列，然后行变化，完成每列的填写，列再加一。
        //具体操作：初始时候列索引j=1不变，然后行索引i，从0的位置遍历到j的位置，实现了列不变行变动，再利用状态方程完成填写。
        //        直到i到达j的位置后，说明列填写完毕，j++，移动到下一列。
        char[] charArr = s.toCharArray();
        // j从第二位为到最后一位，表示子串的右边界
        for (int j = 1; j < dp.length; j++) {
            // i从第一位到倒数第二位，表示子串的左边界，而且还要求i<j
            for (int i = 0; i < j; i++) {
                if (charArr[i] != charArr[j]) {
                    dp[i][j] = false;
                } else {
                    // 边界条件：i和j之间，有一个字符，没有字符都说明是回文子串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // i      j
                        // a......a
                        // char[i]==char[j]，看 i+1 ~ j-1 位置的串是不是回文子串，如果是，说明i~j位置的子串是回文子串
                        dp[i][j]  = dp[i+1][j-1];
                    }

                    // 计算最大回文长度
                    if (dp[i][j]) {
                          if ((j - i + 1) > maxLength) {
                              maxLength = j - i + 1;
                              start = i;
                          }
                    }
                }
            }
        }

        for (boolean[] rt : dp) {
            System.out.println(Arrays.toString(rt));
        }
        return s.substring(start, start + maxLength);
    }


    //public static String solve(String s) {
    //    //1、定义dp[][]。 dp[i][j] 表示 索引i到j的位置的子串，是否是无重复子串
    //    boolean[][] dp = new boolean[s.length()][s.length()];
    //
    //    // 2、初始化。i == j ，说明是单个字符串，当个字符属于无重复子串。进行初始化
    //    for (int i = 0; i < dp.length; i++) {
    //        dp[i][i] = true;
    //    }
    //
    //    // 3、状态转移方程。
    //    // （1）s[i] == s[j] , 说明是重复子串，dp[i][j] = false
    //    // （2）s[i] != s[j] , 如果 i+1的位置到j-1的位置是重复子串，则说明是重复子串，即dp[i+1][j-1] == false，则 dp[i][j]=false
    //    //       如果 i+1的位置到j-1的位置是无重复子串，看s[i] 字符有没有在i+1的位置到j-1的位置的无重复子串出现过，即 i 到 j-1的位置的串是不是无重复子串，
    //    //       如果不是，说明不是无重复子串，即 dp[i][j-1] == false，则 dp[i][j]=false
    //    //       如果是，则看s[j]有没有在i+1的位置到j-1的位置的无重复子串出现过，即 i+1到j的位置的串是不是无重复子串，
    //    //       如果不是，说明不是无重复子串，即 dp[i+1][j] == false，则 dp[i][j]=false
    //    //       如果是，说明是无重复子串，则 dp[i+1][j] == true，则 dp[i][j] = true
    //
    //
    //    int maxLength = 0;
    //    int start = 0;
    //    for (int j = 1; j < dp.length; j++) {
    //        for (int i = 0; i < j; i++) {
    //            if (s.charAt(i) == s.charAt(j)) {
    //                dp[i][j] = false;
    //            } else {
    //                if (j - i == 1) {
    //                    dp[i][j] = true;
    //                } else {
    //                    boolean isValid = dp[i + 1][j - 1];
    //                    if (!isValid) {
    //                        // i+1的位置到j-1的位置不是无重复子串，说明 i~j的串也不是无重复子串
    //                        dp[i][j] = false;
    //                    } else {
    //                        // i+1的位置到j-1的位置是无重复子串,看s[i] 字符有没有在i+1的位置到j-1的位置的无重复子串出现过
    //                        isValid = dp[i][j - 1];
    //                        if (isValid) {
    //                            // s[i] 字符不在i+1的位置到j-1的位置的无重复子串出现过，i 到 j-1的位置的串是无重复子串
    //
    //                            // 看s[j]有没有在i+1的位置到j-1的位置的无重复子串出现过，即 i+1到j的位置的串是不是无重复子串
    //                            isValid = dp[i + 1][j];
    //                            if (isValid) {
    //                                dp[i][j] = true;
    //
    //                                // 大于最大长度，更新最大长度
    //                                if (j - i + 1 > maxLength) {
    //                                    maxLength = j - i + 1;
    //                                    start = i;
    //                                }
    //
    //                            } else {
    //                                dp[i][j] = false;
    //                            }
    //                        }  else {
    //                            // s[i] 字符在i+1的位置到j-1的位置的无重复子串出现过，i 到 j-1的位置的串不是无重复子串
    //                            dp[i][j] = false;
    //                        }
    //                    }
    //                }
    //            }
    //        }
    //    }
    //
    //    for (boolean[] rt : dp) {
    //        System.out.println(Arrays.toString(rt));
    //    }
    //
    //    return s.substring(start, start + maxLength);
    //}

}
