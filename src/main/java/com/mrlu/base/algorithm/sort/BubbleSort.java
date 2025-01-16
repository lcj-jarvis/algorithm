package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-15 14:49
 *
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        //  逐步推导，最后归纳总结得出结论。
        // 算法：复杂问题拆解成简单的问题，逐个解决。
        int[] arr = {3, 9, -1, 10 ,-2, 0};

        // 第一次冒泡
        // 已经冒泡的元素个数
        int bubbledNum = 0;
        // 未冒泡好的元素组成的数组的末端
        int length = arr.length - 1 - bubbledNum;
        boolean swapped = false;
        for (int t1 = 0; t1 < length; t1++) {
            int e1 = arr[t1];

            //t1的下一个位置t2的
            int t2 = t1 + 1;
            int e2 = arr[t2];

            // 比较
            if (compare(e1, e2) > 0) {
                // 交互
                swap(arr, t1, t2);

                swapped = true;
            }
        }
        if (!swapped) {
            // 没有发生交换过。直接结束。
            System.out.println("第" + (bubbledNum + 1) + "冒泡无元素交换，数组已经排序好，无需进行后续操作，最终结果如下：");
            System.out.println(Arrays.toString(arr));
            return;
        }

        System.out.println("第" + (bubbledNum + 1) + "次冒泡结果：");
        System.out.println(Arrays.toString(arr));


        // 第二次冒泡
        // 已经冒泡的元素个数
        bubbledNum = 1;
        // 未冒泡好的元素组成的数组的末端
        length = arr.length - 1 - bubbledNum;
        swapped = false;
        for (int t1 = 0; t1 < length; t1++) {
            int e1 = arr[t1];

            //t1的下一个位置t2的
            int t2 = t1 + 1;
            int e2 = arr[t2];

            // 比较
            if (compare(e1, e2) > 0) {
                // 交互
                swap(arr, t1, t2);

                swapped = true;
            }
        }
        if (!swapped) {
            // 没有发生交换过。直接结束。
            System.out.println("第" + (bubbledNum + 1) + "冒泡无元素交换，数组已经排序好，无需进行后续操作，最终结果如下：");
            System.out.println(Arrays.toString(arr));
            return;
        }

        System.out.println("第" + (bubbledNum + 1) + "次冒泡结果：");
        System.out.println(Arrays.toString(arr));

        // 第三次冒泡
        // 已经冒泡的元素个数
        bubbledNum = 2;
        // 未冒泡好的元素组成的数组的末端
        length = arr.length - 1 - bubbledNum;
        swapped = false;
        for (int t1 = 0; t1 < length; t1++) {
            int e1 = arr[t1];

            //t1的下一个位置t2的
            int t2 = t1 + 1;
            int e2 = arr[t2];

            // 比较
            if (compare(e1, e2) > 0) {
                // 交互
                swap(arr, t1, t2);

                swapped = true;
            }
        }
        if (!swapped) {
            // 没有发生交换过。直接结束。
            System.out.println("第" + (bubbledNum + 1) + "冒泡无元素交换，数组已经排序好，无需进行后续操作，最终结果如下：");
            System.out.println(Arrays.toString(arr));
            return;
        }

        System.out.println("第" + (bubbledNum + 1) + "次冒泡结果：");
        System.out.println(Arrays.toString(arr));


        // 第四次冒泡
        // 已经冒泡的元素个数
        bubbledNum = 3;
        // 未冒泡好的元素组成的数组的末端
        length = arr.length - 1 - bubbledNum;
        swapped = false;
        for (int t1 = 0; t1 < length; t1++) {
            int e1 = arr[t1];

            //t1的下一个位置t2的
            int t2 = t1 + 1;
            int e2 = arr[t2];

            // 比较
            if (compare(e1, e2) > 0) {
                // 交互
                swap(arr, t1, t2);

                swapped = true;
            }
        }
        if (!swapped) {
            // 没有发生交换过。直接结束。
            System.out.println("第" + (bubbledNum + 1) + "冒泡无元素交换，数组已经排序好，无需进行后续操作，最终结果如下：");
            System.out.println(Arrays.toString(arr));
            return;
        }

        System.out.println("第" + (bubbledNum + 1) + "次冒泡结果：");
        System.out.println(Arrays.toString(arr));



        // 第五次冒泡
        // 已经冒泡的元素个数
        bubbledNum = 4;
        // 未冒泡好的元素组成的数组的末端
        length = arr.length - 1 - bubbledNum;
        swapped = false;
        for (int t1 = 0; t1 < length; t1++) {
            int e1 = arr[t1];

            //t1的下一个位置t2的
            int t2 = t1 + 1;
            int e2 = arr[t2];

            // 比较
            if (compare(e1, e2) > 0) {
                // 交互
                swap(arr, t1, t2);

                swapped = true;
            }
        }
        if (!swapped) {
            // 没有发生交换过。直接结束。
            System.out.println("第" + (bubbledNum + 1) + "冒泡无元素交换，数组已经排序好，无需进行后续操作，最终结果如下：");
            System.out.println(Arrays.toString(arr));
            return;
        }

        System.out.println("第" + (bubbledNum + 1) + "次冒泡结果：");
        System.out.println(Arrays.toString(arr));

        // 总结
        //// 需要冒泡arr.length - 1次
        //for (int bubbledNum = 0; bubbledNum < arr.length - 1; bubbledNum++) {
        //    // 未冒泡好的元素组成的数组的末端
        //    int length = arr.length - 1 - bubbledNum;
        //    boolean swapped = false;
        //    for (int t1 = 0; t1 < length; t1++) {
        //        int e1 = arr[t1];
        //
        //        //t1的下一个位置t2的
        //        int t2 = t1 + 1;
        //        int e2 = arr[t2];
        //
        //        // 比较
        //        if (compare(e1, e2) > 0) {
        //            // 交互
        //            swap(arr, t1, t2);
        //
        //            swapped = true;
        //        }
        //    }
        //    if (!swapped) {
        //        // 没有发生交换过。直接结束。
        //        //System.out.println("第" + (bubbledNum + 1) + "冒泡无元素交换，数组已经排序好，无需进行后续操作，最终结果如下：");
        //        //System.out.println(Arrays.toString(arr));
        //
        //        // 用break是为了让后面的输出语句执行。如果没有后面的输出语句，用return也行。
        //        break;
        //    }
        //
        //    //System.out.println("第" + (bubbledNum + 1) + "次冒泡结果：");
        //    //System.out.println(Arrays.toString(arr));
        //}
        //
        //System.out.println("最终结果：");
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 时间复杂度：O(n^2)
     * 缺点：假如在冒泡的过程中，数组已经是有序的，还会进行后续冒泡过程。
     * 优化：在每一次冒泡过程开始前，设置一个标识flag，默认为false，表示没有进行元素交换过。
     *      如果在冒泡的操作中，进行过元素交换，则设置为true。
     *      在一次冒泡过程后，判断flag是否还是false，如果是说明已经有序了，无需进行后续冒泡过程，直接结束。
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 需要冒泡arr.length - 1个元素
        // bubbledNum表示已冒泡的元素个数
        // 循环一次，表示一次完整的冒泡过程
        for (int bubbledNum = 0; bubbledNum < arr.length - 1; bubbledNum++) {
            // 循环一次，表示一次冒泡操作。
            // 从t1位置，开始执行冒泡操作，初始时t1在第一个位置。直到t1到达“未冒泡好的元素组成的数组的末端”才结束
            // 未冒泡好的元素组成的数组的末端 = arr.length - 已冒泡的元素个数 - 1
            for (int t1 = 0; t1 < arr.length - bubbledNum - 1 ; t1++) {
                int e1 = arr[t1];

                // 获取t1的下一个位置t2的元素e2
                int t2 = t1 + 1;
                int e2 = arr[t2];

                // 比较。如果t1位置的元素e1 > t2位置的元素e2，则进行交换
                if (compare(e1, e2) > 0) {
                    // 交换e1和e2的位置
                    swap(arr, t1, t2);
                }
            }

            //System.out.println("第" + (bubbledNum + 1) + "次冒泡排序后");
            //System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 冒泡排序优化
     * @param arr
     */
    public static void prefBubbleSort(int[] arr) {
        // 需要冒泡arr.length - 1个元素
        // bubbledNum表示已冒泡的元素个数
        // 循环一次，表示一次完整的冒泡过程
        for (int bubbledNum = 0; bubbledNum < arr.length - 1; bubbledNum++) {

            // 定义一个标识表示有没有交换过元素。false表示没有
            boolean swapped = false;

            // 循环一次，表示一次冒泡操作。
            // 从t1位置，开始执行冒泡操作，初始时t1在第一个位置。直到t1到达“未冒泡好的元素组成的数组的末端”才结束
            // 未冒泡好的元素组成的数组的末端 = arr.length - 已冒泡的元素个数 - 1
            for (int t1 = 0; t1 < arr.length - bubbledNum - 1 ; t1++) {
                int e1 = arr[t1];

                // 获取t1的下一个位置t2的元素e2
                int t2 = t1 + 1;
                int e2 = arr[t2];

                // 比较。如果t1位置的元素e1 > t2位置的元素e2，则进行交换
                if (compare(e1, e2) > 0) {
                    // 交换e1和e2的位置
                    swap(arr, t1, t2);

                    // 交换过，设置为true
                    swapped = true;
                }
            }

            if(!swapped) {
                // 没有交换过，说明排序好了。跳出循环结束
                break;
            }

            //System.out.println("第" + (bubbledNum + 1) + "次冒泡排序后");
            //System.out.println(Arrays.toString(arr));
        }
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
