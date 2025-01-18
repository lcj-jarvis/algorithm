package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-16 23:26
 *
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr={8,9,1,7,2,3,5,4,6,0};

        // 第一轮分组
        int gap = arr.length / 2;
        // 从gap位置开始遍历，对遍历到的元素，结合相应的有序序列，进行插入排序
        for (int i = gap; i < arr.length; i++) {
            // 获取e2
            int e2 = arr[i];
            // 获取相应的有序序列的起点
            int t1 = i - gap;

            while (t1 >= 0 && compare(arr[t1], e2) > 0) {
                // 设置(t1 + 分组数量(即步长))的位置的元素为e1，e1=arr[t1]
                arr[t1 + gap] = arr[t1];

                // t1往前(向左)移动分组数量的距离
                t1 = t1 - gap;
            }

            // 插入e2到 （t1 + 分组数量）的位置
            arr[t1 + gap] = e2;
        }
        System.out.println(Arrays.toString(arr));


        // 第二轮分组
        gap = gap / 2;
        // 从gap位置开始遍历，对遍历到的元素，结合相应的有序序列，进行插入排序
        for (int i = gap; i < arr.length; i++) {
            // 获取e2
            int e2 = arr[i];
            // 获取相应的有序序列的起点
            int t1 = i - gap;

            while (t1 >= 0 && compare(arr[t1], e2) > 0) {
                // 设置(t1 + 分组数量(即步长))的位置的元素为e1，e1=arr[t1]
                arr[t1 + gap] = arr[t1];

                // t1往前(向左)移动分组数量的距离
                t1 = t1 - gap;
            }

            // 插入e2到 （t1 + 分组数量）的位置
            arr[t1 + gap] = e2;
        }
        System.out.println(Arrays.toString(arr));


        // 第三轮分组
        gap = gap / 2;
        // 从gap位置开始遍历，对遍历到的元素，结合相应的有序序列，进行插入排序
        for (int i = gap; i < arr.length; i++) {
            // 获取e2
            int e2 = arr[i];
            // 获取相应的有序序列的起点
            int t1 = i - gap;

            while (t1 >= 0 && compare(arr[t1], e2) > 0) {
                // 设置(t1 + 分组数量(即步长))的位置的元素为e1，e1=arr[t1]
                arr[t1 + gap] = arr[t1];

                // t1往前(向左)移动分组数量的距离
                t1 = t1 - gap;
            }

            // 插入e2到 （t1 + 分组数量）的位置
            arr[t1 + gap] = e2;
        }
        System.out.println(Arrays.toString(arr));

        // 没有第四轮，因为gap等于0了，无需进行分组插入排序


        // 总结
        // 计算每轮分组的数量，然后进行分组插入排序，直到分组数量小于或等于0，就结束
        //for (int gap = arr.length / 2; gap > 0; gap /= 2) {
        //    // 从gap位置开始遍历，对遍历到的元素，结合相应的有序序列，进行插入排序
        //    for (int i = gap; i < arr.length; i++) {
        //        // 获取e2
        //        int e2 = arr[i];
        //        // 获取相应的有序序列的起点
        //        int t1 = i - gap;
        //
        //        while (t1 >= 0 && compare(arr[t1], e2) > 0) {
        //            // 设置(t1 + 分组数量(即步长))的位置的元素为e1，e1=arr[t1]
        //            arr[t1 + gap] = arr[t1];
        //
        //            // t1往前(向左)移动分组数量的距离
        //            t1 = t1 - gap;
        //        }
        //
        //        // 插入e2到 （t1 + 分组数量）的位置
        //        arr[t1 + gap] = e2;
        //    }
        //}
        //System.out.println(Arrays.toString(arr));
    }

  public static void shellSort(int[] arr) {
      // 计算每轮分组的数量，然后进行分组插入排序，直到分组数量小于或等于0，就结束
      for (int gap = arr.length / 2; gap > 0; gap /= 2) {
          // 从gap位置开始遍历，对遍历到的元素，结合相应的有序序列，进行插入排序
          for (int i = gap; i < arr.length; i++) {
              // 获取e2
              int e2 = arr[i];
              // 获取相应的有序序列的起点
              int t1 = i - gap;

              while (t1 >= 0 && compare(arr[t1], e2) > 0) {
                  // 设置(t1 + 分组数量(即步长))的位置的元素为e1，e1=arr[t1]
                  arr[t1 + gap] = arr[t1];

                  // t1往前(向左)移动分组数量的距离
                  t1 = t1 - gap;
              }

              // 插入e2到 （t1 + 分组数量）的位置
              arr[t1 + gap] = e2;
          }
      }
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
