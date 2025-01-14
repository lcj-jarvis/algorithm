package com.mrlu.base.datastruct.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 简单de快乐
 * @create 2025-01-13 14:03
 *
 * 逆波兰计算器：使用后缀表达式完成
 */
public class PolandCalculator {

    /**
     * @param expression 中缀表达式
     * @return
     */
    public int calculate(String expression) {
        // 1、为了对字符串遍历方便，我们不使用index的方式，
        // 我们直接将字符串解析好放到List。
        // List<String> elements = toSuffixExpressionList(expression);

        // 1、中缀表达式转逆波兰表达式，保存结果到集合中。
        List<String> elements = infixToPostfix(expression);

        //2、从左到右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个元素，
        //用运算符对它们做相应的计算（次顶元素和栈顶元素），
        //并将运算结果压入堆栈；重复上述过程，直到表达式的最右端，最后运算得出的值即为表达式的结果.
        Stack<String> stack = new Stack<>();
        for (String element : elements) {
            // 使用正则表达式判断是否是数字
            boolean isNumber = element.matches("\\d+");
            if (isNumber) {
                stack.push(element);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = calculate(num1, num2, element);
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀表达式转逆波兰表达式
     * @param expression
     * @return
     */
    public List<String> infixToPostfix(String expression) {
        // 1、解析中缀表达式的元素保存到集合，便于操作
        List<String> elements = getElements(expression);

        //(1) 初始化两个栈：运算符栈S1和储存结果的栈S2；
        // 存储运算符
        Stack<String> s1 = new Stack<>();
        // 存储结果
        Stack<String> s2 = new Stack<>();
        //(2) 从左至右扫描中缀表达式；
        for (String element : elements) {
            boolean isNumber = element.matches("\\d+");
            if (isNumber) {
                //(3) 遇到操作数时，将其压入S2；
                s2.push(element);
            } else if (left.equals(element)) {
                //(5-1)如果是左括号“(”，则直接压入S1
                s1.push(element);
            } else if (right.equals(element)) {
                // (5-2)如果是右括号“)”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，
                // 此时将这一对括号丢弃；可以想象成“（”比任何运算符都高，“）”比任何运算符都低 。
                while (!left.equals(s1.peek())) {
                    s2.push(s1.pop());
                }
                // 弹出(
                s1.pop();
            } else {
                // (4)如果是运算符，循环判断是否满足S1不为空，而且 “当前运算符优先级” 小于或等于 “S1栈顶运算符优先级”，
                // 满足的话，则进入循环，执行弹出S1栈顶运算符并加入S2。不满足的话，则不进入循环，将当前运算符压入S1。
                while (!s1.isEmpty() && getPriority(element) <= getPriority(s1.peek())) {
                    s2.push(s1.pop());
                }
                s1.push(element);
            }
        }

        //(7) 将S1中剩余的运算符依次弹出并压入S2；
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        //(8) S2栈低到栈顶的结果，就是逆波兰表达式。按照栈底到栈顶的顺序，保存到有序集合并返回
        return new ArrayList<>(s2);
    }

    /**
     * 逆波兰表达式（后缀表达式）。给定的后缀表达式的每个元素以空格分隔
     * @param expression
     * @return
     */
    private List<String> toSuffixExpressionList(String expression) {
        String[] expressionArray = expression.split(" ");
        return Arrays.asList(expressionArray);
    }

    private static final String add = "+";
    private static final String sub = "-";
    private static final String mul = "*";
    private static final String div = "/";
    private static final String left = "(";
    private static final String right = ")";

    /**
     * 获取两个出栈数的运算结果
     * @param first 先出栈的数
     * @param second 后出栈的数
     * @param op 运算符
     * @return 返回运算结果
     */
    private int calculate(int first, int second, String op) {
        int rt;
        switch (op) {
            case add:
                rt = first + second;
                break;
            case sub:
                // 注意是second - first。因为second先入栈
                rt = second - first;
                break;
            case mul:
                rt = first * second;
                break;
            case div:
                // 注意是second / first。因为second先入栈
                rt = second / first;
                break;
            default:
                throw new RuntimeException("运算法不合法");
        }
        return rt;
    }

    /**
     *  数字越大，优先级越高。运算符的优先级比操作符的优先级高。
     * @param op
     * @return
     */
    private int getPriority(String op) {
        if (add.equals(op) || sub.equals(op)) {
            return 0;
        }
        if (mul.equals(op) || div.equals(op)) {
            return 1;
        }
        if (left.equals(op) || right.equals(op)) {
            return -2;
        }
        return -100;
    }

    /**
     * 获取中缀表达式的每个元素。
     * @param expression
     * @return
     */
    private List<String> getElements(String expression) {
        List<String> elements = new ArrayList<>();

        int i = 0;
        while (i < expression.length()) {
            char element = expression.charAt(i);
            // ASCII码 0 -> 48 .  [0,9]
            boolean isNumber = element >= 48 && element <= 56;
            if (!isNumber) {
                elements.add(String.valueOf(element));
                // 数组后移
                i++;
            } else {
                // 找到连续的数字。
                StringBuilder builder = new StringBuilder();
                builder.append(element);
                // 开始寻找的位置。
                int j = i + 1;
                for (int n = j; n < expression.length(); n++) {
                    char el = expression.charAt(n);
                    if (!isNumber(el)) {
                        break;
                    }
                    builder.append(el);
                }
                elements.add(builder.toString());

                // 更新i的位置
                i = i + builder.length();
            }
        }

        return elements;
    }

    /**
     * 判断给定的字符是否属于[0,9]
     * @param element
     * @return
     */
    private boolean isNumber(char element) {
        return element >= 48 && element <= 56;
    }


}
