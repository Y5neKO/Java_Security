/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.proxy;

import java.io.*;
import java.lang.reflect.Proxy;

public class FileSystemProxySerializationTest {
    public static void main(String[] args) {
        try{
            //创建UnixFileSystem类实例
            FileSystem fileSystem = new UnixFileSystem();

            //使用JDK动态代理生成FileSystem动态代理类实例
            FileSystem proxyInstance = (FileSystem) Proxy.newProxyInstance(
                    FileSystem.class.getClassLoader(),// 指定动态代理类的类
                    new Class[]{FileSystem.class},//指定动态代理实现的接口
                    new JDKInvocationHandler(fileSystem)//使用JDK动态处理类，用UnixFileSystem类代理
            );

            //创建Java字节输出流对象
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            //创建Java反序列化输出流对象
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            //序列化动态代理类
            oos.writeObject(proxyInstance);
            oos.flush();
            oos.close();

            System.out.println("序列化结果为：");
            System.out.println(baos);

            // 利用动态代理类生成的二进制数组创建二进制输入流对象用于反序列化操作
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

            // 通过反序列化输入流(bais),创建Java对象输入流(ObjectInputStream)对象
            ObjectInputStream in = new ObjectInputStream(bais);

            // 反序列化输入流数据为FileSystem对象
            FileSystem test = (FileSystem) in.readObject();

            System.out.println("反序列化类实例类名:" + test.getClass());
            System.out.println("反序列化类实例:" + test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
