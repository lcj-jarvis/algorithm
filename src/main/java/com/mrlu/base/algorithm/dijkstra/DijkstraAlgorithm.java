package com.mrlu.base.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-02-22 20:59
 *
 * 迪杰斯特拉算法
 */
public class DijkstraAlgorithm {

    public static final int INF = Integer.MAX_VALUE;

    public static final int EMPTY = -1;

    public static void main(String[] args) {
        char[] vertexs={'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 邻接矩阵
        int matrix[][]={
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/{ 0, 12,INF,INF,INF, 16, 14},
                /*B*/{ 12, 0, 10,INF,INF, 7,INF},
                /*C*/{INF, 10, 0, 3, 5, 6,INF},
                /*D*/{INF,INF, 3, 0, 4,INF,INF},
                /*E*/ { INF, INF, 5, 4, 0, 2, 8},
                /*F*/ { 16, 7, 6,INF, 2, 0, 9},
                /*G*/ { 14, INF, INF, INF, 8, 9, 0}};

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(vertexs, matrix);
        algorithm.djs(1);
        System.out.println("================================");
        algorithm.djs(2);
        System.out.println("================================");
        algorithm.djs(3);
    }

    //顶点数组
    public char[] vertexs;
    //邻接矩阵
    public int[][] matrix;

    public DijkstraAlgorithm(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
    }

    /**
     * 一、准备工作
     * 1、创建数组isVisited，记录下标为i的顶点是否访问过，数组大小为顶点的个数，默认都没有访问过
     * boolean[] isVisited = new boolean[vertexs.length]
     * 2、创建以下数组dist。 dist[i]表示下标为i顶点到起点v的最短距离，数组大小为顶点的个数
     * int[] dist = new int[vertexs.length]
     * 3、创建前驱节点数组，存储每个节点的前驱节点，用于回溯路径。数组如下：
     * int[] previous = new int[vertexs.length];
     * previous[i]为i的前驱顶点。可以理解为有一条边，边的起点为previous[i]，终点为i。用于回溯路径
     * 二、初始化
     * 1、初始时，设置所有顶点到起点的最短距离为INF=int的最大值。即数组dist所有元素为int的最大值
     * 2、初始时，设置所有顶点的前驱顶点不存在，用-1表示不存在。即数组previous所有元素为-1
     * 3、设置起点的距离为0，即dist[v]=0
     * 三、找到除起点外剩余顶点距离起点的最短路径
     * 除起点外，剩余n-1个顶点到起点的距离需要计算，n为图的顶点个数。即求取除divt[v]外，其他位置的值。
     * 1、找到距离起点的距离最小的顶点作为当前顶点u
     * 2、标记当前顶点为已访问
     * 3、获取与当前顶点u相连的、而且未访问过顶点的。计算出到这些顶点的距离起点的最短路径
     * 假设与当前顶点u相连的顶点为j，而且j没有访问过。
     * 当前j到起点的最短距离distance = j的前一个结点到起点的最短距离（即u到起点的距离） + 边u-j的长度 = dist[u] + 边u-j的长度
     * j到起点已有的最短距离existed = dist[j]
     * 如果计算出来的最短距离distance < 已有最短距离existed，则更新j到起点的最短距离为distance，并记录j的前驱节点为u，即previous[j]=u
     *
     * 四、遍历输出结果
     * 遍历dist数组，如果dist[i]不等于INF，则通过i找到previous[i]，再往前递归回溯，直到找到-1，说明到达起点，最后开始出栈输出结果。
     * @param v
     */
    public void djs(int v) {
        //一、准备工作
        // 记录下标为i的顶点是否访问过
        boolean[] isVisited = new boolean[vertexs.length];
        // dist[i]表示下标为i顶点到起点v的最短距离
        int[] dist = new int[vertexs.length];
        // previous[i]为i的前驱顶点。可以理解为有一条边，边的起点为previous[i]，终点为i。用于回溯路径
        int[] previous = new int[vertexs.length];

        //二、初始化
        // 初始时，设置所有顶点到起点的最短距离为INF
        Arrays.fill(dist, INF);
        // 初始时，设置所有顶点的前驱顶点不存在，用-1表示不存在。
        Arrays.fill(previous, EMPTY);
        // 设置起点的距离为0
        dist[v] = 0;

        //三、找到除起点外剩余顶点距离起点的最短路径
        // 需要找到 n - 1个顶点到起点的最短距离。因为起点的已经设置为0
        for (int i = 0; i < vertexs.length - 1; i++) {
            // 1、找到距离起点距离最小的顶点作为当前顶点
            int u = findMin(dist, isVisited);
            // 2、标记当前顶点已访问
            isVisited[u] = true;

            // 3、获取与当前顶点相连的、而且未访问过顶点的。计算出到这些顶点的距离起点的最短路径
            for (int j = 0; j < vertexs.length; j++) {
                // 不等与INF，说明u与j连通
                boolean connect = matrix[u][j] != INF;
                if (connect) {
                    // 连通才计算

                    // 当前计算的j到起点的最短距离 = j的前一个结点到起点的最短距离（即u到起点的距离） + 边u-j的长度
                    int distance = dist[u] + matrix[u][j];
                    // 已有最短距离
                    int existed = dist[j];
                    // 如果当前顶点j还没有访问过，计算出来的最短距离 < 已有最短距离，则更新j到起点的最短距离
                    if (!isVisited[j]  && distance < existed) {
                        // 更新最短距离
                        dist[j] = distance;
                        // 更新距离最近的前驱顶点
                        previous[j] = u;
                    }
                }
            }
        }

        //四、遍历并回溯输出结果
        // 打印最短路径结果
        System.out.println("Node\tShortest Distance\tPath");
        for (int i = 0; i < vertexs.length; i++) {
            System.out.print(i + "\t\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]) + "\t\t\t\t\t");

            // 如果节点不可达，直接输出 "No Path"
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("No Path");
            } else {
                // 输出路径
                printPath(previous, i);
                System.out.println();
            }
        }
    }

    // 回溯输出路径
    private void printPath(int[] previous, int target) {
        if (target == EMPTY) {
            return; // 没有路径
        }
        printPath(previous, previous[target]); // 递归回溯前驱节点
        //System.out.print(target + " "); // 输出当前节点下标
        System.out.print(vertexs[target] + " "); // 输出当前节点
    }

    /**
     * 找到距离起点距离最小的而且未访问过的顶点作为当前顶点
     * @param dist
     * @param isVisited
     * @return
     */
    private int findMin(int[] dist, boolean[] isVisited) {
        int min = INF;
        int index = 0;
        for (int i = 0; i < dist.length; i++) {
            if (!isVisited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

}
