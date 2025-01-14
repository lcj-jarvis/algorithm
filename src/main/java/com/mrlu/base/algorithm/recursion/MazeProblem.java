package com.mrlu.base.algorithm.recursion;

/**
 * @author 简单de快乐
 * @create 2025-01-13 21:17
 *
 * 迷宫问题：递归-回溯
 */
public class MazeProblem {


    public static void main(String[] args) {
        // 定义二维数组，1表示墙
        int[][] map = new int[8][7];
        // 第1行，第8行所有列置1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 第1列，第7列所有元素置1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;

        int i = 1;
        int j = 1;
        solve(map, i, j);

        // 输出找到路径后的二维数组
        for (int[] ints : map) {
            for (int item : ints) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        // 求最短路径呢？？？
        // 根据不同的策略，算出对应的数组，
        // 然后计算数组元素为2的个数，最少的就是路径最短。
        // 当前我们一般不用这种方式，用Dijkstra算法解决
    }


    /**
     * 使用递归问题解决迷宫问题
     * 1、map是地图
     * 2、i,j表示从地图的哪个位置开始出发(1,1)
     * 3、这里我们约定如果能到map[6][5],则说明通路找到
     * 4、约定：当map[i][j]为0表示该点没有走过，为1表示墙，为2表示此路通，为3表示该点已经走过，但此路不通
     * 5、在走迷宫时，需要确定一个策略(即如何走)，这里我们采用
     *    下 -> 右 -> 上 -> 左，如果该点走不通，再回溯
     */
    private static boolean solve(int[][] map, int i, int j) {
         if (map[6][5] == 2) {
             return true;
         } else {
             // 这个点还没有走过
             if (map[i][j] == 0) {
                 // 这里先假设我们所在的(i,j)是通的，然后根据策略开始走
                 // 如果所有的策略走不通，表示(i,j)位置为3，表示该点已经走过，但此路不通
                 map[i][j] = 2;
                 if(solve(map, i+1, j)) { // 往下走
                     return true;
                 } else if (solve(map, i, j + 1)) { // 往右走
                     return true;
                 }  else if (solve(map, i - 1, j)) {  // 往上走
                     return true;
                 }  else if (solve(map, i, j-1)) { // 往左走
                     return true;
                 } else {
                     // 说明此路不通，是死路
                     map[i][j] = 3;
                     return false;
                 }
             } else {
                 // 这个点走过了。可能是1,2,3，但是都是不通的了
                 return false;
             }
         }
    }


}
