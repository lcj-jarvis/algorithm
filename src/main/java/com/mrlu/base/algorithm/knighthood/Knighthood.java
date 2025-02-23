package com.mrlu.base.algorithm.knighthood;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author 简单de快乐
 * @create 2025-02-23 22:57
 *
 * 骑士周游问题
 */
public class Knighthood {

    // 列的数量
    public int X;
    // 列的数量
    public int Y;

    // 记录(x,y)位置，是否走过。true表示走过，false表示没有。
    private boolean[][] isVisited;

    // 是否完成
    private boolean finished;

    public Knighthood(int n) {
        X = n;
        Y = n;
        this.isVisited = new boolean[n][n];
    }

    public static void main(String[] args) {
        int n = 8;
        Knighthood knighthood = new Knighthood(n);
        //创建棋盘
        int[][] chessboard = new int[n][n];
        // 第一行
        int row = 1;
        // 第一列
        int column = 1;
        //测试一下耗时
        long start = System.currentTimeMillis();
        knighthood.traversal(chessboard, row- 1, column- 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end- start) + " 毫秒");
        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param chessboard 棋盘
     * @param x 当前位置的横坐标x。x>=0
     * @param y 当前位置的纵坐标y。y>=0
     * @param step 当前是第几步，step>=1
     */
    public void traversal(int[][] chessboard, int x, int y, int step) {
        // 设置当前位置已走过
        isVisited[x][y] = true;
        // 记录当前位置是第几步走的
        chessboard[x][y] = step;
        //获取下一步可以走的所有合法位置。
        List<Point> nexts = nexts(new Point(x, y));
        // 贪心算法优化，排序后，每次都选择最优的
        //对 nexts 进行排序, 排序的规则就是对nexts的所有的Point对象的下一步的位置的数目，进行从小到大排序
        sort(nexts);

        Iterator<Point> iterator = nexts.iterator();
        while (iterator.hasNext()) {
            Point next = iterator.next();
            //iterator.remove();
            // 如果没有走过，则可以走
            if (!isVisited[next.getX()][next.getY()]) {
                traversal(chessboard, next.getX(), next.getY(), step + 1);
            }
        }

        // 判断是否完成任务，使用step和应该走的步数比较。
        // 如果没有达到数量，则表示没有完成任务，之前走过的步数都是错的，将棋盘清0，和回退未没走过
        // 1、棋盘到目前位置，仍然没有走完
        // 2、棋盘处于一个回溯过程
        if (step < X * Y && !finished) {
            // 清空棋盘
            chessboard[x][y] = 0;
            // 回退为没走过
            isVisited[x][y] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 当前的下一步根据它们的下一步数量从小到大排序
     * @param nexts
     */
    public void sort(List<Point> nexts) {
        nexts.sort(Comparator.comparingInt(n -> nexts(n).size()));
    }

    /**
     * 获取下一步可以走的所有合法位置。
     * @param currentPoint 当前位置
     * @return
     */
    public List<Point> nexts(Point currentPoint) {
        // 下一步要走的横坐标
        int nextX;
        // 下一步要走的纵坐标
        int nextY;

        // 保持可以走的下一步
        ArrayList<Point> results = new ArrayList<>();

        // 1、先走5的位置
        // 如果”下一步要走的横坐标“没有超出x轴的起点0，而且”下一步要走的纵坐标“没有超出棋盘纵坐标的范围，说明是可以走的
        if ((nextX = currentPoint.getX() - 2) >= 0 && (nextY = currentPoint.getY() + 1) < Y) {
            results.add(new Point(nextX, nextY));
        }

        // 2、再走6的位置
        // 如果”下一步要走的横坐标“没有超出x轴的起点0，而且”下一步要走的纵坐标“没有超出棋盘纵坐标的范围，说明是可以走的
        if ((nextX = currentPoint.getX() - 1) >= 0 && (nextY = currentPoint.getY() + 2) < Y) {
            results.add(new Point(nextX, nextY));
        }

        // 3、再走7的位置
        // 如果”下一步要走的横坐标“没有超出棋盘横坐标的范围，而且”下一步要走的纵坐标“没有超出棋盘纵坐标的范围，说明是可以走的
        if ((nextX = currentPoint.getX() + 1) < X && (nextY = currentPoint.getY() + 2) < Y) {
            results.add(new Point(nextX, nextY));
        }

        // 4、再走0的位置
        // 如果”下一步要走的横坐标“没有超出棋盘横坐标的范围，而且”下一步要走的纵坐标“没有超出棋盘纵坐标的范围，说明是可以走的
        if ((nextX = currentPoint.getX() + 2) < X && (nextY = currentPoint.getY() + 1) < Y) {
            results.add(new Point(nextX, nextY));
        }

        // 5、再走1的位置
        // 如果”下一步要走的横坐标“没有超出棋盘横坐标的范围，而且”下一步要走的纵坐标“没有超出y轴的起点0，说明是可以走的
        if ((nextX = currentPoint.getX() + 2) < X && (nextY = currentPoint.getY() - 1) >= 0) {
            results.add(new Point(nextX, nextY));
        }

        // 6、再走2的位置
        // 如果”下一步要走的横坐标“没有超出棋盘横坐标的范围，而且”下一步要走的纵坐标“没有超出y轴的起点0，说明是可以走的
        if ((nextX = currentPoint.getX() + 1) < X && (nextY = currentPoint.getY() - 2) >= 0) {
            results.add(new Point(nextX, nextY));
        }

        // 7、再走3的位置
        // 如果”下一步要走的横坐标“没有超出x轴的起点0，而且”下一步要走的纵坐标“没有超出y轴的起点0，说明是可以走的
        if ((nextX = currentPoint.getX() - 1) >= 0 && (nextY = currentPoint.getY() - 2) >= 0) {
            results.add(new Point(nextX, nextY));
        }

        // 8、再走4的位置
        // 如果”下一步要走的横坐标“没有超出x轴的起点0，而且”下一步要走的纵坐标“没有超出y轴的起点0，说明是可以走的
        if ((nextX = currentPoint.getX() - 2) >= 0 && (nextY = currentPoint.getY() - 1) >= 0) {
            results.add(new Point(nextX, nextY));
        }
        return results;
    }

}
