/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.reflect;

import java.lang.reflect.Constructor;

public class TestReflectConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class p=Class.forName("com.y5neko.sec.phone.phone");

        Constructor constructor=p.getConstructor(String.class, double.class);
        System.out.println("public类型的构造器：");
        System.out.println(constructor);

        Constructor[] constructors = p.getConstructors();
        System.out.println("全部public类型的构造器：");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }

        Constructor constructor1 = p.getDeclaredConstructor();
        System.out.println("private和public类型的构造器：");
        System.out.println(constructor1);

        Constructor[] constructors1 = p.getDeclaredConstructors();
        System.out.println("全部类型的构造器：");
        for (int i = 0; i < constructors1.length; i++) {
            System.out.println(constructors1[i]);
        }
    }
}
