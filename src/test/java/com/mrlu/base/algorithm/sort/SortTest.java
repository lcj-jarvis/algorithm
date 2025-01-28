package com.mrlu.base.algorithm.sort;

import com.mrlu.base.datastruct.linkedlist.HeroNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 简单de快乐
 * @create 2025-01-20 14:07
 */
public class SortTest {


    @Test
    public void test() {
        // 看他们使用了什么排序算法
        ArrayList<Object> list = new ArrayList<>();
        list.sort(Comparator.comparing(Object::hashCode));
        list.stream().sorted();
        Arrays.sort(list.toArray(new Object[0]), Comparator.comparing(Object::hashCode));
    }


    @Test
    public void testBubbleSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        SortUtil.bubbleSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        SortUtil.bubbleSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        //SortUtil.bubbleSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name降序
        // SortUtil.bubbleSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        //SortUtil.bubbleSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }

    @Test
    public void testSelectSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        //SortUtil.selectSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        //SortUtil.selectSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        // SortUtil.selectSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name升序
        // SortUtil.selectSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        SortUtil.selectSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }


    @Test
    public void testInsertSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        SortUtil.insertSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        //SortUtil.insertSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        //SortUtil.insertSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name升序
        //SortUtil.insertSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        //SortUtil.insertSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }

    @Test
    public void testShellSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        SortUtil.shellSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        //SortUtil.shellSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        //SortUtil.shellSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name升序
        //SortUtil.shellSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        //SortUtil.shellSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }

    @Test
    public void testQuickSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        SortUtil.quickSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        //SortUtil.quickSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        //SortUtil.quickSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name升序
        //SortUtil.quickSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        //SortUtil.quickSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }

    @Test
    public void testMergeSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        //SortUtil.mergeSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        //SortUtil.mergeSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        //SortUtil.mergeSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name升序
        //SortUtil.mergeSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        SortUtil.mergeSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }

    @Test
    public void testHeapSort() {
        HeroNode[] heroNodes = mockData();
        System.out.println("排序前的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
        // 先根据no升序，再根据name升序
        SortUtil.heapSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName));

        // 先根据no升序，再根据name降序
        //SortUtil.heapSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing((t1, t2) -> t2.getName().compareTo(t1.getName())));

        // 先根据no序号降序，再根据name升序
        //SortUtil.heapSort(heroNodes, Comparator.comparing(HeroNode::getNo).reversed().thenComparing(HeroNode::getName));

        // 先根据no序号降序，再根据name降序
        //SortUtil.heapSort(heroNodes, Comparator.comparing(HeroNode::getNo).thenComparing(HeroNode::getName).reversed());

        System.out.println("排序后的结果");
        Arrays.stream(heroNodes).forEach(System.out::println);
    }


    @Test
    public void testTimeComplexity() {
        int length = 1200000;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ArrayList<Integer> arrayList = new ArrayList<>(length);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int nextInt = random.nextInt();
            arrayList.add(nextInt);
            arr[i] = nextInt;
        }
        Integer[] array = arrayList.toArray(new Integer[0]);

        long begin = System.currentTimeMillis();
        //SortUtil.bubbleSort(array, Comparator.comparingInt(e -> e));
        long end = System.currentTimeMillis();
        //System.out.println("冒泡排序耗时：" + (end - begin) / 1000 + "秒");

        begin = System.currentTimeMillis();
        //SortUtil.selectSort(array, Comparator.comparingInt(e -> e));
        end = System.currentTimeMillis();
        //System.out.println("选择排序耗时：" + (end - begin) / 1000 + "秒");

        //begin = System.currentTimeMillis();
        //SortUtil.insertSort(array, Comparator.comparingInt(e -> e));
        //end = System.currentTimeMillis();
        //System.out.println("插入排序耗时：" + (end - begin) / 1000 + "秒");

        begin = System.currentTimeMillis();
        SortUtil.shellSort(array, Comparator.comparingInt(e -> e));
        end = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (end - begin) / 1000 + "秒");

        begin = System.currentTimeMillis();
        SortUtil.quickSort(array, Comparator.comparingInt(e -> e));
        //SortUtil.quickSortUseSwap(array, Comparator.comparingInt(e -> e));
        end = System.currentTimeMillis();
        System.out.println("快速排序耗时：" + (end - begin) / 1000 + "秒");

        begin = System.currentTimeMillis();
        SortUtil.mergeSort(array, Comparator.comparingInt(e -> e));
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时：" + (end - begin) / 1000 + "秒");


        begin = System.currentTimeMillis();
        RadixSort.radixSort(arr);
        end = System.currentTimeMillis();
        System.out.println("基数排序耗时：" + (end - begin) / 1000 + "秒");

        //System.out.println(Arrays.toString(arr));
    }

    private HeroNode[] mockData() {
        HeroNode h1 = new HeroNode();
        h1.setNo(2);
        h1.setName("jack");

        HeroNode h2 = new HeroNode();
        h2.setNo(6);
        h2.setName("john");

        HeroNode h3 = new HeroNode();
        h3.setNo(8);
        h3.setName("mike");

        HeroNode h4 = new HeroNode();
        h4.setNo(1);
        h4.setName("jackson");

        HeroNode h5 = new HeroNode();
        h5.setNo(5);
        h5.setName("marry");

        HeroNode h6 = new HeroNode();
        h6.setNo(6);
        h6.setName("tony");

        ArrayList<HeroNode> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        list.add(h5);
        list.add(h6);
        return list.toArray(new HeroNode[0]);
    }
}
