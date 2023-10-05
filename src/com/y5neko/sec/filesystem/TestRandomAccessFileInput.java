/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.filesystem;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFileInput {
    public static void main(String[] args) {
        File file = new File("D:/test.txt");

        try {
            // 创建RandomAccessFile对象,r表示以只读模式打开文件，一共有:r(只读)、rw(读写)、
            // rws(读写内容同步)、rwd(读写内容或元数据同步)四种模式。
            RandomAccessFile raf = new RandomAccessFile(file, "r");

            // 定义每次输入流读取到的字节数对象
            int a = 0;

            // 定义缓冲区大小
            byte[] bytes = new byte[1024];

            // 创建二进制输出流对象
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            // 循环读取文件内容
            while ((a = raf.read(bytes)) != -1) {
                // 截取缓冲区数组中的内容，(bytes, 0, a)其中的0表示从bytes数组的
                // 下标0开始截取，a表示输入流read到的字节数。
                out.write(bytes, 0, a);
            }

            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
