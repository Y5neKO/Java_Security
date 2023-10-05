/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.deserialize;

import java.io.*;
import java.util.Arrays;

public class TestTransient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test test = new Test();

        // 设置值
        test.test = "Test Value";
        System.out.println(test.test);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(test);
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Test serTest = (Test) objectInputStream.readObject();
        System.out.println(serTest.test);
    }
}
class Test implements Serializable {
    transient public String test;
}