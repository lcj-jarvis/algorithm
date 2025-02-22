package com.mrlu.base.algorithm.graph;

import com.mrlu.base.algorithm.dijkstra.DijkstraAlgorithm;
import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.dijkstra.DijkstraAlgorithm.INF;

/**
 * @author 简单de快乐
 * @create 2025-02-23 0:04
 */
public class DijkstraAlgorithmTest {

    @Test
    public void test() {
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
}
