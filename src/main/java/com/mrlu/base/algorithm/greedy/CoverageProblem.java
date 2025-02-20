package com.mrlu.base.algorithm.greedy;

import java.util.*;

/**
 * @author 简单de快乐
 * @create 2025-02-20 18:56
 *
 * 集合覆盖问题
 */
public class CoverageProblem {


    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String,Set<String>> broadcasts = new HashMap<String, Set<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        List<String> select = select(broadcasts);
        select.forEach(System.out::println);
    }


    public static List<String> select(Map<String, Set<String>> borastMap) {
        ArrayList<String> selects = new ArrayList<>();
        // 1、获取所有的区域
        HashSet<String> allAreas = new HashSet<>();
        for (Set areas : borastMap.values()) {
            allAreas.addAll(areas);
        }

        while (allAreas.size() > 0) {
            int maxNum = 0;
            String maxStation = null;
            for (Map.Entry<String, Set<String>> entry : borastMap.entrySet()) {
                String station = entry.getKey();
                Set<String> areas = entry.getValue();

                //计算广播台的覆盖区域cov覆盖了allAreas中的多少个区域
                HashSet<String> cov = new HashSet<>(areas);
                cov.retainAll(allAreas);
                int num = cov.size();
                // 体现了贪心算法，每次选择都是选择最优的
                if (cov.size() > maxNum) {
                    maxNum = num;
                    maxStation = station;
                }
            }

            //移除选中的广播站在allAreas中的覆盖区域。
            if (maxStation != null) {
                selects.add(maxStation);
                allAreas.removeAll(borastMap.get(maxStation));
            }

            //再从剩余的区域，选择广播站
        }
        return selects;
    }

}
