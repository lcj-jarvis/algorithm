package com.mrlu.base.algorithm.prim;

/**
 * @author 简单de快乐
 * @create 2025-02-21 13:13
 */
public class MGraph {

    // 顶点个数
    public int size;
    //顶点数组
    public char[] vertexs;
    //邻接矩阵
    public int[][] matrix;

    public MGraph(char[] vertexs, int[][] matrix) {
        this.size = vertexs.length;
        this.vertexs = vertexs;
        this.matrix = matrix;
    }

}
