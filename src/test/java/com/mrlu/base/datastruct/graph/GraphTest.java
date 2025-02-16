package com.mrlu.base.datastruct.graph;

import org.junit.jupiter.api.Test;

/**
 * @author 简单de快乐
 * @create 2025-02-13 22:50
 */
public class GraphTest {


    @Test
    public void test() {
        Graph graph = new Graph(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // A-B A-C

        //A-B
        graph.insertEdge(0, 1, 1);
        //A-C
        graph.insertEdge(0, 2, 1);
        //B-C B-D B-E
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        System.out.println("边的数量：" + graph.getNumOfEdges());
        System.out.println("顶点的数量：" + graph.getNumOfVertex());
        System.out.println("第1个顶点：" + graph.getVertexByIndex(0));
        System.out.println("第二个顶点和第三个顶点的权重：" + graph.getWeight(1, 2));
        graph.printGraph();

    }

    @Test
    public void testDFS() {
        Graph graph = getGraph();
        graph.printGraph();
        //graph.DFSDebug();
        graph.DFS();
    }



    @Test
    public void testDFSDebug() {
        Graph graph = getGraph();
        graph.printGraph();
        graph.DFSDebug();
    }



    private Graph getGraph() {
        Graph graph = new Graph(9);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G");
        graph.insertVertex("H");
        graph.insertVertex("I");

        //A-B
        graph.insertEdge(0, 1, 1);
        //A-F
        graph.insertEdge(0, 5, 1);
        //B-C B-I B-G
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 8, 1);
        graph.insertEdge(1, 6, 1);

        // C-D C-I
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(2, 8, 1);

        // D-I D-G D-H D-E
        graph.insertEdge(3, 8, 1);
        graph.insertEdge(3, 6, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(3, 4, 1);

        // E-F E-H
        graph.insertEdge(4, 5, 1);
        graph.insertEdge(4, 7, 1);

        // F-G
        graph.insertEdge(5, 6, 1);
        // G-H
        graph.insertEdge(6, 7, 1);
        return graph;
    }



    @Test
    public void testBFSDebug() {
        Graph graph = getGraph();
        graph.printGraph();
        graph.BFSDebug();
    }


    @Test
    public void testBFS() {
        Graph graph = getGraph();
        graph.printGraph();
        graph.BFS();
    }


    @Test
    public void testSearch() {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(search(arr, 2));
    }

    public int search(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
