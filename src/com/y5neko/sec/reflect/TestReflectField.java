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
