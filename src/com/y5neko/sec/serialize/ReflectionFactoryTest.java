/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.serialize;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;

public class ReflectionFactoryTest {
    public static void main(String[] args) {
        try{
            //获取sun.reflect.ReflectionFactory对象
            ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();

            // 使用反序列化方式获取DeserializationTest类的构造方法
            Constructor constructor = reflectionFactory.newConstructorForSerialization(DeserializationTest.class, Object.class.getConstructor());
            System.out.println(constructor.newInstance());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
