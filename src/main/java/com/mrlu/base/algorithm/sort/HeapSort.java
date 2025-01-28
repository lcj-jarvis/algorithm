package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-27 23:59
 *
 * 说明：这里的代码是实现从大到小的，如果想从小到大，就要构建大根堆，只要改动以下两点
 * （1）compare(arr[right], arr[i]) < 0 改成 compare(arr[right], arr[i]) > 0
 * （2）compare(arr[i], temp) < 0 改成 compare(arr[i], temp) > 0
 */
public class HeapSort {

    public static void main(String[] args) {
        //int arr[] = {49, 38, 65, 97, 76, 13, 27, 49};
        int arr[] = {49, 38, 65, 97, 76, 13, 27, 49, -1, 0, 66, 666, 888};
        heapSort(arr);
        // [13, 38, 27, 49, 76, 65, 49, 97]
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序：从大到小
     * 时间复杂度O(nlogn)
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //1、无序序列构建小根堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        // 2、堆顶元素和堆的最后一个位置元素交换，即出堆与用堆的最后一个元素作为根节点。
        // 剩余未出堆的元素作为待构建堆的无序序列，使用根节点进行调整建堆，再重复取出(交换)调整....直到待构建堆的无序序列的节点个数为0
        for (int i = arr.length - 1; i > 0; i--) {
            // 堆顶元素和堆的最后一个位置元素交换，即出堆与用堆的最后一个元素作为根节点
            swap(arr, 0, i);

            // 待参与构建堆的无序序列节点个数
            int size = i;
            // 使用根节点进行调整建堆
            adjust(arr, 0, size);
        }
    }


    /**
     * 调整index位置的子树为小根堆，子树的结点个数为size
     *
     * @param arr
     * @param index 调整的位置(索引)
     * @param size  待参与构建堆的无序序列节点个数
     */
    //public static void adjust(int[] arr, int index, int size) {
    //    // (2 * index + 1) 获取左子树的索引位置，如果左子树的索引位置超出待参与构建堆的无序序列的范围，直接结束
    //    for (int i = (2 * index + 1); i < size; i = 2 * i + 1) {
    //        int right = i + 1;
    //        // 如果有有节点，则比较左右节点，取较小的
    //        if (right < size && compare(arr[right], arr[i]) < 0) {
    //            // 右节点更小，移到右节点位置
    //            i = i + 1;
    //        }
    //        // 左右节点中较小的那个节点和需要调整的节点比较
    //        if (compare(arr[i], arr[index]) < 0) {
    //            // 左右节点中较小的那个节点和需要调整的节点交换位置
    //            swap(arr, index, i);
    //
    //            // 更新调整的节点位置。即移动需要调整的节点到左右节点中较小的那个节点的位置，作为新的调整位置
    //            index = i;
    //        } else {
    //            // 无需调整，说明以该节点为根节点的子树已经是一个堆了
    //            break;
    //        }
    //
    //        // 获取index位置的下一个左子树的索引 i = 2 * index + 1 = 2 * i + 1
    //        // 判断是否超出 待参与构建堆的无序序列 的范围。
    //    }
    //}

    /**
     * 调整index位置的子树为小根堆，子树的结点个数为size。
     * 优化后：
     * 不需要每次交换。初始时候只需要记录调整的节点，用于比较，然后最后把调整的节点设置到最终位置即可
     *
     * @param arr
     * @param index 调整的位置(索引)
     * @param size  待参与构建堆的无序序列节点个数
     */
    public static void adjust(int[] arr, int index, int size) {
        //初始时候只需要记录调整的节点，用于比较
        int temp = arr[index];
        // (2 * index + 1) 获取左子树的索引位置，如果左子树的索引位置超出待参与构建堆的无序序列的范围，直接结束
        for (int i = (2 * index + 1); i < size; i = 2 * i + 1) {
            int right = i + 1;
            // 比较左右节点
            if (right < size && compare(arr[right], arr[i]) < 0) {
                // 右节点更小，移到右节点位置
                i = i + 1;
            }
            // 左右节点中较小的那个节点和需要调整的节点比较
            if (compare(arr[i], temp) < 0) {
                // 把左右节点中较小的那个节点设置到调整的位置，即交换位置
                arr[index] = arr[i];

                // 更新调整的节点位置。即移动需要调整的节点到左右节点中较小的那个节点的位置，作为新的调整位置
                index = i;
            } else {
                // 无需调整，说明以该节点为根节点的子树已经是一个堆了
                break;
            }

            // 获取index位置的下一个左子树的索引 i = 2 * index + 1 = 2 * i + 1
            // 判断是否超出 待参与构建堆的无序序列 的范围。
        }

        // 设置最终调整的位置的元素为原来的元素，实现交换
        arr[index] = temp;
    }

    /**
     * 数组元素arr[t1]和arr[t2]交换位置
     */
    private static void swap(int[] arr, int t1, int t2) {
        // 先记录t1位置的元素
        int temp = arr[t1];
        // 把t2位置的元素设置到t1位置
        arr[t1] = arr[t2];
        // 把t1位置的元素设置到t2位置
        arr[t2] = temp;
    }

    /**
     * 比较元素e1和e2。
     * 返回的结果小于0，说明元素e1小于e2。反之，说明元素e1大于e2。
     * @param e1
     * @param e2
     * @return
     */
    private static int compare(int e1, int e2) {
        return e1 - e2;
    }



}
