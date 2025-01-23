package com.mrlu.base.algorithm.search;

/**
 * @author 简单de快乐
 * @create 2025-01-22 23:57
 *
 * 斐波那契查找
 * 注意】使用斐波那契查找的前提是数组是有序的
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,5,6,6,7,8,9};
        System.out.println(fibonacciSearch(arr, 7));
        System.out.println(fibonacciSearch(arr,  2));
        System.out.println(fibonacciSearch(arr, 6));
        System.out.println(fibonacciSearch(arr, 1));
        System.out.println(fibonacciSearch(arr, 5));
        System.out.println(fibonacciSearch(arr, 9));
        System.out.println(fibonacciSearch(arr, -100));
    }

    /**
     * 获取斐波那契数列元素
     * @param k
     * @return
     */
    public static int fib(int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return fib(k - 1) + fib(k - 2);
    }


    public static int fibonacciSearch(int[] arr, int element) {
        //1、从头到尾开始获取斐波那契数列的元素，直到找到大于等于数组长度的元素，获取对应的k值，即斐波那契数量索引，
        int k = 0;
        while (fib(k) < arr.length) {
            k++;
        }
        // 2、当f(k) > 原数组长度时候，扩容数组。扩容后的数组超出原数组长度的部分统一设置为原数组的最后一个元素
        int targetLength = fib(k);
        int[] temp = arr;
        if (targetLength > arr.length) {
            temp = new int[targetLength];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            for (int i = arr.length; i < temp.length; i++) {
                temp[i] = arr[arr.length - 1];
            }
        }

        //3、mid = left + f(k-1) - 1, f(k-1)为斐波那契数列中索引为k-1的元素
        //4、如果temp[mid] == 要查找的元素，返回mid
        //5、如果temp[mid] < 要查找的元素，从mid的右边找，left = mid + 1，k = k -2。
        //因为mid右边的长度为f(k-2), f(k-2) = f(k-3) + f(k-4), mid右边的长度的黄金分割长度为f(k-3)，从k-1变成k-3，k需要减2
        //5、如果temp[mid] > 要查找的元素，从mid的左边找，right = mid - 1，k = k - 1
        //因为mid左边的长度为f(k-1), f(k-1) = f(k-2) + f(k-3), mid左边的长度的黄金分割长度为f(k-2)，从k-1变成k-2，k需要减1
        //重复3、4、5、6步骤，直到left >= right，最后返回-1表示没有找到
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + fib(k - 1) - 1;
            if (temp[mid] == element) {
                return mid;
            } else if (temp[mid] > element) {
                right = mid - 1;
                k = k - 1;
            } else if (temp[mid] < element) {
                left = mid + 1;
                k = k - 2;
            }
        }

        //为什么上面的循环不考虑left等于right的情况呢？？？
        //因为left等于right的时候，算出来的mid小于left，然后会死循环。
        if (left == right && temp[left] == element) {
            return left;
        }
        return -1;
    }

}
