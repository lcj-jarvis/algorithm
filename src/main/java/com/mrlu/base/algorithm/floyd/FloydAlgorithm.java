package com.mrlu.base.algorithm.floyd;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-02-23 19:07
 */
public class FloydAlgorithm {

    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        // 这里不用int最大值，因为后面的加起来会超出范围
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        //创建 Graph 对象
        FloydAlgorithm floydAlgorithm = new FloydAlgorithm(vertex, matrix);

        // 计算最短路径
        floydAlgorithm.floyd();

        // 查看以A为起点的所有结果
        floydAlgorithm.show(0);
        //  查看所有顶点到各个顶点的最短路径
        //floydAlgorithm.showAll();
    }

    // 顶点数组
    private char[] vertexs;

    // 最短距离矩阵
    private int[][] dist;

    // 前驱顶点矩阵
    private int[][] previous;

    public FloydAlgorithm(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;

        this.dist = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                dist[i][j] = matrix[i][j];
            }
        }
        this.previous = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < previous.length; i++) {
            Arrays.fill(previous[i], i);
        }
    }

    /**
     * 弗洛伊德算法
     * 时间复杂度O(n^3)
     */
    public void floyd() {
        int n = dist.length;
        // 从中间点开始遍历
        for (int k = 0; k < n; k++) {
            // 从i顶点开始
            for (int i = 0; i < n; i++) {
                // 到达j顶点
                for (int j = 0; j < n; j++) {
                    // 求出从i顶点出发，经过k中间顶点，到达j顶点距离
                    // 计算并比较，是否更新最短距离.
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        previous[i][j] = previous[k][j];
                    }
                }
            }
        }
    }

    /**
     * 查看下标为index的顶点到各个顶点的最短路径
     */
    public void show(int index) {
        for (int i = 0; i < previous[index].length; i++) {
            System.out.println(vertexs[index] + "->" + vertexs[i] + "的最短路径等于" + dist[index][i] + "，路径如下：");
            // 回溯输出路径
            show(previous[index], i);
            System.out.println();
            System.out.println("============================");
        }
    }

    /**
     * 查看所有顶点到各个顶点的最短路径
     */
    public void showAll() {
        for (int i = 0; i < dist.length; i++) {
            show(i);
        }
    }

    /**
     * 从终点开始回溯输出结果
     * @param index 终点下标
     */
    public void show(int[] previousArr, int index) {
        int previous = previousArr[index];
        if (previous != index) {
            // 往前回溯
            show(previousArr, previous);
        }
        System.out.print(vertexs[index] + "->");
    }

}
