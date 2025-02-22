package com.mrlu.base.datastruct.tree;

import com.mrlu.base.datastruct.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 简单de快乐
 * @create 2025-02-15 10:05
 */
public class SkuTest {

    @Test
    public void testBuildSkus() {
        List<List<Integer>> elementLists = new ArrayList<>();
        //ArrayList<Integer> e1s = new ArrayList<>();
        //e1s.add(1);
        //e1s.add(2);
        //e1s.add(3);
        //elementLists.add(e1s);
        //
        //ArrayList<Integer> e2s = new ArrayList<>();
        //e2s.add(4);
        //e2s.add(5);
        //e2s.add(6);
        //elementLists.add(e2s);
        //
        //ArrayList<Integer> e3s = new ArrayList<>();
        //e3s.add(7);
        //e3s.add(8);
        //elementLists.add(e3s);
        //
        //ArrayList<Integer> e4s = new ArrayList<>();
        //e4s.add(9);
        //e4s.add(10);
        //elementLists.add(e4s);

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
        List<List<Integer>> rt1 = buildFirst(elementLists);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");

        begin = System.currentTimeMillis();
        List<List<Integer>> rt2 = buildSecond(elementLists);
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");

        //rt1.forEach(System.out::println);
        //System.out.println("结果条数：" + rt1.size());

         //rt2.forEach(System.out::println);
         //System.out.println("结果条数：" + rt2.size());
    }

    public List<List<Integer>> buildFirst(List<List<Integer>> elementLists) {
        return build(elementLists, 0);
    }

    /**
     * 排序组合生成sku列表.
     * skuId集合：
     *   [1,2,3]、
     *   [4,5,6]、
     *   [7,8]
     *
     * 思路：类似于n皇后回溯算法.
     *
     * 暴力递归: 时间复杂度O(m ^ n)
     *
     * @param elementLists
     * @param index
     * @return
     */
    public List<List<Integer>> build(List<List<Integer>> elementLists, int index) {
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
     * O(m^2 logn) + n * m
     *
     * m:列表的平均长度
     * n：elementLists的元素个数
     *
     *
     * @param elementLists
     * @return
     */
    public List<List<Integer>> buildSecond(List<List<Integer>> elementLists) {
        return build(elementLists, 0 ,elementLists.size() - 1);
    }

    public List<List<Integer>> build(List<List<Integer>> elementLists, int left, int right) {
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
        // 1
        int mid  = (left + right) / 2;
        List<List<Integer>> l1 = build(elementLists, left, mid);
        List<List<Integer>> l2 = build(elementLists, mid + 1, right);
        return merge(l1, l2);
    }

    // [[1,2,3]]

    // [[1]、[2]、[3]]  [[4]、[5]、[6]] => [[1,4]、[1,5]、[1,6]、[2,4]、[2,5]、[2,6]]
    private List<List<Integer>> merge(List<List<Integer>> l1, List<List<Integer>> l2) {
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
                ArrayList<Integer> items = new ArrayList<>(e1.size() + e2.size()); // 预分配内存
                items.addAll(e1);  // 先添加e1中的元素
                items.addAll(e2);  // 然后添加e2中的元素
                result.add(items);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] a  = new int[3][1];

        int[] s1 = {1,2,3};
        a[0] = s1;

        int[] s2 = {4,5};
        a[1] = s2;

        int[] s3 = {6,7,8,9};
        a[2] = s3;

        //for (int i = 0; i < a.length; i++) {
        //    int[] temp = a[i];
        //    System.out.println(Arrays.toString(temp));
        //}

        int[][] build = build(a, 0);
        for (int i = 0; i < build.length; i++) {
            int[] temp = build[i];
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("结果条数：" + build.length);
    }

    /**
     * 数组版本生成sku列表.
     * @param elementLists
     * @param index
     * @return
     */
    public int[][] build(int[][] elementLists, int index) {
        if (index > elementLists.length - 1) {
            return null;
        }

        // 1、计算组合总数
        int total = 1;
        for (int i = index; i < elementLists.length; i++) {
            total *= elementLists[i].length;
        }
        int[][] result = new int[total][1];

        // 2、计算获取组合结果
        int count = 0;
        int[] elements = elementLists[index];
        for (int element : elements) {
            int[][] lists = build(elementLists, index + 1);
            if (lists != null) {
                for (int[] subArray : lists) {
                    int[] target = new int[subArray.length + 1];
                    target[0] = element;
                    for (int j = 0; j < subArray.length; j++) {
                        target[j + 1] = subArray[j];
                    }
                    result[count] = target;
                    count++;
                }
            } else {
                int[] group = new int[1];
                group[0] = element;

                result[count] = group;
                count++;
            }
        }
        return result;
    }
    //=======================================SKU生成===================================================


    @Test
    public void testMerge() {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n1.next = n3;
        n3.next = n5;

        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n6 = new ListNode(88);
        n2.next = n4;
        n4.next = n6;

        //ListNode merge = merge(n1, n2);
        ////System.out.println(merge);
        //
        //while (merge != null) {
        //    System.out.println(merge);
        //    merge = merge.next;
        //}

        ListNode n8 = new ListNode(8);
        ListNode n100 = new ListNode(50);
        ListNode n200 = new ListNode(100);
        ListNode n201 = new ListNode(101);
        n8.next = n100;
        n100.next = n200;
        n200.next = n201;

        ListNode n11 = new ListNode(4);
        ListNode n12 = new ListNode(20);
        ListNode n13 = new ListNode(72);
        ListNode n14 = new ListNode(90);
        ListNode n15 = new ListNode(888);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;

        ArrayList<ListNode> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n8);
        nodes.add(n11);
        ListNode merge = merge(nodes, 0);

        while (merge != null) {
            System.out.println(merge);
            merge = merge.next;
        }
    }


    /**
     * 合并n个有序列表
     * @param elements
     */
    public static ListNode merge(List<ListNode> elements, int index) {
        if (index  == elements.size()) {
            return null;
        }

        ListNode l1 = elements.get(index);
        ListNode l2 = merge(elements, index + 1);
        return merge(l1,l2);
    }

    /**
     * 合并n个有序列表，数组版本
     * @param elements
     */
    public static ListNode merge(ListNode[] elements, int index) {
        if (index  == elements.length) {
            return null;
        }

        ListNode l1 = elements[index];
        ListNode l2 = merge(elements, index + 1);
        return merge(l1,l2);
    }

    /**
     * 合并n个有序列表，分治
     * @param elements
     */
    public static ListNode merge(ListNode[] elements, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return elements[left];
        }
        int mid = (left + right) / 2;
        return merge(merge(elements, left, mid), merge(elements, mid + 1, right));
    }


    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode current = null;
        ListNode mergeHead = null;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                if (mergeHead == null) {
                    current = temp1;
                    mergeHead = current;
                } else {
                    current.next = temp1;
                    current = temp1;
                }
                temp1 = temp1.next;
            } else {
                if (mergeHead == null) {
                    current = temp2;
                    mergeHead = current;
                } else {
                    current.next = temp2;
                    current = temp2;
                }
                temp2 = temp2.next;
            }
        }


        if (temp1 != null) {
            current.next = temp1;
        }
        if (temp2 != null) {
            current.next = temp2;
        }
        return mergeHead;
    }
}
