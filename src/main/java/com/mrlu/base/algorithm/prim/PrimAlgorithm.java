package com.mrlu.base.algorithm.prim;

import java.util.Arrays;

public class PrimAlgorithm {

    public static void main(String[] args) {
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
        prim(graph, 0);
        // 权值总和是一样的
        //prim(graph, 1);

        prefPrim(graph, 0);
    }

    /**
     * 时间复杂度为O(n ^ 3)
     * @param graph
     * @param v
     */
    public static void prim(MGraph graph, int v) {
        // 创建数组，标记顶点的访问情况
        boolean[] isVisited = new boolean[graph.size];
        // 设置下标为v的顶点已经访问过
        isVisited[v] = true;
        // 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        // n - 1条边
        for (int i = 0; i < graph.size - 1; i++) {
            // 设置为Integer.MAX_VALUE，边的权值为Integer.MAX_VALUE表示不连通
            int minWeight = Integer.MAX_VALUE;

            // 找到权值最小的边
            for (int j = 0; j < graph.vertexs.length; j++) {
                for (int k = 0; k < graph.vertexs.length; k++) {
                    // 寻找已经访问过的顶点和未访问过顶点间的权值最小的边。
                    if (isVisited[j] && !isVisited[k] && graph.matrix[j][k] < minWeight) {
                        minWeight = graph.matrix[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            // 执行到这里说明，找到一条权值最小的边
            System.out.println("边" + graph.vertexs[h1] + "-" + graph.vertexs[h2] + "权值：" + minWeight);
            // 标记找到的顶点为已经访问
            isVisited[h2] = true;
        }
    }


    public static final int INF = Integer.MAX_VALUE;

    /**
     * 优化后的时间复杂度为O(n ^ 2)
     * @param graph
     * @param v
     */
    public static void prefPrim(MGraph graph, int v) {
        //一、准备工作
        //1、创建数组boolean[] isVisited = new boolean[graph.size]，记录顶点的访问情况，isVisited[i] 等于true，说明下标为i的顶点已经访问过
        boolean[] isVisited = new boolean[graph.size];
        //2、创建数组int[] minDist = new int[graph.size]，记录从已访问的顶点出发，找到所有的未访问结点，与未访问结点相连的最小权值的边。即minEst[i]，表示与下标为i的顶点相连的最小权值边的权值
        int[] minDist = new int[graph.size];
        //3、创建数组int[] parent = new int[graph.size]，记录下标为i的顶点的父顶点。
        //结合minEst数组使用，parent[i]表示与“索引为i的顶点”相连的最小权值边的起点下标，或者说“下标为i的顶点”的最小权值边的起点下标为parent[i]，终点下标为i，最小权值为min[i]
        int[] parent = new int[graph.size];
        //4、初始时，设置minDist所有为元素最大权值INF（便于比较）
        Arrays.fill(minDist, INF);
        //5、初始时从当前位置v开始寻找，设置v的父顶点parent[v] = -1，并设置该顶点为已访问，即isVisited[v]=true
        parent[v] = -1;
        isVisited[v]=true;

        //二、获取所有的边
        for (int i = 0; i < graph.size - 1; i++) {
            //1、遍历所有顶点，更新 minDist[]和parent[]，确保每次选取的都是当前生成树外的最小权值边。
            //从当前顶点v开始，找到所有相连的而且还没有访问过的顶点，
            //并记录“与找到的顶点”相连的最小权值边到minDist数组与parent数组
            //（因为一个顶点可能有多条相连的边，选择与该顶点相连的最小的即可）
            // 举例说明：比如M到P有一条权值为5的边，接着N到P有一条权值为1的边，这时需要更新为1，并记录是N到P
            for (int j = 0; j < graph.vertexs.length; j++) {
                // 如果没有访问过，而且找到的边的权值小于最小权值，则更新最小权值的边，记录起点和终点
                if (!isVisited[j] && graph.matrix[v][j] < minDist[j]) {
                    minDist[j] = graph.matrix[v][j];
                    parent[j] = v;
                }
            }

            //2、选择最小权值的边，并更新当前顶点v，并将其标记为已访问。
            int min = INF;
            for (int j = 0; j < minDist.length; j++) {
                if (!isVisited[j] && minDist[j] < min) {
                    min = minDist[j];
                    // 更新当前顶点
                    v = j;
                }
            }
            isVisited[v] = true;

            //3、通过起点parent[v]和终点v，输出最小权值边graph.matrix[parent[v]][v]
            //System.out.println("边<" + graph.vertexs[parent[i]] + " - " + graph.vertexs[i] + "> 权值：" + graph.matrix[parent[i]][i]);
        }

        // 输出mst的边
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                System.out.println("边<" + graph.vertexs[parent[i]] + " - " + graph.vertexs[i] + "> 权值：" + graph.matrix[parent[i]][i]);
            }
        }
    }

}