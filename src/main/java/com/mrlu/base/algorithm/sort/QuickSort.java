package com.mrlu.base.algorithm.sort;

/**
 * @author 简单de快乐
 * @create 2025-01-18 15:10
 *
 * 快速排序-刨坑式
 */
public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        // 当low < high时候，进行快速排序
        if (low < high) {
            //第一大步：寻找基准位置，并把数组分成比基准小的左部分和右部分
            // 选左边元素作为基准
            int pivotLocation = partitionUseLow(array, low, high);
            // 选右边元素作为基准
            //int pivotLocation = partitionUseHigh(array, low, high);
            // 选中间元素作为基准
            //int pivotLocation = partitionUseAny(array, low, high, (low + high) / 2);
            //第二大步： 基准的左部分进行快速排序(递归) ，基准的左部分的起点low=low，终点high=基准位置 - 1.
            quickSort(array, low, pivotLocation - 1);
            //第三大步：基准的右部分进行快速排序(递归) ，基准的右部分的起点low=基准位置 + 1，终点high=high.
            quickSort(array, pivotLocation + 1, high);
        }
    }

    // 取最左边元素为基准，根据思路推导的代码
    /*public static int partitionUseLow(int[] array, int low, int high) {
        // 初始时候取最左边的值为基准，并认为low的位置是空的位置。
        int pivot = array[low];
        while (low < high) {
            // high从右往左移动，直到high移动到low位置或找到小于等于pivot的元素arr[high]。注：等于的情况也要考虑，不然会死循环
            while (low < high && array[high] >= pivot) {
                high--;
            }
            if (low == high) {
                // 找到基准位置
                break;
            }
            // array[high]搬到空的位置，并认为high的位置是空的位置
            array[low] = array[high];

            // low从左往右移动，直到low移动到high位置或找到大于等于pivot的元素arr[low]。注：等于的情况也要考虑，不然会死循环
            while (low < high && array[low] <= pivot) {
                low++;
            }
            if (low == high) {
                // 找到基准位置
                break;
            }
            // array[low]搬到空的位置，并认为low的位置是空的位置
            array[high] = array[low];
        }
        // 设置基准位置元素。
        array[low] = pivot;
        //System.out.println(Arrays.toString(array));
        // 返回基准位置。
        return low;
    }*/

    /**
     * 选择最左边的元素作为pivot，优化后的代码如下
     * 时间复杂度 O(nlogn)
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partitionUseLow(int[] array, int low, int high) {
        // 1、选择最左边的值作为基准pivot，pivot=arr[low]。此时已经记录pivot的值，然后我们不用管low位置的值了，把它认为是空的。
        //int pivot = array[low];
        //while (low < high) {
        //    // 2、high从右往左移动，直到high移动到low位置或找到小于等于pivot的元素arr[high]。注：等于的情况也要考虑，不然会死循环
        //    while (low < high && compare(array[high], pivot) >= 0) {
        //        high--;
        //    }
        //    // 2.1、array[high]搬到空的位置，并认为high的位置是空的位置
        //    array[low] = array[high];
        //
        //    // 3、low从左往右移动，直到low移动到high位置或找到大于等于pivot的元素arr[low]。注：等于的情况也要考虑，不然会死循环
        //    while (low < high && compare(array[low], pivot) <= 0) {
        //        low++;
        //    }
        //    // 3.1、array[low]搬到空的位置，并认为low的位置是空的位置
        //    array[high] = array[low];
        //}
        //// 设置基准位置元素。
        //array[low] = pivot;
        //// 返回基准位置。
        //return low;

        // 使用partitionUseAny，指定pivotIndex=low，表示使用最左边元素作为基准
        return partitionUseAny(array, low, high, low);
    }

    /**
     * 选择最右边的元素作为pivot，优化后的代码如下
     * 时间复杂度 O(nlogn)
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partitionUseHigh(int[] array, int low, int high) {
        // 方式一：
        // 1、选择最右边的值作为基准pivot，pivot=arr[low]。此时已经记录pivot的值，然后我们不用管low位置的值了，把它认为是空的。
        //int pivot = array[high];
        //while (low < high) {
        //    // 2、low从左往右移动，直到low移动到high位置或找到大于等于pivot的元素arr[low]。注：等于的情况也要考虑，不然会死循环
        //    while (low < high && compare(array[low], pivot) <= 0) {
        //        low++;
        //    }
        //    // 2.1、array[low]搬到空的位置，并认为low的位置是空的位置
        //    array[high] = array[low];
        //
        //    // 3、high从右往左移动，直到high移动到low位置或找到小于等于pivot的元素arr[high]。注：等于的情况也要考虑，不然会死循环
        //    while (low < high && compare(array[high], pivot) >= 0) {
        //        high--;
        //    }
        //    // 3.1、array[high]搬到空的位置，并认为high的位置是空的位置
        //    array[low] = array[high];
        //}
        //// 设置基准位置元素。
        //array[low] = pivot;
        //// 返回基准位置。
        //return low;

        // 方式二：使用partitionUseAny，指定pivotIndex=high，表示使用最右边元素作为基准
        return partitionUseAny(array, low, high, high);
    }

    /**
     *
     * 选择pivotIndex位置的元素作为基准，开始之前把pivot换到左边。然后按照左边的处理逻辑即可。
     * 时间复杂度O(nlogn)
     * @param array
     * @param low
     * @param high
     * @param pivotIndex pivot所在的位置
     * @return
     */
    public static int partitionUseAny(int[] array, int low, int high, int pivotIndex) {
        // 1、获取pivot
        int pivot = array[pivotIndex];
        // 将基准元素移到最左边，方便后续操作。此时已经记录pivot的值，然后我们不用管low位置的值了，把它认为是空的。
        if (pivotIndex != low) {
            swap(array, low, pivotIndex);
        }

        while (low < high) {
            // 2、high从右往左移动，直到high移动到low位置或找到小于等于pivot的元素arr[high]。注：等于的情况也要考虑，不然会死循环
            while (low < high && compare(array[high], pivot) >= 0) {
                high--;
            }
            // 2.1、array[high]搬到空的位置，并认为high的位置是空的位置
            array[low] = array[high];

            // 3、low从左往右移动，直到low移动到high位置或找到大于等于pivot的元素arr[low]。注：等于的情况也要考虑，不然会死循环
            while (low < high && compare(array[low], pivot) <= 0) {
                low++;
            }
            // 3.1、array[low]搬到空的位置，并认为low的位置是空的位置
            array[high] = array[low];
        }
        // 设置基准位置元素。
        array[low] = pivot;
        // 返回基准位置。
        return low;
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

}
