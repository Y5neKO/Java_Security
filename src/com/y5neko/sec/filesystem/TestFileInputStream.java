/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.filesystem;

import java.io.*;

public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
        //创建文件对象
        File file = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");

        //打开文件对象，创建文件输入流
        FileInputStream fis = new FileInputStream(file);

        //定义每次输入流读取的字节数对象
        int a = 0;

        //创建字节缓冲区对象，定义缓冲区大小
        byte[] bytes = new byte[1024];

        //创建字节输出流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //循环读取文件内容
        //read方法将文件输入流中的内容读取（剪切）到bytes内存中，bytes缓冲区有多大就读多长，读完了就返回-1
        while ((a = fis.read(bytes)) != -1){
            //write方法截取bytes缓冲区数组中的内容到baos字节输出流对象中
            //(bytes, 0, a)其中的0表示从bytes数组的下标0开始截取，a表示输入流read到的字节数
            baos.write(bytes, 0, a);
        }

        System.out.println(baos);
    }
}
