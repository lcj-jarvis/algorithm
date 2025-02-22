package com.mrlu.base.algorithm.kruskal;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-02-21 18:29
 *
 * 克鲁斯卡尔算法
 */
public class KruskalAlgorithm {

    //顶点数组
    public char[] vertexs;
    //邻接矩阵
    public int[][] matrix;

    // 边的数量
    public int edgeNums;

    // int最大值表示不连通
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs={'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][]={
            /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
            /*A*/{ 0, 12,INF,INF,INF, 16, 14},
            /*B*/{ 12, 0, 10,INF,INF, 7,INF},
            /*C*/{INF, 10, 0, 3, 5, 6,INF},
            /*D*/{INF,INF, 3, 0, 4,INF,INF},
            /*E*/ { INF, INF, 5, 4, 0, 2, 8},
            /*F*/ { 16, 7, 6,INF, 2, 0, 9},
            /*G*/ { 14, INF, INF, INF, 8, 9, 0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.
        //创建KruskalCase 对象实例
        KruskalAlgorithm kruskalCase = new KruskalAlgorithm(vertexs, matrix);
        Edge[] edges = kruskalCase.kruskal();

        for (Edge edge : edges) {
            int begin = edge.getBegin();
            int end = edge.getEnd();
            System.out.println("<" + kruskalCase.getByIndex(begin) + " - " +  kruskalCase.getByIndex(end) + ">" + " 权值=" + edge.getWeight());
        }
    }

    public KruskalAlgorithm(char[] vertexs, int[][] matrix) {
        this.vertexs = new char[vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (matrix[i][j] != INF) {
                    edgeNums++;
                }
            }
        }
    }

    /**
     * 时间复杂度O(nlogn)，n是边数
     * @return
     */
    public Edge[] kruskal() {
        // 1、获取所有的边
        Edge[] edges = getEdges();
        // 2、所有的边按照权值升序
        Arrays.sort(edges);
        // 3、创建Edge数组，保存最小生成树的所有边，数组大小为图的顶点个数 - 1
        int index = 0;
        Edge[] mst = new Edge[vertexs.length - 1];
        // 4、创建并查集
        UnionSet unionSet = new UnionSet(vertexs.length);

        // 5、遍历所有的边，选择权值最小，且不会在最小生成树中构成回路的边
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            // 获取边的第一个顶点(起点)
            int p1 = edge.getBegin();
            // 获取边的另一个端点
            int p2 = edge.getEnd();

            // 获取p1在“已有的最小生成树的”终点m
            int m = unionSet.find(p1);
            // 获取p2在“已有的最小生成树的”终点n
            int n = unionSet.find(p2);
            if (m != n) {
                // 没有构成回路
                // 加入并查集
                unionSet.union(p1, p2);
                // 保存边到最小生成树mst。
                mst[index++] = edge;
            }
        }
        return mst;
    }

    /**
     * 获取所有的边
     * @return
     */
    public Edge[] getEdges() {
        int index = 0;
        Edge[] edges = new Edge[edgeNums];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != INF) {
                    Edge edge = new Edge(i, j, matrix[i][j]);
                    edges[index++] = edge;
                }
            }
        }
        return edges;
    }

    /**
     * 根据索引获取顶点的内容
     * @param index
     * @return
     */
    public char getByIndex(int index) {
        return vertexs[index];
    }

}
