package com.mrlu.base.datastruct.array;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Sparse array resolver.
 *
 * @author 简单de快乐
 * @create 2025 -01-03 13:43
 *
 * 稀疏数组。以整数数组为例子
 */
public class SparseArrayResolver {

    /**
     * Size int. 获取二维数组非空元素个数
     *
     * @param original the original
     * @return the int
     */
    public int size(int[][] original) {
        int count = 0;
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                int el = original[i][j];
                boolean unEmpty = !isEmpty(el);
                if (unEmpty) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 判断元素是否为空
     * @param el
     * @return
     */
    private boolean isEmpty(int el ) {
        return el == 0;
    }

    /**
     * 将数组解析为稀疏数组
     * @param original
     * @return
     */
    public int[][] resolve(int[][] original) {
        // 1、获取二维数组元素个数
        int num = size(original);

        // 2、创建行数为num+1，列数为3的二维数组
        int[][] sparseArray = new int[num + 1][3];

        // 3、指定稀疏数组第一行第一列为原数组的行数。第一行第二列为原数组的列数。第一行第三列为原数组的元素个数。
        sparseArray[0][0] = original.length;
        sparseArray[0][1] = original[0].length;
        sparseArray[0][2] = num;

        // 4、遍历原数组，获取非空数据的行索引，列索引，具体数据，记录到稀疏数组中。
        //   创建稀疏数组行索引指示器，每统计一个非空元素，指示器加一。
        int counter = 1;
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                int el = original[i][j];
                boolean unEmpty = !isEmpty(el);
                if (unEmpty) {
                    int row = counter;
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = el;
                    counter++;
                }
            }
        }
        return sparseArray;
    }

    /**
     * The constant separator.
     */
    public static final String separator = ",";

    /**
     * Resolve and save. 将数组解析为稀疏数组，并保存到指定文件
     *
     * @param original the original
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void resolveAndSave(int[][] original, String filename) throws IOException {
        // 1、获取稀疏数组
        int[][] sparseArray = resolve(original);
        // 2、使用io流，保存稀疏数组
        save(filename, sparseArray);
    }

    /**
     * Resolve and save. 保存稀疏数组到指定文件
     *
     * @param sparseArray the sparseArray
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void save(String filename, int[][] sparseArray) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filename);
        // 1、遍历稀疏数组，逐行输出，每行的每个元素通过逗号分割。每输出完一行，就输出一个换行。
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                int el = sparseArray[i][j];
                outputStream.write(String.valueOf(el).getBytes(StandardCharsets.UTF_8));
                if (j != sparseArray[i].length - 1) {
                    outputStream.write(separator.getBytes(StandardCharsets.UTF_8));
                }
            }
            outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * 还原稀疏数组为原始数组
     * @param sparseArray
     * @return
     */
    public int[][] restore(int[][] sparseArray) {
        // 1、根据稀疏数组的第一行第一列、第一行第二列得到原始数组的行数、列数
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];
        int[][] original = new int[row][column];
        // 2、从第一行开始遍历稀疏数组，获取原始数据的行索引，列索引，原始数据。
        for (int i = 1; i < sparseArray.length; i++) {
            int originalRow = sparseArray[i][0];
            int originalColumn = sparseArray[i][1];
            int element = sparseArray[i][2];
            original[originalRow][originalColumn] = element;
        }
        return original;
    }

    /**
     * 读取指定文件的稀疏数组还原成原始数组
     * @param filename
     * @return
     * @throws IOException
     */
    public int[][] restore(String filename) throws IOException {
        int[][] sparseArray = readSparseArray(filename);
        return restore(sparseArray);
    }

    private int[][] readSparseArray(String filename) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // 1、获取文件的所有的行
        List<String> lines = reader.lines().collect(Collectors.toList());

        // 2、创建稀疏数组。文件的行数就是稀疏数组的长度，列数固定为3
        int[][] sparseArray = new int[lines.size()][3];

        // 3、遍历文件所有行，解析每行的元素，设置到稀疏数组
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] elements = line.split(separator);
            // 获取稀疏数组的元素
            int rowIndex = Integer.parseInt(elements[0]);
            int columnIndex = Integer.parseInt(elements[1]);
            int element = Integer.parseInt(elements[2]);

            // 设置到对应的位置
            sparseArray[i][0] = rowIndex;
            sparseArray[i][1] = columnIndex;
            sparseArray[i][2] = element;
        }
        return sparseArray;
    }

}
