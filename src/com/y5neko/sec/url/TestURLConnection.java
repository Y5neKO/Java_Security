/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestURLConnection {
    public static void main(String[] args) throws IOException {
        //定义URL链接
        //URL url = new URL("https://blog.ysneko.com");
        //URL url = new URL("file:///D:/test.txt");
        URL url = new URL("http://127.0.0.1/");

        //打开url连接
        URLConnection urlConnection = url.openConnection();

        // 设置请求参数
        urlConnection.setRequestProperty("user-agent", "Y5neKO_Browser");
        //urlConnection.setConnectTimeout(1000);
        //urlConnection.setReadTimeout(1000);

        //建立实际连接
        urlConnection.connect();
        //获取响应字段
        urlConnection.getHeaderFields();
        //通过getInputStream方法获取URL输入流
        urlConnection.getInputStream();

        //创建StringBuilder对象接收输入流获取的内容
        StringBuilder content = new StringBuilder();
        //创建BufferedReader对象和InputStreamReader对象用来逐步处理URL输入流
        //BufferedReader是阻塞流，需要readLine方法取走才会继续读取
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;

        //逐行读取BufferedReader对象接收的内容到line中
        while ((line = in.readLine()) != null){
            content.append("\n").append(line);
        }

        System.out.println(content);
    }
}