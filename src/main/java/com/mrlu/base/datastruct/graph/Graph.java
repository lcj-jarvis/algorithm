package com.mrlu.base.datastruct.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 简单de快乐
 * @create 2025-02-13 22:41
 */
public class Graph {

    private List<String> vertexes;

    private int[][] edges;

    private int numOfEdges;

    /**
     * 根据结点个数初始化图
     * @param n
     */
    public Graph(int n) {
        edges = new int[n][n];
        vertexes = new ArrayList<>();
        numOfEdges = 0;
        isVisited = new Boolean[n];
    }

    /**
     * 添加顶点
     * @param element
     */
    public void insertVertex(String element) {
        vertexes.add(element);
    }

    /**
     * （3）创建方法添加边
     *     方法参数如下：
     *     顶点索引v1：表示顶点的索引。如第一个顶点的索引为0，第二个顶点的索引为1
     *     顶点索引v2：表示另一个顶点的索引。
     *     权重值weight：表示是否直接相连。1表示直接相连，0表示不能。
     *     方法逻辑：
     *     设置索引为v1的顶点和索引为v2的顶点相连，即arr[v1][v2] = 1, arr[v2][v1] = 1，如果是相连的，边界计数器加一。
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        if (weight != 0) {
            numOfEdges++;
        }
    }

    /**
     * 返回图的顶点个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexes.size();
    }

    /**
     * 获取索引为index的顶点
     */
    public String getVertexByIndex(int index) {
        return vertexes.get(index);
    }

    /**
     * 输出图
     */
    public void printGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 获取边的数目
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回索引为v1的顶点和索引为v2的顶点的权重
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    /**
     * 记录结点是否被访问过
     */
    private Boolean[] isVisited;

    //=============================DFS================================
    /**
     * 输出执行过程
     */
    public void DFSDebug() {
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
        // 为什么要遍历呢？？因为图有可能是非连通图
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                DFSDebug(i);
            }
        }
    }

    private void DFSDebug(int i) {
        isVisited[i] = true;

        String value = getVertexByIndex(i);
        System.out.println("访问到结点：" + value);
        //1、获取当前结点i的第一个邻接结点w
        int w = getFirst(i);

        // 一直处理，直到当前结点没有邻接结点

        boolean flag = false;
        while (w != -1) {
            flag = true;
            String vertex = getVertexByIndex(w);
            String content = value + "获取到的邻接结点w:" + vertex;
            Boolean visit = isVisited[w];
            if (visit) {
                content = content + "，已经访问过，获取下一个邻接结点";
            } else {
                content = content + "，未访问过，进入访问";
            }
            System.out.println(content);

            // 如果w没有被访问过，以w为新的结点，进行dfs
            if (!isVisited[w]) {
                DFSDebug(w);
            }
            // 根据前一个邻接结点的下标来获取下一个邻接结点
            w = getNext(i, w);
        }

        if (flag) {
            System.out.println("没有下一个邻接结点，" + value + "已经处理完所有的邻接结点！");
        } else {
            System.out.println(value + "不存在邻接结点！");
        }
    }



    /**
     * DFS遍历。
     * 时间复杂度O(V+E)
     * V: 图的结点数
     * E: 图的边的数量
     */
    public void DFS() {
        // 初始时候设置所有的结点没有被访问过
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        // 遍历所有的结点，如果结点没有被访问过，调用DFS
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                DFS(i);
            }
        }
    }

    /**
     * index结点的DFS
     * @param index
     */
    public void DFS(int index) {
         // 设置index结点为已访问
         isVisited[index] = true;
         // 访问结点
         visit(index);

        // 一直处理，直到当前结点没有邻接结点

         // 获取第一个邻接结点
         int w = getFirst(index);
         // -1表示不存在
         while (w != -1) {
             if (!isVisited[w]) {
                 // 如果没有访问过，则访问
                 DFS(w);
             }
             // 获取下一个邻接结点
             w = getNext(index, w);
         }
    }

    /**
     * 访问index结点
     */
    public void visit(int index) {
        // 这里获取结点的值输出，表示访问
        String vertex = getVertexByIndex(index);
        System.out.println("访问结点：" + vertex);
    }

    /**
     * 获取index结点的第一个邻接结点的下标
     * @param index
     */
    public int getFirst(int index) {
        for (int j = 0; j < vertexes.size(); j++) {
            if (edges[index][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据当前结点的前一个邻接结点的下标来获取当前结点的下一个邻接结点
     * @param index 当前结点
     * @param beforeIndex  当前结点的前一个邻接结点
     * @return
     */
    public int getNext(int index, int beforeIndex) {
        for (int j = beforeIndex + 1; j < vertexes.size(); j++) {
            if (edges[index][j] == 1) {
                return j;
            }
        }
        return -1;
    }
    //=============================DFS================================


    //=============================BFS================================
    /**
     * DFS遍历。
     * 时间复杂度O(V+E)
     * V: 图的结点数
     * E: 图的边的数量
     */
    public void BFS() {
        // 初始时，设置所有结点都没有访问过
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
        // 遍历所有的结点，如果没有访问过，则进行结点的BFS
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                BFS(i);
            }
        }
    }

    private void BFS(int i) {
       // 创建队列
        LinkedList<Integer> queue = new LinkedList<>();
        // 加入队列
        queue.addLast(i);
        // 并设置为已访问
        isVisited[i] = true;

        // 队列不为空
        while (!queue.isEmpty()) {
            // 出队
            int index = queue.removeFirst();
            // 访问结点
            visit(index);

            // 获取所有未访问的邻接结点，加入队列，并标记为已访问。。。
            // 获取第一个邻接结点
            int w = getFirst(index);
            while (w != -1) {
                if (!isVisited[w]) {
                    // 邻接结点没有访问过，加入队列尾部，并设置为已访问
                    queue.addLast(w);
                    isVisited[w] = true;
                }
                // 获取下一个邻接结点
                w = getNext(index, w);
            }
        }
    }


    public void BFSDebug() {
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        // 为什么要遍历呢？？因为图有可能是非连通图
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                BFSDebug(i);
            }
        }
    }

    private void BFSDebug(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i);
        isVisited[i] = true;

        while (!queue.isEmpty()) {
            System.out.print("队列情况：");
            for (Integer index : queue) {
                System.out.print(getVertexByIndex(index) + " ");
            }
            System.out.println();
            System.out.println("=========================");

            // 结点(下标)出队访问
            int index = queue.removeFirst();
            String vertex = getVertexByIndex(index);
            System.out.println("元素出队并访问：" + vertex);

            // index结点的所有的邻接结点入队，用于后续的出队访问
            int w = getFirst(index);
            while (w != -1) {
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    queue.addLast(w);
                    System.out.println("获取" + vertex + "的邻接结点" + getVertexByIndex(w) + "，该邻接结点没有访问，加入队列尾部，获取下一个邻接结点");
                } else {
                    System.out.println("获取" + vertex + "的邻接结点" + getVertexByIndex(w) + "，该邻接结点已经访问过，无需加入队列尾部，获取下一个邻接结点");
                }
                w = getNext(index, w);
            }
            System.out.println("出队元素" + vertex + "的所有邻接结点获取完毕");
        }
        System.out.println("=========================");
        System.out.println("单个结点" + getVertexByIndex(i) + "处理完毕");

    }
    //=============================BFS================================



}
