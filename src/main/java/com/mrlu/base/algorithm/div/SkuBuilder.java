package com.mrlu.base.algorithm.div;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author 简单de快乐
 * @create 2025-02-17 10:52
 */
public class SkuBuilder {

    public static void main(String[] args) {
        //testPrint();
        testTime();
    }

    public static void testPrint() {
        List<List<Integer>> elementLists = new ArrayList<>();
        ArrayList<Integer> e1s = new ArrayList<>();
        e1s.add(1);
        e1s.add(2);
        e1s.add(3);
        elementLists.add(e1s);

        ArrayList<Integer> e2s = new ArrayList<>();
        e2s.add(4);
        e2s.add(5);
        e2s.add(6);
        elementLists.add(e2s);

        ArrayList<Integer> e3s = new ArrayList<>();
        e3s.add(7);
        e3s.add(8);
        elementLists.add(e3s);

        ArrayList<Integer> e4s = new ArrayList<>();
        e4s.add(9);
        e4s.add(10);
        elementLists.add(e4s);

        //List<List<Integer>> rt1 = build(elementLists, 0);
        //rt1.forEach(System.out::println);
        //System.out.println("结果条数：" + rt1.size());



        //List<List<Integer>> rt2 = build(elementLists, 0 , elementLists.size() - 1);
        //rt2.forEach(System.out::println);
        //System.out.println("结果条数：" + rt2.size());

        List<List<Integer>> dp = buildWithDP(elementLists);
        dp.forEach(System.out::println);
        System.out.println("结果条数：" + dp.size());
    }

    public static void testTime() {
        List<List<Integer>> elementLists = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> items = new ArrayList<>();
            int size = random.nextInt(10);
            while (size == 0) {
                size = random.nextInt(10);
            }

            for (int j = 0; j < size; j++) {
                int el = random.nextInt(100);
                items.add(el);
            }
            //System.out.println(items);
            elementLists.add(items);
        }

        long begin = System.currentTimeMillis();
        //List<List<Integer>> rt1 = build(elementLists, 0);
        long end = System.currentTimeMillis();
        //System.out.println("耗时：" + (end - begin) + "ms");

        begin = System.currentTimeMillis();
        List<List<Integer>> rt2 = build(elementLists, 0, elementLists.size() - 1);
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");

        begin = System.currentTimeMillis();
        List<List<Integer>> dp = buildWithDP(elementLists);
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
    }


    /**
     * 排序组合生成sku列表.
     * skuId集合：
     *   [1,2,3]、
     *   [4,5,6]、
     *   [7,8]
     *
     * 暴力递归: 时间复杂度O(m ^ n)
     *
     * 假设elementLists中每个子列表平均有m个元素，则对于最底层（第n层），它只返回单个元素组成的列表，共有m种可能性。
     * 倒数第二层则返回由两元素组成的列表，共有m^2种可能性。
     * 依此类推，直到顶层，总共有m^n种组合。所以，整个算法的时间复杂度大致为O(m^n)
     * 这里m代表每个子列表中元素的平均数量，n代表子列表的数量。
     *
     * @param elementLists
     * @param index
     * @return
     */
    public static List<List<Integer>> build(List<List<Integer>> elementLists, int index) {
        if (index > elementLists.size() - 1) {
            return null;
        }
        // 分解
        List<Integer> elements = elementLists.get(index);
        List<List<Integer>> lists = build(elementLists, index + 1);

        // 合并
        List<List<Integer>> result = new ArrayList<>();
        for (Integer element : elements) {
            if (lists != null) {
                for (List<Integer> subItems : lists) {
                    ArrayList<Integer> items = new ArrayList<>(subItems.size() + 1);
                    items.add(element);
                    items.addAll(subItems);
                    result.add(items);
                }
            } else {
                ArrayList<Integer> group = new ArrayList<>();
                group.add(element);
                result.add(group);
            }
        }
        return result;
    }


    /**
     * 分治算法生成sku列表.
     *
     * skuId集合：
     *   [1,2,3]、
     *   [4,5,6]、
     *   [7,8]、
     *   [9,10]
     *
     * 分：
     *  [[1,2,3],[4,5,6],[7,8],[9,10]]
     *
     *  [[1,2,3],[4,5,6]] 、[[7,8],[9,10]]
     *
     *  [[1,2,3]]、[[4,5,6]]、[[7,8]、[[9,10]]
     *
     *  [[1],[2],[3]]、 [[4],[5],[6]]; [[7],[8]]、[[9],[10]]
     *
     *  合并：
     *  [[1,4],[1,5],[1,6]],[2,4],[2,5],[2,6],[3,4],[3,5],[3,6]]   [[7,9],[7,10],[8,9],[8,10]]
     *  [ [1,4,7,9],[1,4,7,10],[1,4,8,9],[1,4,8,10],
     *    [1,5,7,9],[1,5,7,10],[1,5,8,9],[1,5,8,10],
     *    ...
     *  [3,6,7,9],[3,6,7,10],[3,6,8,9],[3,6,8,10] ]
     *
     *
     *  设 elementLists 的大小为n，每个子列表的平均大小为m
     *  只有一层：合并的时间复杂度O(m * m) = O(m^2)
     *  两层： 合并的时间复杂度O(上层合并的大小 * 上层合并的大小) = O(m ^2 * m ^ 2) = O((m ^ 2) ^ 2)
     *  三层： 合并的时间复杂度O(上层合并的大小 * 上层合并的大小) = O((m ^ 2) ^ 2  * (m ^ 2) ^ 2) = O((m ^ 2) ^ 4)
     *  ...
     *
     *  因为elementLists的大小为n，所以递归深度为log2n，以2为底数。即总层数为：log2n，以2为底数
     *  所以时间复杂度为：O((m ^ 2) ^ log2n) = O(m ^ n)
     *
     *  时间复杂度 = O(m ^ n)。其中n是 elementLists的大小，m是每个子列表的平均大小
     *  空间复杂度 = O(m ^ n)。其中n是 elementLists的大小，m是每个子列表的平均大小
     *
     * 这种算法的时间复杂度非常高，尤其是当 elementLists 的大小较大时。
     * 可以考虑使用动态规划或其他优化策略来减少重复计算
     * @param elementLists
     * @param left
     * @param right
     * @return
     */
    public static List<List<Integer>> build(List<List<Integer>> elementLists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            List<Integer> els = elementLists.get(left);
            List<List<Integer>> result = new ArrayList<>();
            for (Integer el : els) {
                LinkedList<Integer> arrList = new LinkedList<>();
                arrList.add(el);
                result.add(arrList);
            }
            return result;
        }
        // 分解
        int mid = (left + right) / 2;
        List<List<Integer>> l1 = build(elementLists, left, mid);
        List<List<Integer>> l2 = build(elementLists, mid + 1, right);
        // 合并
        return merge(l1 , l2);
    }

    private static List<List<Integer>> merge(List<List<Integer>> l1, List<List<Integer>> l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> e1 : l1) {
            for (List<Integer> e2 : l2) {
                // 预分配内存
                ArrayList<Integer> items = new ArrayList<>(e1.size() + e2.size());
                // 先添加e1中的元素
                items.addAll(e1);
                // 然后添加e2中的元素
                items.addAll(e2);
                result.add(items);
            }
        }
        return result;
    }


    //===========================================================================================
    // 暴力解决
    public static List<List<Integer>> buildWithDP(List<List<Integer>> elementLists) {
        if (elementLists == null || elementLists.isEmpty()) {
            return new ArrayList<>();
        }

        // dp[i] 表示前 i 个子列表的所有组合
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>()); // 初始状态：空组合

        // 遍历每个子列表
        for (List<Integer> elements : elementLists) {
            List<List<Integer>> newDp = new ArrayList<>();

            // 遍历当前 dp 中的每个组合
            for (List<Integer> combination : dp) {
                // 将当前子列表中的每个元素添加到组合中
                for (Integer element : elements) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(element);
                    newDp.add(newCombination);
                }
            }

            // 更新 dp
            dp = newDp;
        }

        return dp;
    }



}
