/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.reflect;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectExec {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException, InterruptedException {
        //获取Runtime类
        Class clazz = Class.forName("java.lang.Runtime");

        //获取私有空参构造器
        Constructor constructor = clazz.getDeclaredConstructor();

        //修改作用域
        constructor.setAccessible(true);

        //实例化对象
        Object o = constructor.newInstance();

        //获取exec方法
        Method method = clazz.getMethod("exec", String.class);

        //invoke反射调用
        Process process = (Process)method.invoke(o,"cmd /c \"whoami /all && calc\"");

        //InputStream读取输入流
        InputStream in = process.getInputStream();
        //创建reader对象
        InputStreamReader inputStreamReader = new InputStreamReader(in, "GBK");
        //转为BufferReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //逐行读取
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        int exitcode = process.waitFor();
        System.out.println("进程退出：" + exitcode);
    }
}
