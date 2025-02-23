package com.mrlu.base.algorithm.graph;

import com.mrlu.base.algorithm.floyd.FloydAlgorithm;
import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-02-23 21:25
 */
public class FloydAlgorithmTest {

    @Test
    public void test() {
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
}
