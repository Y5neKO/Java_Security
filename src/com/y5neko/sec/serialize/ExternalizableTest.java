/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.y5neko.sec.serialize;

import java.io.*;
import java.util.Arrays;

public class ExternalizableTest implements java.io.Externalizable{
    private String username;

    private String email;

    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        // make the client log the Object
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }

    /*
    实现了writeExternal和readExternal方法
     */
    @Override
    public void writeExternal(ObjectOutput oot) throws IOException {
        oot.writeObject(username);
        oot.writeObject(email);
    }
    @Override
    public void readExternal(ObjectInput oit) throws IOException, ClassNotFoundException {
        this.username = (String) oit.readObject();
        this.email = (String) oit.readObject();
    }

    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try{
            //创建ExternalizableTest对象，并初始化
            ExternalizableTest t = new ExternalizableTest();
            t.setUsername("Y5neKO");
            t.setEmail("1727058834@qq.com");

            //创建Java对象序列化输出流对象
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            //序列化ExternalizableTest类
            oos.writeObject(t);
            oos.flush();
            oos.close();

            System.out.println("序列化后的 数据：");
            System.out.println(baos);

            // 打印ExternalizableTest类序列化以后的字节数组，我们可以将其存储到文件中或者通过Socket发送到远程服务地址
            System.out.println("ExternalizableTest类序列化后的字节数组:" + Arrays.toString(baos.toByteArray()));

            // 利用ExternalizableTest类生成的二进制数组创建二进制输入流对象用于反序列化操作
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

            //创建Java对象输入流
            ObjectInputStream ois = new ObjectInputStream(bais);

            //反序列化输入流数据为ExternalizableTest对象
            ExternalizableTest test = (ExternalizableTest) ois.readObject();
            System.out.println("用户名:" + test.getUsername() + "\n邮箱:" + test.getEmail());
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
