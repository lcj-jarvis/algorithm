package com.mrlu.base.algorithm.sort;

import java.util.Arrays;

/**
 * @author 简单de快乐
 * @create 2025-01-19 20:15
 *
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214,66,68,16,168};

        //准备工作
        //（1）一共有十个桶，每个桶是一个一维数组，桶的长度等于数组长度
        //（2）每个桶有各自的元素位置指针，初始位置为0，每个桶的元素位置指针保存到一个一维数组中(也可以理解为当前桶的元素个数)
        int[][] buckets = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        //第一轮：
        //（1）将每个元素的个位数取出，看把元素放在哪个桶。个位数 + 1 = 第几个桶，即个位数等于桶的索引。
        //    如：个位数是2，就把元素放在索引为2的桶
        //（2）从第一个桶开始，按照从头到尾的顺序，获取桶里面的元素保存到原数组中，直到最后一个桶才结束。
        //    需要注意的是每个桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            // 获取个位数
            int bucketIndex = element % 10;
            // 保存到桶的相应位置。bucketCounts[bucketIndex]：桶的元素位置指针
            buckets[bucketIndex][bucketCounts[bucketIndex]] = element;
            // 相应桶的元素位置指针加一
            bucketCounts[bucketIndex] = bucketCounts[bucketIndex] + 1;
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            // 获取桶
            int[] bucket = buckets[i];
            // 获取桶的元素个数
            int bucketCount = bucketCounts[i];
            for (int j = 0; j < bucketCount; j++) {
                // 获取桶里的元素
                int element = bucket[j];
                // 重新保存到原数组
                arr[index] = element;
                index++;
            }
            // 桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
            bucketCounts[i] = 0;
        }
        System.out.println(Arrays.toString(arr));

        //第二轮：
        //（1）将每个元素的十位数取出，看把元素放在哪个桶。十位数 + 1 = 第几个桶，即十位数等于桶的索引。
        //    如十位数是3，就把元素放在索引为3的桶
        //（2）从第一个桶开始，按照从头到尾的顺序，获取桶里面的元素保存到原数组中，直到最后一个桶才结束。
        // 需要注意的是每个桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            // 获取十位数
            int bucketIndex = (element / 10) % 10;
            // 保存到桶的相应位置。bucketCounts[bucketIndex]：桶的元素位置指针
            buckets[bucketIndex][bucketCounts[bucketIndex]] = element;
            // 相应桶的元素位置指针加一
            bucketCounts[bucketIndex] = bucketCounts[bucketIndex] + 1;
        }
        index = 0;
        for (int i = 0; i < buckets.length; i++) {
            // 获取桶
            int[] bucket = buckets[i];
            // 获取桶的元素个数
            int bucketCount = bucketCounts[i];
            for (int j = 0; j < bucketCount; j++) {
                // 获取桶里的元素
                int element = bucket[j];
                // 重新保存到原数组
                arr[index] = element;
                index++;
            }
            // 桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
            bucketCounts[i] = 0;
        }
        System.out.println(Arrays.toString(arr));


        //第三轮
        //（1）将每个元素的百位数取出，看把元素放在哪个桶。百位数 + 1 = 第几个桶，即百位数等于桶的索引。
        // 如：百位数是0，就把元素放在索引为0的桶
        //（2）从第一个桶开始，按照从头到尾的顺序，获取桶里面的元素保存到原数组中，直到最后一个桶才结束。
        // 需要注意的是每个桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            // 获取十位数
            int bucketIndex = (element / (10 * 10)) % 10;
            // 保存到桶的相应位置。bucketCounts[bucketIndex]：桶的元素位置指针
            buckets[bucketIndex][bucketCounts[bucketIndex]] = element;
            // 相应桶的元素位置指针加一
            bucketCounts[bucketIndex] = bucketCounts[bucketIndex] + 1;
        }
        index = 0;
        for (int i = 0; i < buckets.length; i++) {
            // 获取桶
            int[] bucket = buckets[i];
            // 获取桶的元素个数
            int bucketCount = bucketCounts[i];
            for (int j = 0; j < bucketCount; j++) {
                // 获取桶里的元素
                int element = bucket[j];
                // 重新保存到原数组
                arr[index] = element;
                index++;
            }
            // 桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
            bucketCounts[i] = 0;
        }
        System.out.println(Arrays.toString(arr));

        //总结

        /*//准备工作
        //（1）一共有十个桶，每个桶是一个一维数组，桶的长度等于数组长度
        //（2）每个桶有各自的元素位置指针，初始位置为0，每个桶的元素位置指针保存到一个一维数组中(也可以理解为当前桶的元素个数)
        int[][] buckets = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        //需要进行多少轮呢？？？
        //答：需要进行的轮数等于数组中最大的数的位数。如数组最大的数有3位，就需要三轮，有6位就需要6轮。
        //(1)找到数组最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 获取最大的数的位数做为轮数。这里这个方式有点巧妙了
        int round = (max + "").length();

        // 进行round轮基数排序
        for (int i = 0,n = 1; i < round; i++, n *= 10) {
            // 进行某轮
            //（1）将每个元素的相应的位数取出，看把元素放在哪个桶。第一轮取个位数，第二轮取十位数、第三轮取百位数。。。
            for (int j = 0; j < arr.length; j++) {
                int element = arr[j];
                // 获取相应的位数
                int bucketIndex = (element / n) % 10;
                // 保存到桶的相应位置。bucketCounts[bucketIndex]：桶的元素位置指针
                buckets[bucketIndex][bucketCounts[bucketIndex]] = element;
                // 相应桶的元素位置指针加一
                bucketCounts[bucketIndex] = bucketCounts[bucketIndex] + 1;
            }
            //（2）从第一个桶开始，按照从头到尾的顺序，获取桶里面的元素保存到原数组中，直到最后一个桶才结束。
            //    需要注意的是每个桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
            int index = 0;
            for (int k = 0; k < buckets.length; k++) {
                // 获取桶
                int[] bucket = buckets[k];
                // 获取桶的元素个数
                int bucketCount = bucketCounts[k];
                for (int j = 0; j < bucketCount; j++) {
                    // 获取桶里的元素
                    int element = bucket[j];
                    // 重新保存到原数组
                    arr[index] = element;
                    index++;
                }
                // 桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
                bucketCounts[k] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }*/
    }


    // 标准的基数排序，非负数情况
    /*public static void radixSort(int[] arr) {
        doSort(arr);
    }*/


    /**
     * 考虑负数的基数排序
     * @param arr
     */
    public static void radixSort(int[] arr) {
        // 1、寻找数组中的最小值
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        //2、必要时偏移数组元素
        // 是否有负数
        boolean hasNegative = min < 0;
        // 获取偏移量
        int offset = hasNegative ? Math.abs(min) : 0;
        if (hasNegative) {
            // 所有元素加上偏移量，变成非负数
            for (int i = 0; i < arr.length; i++) {
                // 有可能超出int的取值范围
                if (arr[i] < 0) {
                    //小于0的才加
                    arr[i] = arr[i] + offset;
                }
            }
        }

        //3、执行标准的基数排序
        doSort(arr);

        // 4、必要时恢复数据
        if (hasNegative) {
            // 所有元素减去偏移量，还原成非负数
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - offset;
            }
        }
    }



    /**
     * 时间复杂度：O(k*(n + m))
     * k: 待排元素的维度。可以理解为需要多少轮，如多少位数
     * m: 关键字的取值范围为m个值。即有多少个桶
     * n: 元素个数
     *
     * 扩展：假设10000个人按照生日排序
     * 年、月、日 三个维度
     * 假设取值范围分别是 1930-2018 1~12 1~31
     *
     * 处理日：n + 31(个桶) = 10000 + 31
     * 处理月：n + 12(个桶) = 10000 + 12
     * 处理年：n + 89(个桶) = 10000 + 89
     *
     *
     * 使用冒泡排序、插入排序、选择排序
     * O(n^2) ≈ 10的8次方
     *
     * 使用快排、归并排序、堆排序：
     * O(nlogn)  ≈ 10的5次方
     *
     * 基数排序：
     * O(k*(n + m)) ≈ n + 31(个桶) + n + 12(个桶) + n + 89(个桶)
     *              ≈ 10000 + 31 + 10000 + 12 +  10000 + 89
     *              ≈ 10的4次方
     *
     * @param arr
     */
    private static void doSort(int[] arr) {
        // 准备工作
        //（1）一共有十个桶，每个桶是一个一维数组，桶的长度等于数组长度
        //（2）每个桶有各自的元素位置指针，初始位置为0，每个桶的元素位置指针保存到一个一维数组中(也可以理解为当前桶的元素个数)
        int[][] buckets = new int[total][arr.length];
        int[] bucketCounts = new int[total];

        // 进行round轮基数排序
        int round = getRound(arr);
        for (int i = 0,n = 1; i < round; i++, n *= 10) {
            //（1）将每个元素的相应的位数取出，看把元素放在哪个桶。
            // 第一轮取个位数，第二轮取十位数、第三轮取百位数。。。第n轮需要取出元素的第n位数(n从右往左数) = 元素 * / (10的n-1次方) % 10.
            for (int j = 0; j < arr.length; j++) {
                int element = arr[j];
                // 获取桶的索引
                int bucketIndex = getBucketIndex(n, element);
                // 保存到桶的相应位置。bucketCounts[bucketIndex]：桶的元素位置指针
                buckets[bucketIndex][bucketCounts[bucketIndex]] = element;
                // 相应桶的元素位置指针加一
                bucketCounts[bucketIndex] = bucketCounts[bucketIndex] + 1;
            }
            //（2）从第一个桶开始，按照从头到尾的顺序，获取桶里面的元素保存到原数组中，直到最后一个桶才结束。
            //    需要注意的是每个桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
            int index = 0;
            for (int k = 0; k < buckets.length; k++) {
                // 获取桶
                int[] bucket = buckets[k];
                // 获取桶的元素个数
                int bucketCount = bucketCounts[k];
                for (int j = 0; j < bucketCount; j++) {
                    // 获取桶里的元素
                    int element = bucket[j];
                    // 重新保存到原数组
                    arr[index] = element;
                    index++;
                }
                // 桶的元素取出完成后，需要将元素位置指针设置为0，因为后续的轮还要使用。
                bucketCounts[k] = 0;
            }
        }
    }

    /**
     * 获取桶的索引
     */
    private static int getBucketIndex(int n, int element) {
        // 获取相应的位数。
        // 从小到大
        int bucketIndex = (element / n) % 10;

        // 从大到小。逆着放
        // bucketIndex = total - bucketIndex - 1;
        return bucketIndex;
    }

    /**
     *  桶的总数
     */
    public static final int total = 10;

    /**
     * 返回基数排序的总轮数
     * @param arr
     * @return
     */
    private static int getRound(int[] arr) {
        //需要进行多少轮呢？？？
        //答：需要进行的轮数等于数组中最大的数的位数。如数组最大的数有3位，就需要三轮，有6位就需要6轮。
        //(1)找到数组最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 获取最大的数的位数做为轮数。这里这个方式有点巧妙了
        return (max + "").length();
    }

}
