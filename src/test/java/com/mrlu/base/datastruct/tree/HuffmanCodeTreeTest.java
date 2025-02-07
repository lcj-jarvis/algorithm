package com.mrlu.base.datastruct.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mrlu.base.datastruct.tree.HuffmanCodeTree.*;

/**
 * @author 简单de快乐
 * @create 2025-02-06 15:43
 */
public class HuffmanCodeTreeTest {

    @Test
    public void test() {
        Byte i = (byte) Integer.parseInt("10000000", 2);
        System.out.println(i);

        // 原码 --> 反码 --> 补码
        // 原码 --> 反码
        // （1）正数：原码等于反码
        // （2）负数：符号位不变，其他各位取反
        //  如：正数1的原码：00000001  --> 反码：00000001
        //      负数-1的原码：10000001 --> （从左到右的第一位）符号位等于1不变，其他位取反，得到反码：1 111 1110

        // 反码 --> 补码
        // （1）正数：反码等于补码
        // （2）负数：反码加一等于补码
        // 负数-1的原码：10000001 --> （从左到右的第一位）符号位等于1不变，其他位取反，得到反码：1 111 1110
        //    ---> 反码加一，得到补码：1 111 1111

        // 补码 --> 反码 --> 原码
        // (1)看最高位是0还是1
        // (2)0表示正数，补码等于反码，等于原码
        // (3)1表示负数。
        // (3-1)求取反码：补码减一，然后符号位不变，设置回原来的符合位1，即可得到反码
        // (3-2)求取原码：符号位不变，其他位逐位取反，即可得到原码
        // 如：补码1000 0000。
        // 反码：（1）补码减一：1000 0000 - 1 = 0111 1111
        //      （2）设置回原来的符合位1 =  1111 1111
        // 原码：符号位不变，其他位逐位取反。1 111 1111 --> 1(符号位) 000 0000 即 10000000
        //    符号位是1，说明是负数，不考虑符号位000 0000，最终结果是负0，即-0。如果是0的话，用0000 0000表示。
        //    说明是2的八次方，即128，符号位是1，结果是-128。

        // 如补码：10101000
        // 反码：（1）补码减一：1010 1000 - 1 = 1010 0111
        //      （2）设置回原来的符合位1 =  1010 0111
        // 原码：符号位不变，其他位逐位取反。1010 0111 --> 1(符号位) 101 1000 即 1 101 1000
        // 2^3 + 2^4 + 2^6 = 8 + 16 + 64 = 88, 符号位是1，说明是-88.

        byte b = (byte) 128;
        // -128
        System.out.println(b);

        // 10000010（补码）--> 10000001(反码) --> 11111110(原码) = 2 + 2^2 + 2^3 + 2^4 + 2^5 + 2^6 = 2 + 4 + 8 + 16 + 32 + 64 = -126
        byte c = (byte) 130;
        System.out.println(c);
    }

    @Test
    public void testCreate() {
        String str = "i like like like java do you like a java";
        HuffmanCodeTree tree = HuffmanCodeTree.create(str.getBytes());
        tree.preOrder();

        tree.buildCodeMap();
    }

    @Test
    public void test1() {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(-128));
    }

    @Test
    public void testDecode() {
        String str = "i like like like java do you like a java";
        byte[] zip = zip(str.getBytes());
        System.out.println("压缩后的结果：" + Arrays.toString(zip));

        byte[] bytes = decode(zip, getHuffmanCodeMap(str.getBytes()));
        String decodeStr = new String(bytes);
        System.out.println("解压缩后的结果：" + decodeStr);
        System.out.println("解压后的结果是否等于原来的结果：" + decodeStr.equals(str));
    }


    @Test
    public void testZipFile() {
        String src = "F:\\code\\algorithm\\src\\main\\java\\com\\mrlu\\base\\datastruct\\tree\\@Resource注入.jpg";
        String dest = "F:\\code\\algorithm\\src\\main\\java\\com\\mrlu\\base\\datastruct\\tree\\注入.zip";
        HuffmanCodeTree.zipFile(src, dest);
    }

    @Test
    public void testUnZipFile() {
        String src = "F:\\code\\algorithm\\src\\main\\java\\com\\mrlu\\base\\datastruct\\tree\\注入.zip";
        String dest = "F:\\code\\algorithm\\src\\main\\java\\com\\mrlu\\base\\datastruct\\tree\\注入.jpg";
        HuffmanCodeTree.unZipFile(src, dest);
    }
}
