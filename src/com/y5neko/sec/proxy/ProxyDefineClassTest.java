/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.y5neko.sec.classloader.TestClassLoader.TEST_CLASS_BYTES;
import static com.y5neko.sec.classloader.TestClassLoader.TEST_CLASS_NAME;

public class ProxyDefineClassTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("java.lang.reflect.Proxy");

        //获取系统的类加载器，可以根据具体情况换成一个存在的类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        //反射java.lang.reflect.Proxy类获取其中的defineClass0方法
        Method method = clazz.getDeclaredMethod("defineClass0", ClassLoader.class, String.class, byte[].class, int.class, int.class);
        method.setAccessible(true);

        //反射调用java.lang.reflect.Proxy.defineClass0()方法，动态向JVM注册
        Class helloWorldClass = (Class) method.invoke(null,new Object[]{classLoader, TEST_CLASS_NAME, TEST_CLASS_BYTES, 0, TEST_CLASS_BYTES.length});
        System.out.println(helloWorldClass);
    }

}
