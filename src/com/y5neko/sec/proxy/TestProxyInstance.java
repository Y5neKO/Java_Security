/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.proxy;

import java.lang.reflect.Proxy;

public class TestProxyInstance {
    public static void main(String[] args) {
        // 创建UnixFileSystem类实例
        FileSystem fileSystem = new UnixFileSystem();

        // 使用JDK动态代理生成FileSystem动态代理类实例
        FileSystem proxyInstance = (FileSystem) Proxy.newProxyInstance(
                FileSystem.class.getClassLoader(),// 指定动态代理类的类加载器为FileSystem类的加载器
                new Class[]{FileSystem.class},// 定义动态代理生成的类实现的接口
                new JDKInvocationHandler(fileSystem)// 动态代理处理类
        );

        System.out.println(proxyInstance);
    }
}
