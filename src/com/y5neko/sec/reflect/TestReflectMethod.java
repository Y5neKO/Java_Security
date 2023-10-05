/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.reflect;

import java.lang.reflect.Method;

public class TestReflectMethod  {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class p = Class.forName("com.y5neko.sec.phone.phone");

        Method method = p.getMethod("dianyuan");
        System.out.println("获取类的一个特定public类型的方法：");
        System.out.println(method);

        Method[] methods = p.getMethods();
        System.out.println("获取类的所有public类型的方法：");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        Method method1 = p.getDeclaredMethod("poweroff");
        System.out.println("获取类的一个特定任意类型的方法：");
        System.out.println(method1);

        Method[] methods1 = p.getDeclaredMethods();
        System.out.println("获取类的所有类型的方法：");
        for (int i = 0; i < methods1.length; i++) {
            System.out.println(methods1[i]);
        }

    }
}
