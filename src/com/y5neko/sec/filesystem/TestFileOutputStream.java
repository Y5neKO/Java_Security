/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.filesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/test.txt");

        String content = "Hello Y5neKO!";

        FileOutputStream fos = new FileOutputStream(file);

        //通过getBytes方法获得字节数组，向文件输出流中写入
        fos.write(content.getBytes());
        //flush方法是为了清空缓冲区
        fos.flush();
        fos.close();
    }
}
