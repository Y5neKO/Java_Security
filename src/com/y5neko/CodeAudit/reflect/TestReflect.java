/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.CodeAudit.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Integer a = 123;

        Class<?> clazz = a.getClass().forName("java.lang.Runtime");
//        System.out.println(clazz);

        Constructor<?> runtimeConstructor = clazz.getDeclaredConstructor();
        runtimeConstructor.setAccessible(true);

        Object runtime = runtimeConstructor.newInstance();

        Method execMethod = clazz.getMethod("exec", String.class);
        execMethod.setAccessible(true);

        execMethod.invoke(runtime, "calc");
    }
}
