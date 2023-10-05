package com.y5neko.sec.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类
        Class p = Class.forName("com.y5neko.sec.phone.phone");

        //获取无参构造器
        Constructor constructor = p.getConstructor();

        //获取有参构造器
        Constructor constructor1 = p.getConstructor(String.class, double.class);

        //获取实例化对象(无参实例化)
        Object o = constructor.newInstance();

        //获取实例化对象(有参实例化)
        Object o1 = constructor1.newInstance("IQOO",12.5);

        //获取方法dianyuan
        Method method = p.getDeclaredMethod("dianyuan");

        //通过method类的invoke方法来执行这个类的方法
        method.invoke(o);

        //获取方法setName, getName, poweroff
        Method method1 = p.getDeclaredMethod("setName", String.class);
        Method method2 = p.getDeclaredMethod("getName");
        Method method3 = p.getDeclaredMethod("poweroff");
        //invoke反射执行
        method1.invoke(o,"IQOO11");
        System.out.println(method2.invoke(o));
        //私有类型，通过setAccessible方法更改权限
        method3.setAccessible(true);
        method3.invoke(o);
    }
}
