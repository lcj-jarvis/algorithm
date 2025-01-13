package com.mrlu.base.datastruct.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 简单de快乐
 * @create 2025-01-13 14:27
 */
public class PolandCalculatorTest {
    @Test
    public void testPolandCalculator() {
        PolandCalculator polandCalculator = new PolandCalculator();
        System.out.println(polandCalculator.calculate("3+5-3*2+1"));
        System.out.println(polandCalculator.calculate("3+2*6-2"));
        System.out.println(polandCalculator.calculate("300+20*6-20"));
        System.out.println(polandCalculator.calculate("3*2*3-3/3+1-2*1"));
        System.out.println(polandCalculator.calculate("10+((5+25)*40)-5"));

        // 中缀表达式转后缀表达式
        //List<String> expression = polandCalculator.infixToPostfix("10+((5+25)*40)-5");
        List<String> expression = polandCalculator.infixToPostfix("1+((2+3)*4)-5");
        //List<String> expression = polandCalculator.infixToPostfix("1+((2+3)*4)-5");
        System.out.println(expression);


        // 前缀表达式：按照运算符的优先级对所有的运算单位加括号，从左往右，将运算符移动相应的括号前面
        //  1+((2+3)×4)-5 --> ((1+((2+3)×4))-5)  -->  (+(1((2+3)×4))-5)
        //  --> (+(1(+(23)×4))-5)  --> (+(1×(+(23)4))-5) -->  -(+(1×(+(23)4))5) --> -+1×+2345

        // 后缀表达式：按照运算符的优先级对所有的运算单位加括号，从右往左开始，将运算符移动相应的括号后面
        //  1+((2+3)×4)-5  --> ((1+((2+3)×4))-5) -->  ((1+((2+3)×4))5)-
        //   --> ((1+((2+3)4)×)5)-  --> ((1+((23)+4)×)5)-  -->  ((1((23)+4)×)+5)-   -->  123+4×+5
    }
}
