package com.mrlu.base.algorithm.graph;

import com.mrlu.base.algorithm.prim.MGraph;
import org.junit.jupiter.api.Test;

import static com.mrlu.base.algorithm.prim.PrimAlgorithm.*;

/**
 * @author 简单de快乐
 * @create 2025-02-22 13:52
 */
public class PrimAlgorithmTest {

    @Test
    public void test() {
        // 将当前这个顶点标记为已经访问
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        //邻接矩阵的关系使用二维数组表示,Integer.MAX_VALUE这个大数，表示两个点不联通
        int[][] weight=new int[][]{
                {Integer.MAX_VALUE,5,7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,2},
                {5,Integer.MAX_VALUE,Integer.MAX_VALUE,9,Integer.MAX_VALUE,Integer.MAX_VALUE,3},
                {7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,8,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,9,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,8,Integer.MAX_VALUE,Integer.MAX_VALUE,5,4},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,4,5,Integer.MAX_VALUE,6},
                {2,3,Integer.MAX_VALUE,Integer.MAX_VALUE,4,6,Integer.MAX_VALUE},};
        //创建MGraph 对象
        MGraph graph = new MGraph(data, weight);
        //prim(graph, 0);
        prim(graph, 1);
        System.out.println("<==================================>");
        // 权值总和是一样的
        prefPrim(graph, 1);
        System.out.println("<==================================>");
        prefPrimV2(graph, 1);
        System.out.println("<==================================>");
        primUseBFS(graph, 1);
    }
}
