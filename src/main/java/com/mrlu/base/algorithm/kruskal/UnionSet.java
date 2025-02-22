package com.mrlu.base.algorithm.kruskal;

/**
 * @author 简单de快乐
 * @create 2025-02-22 11:27
 */
public class UnionSet {

    private int[] parent;

    /**
     * 创建并查集
     * @param n
     */
    public UnionSet(int n) {
        parent = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 路径压缩，并返回i的祖先
     * @param i
     * @return
     */
    public int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    /**
     * 合并（选择起点为i，终点为j的边）
     * @param i
     * @param j
     */
    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 != p2) {
            parent[p1] = p2;
        }
    }


}
