/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.reflect;

import java.lang.reflect.Field;

public class TestReflectField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class p = Class.forName("com.y5neko.sec.phone.phone");

        Field field = p.getField("test");
        System.out.println("获取类的一个public类型属性：");
        System.out.println(field);

        Field[] fields = p.getFields();
        System.out.println("获取类的所有public类型属性：");
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        Field field1 = p.getDeclaredField("name");
        System.out.println("获取类的一个所有类型属性：");
        System.out.println(field1);

        Field[] fields1 = p.getDeclaredFields();
        System.out.println("获取类的所有所有类型属性：");
        for (int i = 0; i < fields1.length; i++) {
            System.out.println(fields1[i]);
        }
    }
}
