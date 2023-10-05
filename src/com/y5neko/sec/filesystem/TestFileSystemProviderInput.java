package com.y5neko.sec.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileSystemProviderInput {

    public static void main(String[] args) {

        // 定义读取的文件路径
        Path path = Paths.get("D:/test.txt");

        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}