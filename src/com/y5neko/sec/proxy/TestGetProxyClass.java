/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class TestGetProxyClass {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 创建UnixFileSystem类实例
        FileSystem fileSystem = new UnixFileSystem();

        // 创建动态代理处理类
        InvocationHandler handler = new JDKInvocationHandler(fileSystem);

        // 通过指定类加载器、类实现的接口数组生成一个动态代理类
        Class proxyClass = Proxy.getProxyClass(
                FileSystem.class.getClassLoader(),// 指定动态代理类的类加载器
                new Class[]{FileSystem.class}// 定义动态代理生成的类实现的接口
        );

        // 使用反射获取Proxy类构造器并创建动态代理类实例
        FileSystem proxyInstance = (FileSystem) proxyClass.getConstructor(
                new Class[]{InvocationHandler.class}).newInstance(new Object[]{handler}
        );

        System.out.println(proxyInstance.getClass());
        System.out.println(proxyInstance);
    }
}
