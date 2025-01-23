package com.mrlu.base.datastruct.hash;

/**
 * @author 简单de快乐
 * @create 2025-01-23 21:12
 *
 * 员工信息
 */
public class Emp {

    // 序号
    public int no;

    // 姓名
    public String name;

    public Emp next;

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
