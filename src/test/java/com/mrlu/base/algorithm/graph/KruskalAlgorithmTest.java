package com.mrlu.base.algorithm.graph;

import com.mrlu.base.algorithm.kruskal.Edge;
import com.mrlu.base.algorithm.kruskal.KruskalAlgorithm;
import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.kruskal.KruskalAlgorithm.INF;

/**
 * @author 简单de快乐
 * @create 2025-02-22 11:40
 */
public class KruskalAlgorithmTest {
    @Test
    public void test() {
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
}
