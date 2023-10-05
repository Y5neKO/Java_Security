/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.reflect;

import com.y5neko.sec.phone.phone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //通过class的newInstance()方法
        Class p = Class.forName("com.y5neko.sec.phone.phone");
        System.out.println(p);
        Object p1 = p.newInstance();
        System.out.println("class的newInstance方法：\n" + p1);
        //反射调用方法
        Method method1 = p.getDeclaredMethod("setName", String.class);
        Method method2 = p.getDeclaredMethod("getName");
        method1.setAccessible(true);
        method1.invoke(p1,new Object[]{"IQOO"});
        System.out.println(method2.invoke(p1));

        //另一种写法,区别是要进行强制类型转化
        Class p_2 = Class.forName("com.y5neko.sec.phone.phone");
        phone p2 = (phone)p_2.newInstance();
        System.out.println("class的第二个newInstance方法：\n" + p2);

        //通过constructor的newInstance()方法
        Class p_3 = Class.forName("com.y5neko.sec.phone.phone");
        Constructor constructor = p_3.getConstructor(String.class, double.class);
        System.out.println("constructor的newInstance方法：");
        System.out.println(constructor);
        Object p3 = constructor.newInstance("IQOO",12.5);
        System.out.println(p3);

//        phone pp = new phone();
//        System.out.println(pp);
//        pp.setName("123");

    }
}
