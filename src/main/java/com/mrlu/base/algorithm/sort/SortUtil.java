package com.mrlu.base.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * @author 简单de快乐
 * @create 2025-01-20 14:25
 *
 * 泛型数组排序工具类。
 *
 * 可以看下java相关排序api底层是什么
 * ArrayList<Object> list = new ArrayList<>();
 * list.sort(Comparator.comparing(Object::hashCode));
 * list.stream().sorted();
 *
 * @see java.util.Arrays
 */
public class SortUtil {

    /**
     * 冒泡排序
     * @param arr 需要排序的数组
     * @param comparator  比较器
     * @param <T>
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (comparator.compare(arr[j], arr[j+1]) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * @param arr 需要排序的数组
     * @param comparator  比较器
     * @param <T>
     */
    public static <T> void selectSort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            T min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(min, arr[j]) > 0) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * 插入排序-交换式
     */
    /*public static <T> void insertSort(T[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && comparator.compare(arr[j], arr[j + 1]) > 0; j--) {
                swap(arr, j, j + 1);
            }
        }
    }*/

    /**
     * 插入排序-移动式
     * @param arr 需要排序的数组
     * @param comparator  比较器
     */
    public static <T> void insertSort(T[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T element = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(arr[j], element) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = element;
        }
    }


    /**
     * 希尔排序
     * @param arr 需要排序的数组
     * @param comparator  比较器
     * @param <T>
     */
    public static <T> void shellSort(T[] arr, Comparator<T> comparator) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                T element = arr[i];
                int j = i - gap;
                while (j >= 0 && comparator.compare(arr[j], element) > 0) {
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = element;
            }
        }
    }

    /**
     * 快速排序-刨坑式
     * @param arr 需要排序的数组
     * @param comparator  比较器
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator) {
        doQuickSort(arr, 0, arr.length - 1, comparator);
    }

    private static <T> void doQuickSort(T[] arr, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotLocation = partition(arr, low, high, (low + high) / 2, comparator);
            doQuickSort(arr, low, pivotLocation - 1, comparator);
            doQuickSort(arr,pivotLocation + 1, high, comparator);
        }
    }

    private static <T> int partition(T[] arr, int low, int high, int pivotIndex, Comparator<T> comparator) {
        T pivot = arr[low];
        // 将基准元素移到最左边，方便后续操作。此时已经记录pivot的值，然后我们不用管low位置的值了，把它认为是空的。
        if (pivotIndex != low) {
            swap(arr, low, pivotIndex);
        }
        while (low < high) {
            while (low < high && comparator.compare(arr[high], pivot) >= 0) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && comparator.compare(arr[low], pivot) <= 0) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    /**
     * 快速排序-交换式
     * @param arr
     * @param comparator
     * @param <T>
     */
    public static <T> void quickSortUseSwap(T[] arr, Comparator<T> comparator) {
        quickSortUseSwap(arr, 0, arr.length - 1, comparator);
    }


    private static <T> void quickSortUseSwap(T[] arr, int low, int high, Comparator<T> comparator) {
        // 记录初始位置
        int originLow = low;
        int originRight = high;

        T pivot = arr[(low + high) / 2];

        while (low < high) {
            while (low < high && comparator.compare(arr[low], pivot) < 0) {
                low++;
            }
            while (low < high && comparator.compare(arr[high], pivot) > 0) {
                high--;
            }
            if (low == high) {
                break;
            }

            swap(arr, low, high);


            if (arr[high] == pivot) {
                low++;
            }
            if (arr[low] == pivot) {
                high--;
            }
        }
        if (low == high) {
            low++;
            high--;
        }

        if (originLow < high) {
            quickSortUseSwap(arr, originLow, high, comparator);
        }

        if (low < originRight) {
            quickSortUseSwap(arr, low, originRight, comparator);
        }

    }

    /**
     * 归并排序
     * @param arr 需要排序的数组
     * @param comparator  比较器
     * @param <T>
     */
    public static  <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        T[] temp = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
        doMergeSort(arr, 0, arr.length - 1, comparator, temp);
    }

    private static  <T> void doMergeSort(T[] arr, int left, int right, Comparator<T> comparator, T[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            doMergeSort(arr, left, mid, comparator, temp);
            doMergeSort(arr, mid + 1, right, comparator, temp);
            merge(arr, left, mid, right, comparator, temp);
        }
    }

    private static <T> void  merge(T[] arr, int left, int mid, int right, Comparator<T> comparator, T[] temp) {
        int leftBegin = left;
        int rightBegin = mid + 1;

        int index = 0;
        while (leftBegin <= mid && rightBegin <= right) {
            if (comparator.compare(arr[leftBegin], arr[rightBegin]) < 0) {
                temp[index] = arr[leftBegin];
                leftBegin++;
            } else {
                temp[index] = arr[rightBegin];
                rightBegin++;
            }
            index++;
        }

        while (leftBegin <= mid) {
            temp[index] = arr[leftBegin];
            leftBegin++;
            index++;
        }
        while (rightBegin <= right) {
            temp[index] = arr[rightBegin];
            rightBegin++;
            index++;
        }

        int begin = left;
        for (int i = 0; i < index; i++) {
            T element = temp[i];
            arr[begin] = element;
            begin++;
        }
    }

    /**
     * 堆排序
     * @param arr
     * @param comparator
     * @param <T>
     */
    public static <T> void heapSort(T[] arr, Comparator<T> comparator) {
        //1、无序序列构建小根堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length, comparator);
        }

        // 2、堆顶元素和堆的最后一个位置元素交换，即出堆与用堆的最后一个元素作为根节点。
        // 剩余未出堆的元素作为待构建堆的无序序列，使用根节点进行调整建堆，再重复取出(交换)调整....直到待构建堆的无序序列的节点个数为0
        for (int i = arr.length - 1; i > 0; i--) {
            // 堆顶元素和堆的最后一个位置元素交换，即出堆与用堆的最后一个元素作为根节点
            swap(arr, 0, i);

            // 待参与构建堆的无序序列节点个数
            int size = i;
            // 使用根节点进行调整建堆
            adjust(arr, 0, size, comparator);
        }
    }

    /**
     * 调整index位置的子树为大根堆，子树的结点个数为size。
     * 优化后：
     * 不需要每次交换。初始时候只需要记录调整的节点，用于比较，然后最后把调整的节点设置到最终位置即可
     *
     * @param arr
     * @param index 调整的位置(索引)
     * @param size  待参与构建堆的无序序列节点个数
     */
    private static <T> void adjust(T[] arr, int index, int size, Comparator<T> comparator) {
        T temp = arr[index];
        for (int i = (2 * index + 1); i < size; i = 2 * i + 1) {
            int right = i + 1;
            if (right < size && comparator.compare(arr[right], arr[i]) > 0) {
                i = i + 1;
            }
            if (comparator.compare(arr[i], temp) > 0) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }

    // 基数排序暂时不支持

    /**
     * 交换arr[i]与arr[j]
     * @param arr
     * @param i
     * @param j
     * @param <T>
     */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
