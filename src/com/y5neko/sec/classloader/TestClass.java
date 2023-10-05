/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.classloader;

import com.y5neko.sec.phone.phone;

public class TestClass {
    public static void main(String[] args) {
        //无参构造器
        //phone p=new phone(); //使用关键字new来实例化类，并且声明是phone类型的。
        //p.name="IQOO 11";
        //p.weight=12.5;

        //p.setName("IQOO11");
        //p.setWeight(12.5);

        //有参构造器
        phone p = new phone("IQOO11",12.5);

        System.out.println(p.getName());
        System.out.println(p.getWeight());

        p.dianyuan();
    }
}

