/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.test;

import java.util.Random;

public class practiceA2 {
    private int age;
    private String name;
    int[] age1={1,2,3,4,5,6,7,8,9,21};

    public practiceA2() {
    }

    public practiceA2( String name) {
        this.name = name;
        this.setAge(123);
    }



    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
        Random r=new Random();
        int index= r.nextInt(age1.length);
        this.age=age1[index];
    }
    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "practiceA2{age = " + age + ", name = " + name + "}";
    }
}