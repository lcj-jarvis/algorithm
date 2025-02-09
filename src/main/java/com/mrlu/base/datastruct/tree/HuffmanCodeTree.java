package com.mrlu.base.datastruct.tree;

import java.io.*;
import java.util.*;

/**
 * @author 简单de快乐
 * @create 2025-02-06 15:31
 *
 * 赫夫曼编码树
 */
public class HuffmanCodeTree {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] zip = zip(str.getBytes());
        System.out.println("压缩后的结果：" + Arrays.toString(zip));

        byte[] bytes = decode(zip, getHuffmanCodeMap(str.getBytes()));
        String decodeStr = new String(bytes);
        System.out.println("解压缩后的结果：" + decodeStr);
        System.out.println("解压后的结果是否等于原来的结果：" + decodeStr.equals(str));
    }

    private HuffmanCodeNode  root;


    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    public HuffmanCodeTree(HuffmanCodeNode root) {
        this.root = root;
    }

    /**
     * 创建赫夫曼树
     * @param bytes 原始的字节数组
     * @return
     */
    public static HuffmanCodeTree create(byte[] bytes) {
        // 1、获取所有结点
        List<HuffmanCodeNode> nodes = getNodes(bytes);

        //2、根据集合创建赫夫曼树
        //注意：创建的新的结点无需设置data
        return doCreate(nodes);
    }

    private static HuffmanCodeTree doCreate(List<HuffmanCodeNode> nodes) {
        while (nodes.size() > 1) {
            // 从小到大排序
            Collections.sort(nodes);

            // 取出最小结点和次小结点
            HuffmanCodeNode leftNode = nodes.get(0);
            HuffmanCodeNode right = nodes.get(1);
            nodes.remove(leftNode);
            nodes.remove(right);

            // 创建新的节点并保存
            HuffmanCodeNode parent = new HuffmanCodeNode(null, leftNode.getWeight() + right.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(right);
            nodes.add(parent);
        }

        return new HuffmanCodeTree(nodes.get(0));
    }

    /**
     * 第二大步: 使用结点保存字符与字符次数，保存结点到集合
     * 1、获取字符串的byte数组
     * 2、使用map统计byte数组中每个字符出现的次数
     * 3、遍历map，根据map的key和value创建结点，保存到集合
     * 4、返回集合
     */
    private static List<HuffmanCodeNode> getNodes(byte[] bytes) {
        HashMap<Byte, Integer> countMap = new HashMap<>();
        for (byte el : bytes) {
            Integer count = countMap.computeIfAbsent(el, k -> 0);
            countMap.put(el, count + 1);
        }

        List<HuffmanCodeNode> nodes = new ArrayList<>();
        countMap.forEach((key, count) -> {
            HuffmanCodeNode node = new HuffmanCodeNode(key, count);
            nodes.add(node);
        });
        return nodes;
    }

    /**
     * 生成编码表
     * 1、创建Map<Byte,String> codeMap记录字符串及其对应的编码
     * 2、生成编码表Map的方法
     *    给定结点node，当前路径编码code，已走的路径编码StringBuilder builder（即用于拼接的路径），编码表Map。
     *    如果结点不为空，则执行以下逻辑：
     *    （1）根据已走的路径编码builder，创建新的路径编码newBuilder（StringBuilder）
     *         newBuilder拼接code
     *    （2）如果结点的data为空，则
     *    		递归遍历结点的left，传入0，newBuilder，编码表Map
     *    		递归遍历结点的right，转入1，newBuilder，编码表Map
     *    （3）如果结点的data不为空，则记录data和newBuilder的字符串到编码表Map
     * 3、初始时候使用root.left和root.right调用
     */
    public Map<Byte, String> buildCodeMap() {
        if (this.root == null) {
            return null;
        }
        HashMap<Byte, String> codeMap = new HashMap<>();
        buildCodeMap(root.getLeft(), "0", new StringBuilder(), codeMap);
        buildCodeMap(root.getRight(), "1", new StringBuilder(), codeMap);
        return codeMap;
    }

    /**
     * 生成编码表
     * @param node 当前节点
     * @param code 路径编码。左0右1
     * @param builder 已走的路径编码builder，即用于拼接的路径
     * @param codeMap 赫夫曼编码表
     */
    private void buildCodeMap(HuffmanCodeNode node, String code, StringBuilder builder, Map<Byte, String> codeMap) {
        StringBuilder newBuilder = new StringBuilder(builder);
        // 拼接路径编码
        newBuilder.append(code);
        if (node != null) {
            if (node.getData() == null) {
                // 递归遍历结点的left，传入0，newBuilder，编码表Map
                buildCodeMap(node.getLeft(), "0", newBuilder, codeMap);
                // 递归遍历结点的right，转入1，newBuilder，编码表Map
                buildCodeMap(node.getRight(), "1", newBuilder, codeMap);
            } else {
                // 结点的data不为空，则记录data和newBuilder的字符串到编码表Map
                codeMap.put(node.getData(), newBuilder.toString());
            }
        }
    }

    /**
     * @param originals 原始字节数组
     * @param codeMap 赫夫曼编码表
     * @return 赫夫曼编码后的字符串
     * 形如：1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
     */
    public static String getCodeStr(byte[] originals, Map<Byte, String> codeMap) {
        StringBuilder builder = new StringBuilder();
        for (byte el : originals) {
            String code = codeMap.get(el);
            builder.append(code);
        }
        return builder.toString();
    }

    /**
     * 根据赫夫曼编码后的字符串，得到压缩后的字节数组
     * @param codeStr 赫夫曼编码后的字符串
     * @return 压缩后的字节数组
     *
     * 举例：String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返回的是字符串
     * "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000
     *  101111111100110001001010011011100"
     * => 对应的 byte[] zips ，即 8位对应一个 byte,放入到 zips
     * zips[0] = 10101000(补码) => byte [推导 10101000(补码) => 10101000 - 1 => 10100111(反码)=> 11011000(原码) = -88]
     *
     * 原码 --> 反码 --> 补码
     * 原码 --> 反码
     * （1）正数：反码等于原码
     * （2）负数：符号位不变，其他各位取反（从左到右的第一位是符号位）
     *  如：正数1的原码：00000001  --> 反码：00000001
     *      负数-1的原码：10000001 --> （从左到右的第一位）符号位等于1不变，其他位取反，得到反码：1 111 1110
     *
     * 反码 --> 补码
     * （1）正数：补码等于反码
     * （2）负数：反码加一等于补码
     * 负数-1的原码：10000001 --> （从左到右的第一位）符号位等于1不变，其他位取反，得到反码：1 111 1110
     *    ---> 反码加一，得到补码：1 111 1111
     *
     * 补码 --> 反码 --> 原码
     * (1)看最高位是0还是1
     * (2)0表示正数，补码等于反码，等于原码
     * (3)1表示负数。
     * (3-1)求取反码：补码减一，然后符号位不变，设置回原来的符合位1，即可得到反码
     * (3-2)求取原码：符号位不变，其他位逐位取反，即可得到原码
     * 如：补码1000 0000。
     * 反码：（1）补码减一：1000 0000 - 1 = 0111 1111
     *      （2）设置回原来的符合位1 =  1111 1111
     * 原码：符号位不变，其他位逐位取反。1 111 1111 --> 1(符号位) 000 0000 即 10000000
     *    符号位是1，说明是负数，不考虑符号位000 0000，最终结果是负0，即-0。如果是0的话，用0000 0000表示。
     *    说明是2的八次方，即128，符号位是1，结果是-128。
     *
     * 如补码：10101000
     * 反码：（1）补码减一：1010 1000 - 1 = 1010 0111
     *      （2）设置回原来的符合位1 =  1010 0111
     * 原码：符号位不变，其他位逐位取反。1010 0111 --> 1(符号位) 101 1000 即 1 101 1000
     * 2^3 + 2^4 + 2^6 = 8 + 16 + 64 = 88, 符号位是1，说明是-88.
     *
     */
    private static byte[] zip(String codeStr) {
        // 1、每8个二进制字符为一个字节，计算压缩字节数组长度
        int length;
        if (codeStr.length() % 8 == 0) {
            length = codeStr.length() / 8;
        } else {
            length = codeStr.length() / 8 + 1;
        }

        // 2、创建字节数组
        byte[] zips = new byte[length];
        int index = 0;
        for (int i = 0; i < codeStr.length(); i+=8) {
             // 每8位截取一次
             int end = i + 8;
             String byteStr;
             if (end < codeStr.length()) {
                 byteStr = codeStr.substring(i, end);
             } else {
                 // 超出数组长度，截取剩余部分
                 byteStr = codeStr.substring(i);
             }

            // 二进制转成byte。以补码的形式存储到字节数组
            byte el = (byte) Integer.parseInt(byteStr, 2);
            zips[index] = el;
            index++;
        }
        return zips;
    }

    /**
     * 使用赫夫曼编码进行数据压缩
     * @param bytes 原始的字节数组
     * @return 压缩后的字节数组
     */
    public static byte[] zip(byte[] bytes) {
        // 1、创建赫夫曼树
        HuffmanCodeTree tree = HuffmanCodeTree.create(bytes);

        // 2、生成编码表
        Map<Byte, String> map = tree.buildCodeMap();
        //System.out.println(map);

        // 3、根据字节数组，获取编码字符串
        String codeStr = getCodeStr(bytes, map);
        //System.out.println(codeStr);

        // 4、根据赫夫曼编码后的字符串，得到压缩后的字节数组
        return zip(codeStr);
    }


    /**
     * 1、根据压缩后的字节数组，得到赫夫曼编码后的二进制字符串
     *  遍历压缩后的字节数组，获取单个字节b，执行以下逻辑
     *  (1) 传入压缩后的单个字节b，flag标志是否是最后一个压缩的字节，将b转成int类型的元素el
     *  (2) 如果el小于0，通过Integer.toBinaryString(el)，获取二进制补码字符串，然后从倒数第8开始截取字符串并返回。
     *      因为b小于0，得到的补码是32位的（int类型是4个字节），压缩时候是根据8位补码压缩的，所以我们需要截取。
     * （3）如果el大于0，而且是最后一个压缩的字节，则直接通过Integer.toBinaryString(el)，获取二进制补码字符串返回
     * （4）如果el大于0，不是最后一个压缩的字符串，需要对el进行补位，因为可能有不够8位的正数，如1,2之类的。通过el |= 256，保证够8位
     *      例如int类型的256与1进行或等于，256的补码：1 0000 0000 或等于 1 后得到的结果是 1 0000 0001。
     *      然后通过 Integer.toBinaryString(el) ，得到的结果是1 0000 0001，再从倒数第8开始截取字符串并返回
     *
     * 2、结合赫夫曼编码表和赫夫曼编码后的二进制字符串，得到原始的字节数组
     * （1）根据赫夫曼编码表创建Map<String, Byte> map, map的key是赫夫曼编码，Byte是原始的字节
     * （2）创建List集合，用于保存原始的字节
     * （3）定义变量i，i从0开始遍历赫夫曼编码后的二进制字符串
     *    （3-1）定义计数器count，count的初始值等于1
     *    （3-2）使用i和计数器循环截取字符串，直到找到原始的字节
     *          从i到i+count的位置开始截取赫夫曼编码后的二进制字符串，
     *          如果map中包含该字符串，则获取它对应的原始字节，保存到集合中。跳出循环
     *          如果不包含，count++。
     *          重复执行该过程，直到map中包含截取的字符串。
     *    （3-3）i移动到截取的字符串的下一个位置，即i移动到i+count的位置
     * @param bytes 压缩后的字节数组
     * @param codeMap 赫夫曼编码表
     * @return 返回解压缩后的字节数组
     */
    public static byte[] decode(byte[] bytes, Map<Byte, String> codeMap) {
        //1、根据压缩后的字节数组，得到赫夫曼编码后的二进制字符串
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean last = i == bytes.length - 1;
            builder.append(decode(b, last));
        }
        //System.out.println(builder.toString());

        //2、结合赫夫曼编码表和赫夫曼编码后的二进制字符串，得到原始的字节数组
        return decode(builder.toString(), codeMap);
    }


    /**
     * 1、根据压缩后的字节数组，得到赫夫曼编码后的二进制字符串
     *  遍历压缩后的字节数组，获取单个字节b，执行以下逻辑
     *  (1) 传入压缩后的单个字节b，flag标志是否是最后一个压缩的字节，将b转成int类型的元素el
     *  (2) 如果el小于0，通过Integer.toBinaryString(el)，获取二进制补码字符串，然后从倒数第8开始截取字符串并返回。因为b小于0，得到的补码是32位的（int类型是4个字节），压缩时候是根据8位补码压缩的，所以我们需要截取。
     * （3）如果el大于0，而且是最后一个压缩的字节，则直接通过Integer.toBinaryString(el)，获取二进制补码字符串返回
     * （4）如果el大于0，不是最后一个压缩的字符串，需要对el进行补位，因为可能有不够8位的正数，如1,2之类的。通过el |= 256，保证够8位
     *      例如int类型的256与1进行或等于，256的补码：1 0000 0000 或等于 1 后得到的结果是 1 0000 0001。
     * @param b 压缩的字节
     * @param last 是否是最后一个压缩的字节
     * @return 返回字节对应的赫夫曼编码字符串
     */
    public static String decode(byte b, boolean last) {
        int el = b;
        if (el < 0) {
            String binaryStr = Integer.toBinaryString(el);
            return binaryStr.substring(binaryStr.length() - 8);
        } else {
            if (last) {
                return Integer.toBinaryString(el);
            }  else {
                el |= 256;
                String binaryStr = Integer.toBinaryString(el);
                return binaryStr.substring(binaryStr.length() - 8);
            }
        }
    }

    /**
     * 2、结合赫夫曼编码表和赫夫曼编码后的二进制字符串，得到原始的字节数组
     * （1）根据赫夫曼编码表创建Map<String, Byte> map, map的key是赫夫曼编码，Byte是原始的字节
     * （2）创建List集合，用于保存原始的字节
     * （3）定义变量i，i从0开始遍历赫夫曼编码后的二进制字符串
     *    （3-1）定义计数器count，count的初始值等于1
     *    （3-2）使用i和计数器循环截取字符串，直到找到原始的字节
     *          从i到i+count的位置开始截取赫夫曼编码后的二进制字符串，
     *          如果map中包含该字符串，则获取它对应的原始字节，保存到集合中。跳出循环
     *          如果不包含，count++。
     *          重复执行该过程，直到map中包含截取的字符串。
     *    （3-3）i移动到截取的字符串的下一个位置，即i移动到i+count的位置
     * @param huffStr 赫夫曼编码后的二进制字符串
     * @param codeMap 赫夫曼编码表
     * @return 返回解压缩后的字节数组
     */
    public static byte[] decode(String huffStr, Map<Byte, String> codeMap) {
        HashMap<String, Byte> map = new HashMap<>();
        codeMap.forEach((originalElement, code) -> map.put(code, originalElement));

        List<Byte> elements = new ArrayList<>();
        for (int i = 0; i < huffStr.length();) {
            int count = 1;
            while (true) {
                String str = huffStr.substring(i, i + count);
                Byte originalElement = map.get(str);
                if (originalElement != null) {
                    elements.add(originalElement);
                    break;
                } else {
                    count++;
                }
            }
            i+=count;
        }

        byte[] bytes = new byte[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            bytes[i] = elements.get(i);
        }
        return bytes;
    }

    public static Map<Byte, String> getHuffmanCodeMap(byte[] bytes) {
        return create(bytes).buildCodeMap();
    }


    /**
     * 1、输入需要压缩的文件的完整路径src，压缩后的文件的完整路径dest(包括文件名称)
     * 2、使用src创建文件输入流FileInputStream in，通过in获取输入文件的字节数组
     * 3、通过字节数组，获取赫夫曼编码表
     * 4、将字节数组压缩，得到压缩后的字节数组
     * 5、使用dest创建文件输出流FileOutputStream os，然后根据os创建对象输出流ObjectOutputStream objOs
     * 6、通过对象输出流objOs输出压缩后的字节数组
     * 7、通过对象输出流objOs输出赫夫曼编码表。为什么要输出呢？因为恢复文件需要
     * 8、关闭所有用到的输入输出流
     * @param srcPath
     * @param destPath
     */
    public static void zipFile(String srcPath, String destPath) {
        FileInputStream in = null;
        FileOutputStream os = null;
        ObjectOutputStream objOs = null;
        try {
            in = new FileInputStream(srcPath);

            // 2、使用src创建文件输入流FileInputStream in，通过in获取输入文件的字节数组
            byte[] bytes = new byte[in.available()];
            in.read(bytes);

            // 3、通过字节数组，获取赫夫曼编码表
            Map<Byte, String> codeMap = getHuffmanCodeMap(bytes);

            // 4、将字节数组压缩，得到压缩后的字节数组
            byte[] zips = zip(bytes);

            //5、使用dest创建文件输出流FileOutputStream os，然后根据os创建对象输出流ObjectOutputStream objOs
            os = new FileOutputStream(destPath);
            objOs = new ObjectOutputStream(os);


            //6、通过对象输出流objOs输出压缩后的字节数组
            objOs.writeObject(zips);

            //7、通过对象输出流objOs输出赫夫曼编码表
            objOs.writeObject(codeMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //8、关闭所有用到的输入输出流
            if (in != null ) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objOs != null) {
                try {
                    objOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 1、输入压缩后的文件的完整路径srcPath，解压后的文件输出的完整路径destPath(包括文件名称)
     * 2、使用srcPath创建文件输入流FileInputStream in，然后根据in创建对象输入流ObjectInputStream objIs
     * 3、通过对象输入流objIs，读取压缩后的字节数组
     * 4、通过对象输入流objIs，读取赫夫曼编码表Map<Byte,String> codeMap对象
     * 5、使用压缩后的字节数组、codeMap对象进行解压缩，得到解压后的字节数组
     * 6、使用dest创建文件输出流FileOutputStream os，将解压后的字节数组输出
     * 7、关闭所有用到的输入输出流
     * 【注意】3、4步骤的读取顺序要和压缩的顺序一致
     * @param srcPath
     * @param destPath
     */
    public static void unZipFile(String srcPath, String destPath) {
        FileInputStream in = null;
        FileOutputStream os = null;
        ObjectInputStream objIs = null;
        try {
            //2、使用srcPath创建文件输入流FileInputStream in，然后根据in创建对象输入流ObjectInputStream objIs
            in = new FileInputStream(srcPath);
            objIs = new ObjectInputStream(in);

            //3、通过对象输入流objIs，读取压缩后的字节数组
            byte[] zips = (byte[]) objIs.readObject();

            //4、通过对象输入流objIs，读取赫夫曼编码表Map<Byte,String> codeMap对象
            Map<Byte,String> codeMap = (Map<Byte, String>) objIs.readObject();


            //5、使用压缩后的字节数组、codeMap对象进行解压缩，得到解压后的字节数组
            byte[] bytes = decode(zips, codeMap);

            //6、使用dest创建文件输出流FileOutputStream os，将解压后的字节数组输出
            os = new FileOutputStream(destPath);
            os.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7、关闭所有用到的输入输出流
            if (in != null ) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objIs != null) {
                try {
                    objIs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
