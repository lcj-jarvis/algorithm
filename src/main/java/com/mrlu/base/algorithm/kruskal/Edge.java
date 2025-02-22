package com.mrlu.base.algorithm.kruskal;

/**
 * @author 简单de快乐
 * @create 2025-02-21 18:30
 *
 * 创建边类
 */
public class Edge implements Comparable<Edge>{

    // 存储一条边的起点下标
    private int begin;
    // 存储一条边的终点下标
    private int end;
    // 边的权重
    private int weight;

    public Edge(int begin, int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
